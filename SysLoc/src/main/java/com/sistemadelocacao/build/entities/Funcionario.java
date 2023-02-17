package com.sistemadelocacao.build.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Funcionario {
	private String nome, tel, senha;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	
	public Funcionario (String nome, String tel, String senha) {
		this.nome = nome;
		this.tel = tel;
		this.senha = senha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
