package com.sistemadelocacao.build.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sistemadelocacao.build.entities.Cliente;

public interface Clientes extends JpaRepository<Cliente, Integer>{
	
	@Query("SELECT c FROM Cliente c WHERE c.nome = :nome")
	List<Cliente> procurarPorNome(@Param("nome") String nome);

}
