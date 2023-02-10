package com.sistemadelocacao.build.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

import com.sistemadelocacao.build.entities.Boleto;

@RestController
@RequestMapping("/apirest/boleto")
public class BoletoController {
	
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public void criar(
			@RequestParam("id") int id,
			@RequestParam("dataEmissao") Date dataEmissao,
			@RequestParam("dataPagamento") Date dataPagamento,
			@RequestParam("valor") float valor) {
		Boleto boleto = new Boleto(id, dataEmissao, dataPagamento, valor);
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public String recuperar (@PathVariable("id") int id) {
		return "OK";
	}
}
