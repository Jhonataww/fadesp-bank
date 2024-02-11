package com.fadesp.bank.controllers;

import com.fadesp.bank.domain.models.CartaoCredito;
import com.fadesp.bank.domain.models.CartaoDebito;
import com.fadesp.bank.services.CartaoCreditoService;
import com.fadesp.bank.services.CartaoDebitoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cartao")
public class CartaoController {

    @Autowired
    CartaoCreditoService cartaoCreditoService;

    @Autowired
    CartaoDebitoService cartaoDebitoService;

    @PostMapping("/debito")
    public ResponseEntity<CartaoDebito> criarCartaoDebito(@RequestBody @Valid CartaoDebito cartao){
        return ResponseEntity.status(HttpStatus.CREATED).body(cartaoDebitoService.save(cartao));
    }
    @PostMapping("/credito")
    public ResponseEntity<CartaoCredito> criarCartaoCredito(@RequestBody @Valid CartaoCredito cartao){
        return ResponseEntity.status(HttpStatus.CREATED).body(cartaoCreditoService.save(cartao));
    }
}
