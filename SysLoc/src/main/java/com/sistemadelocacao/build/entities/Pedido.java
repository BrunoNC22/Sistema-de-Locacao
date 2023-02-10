package com.sistemadelocacao.build.entities;

import java.sql.Time;
import java.util.Date;

public class Pedido {
	private int id;
	private Date dataEmissao;
	private Time horaEmissao;
	private String periodo;
	private Date dataDevolucao;
	private int contrato;
	private String endereco;
	private float valorTotal;
	
	public Pedido(int id, Date dataEmissao, Time horaEmissao, String periodo, int contrato,
			String endereco, float valorTotal) {
		this.id = id;
		this.dataEmissao = dataEmissao;
		this.horaEmissao = horaEmissao;
		this.periodo = periodo;
		this.contrato = contrato;
		this.endereco = endereco;
		this.valorTotal = valorTotal;
	}
	
	
	
}
