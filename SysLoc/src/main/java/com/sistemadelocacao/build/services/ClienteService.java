package com.sistemadelocacao.build.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemadelocacao.build.entities.Cliente;
import com.sistemadelocacao.build.repository.Clientes;

@Service
public class ClienteService {
	
	@Autowired
	private Clientes clientes;
	
	
	public Cliente buscar(int id) {
		return clientes.findById(id).orElseThrow();
	}
	
	
	public List<Cliente> buscarClientes() {
		return clientes.findAll();
	}
	
	
	public String deletar(int id) {
		clientes.deleteById(id);
		return "redirect:/clientes";
	}
	
	
	public void novo(Cliente cliente) {
		clientes.save(cliente);
	}
}
