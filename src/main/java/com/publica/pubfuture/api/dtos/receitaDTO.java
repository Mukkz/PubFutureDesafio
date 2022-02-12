package com.publica.pubfuture.api.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Column;
import java.time.LocalDate;
@Getter
@Setter

public class receitaDTO {

    private Integer conta_id;
    public Float valor;

    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate dataRecebimento;
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate dataRecebimentoEsperado;

    public String descricao;

    @Column (nullable = false)
    public String tipoReceita;



}
