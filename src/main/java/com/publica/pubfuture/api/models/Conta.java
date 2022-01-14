package com.publica.pubfuture.api.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer id;

    public BigDecimal saldo;

    @Column (nullable = false)
    public String tipoConta;

    @Column (nullable = false)
    public String instituicaoFinanceira;

}
