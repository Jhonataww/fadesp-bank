package com.fadesp.bank.services.Impl;

import com.fadesp.bank.domain.models.Pessoa;
import com.fadesp.bank.repositories.PessoaRepository;
import com.fadesp.bank.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaServiceImpl implements PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;
    @Override
    public Pessoa save(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }
}
