package com.sistemadelocacao.build.entities;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name= "boleto")
public class Boleto {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	
	@Column
	private LocalDate dataEmissao;
	
	@Column
	private LocalDate dataPagamento;
	
	@Column
	private boolean pago = false;
	
	@Column
	private float valor;
	
	
	public Boleto (LocalDate dataEmissao, float valor) {
		this.dataEmissao = dataEmissao;
		this.valor = valor;
	}
	
	public void pagarBoleto(LocalDate dataAtual) {
		this.dataPagamento = dataAtual;
		this.pago = true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
