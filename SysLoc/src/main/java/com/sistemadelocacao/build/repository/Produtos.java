package com.sistemadelocacao.build.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemadelocacao.build.entities.Produto;

public interface Produtos extends JpaRepository<Produto, Integer>{

}
