package com.sistemadelocacao.build.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemadelocacao.build.entities.Boleto;

public interface Boletos  extends JpaRepository<Boleto, Integer>{

}
