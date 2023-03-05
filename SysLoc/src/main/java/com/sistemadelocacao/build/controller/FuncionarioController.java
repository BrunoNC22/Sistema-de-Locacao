package com.sistemadelocacao.build.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.sistemadelocacao.build.entities.Funcionario;
import com.sistemadelocacao.build.repository.Funcionarios;

import java.util.List;

@RestController
@RequestMapping("/apirest/funcionario")
public class FuncionarioController {
	
private Funcionarios funcionarios;
	
	public FuncionarioController( Funcionarios funcionarios) {
		this.funcionarios = funcionarios;
	}
	
	@GetMapping("{id}")
	public Funcionario getBoletoById(@PathVariable Integer id) {
		return funcionarios
				.findById(id)
		        .orElseThrow(() -> 
		        	new ResponseStatusException(
		        			HttpStatus.NOT_FOUND,
		                    "Boleto não encontrado"));
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Funcionario save(@RequestBody Funcionario funcionario) { 
		return funcionarios.save(funcionario);
	}
	
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete( @PathVariable Integer id ){
        funcionarios.findById(id)
                .map( funcionario -> {
                    funcionarios.delete(funcionario);
                    return funcionario;
                })
                .orElseThrow(() -> new ResponseStatusException(
                		HttpStatus.NOT_FOUND,
                        "Funcionario não encontrado"));
    }
    
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update( @PathVariable Integer id,
                        @RequestBody Funcionario funcionario ){
        funcionarios
                .findById(id)
                .map( boletoExistente -> {
                    funcionario.setId(boletoExistente.getId());
                    funcionarios.save(funcionario);
                    return boletoExistente;
                }).orElseThrow(() -> new ResponseStatusException(
                		HttpStatus.NOT_FOUND, 
                		"Funcionario não encontrado"));
    }
    
    @GetMapping
    public List<Funcionario> find(){
        return funcionarios.findAll();
    }
	
}
