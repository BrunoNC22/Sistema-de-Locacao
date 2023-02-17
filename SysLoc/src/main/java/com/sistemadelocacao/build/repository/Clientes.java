package com.sistemadelocacao.build.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemadelocacao.build.entities.Cliente;

public interface Clientes extends JpaRepository<Cliente, Integer>{

}
