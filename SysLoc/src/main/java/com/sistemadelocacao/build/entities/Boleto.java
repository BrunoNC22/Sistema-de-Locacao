package com.sistemadelocacao.build.entities;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;

@Entity
@Table(name= "boleto")
public class Boleto {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	
	// @Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = true, updatable = true)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataEmissao;
	
	// @Temporal(TemporalType.TIMESTAMP) // <- não está funcionando, pesquisar como funciona
	@Column(nullable = true, updatable = true)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataPagamento;
	
	@Column
	private boolean pago = false;
	
	@Column(nullable = false, updatable = true)
	private float valor;
	
	
	public Boleto (float valor) {
		this.dataEmissao = LocalDate.now();
		this.valor = valor;
	}
	
	public Boleto() {}
	
	public void pagarBoleto() {
		this.dataPagamento = LocalDate.now();
		this.pago = true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
