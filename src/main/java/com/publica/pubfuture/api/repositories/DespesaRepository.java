package com.publica.pubfuture.api.repositories;

import com.publica.pubfuture.api.models.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface DespesaRepository extends JpaRepository<Despesa, Integer> {

    @Query("FROM Despesa WHERE tipoDespesa = :tipoDespesa")
    List<Despesa> porTipo(String tipoDespesa);

    @Query ("FROM Despesa WHERE dataPagamento BETWEEN :dataInicial AND :dataFinal")
    List<Despesa> porData(LocalDate dataInicial, LocalDate dataFinal);

    @Query ("SELECT SUM(valor) FROM Despesa")
    BigDecimal totalValor();

}
