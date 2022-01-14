package com.publica.pubfuture.api.controllers;

import com.publica.pubfuture.api.models.Despesa;
import com.publica.pubfuture.api.repositories.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class DespesaController {

    @Autowired
    private DespesaRepository repository;

    @GetMapping(path = "/api/despesas/total")
    public BigDecimal totalValor(){
        return repository.totalValor();
    }

    @GetMapping (path = "/api/despesas")
    public List<Despesa> listarTodasDespesas(@RequestParam String tipoDespesa,
                                             @RequestParam String dataInicial,
                                             @RequestParam String dataFinal){
        if(tipoDespesa.length() > 0) {
            return (List<Despesa>) repository.porTipo(tipoDespesa);
        }
        else if(dataInicial.length() > 0 && dataFinal.length() > 0){
            LocalDate dataInicialFormatada = LocalDate.parse(dataInicial);
            LocalDate dataFinalFormatada = LocalDate.parse(dataFinal);
            return (List<Despesa>) repository.porData(dataInicialFormatada, dataFinalFormatada);
        }
        else{
            return (List<Despesa>) repository.findAll();
        }
    }

    @PostMapping(path = "/api/despesas")
    @ResponseStatus(HttpStatus.CREATED)
    public Despesa cadastrar(@RequestBody Despesa despesa){
        return repository.save(despesa);
    }

    @DeleteMapping (path = "/api/despesas/{id}")
    @ResponseStatus (HttpStatus.ACCEPTED)
    public void deletar (@PathVariable (name="id", required = true) Integer id){
        repository.deleteById(id);
    }

    @PutMapping (path = "/api/despesas/{id}")
    @ResponseStatus (HttpStatus.ACCEPTED)
    public Despesa editar(@PathVariable (name = "id", required = true) Integer id, @RequestBody Despesa despesa){
        Optional<Despesa> rOpt = repository.findById(id);

        Despesa dToEdit = rOpt.get();
        dToEdit.setDataPagamento(despesa.getDataPagamento());
        dToEdit.setTipoDespesa(despesa.getTipoDespesa());
        dToEdit.setValor(despesa.getValor());
        dToEdit.setDataPagamentoEsperado(despesa.getDataPagamentoEsperado());
        repository.save(dToEdit);
        return dToEdit;
    }

}
