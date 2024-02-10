package com.fadesp.bank.domain.models;

import jakarta.persistence.Entity;

@Entity
public class CartaoDebito extends Cartao{

    public Double getSaldo() {
        return getConta().getSaldo();
    }

    public void setSaldo(Double saldo) {
        getConta().setSaldo(saldo);
    }
}
