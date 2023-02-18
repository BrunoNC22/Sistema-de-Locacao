package com.sistemadelocacao.build.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Produto {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	private String descricao;
	private float valorDia;
	private float valorSemana;
	private float valorMes;
	
	public Produto(String descricao, float valorDia, float valorSemana, float valorMes) {
		this.descricao = descricao;
		this.valorDia = valorDia;
		this.valorSemana = valorSemana;
		this.valorMes = valorMes;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
