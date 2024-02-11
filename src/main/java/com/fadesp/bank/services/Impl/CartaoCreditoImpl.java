package com.fadesp.bank.services.Impl;

import com.fadesp.bank.domain.models.CartaoCredito;
import com.fadesp.bank.repositories.CartaoCreditoRepository;
import com.fadesp.bank.services.CartaoCreditoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartaoCreditoImpl implements CartaoCreditoService {

    @Autowired
    CartaoCreditoRepository cartaoCreditoRepository;
    @Override
    public CartaoCredito save(CartaoCredito cartao) {
        return cartaoCreditoRepository.save(cartao);
    }
}
