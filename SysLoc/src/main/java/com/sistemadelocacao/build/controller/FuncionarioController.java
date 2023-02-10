package com.sistemadelocacao.build.controller;

import com.sistemadelocacao.build.entities.Funcionario;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@RequestMapping("/apirest/funcionario")
public class FuncionarioController {
	
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public void criar(
			@RequestParam("nome") String nome,
			@RequestParam("tel") String tel,
			@RequestParam("senha") String senha,
			@RequestParam("id") int id
			){
		Funcionario funcionario = new Funcionario(nome, tel, senha, id);
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public String recuperar (@PathVariable("id") int id) {
		return "OK";
	}

}
