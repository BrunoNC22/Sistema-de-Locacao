package com.sistemadelocacao.build.services;

import java.util.List;

import com.sistemadelocacao.build.entities.Cliente;
import com.sistemadelocacao.build.entities.Pedido;
import com.sistemadelocacao.build.entities.Produto;
import com.sistemadelocacao.build.repository.Clientes;
import com.sistemadelocacao.build.repository.Pedidos;
import com.sistemadelocacao.build.repository.Produtos;

public class PedidoService {

	private Pedidos pedidos;
	private Produtos produtos;
	private Clientes clientes;

	public PedidoService(Pedidos pedidos, Produtos produtos, Clientes clientes) {
		this.pedidos = pedidos;
		this.produtos = produtos;
		this.clientes = clientes;
	}

	public Pedido buscarPedido(Integer id) {
		return pedidos.findById(id).orElseThrow();
	}

	public Pedido save(Pedido pedido) {
		return pedidos.save(pedido);
	}

	public void delete(Integer id) {
		pedidos.deleteById(id);
	}

	public void update(Integer id, Pedido pedidoAtualizado) {
		Pedido antigoPedido = buscarPedido(id);
		pedidoAtualizado.setId(antigoPedido.getId());
		pedidos.save(pedidoAtualizado);
	}

	public Pedido adicionarProduto(Integer id, int produtoId) {
		Produto produto = produtos.findById(produtoId).orElseThrow();
		Pedido pedido = pedidos.findById(id).orElseThrow();

		pedido.adicionarProduto(produto);
		return pedidos.save(pedido);
	}

	public void atribuirCliente(Integer id, int clienteId) {
		Pedido pedido = pedidos.findById(id).orElseThrow();
		Cliente cliente = clientes.findById(clienteId).orElseThrow();

		pedido.setClienteResponsavel(cliente);
		cliente.adicionarPedido(pedido);
		pedidos.save(pedido);
		clientes.save(cliente);
	}

	public List<Pedido> find() {
		return pedidos.findAll();
	}
}
