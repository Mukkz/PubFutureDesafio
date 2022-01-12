package com.publica.pubfuture.api.repositories;

import com.publica.pubfuture.api.models.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;


public interface ReceitaRepository extends JpaRepository<Receita, BigInteger> {

    @Query ("FROM Receita WHERE tipoReceita = :tipoReceita")
    List<Receita> porTipo(String tipoReceita);

    @Query ("FROM Receita WHERE dataRecebimento BETWEEN :dataInicial AND :dataFinal")
    List<Receita> porData(LocalDate dataInicial, LocalDate dataFinal);

    @Query ("SELECT SUM(valor) FROM Receita")
    BigDecimal totalValor();

}
