package com.sistemadelocacao.build.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	@Column(nullable = false, updatable = true, length = 30)
	private String nome;
	@Column(nullable = true, updatable = true, length = 15)
	private String tel;
	@Column(nullable = true, updatable = true, length = 30)
	private String endereco;
	@Column(nullable = true, updatable = true, length = 14)
	private String cpf;
	@Column(nullable = true, updatable = true, length = 18)
	private String cnpj;
	@Column(nullable = false, updatable = true, length = 2)
	private String tipo;
	@Column(nullable = false, updatable = true, length = 30)
	private String email;
	
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
	
	public Cliente() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
}
