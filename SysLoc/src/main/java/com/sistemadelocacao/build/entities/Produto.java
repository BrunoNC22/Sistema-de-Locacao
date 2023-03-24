package com.sistemadelocacao.build.entities;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Produto {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	@Column(nullable = false, updatable = true)
	private String descricao;
	@Column(nullable = false, updatable = true)
	private float valorDia;
	@Column(nullable = false, updatable = true)
	private float valorSemana;
	@Column(nullable = false, updatable = true)
	private float valorMes;
	
	@ManyToMany(mappedBy = "produto")
	private List<Pedido> pedidosEmQueAparece;
	
	public Produto(String descricao, float valorDia, float valorSemana, float valorMes) {
		this.descricao = descricao;
		this.valorDia = valorDia;
		this.valorSemana = valorSemana;
		this.valorMes = valorMes;
	}
	
	public Produto() {}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public float getValorDia() {
		return valorDia;
	}

	public void setValorDia(float valorDia) {
		this.valorDia = valorDia;
	}

	public float getValorSemana() {
		return valorSemana;
	}

	public void setValorSemana(float valorSemana) {
		this.valorSemana = valorSemana;
	}

	public float getValorMes() {
		return valorMes;
	}

	public void setValorMes(float valorMes) {
		this.valorMes = valorMes;
	}

	public List<Pedido> getPedidosEmQueAparece() {
		return pedidosEmQueAparece;
	}

	public void setPedidosEmQueAparece(List<Pedido> pedidosEmQueAparece) {
		this.pedidosEmQueAparece = pedidosEmQueAparece;
	}

	@Override
	public String toString() {
		return "Produto [id=" + id + ", descricao=" + descricao + ", valorDia=" + valorDia + ", valorSemana="
				+ valorSemana + ", valorMes=" + valorMes + "]";
	}
	
	
}
