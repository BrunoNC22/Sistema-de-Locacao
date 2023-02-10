package com.sistemadelocacao.build.entities;

public class Produto {
	private int id;
	private String descricao;
	private float valorDia;
	private float valorSemana;
	private float valorMes;
	
	public Produto(int id, String descricao, float valorDia, float valorSemana, float valorMes) {
		this.id = id;
		this.descricao = descricao;
		this.valorDia = valorDia;
		this.valorSemana = valorSemana;
		this.valorMes = valorMes;
	}
	
	
}
