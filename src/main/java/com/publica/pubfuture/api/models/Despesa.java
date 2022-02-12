package com.publica.pubfuture.api.models;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "despesas")
@Getter
@Setter
public class Despesa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;

    @ManyToOne
    @JoinColumn(name = "conta_id")
    private Conta conta;

    @Column(nullable = false)
    public Float valor;

    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate dataPagamento;
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate dataPagamentoEsperado;


    @Column (nullable = false)
    public String tipoDespesa;

    public Despesa(){

    }

    public Despesa(Integer id, Conta conta, Float valor, LocalDate dataPagamento, LocalDate dataPagamentoEsperado, String tipoDespesa) {
        this.id = id;
        this.conta = conta;
        this.valor = valor;
        this.dataPagamento = dataPagamento;
        this.dataPagamentoEsperado = dataPagamentoEsperado;
        this.tipoDespesa = tipoDespesa;
    }
}
