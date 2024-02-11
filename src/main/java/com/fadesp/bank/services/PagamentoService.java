package com.fadesp.bank.services;

import com.fadesp.bank.domain.dtos.AlterarPagamentoRecord;
import com.fadesp.bank.domain.dtos.ExcluirPagamentoRecord;
import com.fadesp.bank.domain.enums.StatusPagamentoEnum;
import com.fadesp.bank.domain.models.Pagamento;

import java.util.List;

public interface PagamentoService {

    String realizarPagamento(Pagamento pagamento);

    List<Pagamento> findAllPagamentos(Long codigoDebito, String cpfCnpj, StatusPagamentoEnum status);

    String alterarPagamento(AlterarPagamentoRecord pagamento);

    String excluirPagamento(ExcluirPagamentoRecord pagamento);
}
