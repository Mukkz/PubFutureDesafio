package com.publica.pubfuture.api.controllers;

import com.publica.pubfuture.api.models.Conta;
import com.publica.pubfuture.api.models.Receita;
import com.publica.pubfuture.api.repositories.ContaRepository;
import com.publica.pubfuture.api.repositories.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class ReceitaController {

    @Autowired
    private ReceitaRepository repository;
    @Autowired
    private ContaRepository contaRepository;

    @GetMapping (path = "/api/receitas/total")
    public BigDecimal totalValor(){
        return repository.totalValor();
    }

//    Para buscar as receitas por data ou tipo de receita, utilizar os Param: ?tipoReceita=&dataInicial=&dataFinal=
    @GetMapping (path = "/api/receitas")
    public List <Receita> listarTodasReceitas(@RequestParam String tipoReceita,
                                              @RequestParam String dataInicial,
                                              @RequestParam String dataFinal){
        if(tipoReceita.length() > 0) {
            return (List<Receita>) repository.porTipo(tipoReceita);
        }
        else if(dataInicial.length() > 0 && dataFinal.length() > 0){
            LocalDate dataInicialFormatada = LocalDate.parse(dataInicial);
            LocalDate dataFinalFormatada = LocalDate.parse(dataFinal);
            return (List<Receita>) repository.porData(dataInicialFormatada, dataFinalFormatada);
        }
        else return (List<Receita>) repository.findAll();
    }

    @PostMapping (path = "/api/receitas/{id}")
    @ResponseStatus (HttpStatus.CREATED)
    public Receita cadastrar(@PathVariable (name = "id", required = true) Integer id,@RequestBody Receita receita){
        Conta conta = contaRepository.findById(id).get();
        receita.setConta(conta);
        repository.save(receita);
        return receita;
    }

    @DeleteMapping (path = "/api/receitas/{id}")
    @ResponseStatus (HttpStatus.ACCEPTED)
    public void deletar (@PathVariable (name="id", required = true) Integer id){
        repository.deleteById(id);
    }

    @PutMapping (path = "/api/receitas/{id}")
    @ResponseStatus (HttpStatus.ACCEPTED)
    public Receita editar(@PathVariable (name = "id", required = true) Integer id, @RequestBody Receita receita){
        Optional <Receita> rOpt = repository.findById(id);

            Receita rToEdit = rOpt.get();
            rToEdit.setDataRecebimento(receita.getDataRecebimento());
            rToEdit.setTipoReceita(receita.getTipoReceita());
            rToEdit.setDescricao(receita.getDescricao());
            rToEdit.setValor(receita.getValor());
            rToEdit.setDataRecebimentoEsperado(receita.getDataRecebimentoEsperado());
            repository.save(rToEdit);
            return rToEdit;
    }

}
