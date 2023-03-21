package com.sistemadelocacao.build.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.sistemadelocacao.build.entities.Cliente;
import com.sistemadelocacao.build.entities.Pedido;
import com.sistemadelocacao.build.entities.Produto;
import com.sistemadelocacao.build.repository.Clientes;
import com.sistemadelocacao.build.repository.Pedidos;
import com.sistemadelocacao.build.repository.Produtos;

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

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/apirest/pedido")
public class PedidoController {
	
	private Pedidos pedidos;
	private Produtos produtos;
	private Clientes clientes;
	
	public PedidoController(Pedidos pedidos, Produtos produtos, Clientes clientes) {
		this.pedidos = pedidos;
		this.produtos = produtos;
		this.clientes = clientes;
	}
	
	@GetMapping("/{id}")
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
	public Pedido save(@RequestParam(name = "dataInicio") LocalDate dataInicio, @RequestParam(name = "periodo") int periodo, @RequestParam(name = "endereco") String endereco) {
		Pedido pedido = new Pedido(dataInicio, periodo, endereco);
		return pedidos.save(pedido);
	}
	
    @DeleteMapping("/{id}")
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
    
    @PutMapping("/{id}")
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
    
    @PutMapping("/adicionar-produto/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Pedido adicionarProduto(@PathVariable Integer id, @RequestParam(name = "produtoid") int produtoId) {
    	Produto produto = produtos.findById(produtoId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    	Pedido pedido = pedidos.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    	
    	pedido.adicionarProduto(produto);
    	return pedidos.save(pedido);
    }
    
    @PutMapping("/atribuir-cliente/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atribuirCliente(@PathVariable Integer id, @RequestParam(name = "clienteid") int clienteId) {
    	Pedido pedido = pedidos.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    	Cliente cliente = clientes.findById(clienteId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    	
    	pedido.setClienteResponsavel(cliente);
    	cliente.adicionarPedido(pedido);
    	pedidos.save(pedido);
    	clientes.save(cliente);
    }
    
    @GetMapping
    public List<Pedido> find(){
        return pedidos.findAll();
    }
	
}
