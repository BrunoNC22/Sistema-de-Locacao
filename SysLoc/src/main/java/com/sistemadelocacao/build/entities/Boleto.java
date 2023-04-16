package com.sistemadelocacao.build.entities;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;

@Entity
@Table(name= "boleto")
public class Boleto {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	
	@Column(nullable = true, updatable = true)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataEmissao;
	
	@Column(nullable = true, updatable = true)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataPagamento;
	
	@Column
	private boolean pago = false;
	
	@Column(nullable = false, updatable = true)
	private float valor;
	
	@ManyToOne
	@JoinColumn(name = "fk_pedido")
	private Pedido pedido;
	
	
	public Boleto (float valor) {
		this.dataEmissao = LocalDate.now();
		this.valor = valor;
	}
	
	public Boleto() {}
	
	public void pagarBoleto() {
		this.dataPagamento = LocalDate.now();
		this.pago = true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDate getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(LocalDate dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public LocalDate getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public boolean isPago() {
		return pago;
	}

	public void setPago(boolean pago) {
		this.pago = pago;
	}

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	
}
