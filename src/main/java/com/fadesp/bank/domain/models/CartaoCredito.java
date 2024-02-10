package com.fadesp.bank.domain.models;

import jakarta.persistence.Entity;

@Entity
public class CartaoCredito extends Cartao{

    private double limite;

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

}
