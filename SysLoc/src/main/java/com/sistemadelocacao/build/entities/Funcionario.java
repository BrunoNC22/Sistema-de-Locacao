package com.sistemadelocacao.build.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Funcionario {
	@Column(nullable = false, updatable = true, length = 30)
	private String nome; 
	@Column(nullable = true, updatable = true, length = 14)
	private String tel;
	@Column(nullable = false, updatable = true, length = 20)
	private String senha;
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
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
