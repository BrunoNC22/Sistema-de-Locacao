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

import java.util.List;

import com.sistemadelocacao.build.entities.Produto;
import com.sistemadelocacao.build.repository.Produtos;



@RestController
@RequestMapping("/apirest/produto")
public class ProdutoController {
	
private Produtos produtos;
	
	public ProdutoController( Produtos produtos) {
		this.produtos = produtos;
	}
	
	@GetMapping("{id}")
	public Produto getProdutoById(@PathVariable Integer id) {
		return produtos
				.findById(id)
		        .orElseThrow(() -> 
		        	new ResponseStatusException(
		        			HttpStatus.NOT_FOUND,
		                    "produto não encontrado"));
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Produto save(@RequestBody Produto produto) { 
		return produtos.save(produto);
	}
	
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete( @PathVariable Integer id ){
        produtos.findById(id)
                .map( produto -> {
                    produtos.delete(produto);
                    return produto;
                })
                .orElseThrow(() -> new ResponseStatusException(
                		HttpStatus.NOT_FOUND,
                        "Produto não encontrado"));
    }
    
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update( @PathVariable Integer id,
                        @RequestBody Produto produto ){
        produtos
                .findById(id)
                .map( produtoExistente -> {
                    produto.setId(produtoExistente.getId());
                    produtos.save(produto);
                    return produtoExistente;
                }).orElseThrow(() -> new ResponseStatusException(
                		HttpStatus.NOT_FOUND, 
                		"Produto não encontrado"));
    }
    
    @GetMapping
    public List<Produto> find(){
        return produtos.findAll();
    }
}