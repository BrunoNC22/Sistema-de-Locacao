package com.sistemadelocacao.build.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("/apirest/boleto")
public class BoletoController {
	
	private Boletos boletos;
	
	public BoletoController( Boletos boletos) {
		this.boletos = boletos;
	}
	
	@GetMapping("/{id}")
	public Boleto getBoletoById(@PathVariable(value = "id", required = true) Integer id) {
		return boletos
				.findById(id)
		        .orElseThrow(() -> 
		        	new ResponseStatusException(
		        			HttpStatus.NOT_FOUND,
		                    "Boleto não encontrado"));
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Boleto save(@RequestParam(value = "valor") float valor) { 
		Boleto boleto = new Boleto(valor);
		boletos.save(boleto);
		return boleto;
	}
	
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id ){
        boletos.findById(id)
                .map( boleto -> {
                    boletos.delete(boleto);
                    return boleto;
                })
                .orElseThrow(() -> new ResponseStatusException(
                		HttpStatus.NOT_FOUND,
                        "Boleto não encontrado"));
    }
    
    @PutMapping("/{id}")
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
    
    @PutMapping("/pagar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity pagarBoleto(@PathVariable Integer id) throws JsonProcessingException{
        Boleto b = boletos.findById(id).orElseThrow(() -> new ResponseStatusException(
        		HttpStatus.NOT_FOUND, 
            	"Boleto não encontrado"
        		));
        b.pagarBoleto();
        boletos.save(b);
        return ResponseEntity.ok(HttpStatus.OK);
    }
	
	@GetMapping 
	public List<Boleto> findAllBoletos(){ 
	return boletos.findAll();
	}
	 
}
