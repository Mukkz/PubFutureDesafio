package com.publica.pubfuture.api.controllers;

import com.publica.pubfuture.api.models.Conta;
import com.publica.pubfuture.api.repositories.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
public class ContaController {

    @Autowired
    private ContaRepository repository;

    @GetMapping (path = "/api/contas")
    public List<Conta> listarTodasContas(){
            return (List<Conta>) repository.findAll();
        }

    @GetMapping(path = "/api/contas/total")
    public BigDecimal totalSaldo(){

        return repository.totalSaldo();
    }

    @PostMapping(path = "/api/contas")
    @ResponseStatus(HttpStatus.CREATED)
    public Conta cadastrar(@RequestBody Conta conta){

        return repository.save(conta);
    }

    @DeleteMapping (path = "/api/contas/{id}")
    @ResponseStatus (HttpStatus.ACCEPTED)
    public void deletar (@PathVariable (name="id", required = true) Integer id){

        repository.deleteById(id);
    }

    @PutMapping (path = "/api/contas/{id}")
    @ResponseStatus (HttpStatus.ACCEPTED)
    public Conta editar(@PathVariable (name = "id", required = true) Integer id, @RequestBody Conta conta){
        Optional<Conta> cOpt = repository.findById(id);

        Conta cToEdit = cOpt.get();
        cToEdit.setInstituicaoFinanceira(conta.getInstituicaoFinanceira());
        cToEdit.setTipoConta(conta.getTipoConta());
        cToEdit.setSaldo(conta.getSaldo());
        repository.save(cToEdit);
        return cToEdit;
    }

}
