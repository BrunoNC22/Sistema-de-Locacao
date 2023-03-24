package com.sistemadelocacao.build.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sistemadelocacao.build.entities.Cliente;
import com.sistemadelocacao.build.services.ClienteService;

@Controller
@RequestMapping(path = "/clientes")
public class ClienteControllerView {
	
	@Autowired
	private ClienteService service;
	
	@GetMapping(path = "/{id}")
	public String buscar(@PathVariable int id, Model model) {
		model.addAttribute("cliente", service.buscar(id));
		return "cliente";
	}
	
	@GetMapping
	public String buscarClientes(Model model) {
		model.addAttribute("clientes", service.buscarClientes());
		return "clientes";
	}
	
	@GetMapping("/new")
	public ModelAndView novoCliente() {
		ModelAndView mv = new ModelAndView("novoCliente");
		return mv;
	}
	
	@GetMapping("/{id}/delete")
	public String delete(@PathVariable int id) {
		service.deletar(id);
		return "redirect:/clientes";
	}
	
	@PostMapping
	public String save(Cliente cliente) {
		service.novo(cliente);
		return "redirect:/clientes";
	}
	
}
