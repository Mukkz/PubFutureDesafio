package com.publica.pubfuture.api.controllers;

import com.publica.pubfuture.api.models.Receita;
import com.publica.pubfuture.api.repositories.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ReceitaController {

    @Autowired
    private ReceitaRepository repository;

    @GetMapping (path = "/api/receitas")
    public List <Receita> listarTodasReceitas(){
        return (List<Receita>) repository.findAll();

    }

    @PostMapping (path = "/api/receitas")
    @ResponseStatus (HttpStatus.CREATED)
    public Receita cadastrar(@RequestBody Receita receita){
        return repository.save(receita);
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
            rToEdit.setConta(receita.getConta());
            rToEdit.setDataRecebimento(receita.getDataRecebimento());
            rToEdit.setTipoReceita(receita.getTipoReceita());
            rToEdit.setDescricao(receita.getDescricao());
            rToEdit.setValor(receita.getValor());
            rToEdit.setDataRecebimentoEsperado(receita.getDataRecebimentoEsperado());
            repository.save(rToEdit);
            return rToEdit;
    }

}
