package com.sistemadelocacao.build.controller;

import org.springframework.web.bind.annotation.RestController;

import com.sistemadelocacao.build.entities.Pedido;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.sql.Time;
import java.util.Date;

@RestController
@RequestMapping("/apirest/pedido")
public class PedidoController {
	
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public void criar (
			@RequestParam("id") int id,
			@RequestParam("dataEmissao") Date dataEmissao,
			@RequestParam("horaEmissao") Time horaEmissao,
			@RequestParam("periodo") String periodo,
			@RequestParam("contrato") int contrato,
			@RequestParam("endereco") String endereco,
			@RequestParam("valorTotal") float valorTotal
			) {
		Pedido pedido = new Pedido(id, dataEmissao, horaEmissao, periodo, contrato, endereco, valorTotal);
		
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public String recuperar (@PathVariable("id") int id) {
		return "OK";
	}
}
