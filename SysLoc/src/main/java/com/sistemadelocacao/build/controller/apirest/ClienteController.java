package com.sistemadelocacao.build.controller.apirest;

import org.springframework.beans.factory.annotation.Autowired;
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

import java.util.List;

import com.sistemadelocacao.build.entities.Cliente;
import com.sistemadelocacao.build.services.ClienteService;



@RestController
@RequestMapping("/apirest/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	
	@GetMapping("/{id}")
	public Cliente getClienteById(@PathVariable Integer id) {
		return service.buscar(id);
	}
	
	@GetMapping
	public List<Cliente> find(){
		return service.buscarClientes();
	}
	
	@GetMapping("/consultar-nome")
	public List<Cliente> consultarPorNome(@RequestParam("nome") String nome) {
		return service.buscarPorNome(nome);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void save(@RequestBody Cliente cliente) {
		service.novo(cliente);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		service.deletar(id);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@PathVariable Integer id, @RequestBody Cliente cliente) {
		service.atualizarCliente(id, cliente);
	}
}
