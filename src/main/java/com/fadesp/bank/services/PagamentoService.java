package com.fadesp.bank.services;

import com.fadesp.bank.domain.models.CartaoCredito;
import com.fadesp.bank.domain.models.Pagamento;

public interface PagamentoService {

    String realizarPagamento(Pagamento pagamento);
}
