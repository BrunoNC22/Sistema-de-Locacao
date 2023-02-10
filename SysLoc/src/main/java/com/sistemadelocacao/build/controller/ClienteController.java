package com.sistemadelocacao.build.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.sistemadelocacao.build.entities.Cliente;



@RestController
@RequestMapping("/apirest/cliente")
public class ClienteController {
	
	@PostMapping("")
	public void criar (
			@RequestParam("id") int id,
			@RequestParam("nome") String nome,
			@RequestParam("tel") String tel,
			@RequestParam("endereco") String endereco,
			@RequestParam("cpf") String cpf,
			@RequestParam("cnpj") String cnpj,
			@RequestParam("tipo") String tipo,
			@RequestParam("email") String email
			) { 
		Cliente cliente = new Cliente(id, nome, tel, endereco, cpf, cnpj, tipo, email);
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public String recuperar (@PathVariable("id") int id) {
		return "OK";
	}
}
