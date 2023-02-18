package com.sistemadelocacao.build.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.sistemadelocacao.build.entities.Pedido;
import com.sistemadelocacao.build.repository.Pedidos;

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
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@RestController
@RequestMapping("/apirest/pedido")
public class PedidoController {
	
private Pedidos pedidos;
	
	public PedidoController( Pedidos pedidos) {
		this.pedidos = pedidos;
	}
	
	@GetMapping("{id}")
	public Pedido getBoletoById(@PathVariable Integer id) {
		return pedidos
				.findById(id)
		        .orElseThrow(() -> 
		        	new ResponseStatusException(
		        			HttpStatus.NOT_FOUND,
		                    "Pedido não encontrado"));
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Pedido save(@RequestBody Pedido pedido) { 
		return pedidos.save(pedido);
	}
	
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete( @PathVariable Integer id ){
        pedidos.findById(id)
                .map( pedido -> {
                    pedidos.delete(pedido);
                    return pedido;
                })
                .orElseThrow(() -> new ResponseStatusException(
                		HttpStatus.NOT_FOUND,
                        "Pedido não encontrado"));
    }
    
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update( @PathVariable Integer id,
                        @RequestBody Pedido pedido ){
        pedidos
                .findById(id)
                .map( pedidoExistente -> {
                    pedido.setId(pedidoExistente.getId());
                    pedidos.save(pedido);
                    return pedidoExistente;
                }).orElseThrow(() -> new ResponseStatusException(
                		HttpStatus.NOT_FOUND, 
                		"Pedido não encontrado"));
    }
    
    @GetMapping
    public List<Pedido> find(Pedido filtro ){
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(
                        ExampleMatcher.StringMatcher.CONTAINING);

        Example example = Example.of(filtro, matcher);
        return pedidos.findAll(example);
    }
	
}
