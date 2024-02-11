package com.fadesp.bank.domain.dtos;

import com.fadesp.bank.domain.enums.MetodoPagamentoEnum;
import com.fadesp.bank.domain.enums.StatusPagamentoEnum;
import jakarta.validation.constraints.*;

import java.io.Serializable;

public record AlterarPagamentoRecord(
        @NotNull(message = "Id do pagamento é obrigatório")
        Long id,

        @NotNull(message = "O método de pagamento é obrigatório")
        StatusPagamentoEnum status

) implements Serializable {
}