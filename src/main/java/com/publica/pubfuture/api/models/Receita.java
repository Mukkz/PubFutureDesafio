package com.publica.pubfuture.api.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "receitas")
@Getter
@Setter
public class Receita implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name="conta_id")
    private Conta conta;

    @Column (nullable = false)
    public Float valor;

    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate dataRecebimento;
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate dataRecebimentoEsperado;

    public String descricao;

    @Column (nullable = false)
    public String tipoReceita;

    public void setConta(Conta conta) {

        this.conta = conta;
    }

    public Receita(){

    }

    public Receita(Integer id, Conta conta, Float valor, LocalDate dataRecebimento, LocalDate dataRecebimentoEsperado, String descricao, String tipoReceita) {
        this.id = id;
        this.conta = conta;
        this.valor = valor;
        this.dataRecebimento = dataRecebimento;
        this.dataRecebimentoEsperado = dataRecebimentoEsperado;
        this.descricao = descricao;
        this.tipoReceita = tipoReceita;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Receita receita = (Receita) o;
        return id.equals(receita.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
