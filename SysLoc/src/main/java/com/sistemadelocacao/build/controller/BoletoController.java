package com.sistemadelocacao.build.controller;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import com.sistemadelocacao.build.entities.Boleto;
import com.sistemadelocacao.build.repository.Boletos;

@RestController
@RequestMapping("/apirest/boleto")
public class BoletoController {
	
	private Boletos boletos;
	
	public BoletoController( Boletos boletos) {
		this.boletos = boletos;
	}
	
	@GetMapping("{id}")
	public Boleto getBoletoById(@PathVariable Integer id) {
		return boletos
				.findById(id)
		        .orElseThrow(() -> 
		        	new ResponseStatusException(
		        			HttpStatus.NOT_FOUND,
		                    "Boleto não encontrado"));
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Boleto save(@RequestParam float valor) { 
		Boleto boleto = new Boleto(valor);
		return boletos.save(boleto);
	}
	
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete( @PathVariable Integer id ){
        boletos.findById(id)
                .map( boleto -> {
                    boletos.delete(boleto);
                    return boleto;
                })
                .orElseThrow(() -> new ResponseStatusException(
                		HttpStatus.NOT_FOUND,
                        "Boleto não encontrado"));
    }
    
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update( @PathVariable Integer id,
                        @RequestBody Boleto boleto ){
        boletos
                .findById(id)
                .map( boletoExistente -> {
                    boleto.setId(boletoExistente.getId());
                    boletos.save(boleto);
                    return boletoExistente;
                }).orElseThrow(() -> new ResponseStatusException(
                		HttpStatus.NOT_FOUND, 
                		"Boleto não encontrado"));
    }
    
    @GetMapping
    public List<Boleto> find(Boleto filtro ){
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING);

        Example example = Example.of(filtro, matcher);
        return boletos.findAll(example);
    }
}
