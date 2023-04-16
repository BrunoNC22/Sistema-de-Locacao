package com.sistemadelocacao.build.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemadelocacao.build.entities.Produto;
import com.sistemadelocacao.build.repository.Produtos;

@Service
public class ProdutoService {
	
	@Autowired
	private Produtos repositorio;
	
	public Produto buscarProdutoPorId(Integer id) {
		return repositorio.findById(id).orElseThrow();
	}
	
	public List<Produto> buscarProdutos() {
		return repositorio.findAll();
	}
	
	public void delete(int id) {
		repositorio.deleteById(id);
	}
	
	public void novo(Produto produto) { 
		repositorio.save(produto);
	}
	
	public void atualizarProduto(Integer id, Produto produtoAtualizado) {
		Produto antigoProduto = buscarProdutoPorId(id);
		produtoAtualizado.setId(antigoProduto.getId());
		repositorio.save(produtoAtualizado);
	}
}
