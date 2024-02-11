package com.fadesp.bank.domain.models;

import com.fadesp.bank.domain.enums.MetodoPagamentoEnum;
import com.fadesp.bank.domain.enums.StatusPagamentoEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

@Entity
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigoDebito;

    @Size(max = 14 , message = "O número do CNPJ deve ter no máximo 14 caracteres")
    @Min(value = 11, message = "O número do CPF deve ter no mínimo 11 caracteres")
    private String cpfCnpjPagador;

    @NotNull(message = "O método de pagamento é obrigatório")
    private MetodoPagamentoEnum metodoPagamento;

    private String numeroCartao;

    @NotNull(message = "O valor do pagamento é obrigatório")
    @DecimalMin(value = "0.01", message = "O valor do pagamento deve ser maior que zero")
    private Double valorPagamento;

    private StatusPagamentoEnum status;

    public Long getCodigoDebito() {
        return codigoDebito;
    }

    public void setCodigoDebito(Long codigoDebito) {
        this.codigoDebito = codigoDebito;
    }

    public String getCpfCnpjPagador() {
        return cpfCnpjPagador;
    }

    public void setCpfCnpjPagador(String cpfCnpjPagador) {
        this.cpfCnpjPagador = cpfCnpjPagador;
    }

    public MetodoPagamentoEnum getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(MetodoPagamentoEnum metodoPagamentoEnum) {
        this.metodoPagamento = metodoPagamentoEnum;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public Double getValorPagamento() {
        return valorPagamento;
    }

    public void setValorPagamento(Double valorPagamento) {
        this.valorPagamento = valorPagamento;
    }

    public StatusPagamentoEnum getStatus() {
        return status;
    }

    public void setStatus(StatusPagamentoEnum status) {
        this.status = status;
    }
}
