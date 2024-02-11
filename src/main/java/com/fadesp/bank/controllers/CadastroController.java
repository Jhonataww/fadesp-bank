package com.fadesp.bank.controllers;

import com.fadesp.bank.domain.models.Conta;
import com.fadesp.bank.domain.models.Pessoa;
import com.fadesp.bank.services.ContaService;
import com.fadesp.bank.services.PessoaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cadastro")
public class CadastroController {

    @Autowired
    PessoaService pessoaService;

    @Autowired
    ContaService contaService;

    @PostMapping("/pessoa")
    public ResponseEntity<Pessoa> cadastrarPessoa(@RequestBody @Valid Pessoa pessoa){
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.save(pessoa));
    }
    @PostMapping("/conta")
    public ResponseEntity<Conta> cadastrarConta(@RequestBody @Valid Conta conta){
        return ResponseEntity.status(HttpStatus.CREATED).body(contaService.save(conta));
    }
}
