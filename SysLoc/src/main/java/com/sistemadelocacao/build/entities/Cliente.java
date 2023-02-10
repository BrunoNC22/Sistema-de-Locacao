package com.sistemadelocacao.build.entities;

public class Cliente {
	private int id;
	private String nome, tel, endereco, cpf, cnpj, tipo, email;
	
	public Cliente(int id, String nome, String tel, String endereco, String cpf, String cnpj, String tipo,
			String email) {
		this.id = id;
		this.nome = nome;
		this.tel = tel;
		this.endereco = endereco;
		this.cpf = cpf;
		this.cnpj = cnpj;
		this.tipo = tipo;
		this.email = email;
	}

	
	
}
