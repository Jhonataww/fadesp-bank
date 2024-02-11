package com.fadesp.bank.repositories;

import com.fadesp.bank.domain.models.CartaoCredito;
import com.fadesp.bank.domain.models.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long>, PagingAndSortingRepository<Pagamento, Long>, JpaSpecificationExecutor<Pagamento> {

}
