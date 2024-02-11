package com.fadesp.bank.controllers;

import com.fadesp.bank.domain.models.Pagamento;
import com.fadesp.bank.services.PagamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pagamento")
public class TransacaoController {

    @Autowired
    PagamentoService pagamentoService;

    @PostMapping("/realizar")
    public ResponseEntity<String> realizarPagamento(@RequestBody @Valid Pagamento pagamento) {
        pagamentoService.realizarPagamento(pagamento);
        return ResponseEntity.ok("Pagamento realizado com sucesso!");
    }

}
