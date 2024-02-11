package com.fadesp.bank.services;

import com.fadesp.bank.domain.enums.StatusPagamentoEnum;
import com.fadesp.bank.domain.models.Pagamento;

import java.util.List;

public interface PagamentoService {

    String realizarPagamento(Pagamento pagamento);

    List<Pagamento> findAllPagamentos(Long codigoDebito, String cpfCnpj, StatusPagamentoEnum status);
}
