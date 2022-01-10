package com.publica.pubfuture.api.controllers;

import com.publica.pubfuture.api.models.Receita;
import com.publica.pubfuture.api.repositories.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReceitaController {

    @Autowired
    private ReceitaRepository repository;

    @GetMapping (path = "/api/receitas")
    public List <Receita> listarTodasReceitas(){
        return (List<Receita>) repository.findAll();

    }

    @PostMapping (path = "/api/receitas")
    public Receita cadastrar(@RequestBody Receita receita){
        return repository.save(receita);
    }

    @DeleteMapping (path = "/api/receitas/{id}")
    public void deletar (@PathVariable (name="id", required = true) Integer id){
        repository.deleteById(id);
    }

}
