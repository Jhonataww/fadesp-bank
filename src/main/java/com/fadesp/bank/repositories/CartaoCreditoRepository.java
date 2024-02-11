package com.fadesp.bank.repositories;

import com.fadesp.bank.domain.models.CartaoCredito;
import com.fadesp.bank.domain.models.CartaoDebito;
import com.fadesp.bank.domain.models.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaoCreditoRepository extends JpaRepository<CartaoCredito, Long> {

    CartaoCredito findByContaCnpjOrContaTitularCpf(String cnpj, String cpf);

    CartaoCredito findByNumeroCartao(String numero);

}
