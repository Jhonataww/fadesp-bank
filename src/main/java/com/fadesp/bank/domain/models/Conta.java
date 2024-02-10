package com.fadesp.bank.domain.models;


import com.fadesp.bank.domain.enums.TipoConta;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.UniqueElements;

import java.io.Serializable;

@Entity
public class Conta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O número da conta é obrigatório")
    @Size(max = 20, message = "O número da conta deve ter no máximo 20 caracteres")
    @UniqueElements(message = "O número da conta já está em uso")
    private String numeroConta;

    @NotNull(message = "O saldo é obrigatório")
    @DecimalMin(value = "0.0", inclusive = false, message = "O saldo deve ser maior que zero")
    private Double saldo;

    @NotNull(message = "O tipo de conta é obrigatório")
    private TipoConta tipoConta;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa titular;

    public Long getId() {
        return id;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public Double getSaldo() {
        return saldo;
    }

    public TipoConta getTipoConta() {
        return tipoConta;
    }

    public Pessoa getTitular() {
        return titular;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public void setTipoConta(TipoConta tipoConta) {
        this.tipoConta = tipoConta;
    }

    public void setTitular(Pessoa titular) {
        this.titular = titular;
    }
}