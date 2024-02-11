package com.fadesp.bank.repositories;

import com.fadesp.bank.domain.models.CartaoCredito;
import com.fadesp.bank.domain.models.CartaoDebito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartaoDebitoRepository extends JpaRepository<CartaoDebito, Long> {

    CartaoDebito findByContaCnpjOrContaTitularCpf(String cnpj, String cpf);

    CartaoDebito findByNumeroCartao(String numero);
}
