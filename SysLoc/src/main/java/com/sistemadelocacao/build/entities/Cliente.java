package com.sistemadelocacao.build.entities;

import java.util.List;

import org.hibernate.validator.constraints.Length;

import com.sistemadelocacao.build.annotations.CnpjValidation;
import com.sistemadelocacao.build.annotations.CpfValidation;
import com.sistemadelocacao.build.annotations.EmailValidation;
import com.sistemadelocacao.build.annotations.TelefoneValidation;
import com.sistemadelocacao.build.annotations.TipoDePessoaValidation;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, updatable = true, length = 30)
	@Length(max = 30, message = "O nome deve ter no maximo 30 caracteres")
	private String nome;
	
	@Column(nullable = true, updatable = true, length = 15)
	@Length(max = 15, message = "O telefone deve ter no maximo 15 caracteres")
	@TelefoneValidation
	private String tel;
	
	@Column(nullable = true, updatable = true, length = 30)
	@Length(max = 30, message = "O endereco deve ter no maximo 30 caracteres")
	private String endereco;
	
	@Column(nullable = true, updatable = true, length = 14)
	@Length(max = 14, message = "O CPF deve ter no maximo 14 caracteres")
	@CpfValidation
	private String cpf;
	
	@Column(nullable = true, updatable = true, length = 18)
	@Length(max = 18, message = "O CNPJ deve ter no maximo 18 caracteres")
	@CnpjValidation
	private String cnpj;
	
	@Column(nullable = false, updatable = true, length = 2)
	@Length(max = 2, message = "O tipo deve ter no maximo 2 caracteres")
	@TipoDePessoaValidation
	private String tipo;
	
	@Column(nullable = false, updatable = true, length = 30)
	@Length(max = 30, message = "O email deve ter no maximo 30 caracteres")
	@EmailValidation
	private String email;
	
	@OneToMany
	@JoinColumn(name = "id_cliente")
	private List<Pedido> pedidos; 
	
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
	
	public void adicionarPedido(Pedido pedido) {
		this.pedidos.add(pedido);
	}

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
