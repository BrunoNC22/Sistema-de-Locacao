package com.sistemadelocacao.build.entities;

public class Funcionario {
	private String nome, tel, senha;
	private int id;
	
	public Funcionario (String nome, String tel, String senha, int id) {
		this.nome = nome;
		this.tel = tel;
		this.senha = senha;
		this.id = id;
	}
}
