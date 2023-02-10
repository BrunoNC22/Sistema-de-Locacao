package com.sistemadelocacao.build.entities;

import java.util.Date;

public class Boleto {
	private int id;
	private Date dataEmissao;
	private Date dataPagamento;
	private float valor;
	
	public Boleto (int id, Date dataEmissao, Date dataPagamento, float valor) {
		this.id = id;
		this.dataEmissao = dataEmissao;
		this.dataPagamento = dataPagamento;
		this.valor = valor;
	}
}
