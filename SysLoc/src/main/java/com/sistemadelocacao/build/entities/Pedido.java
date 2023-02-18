package com.sistemadelocacao.build.entities;

import java.sql.Time;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pedido {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	private Date dataEmissao;
	private Time horaEmissao;
	private String periodo;
	private Date dataDevolucao;
	private int contrato;
	private String endereco;
	private float valorTotal;
	
	public Pedido(Date dataEmissao, Time horaEmissao, String periodo, int contrato,
			String endereco, float valorTotal) {
		this.dataEmissao = dataEmissao;
		this.horaEmissao = horaEmissao;
		this.periodo = periodo;
		this.contrato = contrato;
		this.endereco = endereco;
		this.valorTotal = valorTotal;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
