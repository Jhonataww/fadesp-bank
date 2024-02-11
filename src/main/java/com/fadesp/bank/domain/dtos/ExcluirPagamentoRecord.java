package com.fadesp.bank.domain.dtos;

import com.fadesp.bank.domain.enums.StatusPagamentoEnum;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public record ExcluirPagamentoRecord(
        @NotNull(message = "Id do pagamento é obrigatório")
        Long id
) implements Serializable {
}