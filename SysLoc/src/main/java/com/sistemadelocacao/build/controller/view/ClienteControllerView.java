package com.sistemadelocacao.build.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sistemadelocacao.build.entities.Cliente;
import com.sistemadelocacao.build.repository.Clientes;

@Controller
@RequestMapping(path = "/clientes")
public class ClienteControllerView {
	
	@Autowired
	private Clientes clientes;
	
	public ClienteControllerView(Clientes clientes) {
		this.clientes = clientes;
	}
	
	@GetMapping(path = "/{id}")
	public String buscar(@PathVariable("id") int id, Model model) {
		model.addAttribute("cliente", clientes.findById(id).orElseThrow());
		return "cliente";
	}
	
}