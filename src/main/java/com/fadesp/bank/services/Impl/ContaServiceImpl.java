package com.fadesp.bank.services.Impl;

import com.fadesp.bank.domain.models.Conta;
import com.fadesp.bank.domain.models.Pessoa;
import com.fadesp.bank.repositories.ContaRepository;
import com.fadesp.bank.repositories.PessoaRepository;
import com.fadesp.bank.services.ContaService;
import com.fadesp.bank.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaServiceImpl implements ContaService {

    @Autowired
    ContaRepository contaRepository;
    @Override
    public Conta save(Conta conta) {
        return contaRepository.save(conta);
    }
}
