package com.sistemadelocacao.build.entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Pattern;

@Entity
public class Pedido {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	
	@Column(nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataEmissao;
	@Column(nullable = false)
	private LocalTime horaEmissao;
	@Column(nullable = true, updatable = true)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataInicio;
	@Column(nullable = true, updatable = true)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataFim;
	@Column(nullable = true, updatable = true)
	private int periodo;
	@Column(nullable = true, updatable = true)
	/* @Pattern(regexp = "\\d{2}\\/\\d{2}\\/\\d{4} ate \\d{2}\\/\\d{2}\\/\\d{4} \\d{2} dias", message = "Mensagem fora do padrao") */
	private String stringPeriodo;
	@Column(nullable = true, updatable = true)
	private Date dataDevolucao;
	@Column(nullable = true, updatable = true, length = 30)
	private String endereco;
	@Column(nullable = true, updatable = true)
	private float valorTotal;
	
	@OneToMany(targetEntity = Produto.class)
	private List<Produto> produto;
	
	public Pedido(LocalDate dataInicio ,int periodo, String endereco) {
		this.dataFim = dataInicio.plusDays(periodo);
		this.dataInicio = dataInicio;
		this.periodo = periodo;
		this.stringPeriodo = gerarPeriodo(this.dataInicio, this.dataFim, this.periodo);
		this.endereco = endereco;
		this.dataEmissao = LocalDate.now();
		this.horaEmissao = LocalTime.now();
		this.valorTotal = 0;
	}
	
	public Pedido() {}
	
	private String gerarPeriodo(LocalDate dataInicio, LocalDate dataFim, int periodo) {
		String stringDataInicio = dataInicio.format(DateTimeFormatter.ofPattern("dd/MM/YYYY"));
		String stringDataFim = dataFim.format(DateTimeFormatter.ofPattern("dd/MM/YYYY"));
		return stringDataInicio + " ate " + stringDataFim + " " + periodo + " dias";
	}
	
	public void adicionarProduto(Produto produto) {
		this.produto.add(produto);
		if (this.periodo < 7) {
			this.valorTotal = this.valorTotal + (produto.getValorDia() * this.periodo);
		}
		else if (this.periodo == 7) {
			this.valorTotal = this.valorTotal + produto.getValorSemana();
		}
		else {
			this.valorTotal = this.valorTotal + produto.getValorMes();
		}
		
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

	public LocalTime getHoraEmissao() {
		return horaEmissao;
	}

	public void setHoraEmissao(LocalTime horaEmissao) {
		this.horaEmissao = horaEmissao;
	}

	public String getPeriodo() {
		return stringPeriodo;
	}

	public void setPeriodo(String periodo) {
		this.stringPeriodo = periodo;
	}

	public Date getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
	
}
