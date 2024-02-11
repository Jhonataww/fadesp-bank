package com.fadesp.bank.controllers;

import com.fadesp.bank.domain.dtos.AlterarPagamentoRecord;
import com.fadesp.bank.domain.dtos.ExcluirPagamentoRecord;
import com.fadesp.bank.domain.enums.StatusPagamentoEnum;
import com.fadesp.bank.domain.models.Pagamento;
import com.fadesp.bank.services.PagamentoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pagamento")
public class TransacaoController {

    @Autowired
    PagamentoService pagamentoService;

    @Transactional
    @PostMapping("/realizar")
    public ResponseEntity<String> realizarPagamento(@RequestBody @Valid Pagamento pagamento) {
        pagamentoService.realizarPagamento(pagamento);
        return ResponseEntity.ok("Pagamento realizado com sucesso!");
    }

    @GetMapping("/consultar")
    public ResponseEntity<Object> findAllPagamentos(@RequestParam(required = false) Long codigoDebito,
                                                    @RequestParam(required = false) String cpfCnpj,
                                                    @RequestParam(required = false)StatusPagamentoEnum status){
        Optional<List<Pagamento>> productO = Optional.ofNullable(pagamentoService.findAllPagamentos(codigoDebito, cpfCnpj, status));

        if(productO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(productO);
    }

    @Transactional
    @PostMapping("/alterar")
    public ResponseEntity<String> alterarPagamento(@RequestBody @Valid AlterarPagamentoRecord pagamento) {
        pagamentoService.alterarPagamento(pagamento);
        return ResponseEntity.ok("Pagamento alterado com sucesso!");
    }

    @Transactional
    @PostMapping("/excluir")
    public ResponseEntity<String> excluir(@RequestBody @Valid ExcluirPagamentoRecord pagamento) {
        pagamentoService.excluirPagamento(pagamento);
        return ResponseEntity.ok("Pagamento alterado com sucesso!");
    }
}
