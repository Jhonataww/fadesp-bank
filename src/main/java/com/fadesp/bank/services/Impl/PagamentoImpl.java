package com.fadesp.bank.services.Impl;

import com.fadesp.bank.domain.dtos.AlterarPagamentoRecord;
import com.fadesp.bank.domain.dtos.ExcluirPagamentoRecord;
import com.fadesp.bank.domain.enums.StatusPagamentoEnum;
import com.fadesp.bank.domain.models.Pagamento;
import com.fadesp.bank.repositories.CartaoCreditoRepository;
import com.fadesp.bank.repositories.CartaoDebitoRepository;
import com.fadesp.bank.repositories.ContaRepository;
import com.fadesp.bank.repositories.PagamentoRepository;
import com.fadesp.bank.services.PagamentoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PagamentoImpl implements PagamentoService {

    @Autowired
    PagamentoRepository pagamentoRepository;

    @Autowired
    ContaRepository contaRepository;

    @Autowired
    CartaoCreditoRepository cartaoCreditoRepository;

    @Autowired
    CartaoDebitoRepository cartaoDebitoRepository;

    @Transactional
    @Override
    public String realizarPagamento(Pagamento pagamento) {

        switch (pagamento.getMetodoPagamento()) {
            case BOLETO:
                boletos(pagamento);
                break;
            case PIX:
                pix(pagamento);
                break;
            case CARTAO_CREDITO:
                cartaoCredito(pagamento);
                break;
            case CARTAO_DEBITO:
                cartaoDebito(pagamento);
                break;
            default:
                throw new RuntimeException("Método de pagamento não reconhecido");
        }

        return "Pagamento realizado com sucesso!";
    }

    @Override
    public List<Pagamento> findAllPagamentos(Long codigoDebito, String cpfCnpj, StatusPagamentoEnum status) {
        Specification<Pagamento> spec = (root, query, criteriaBuilder) -> {
            if (codigoDebito != null) {
                return criteriaBuilder.equal(root.get("codigoDebito"), codigoDebito);
            }
            if (cpfCnpj != null) {
                return criteriaBuilder.equal(root.get("cpfCnpjPagador"), cpfCnpj);
            }
            if (status != null) {
                return criteriaBuilder.equal(root.get("status"), status);
            }
            return null;
        };

        return pagamentoRepository.findAll(spec);
    }

    @Transactional
    @Override
    public String alterarPagamento(AlterarPagamentoRecord pagamentoRecord) {
        Pagamento pagamento = pagamentoRepository.findById(pagamentoRecord.id()).orElseThrow(() -> new RuntimeException("Pagamento não encontrado"));

        if(pagamento.getStatus() == StatusPagamentoEnum.PROCESSADO_COM_SUCESSO){
            throw new RuntimeException("Pagamento já foi pago, não pode ter seu status alterado");
        }
        if(pagamento.getStatus() == StatusPagamentoEnum.PROCESSADO_COM_FALHA && pagamentoRecord.status() != StatusPagamentoEnum.PENDENTE){
            throw new RuntimeException("Pagamento está Processado com Falha, ele só pode ter seu status alterado para Pendente");
        }

        pagamento.setStatus(pagamentoRecord.status());
        pagamentoRepository.save(pagamento);
        return "Pagamento alterado com sucesso!";
    }

    @Transactional
    @Override
    public String excluirPagamento(ExcluirPagamentoRecord pagamentoRecord) {
        Pagamento pagamento = pagamentoRepository.findById(pagamentoRecord.id()).orElseThrow(() -> new RuntimeException("Pagamento não encontrado"));

        if(pagamento.getStatus() != StatusPagamentoEnum.PENDENTE){
            throw new RuntimeException("Pagamento não pode ser excluido, pois já foi processado");
        }
        pagamentoRepository.delete(pagamento);
        return "Pagamento excluido com sucesso!";
    }

    private void boletos(Pagamento pagamento) {

        var conta = contaRepository.findByCnpjOrTitularCpf(pagamento.getCpfCnpjPagador(), pagamento.getCpfCnpjPagador());

        if(conta == null){
            throw new RuntimeException("Conta não encontrada");
        }
        if(conta.getSaldo() < pagamento.getValorPagamento()){
            throw new RuntimeException("Saldo insuficiente");
        }
        if(pagamento.getNumeroCartao() != null){
            pagamento.setNumeroCartao(null);
        }
        conta.setSaldo(conta.getSaldo() - pagamento.getValorPagamento());
        contaRepository.save(conta);
        pagamento.setStatus(StatusPagamentoEnum.PENDENTE);
        pagamentoRepository.save(pagamento);
    }

    private void pix(Pagamento pagamento) {
        var conta = contaRepository.findByCnpjOrTitularCpf(pagamento.getCpfCnpjPagador(), pagamento.getCpfCnpjPagador());
        if(conta == null){
            throw new RuntimeException("Conta não encontrada");
        }
        if(conta.getSaldo() < pagamento.getValorPagamento()){
            throw new RuntimeException("Saldo insuficiente");
        }
        if(pagamento.getNumeroCartao() != null){
            pagamento.setNumeroCartao(null);
        }
        conta.setSaldo(conta.getSaldo() - pagamento.getValorPagamento());
        contaRepository.save(conta);
        pagamento.setStatus(StatusPagamentoEnum.PENDENTE);
        pagamentoRepository.save(pagamento);
    }

    private void cartaoCredito(Pagamento pagamento) {
        var cartaoCredito = cartaoCreditoRepository.findByContaCnpjOrContaTitularCpf(
                pagamento.getCpfCnpjPagador(), pagamento.getCpfCnpjPagador()
        );
        cartaoCredito = cartaoCredito == null ?
                cartaoCreditoRepository.findByNumeroCartao(pagamento.getNumeroCartao()) : cartaoCredito;

        if(cartaoCredito == null){
            throw new RuntimeException("Cartão de Crédito não encontrado");
        }
        if(cartaoCredito.getLimite() < pagamento.getValorPagamento() || cartaoCredito.getFatura() >= cartaoCredito.getLimite()) {
            throw new RuntimeException("Creditos insuficientes");
        }

        pagamento.setCpfCnpjPagador(cartaoCredito.getConta().getCnpj() == null ?
                cartaoCredito.getConta().getTitular().getCpf() : cartaoCredito.getConta().getCnpj());
        cartaoCredito.setFatura(cartaoCredito.getFatura() + pagamento.getValorPagamento());
        cartaoCreditoRepository.save(cartaoCredito);
        pagamento.setStatus(StatusPagamentoEnum.PENDENTE);
        pagamentoRepository.save(pagamento);
    }

    private void cartaoDebito(Pagamento pagamento) {
        var cartaoDebito = cartaoDebitoRepository.findByContaCnpjOrContaTitularCpf(pagamento.getCpfCnpjPagador(), pagamento.getCpfCnpjPagador());
        cartaoDebito = cartaoDebito == null ? cartaoDebitoRepository.findByNumeroCartao(pagamento.getNumeroCartao()) : cartaoDebito;

        if(cartaoDebito == null){
            throw new RuntimeException("Cartão de Débito não encontrado");
        }
        if(cartaoDebito.getConta().getSaldo() < pagamento.getValorPagamento()) {
            throw new RuntimeException("Saldo insuficiente");
        }

        pagamento.setCpfCnpjPagador(cartaoDebito.getConta().getCnpj() == null ?
                cartaoDebito.getConta().getTitular().getCpf() : cartaoDebito.getConta().getCnpj());
        cartaoDebito.getConta().setSaldo(cartaoDebito.getConta().getSaldo() - pagamento.getValorPagamento());
        cartaoDebitoRepository.save(cartaoDebito);
        pagamento.setStatus(StatusPagamentoEnum.PENDENTE);
        pagamentoRepository.save(pagamento);
    }
}
