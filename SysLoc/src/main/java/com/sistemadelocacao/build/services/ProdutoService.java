package com.sistemadelocacao.build.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemadelocacao.build.entities.Produto;
import com.sistemadelocacao.build.repository.Produtos;

@Service
public class ProdutoService {
	
	@Autowired
	private Produtos produtos;
	
	public List<Produto> buscarProdutos() {
		return produtos.findAll();
	}
	
	public void delete(int id) {
		produtos.deleteById(id);
	}
	
	public void novo(Produto produto) { 
		produtos.save(produto);
	}
}
