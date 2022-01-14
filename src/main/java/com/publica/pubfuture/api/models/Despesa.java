package com.publica.pubfuture.api.models;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
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

}
