package com.sistemadelocacao.build.controller;



import com.sistemadelocacao.build.entities.Produto;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@RequestMapping("/apirest/produto")
public class ProdutoController {
	
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public void criar(
			@RequestParam("descricao") String descricao,
			@RequestParam("valorDia") float valorDia,
			@RequestParam("valorSemana") float valorSemana,
			@RequestParam("valorMes") float valorMes
			) {
		Produto produto = new Produto(descricao, valorDia, valorSemana, valorMes);
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public String recuperar (@PathVariable("id") int id) {
		return "OK";
	}
}
