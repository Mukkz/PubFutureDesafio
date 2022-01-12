package com.publica.pubfuture.api.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.math.BigInteger;
import java.time.LocalDate;

@Entity
public class Receita {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public BigInteger id;

    @Column (nullable = false)
    public Float valor;

    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate dataRecebimento;
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate dataRecebimentoEsperado;

    public String descricao;

    @Column (nullable = false)
    public String conta;

    @Column (nullable = false)
    public String tipoReceita;


    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public LocalDate getDataRecebimento() {
        return dataRecebimento;
    }

    public void setDataRecebimento(LocalDate dataRecebimento) {
        this.dataRecebimento = dataRecebimento;
    }

    public LocalDate getDataRecebimentoEsperado() {
        return dataRecebimentoEsperado;
    }

    public void setDataRecebimentoEsperado(LocalDate dataRecebimentoEsperado) {
        this.dataRecebimentoEsperado = dataRecebimentoEsperado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public String getTipoReceita() {
        return tipoReceita;
    }

    public void setTipoReceita(String tipoReceita) {
        this.tipoReceita = tipoReceita;
    }
}
