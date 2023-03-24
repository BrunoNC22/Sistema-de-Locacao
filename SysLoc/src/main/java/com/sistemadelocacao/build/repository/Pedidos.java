package com.sistemadelocacao.build.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemadelocacao.build.entities.Pedido;

public interface Pedidos extends JpaRepository<Pedido, Integer>{

}
