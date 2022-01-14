package com.publica.pubfuture.api.repositories;

import com.publica.pubfuture.api.models.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;

public interface ContaRepository extends JpaRepository<Conta, Integer> {

    @Query("SELECT SUM(saldo) FROM Conta")
    BigDecimal totalSaldo();


}
