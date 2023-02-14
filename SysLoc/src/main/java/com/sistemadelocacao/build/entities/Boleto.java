package com.sistemadelocacao.build.entities;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name= "Boleto")
public class Boleto {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	
	
	private LocalDate dataEmissao;
	private LocalDate dataPagamento;
	private boolean pago = false;
	private float valor;
	
	public Boleto (int id, LocalDate dataEmissao, LocalDate dataPagamento, float valor) {
		this.id = id;
		this.dataEmissao = dataEmissao;
		this.dataPagamento = dataPagamento;
		this.valor = valor;
	}
	
	public void pagarBoleto() {
		this.pago = true;
	}
}
