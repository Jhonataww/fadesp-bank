package com.fadesp.bank.services.Impl;

import com.fadesp.bank.domain.models.CartaoDebito;
import com.fadesp.bank.repositories.CartaoDebitoRepository;
import com.fadesp.bank.services.CartaoDebitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartaoDebitoImpl implements CartaoDebitoService {

    @Autowired
    CartaoDebitoRepository cartaoDebitoRepository;
    @Override
    public CartaoDebito save(CartaoDebito cartao) {
        return cartaoDebitoRepository.save(cartao);
    }
}
