package com.sistemadelocacao.build.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	private String nome, tel, endereco, cpf, cnpj, tipo, email;
	
	public Cliente(String nome, String tel, String endereco, String cpf, String cnpj, String tipo,
			String email) {
		this.nome = nome;
		this.tel = tel;
		this.endereco = endereco;
		this.cpf = cpf;
		this.cnpj = cnpj;
		this.tipo = tipo;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	
}
