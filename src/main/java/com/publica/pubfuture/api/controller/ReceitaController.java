package com.publica.pubfuture.api.controller;

import com.publica.pubfuture.api.model.Receita;
import com.publica.pubfuture.api.repository.ReceitaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReceitaController {

    private ReceitaRepository repository;

    @GetMapping (path = "/api/listarTodasReceitas")
    public List <Receita> listarTodasReceitas(){
        return (List<Receita>) repository.findAll();

    }

    @PostMapping (path = "api/receita/salvar")
    public Receita cadastrar(@RequestBody Receita receita){
        return repository.save(receita);
    }

}
