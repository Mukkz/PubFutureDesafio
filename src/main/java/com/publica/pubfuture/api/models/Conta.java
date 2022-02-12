package com.publica.pubfuture.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "contas")
@Getter
@Setter
public class Conta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;
    public BigDecimal saldo;
    @Column (nullable = false)
    public String tipoConta;
    @Column (nullable = false)
    public String instituicaoFinanceira;

    @JsonIgnore
    @OneToMany (mappedBy = "conta")
    private List<Receita> receitas = new ArrayList<>();

    public Conta(){

    }
    public Conta(Integer id, BigDecimal saldo, String tipoConta, String instituicaoFinanceira, List<Receita> receitas) {
        this.id = id;
        this.saldo = saldo;
        this.tipoConta = tipoConta;
        this.instituicaoFinanceira = instituicaoFinanceira;
        this.receitas = receitas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conta conta = (Conta) o;
        return id.equals(conta.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
