package com.sistemadelocacao.build.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistemadelocacao.build.entities.Funcionario;

public interface Funcionarios extends JpaRepository<Funcionario, Integer>{

}
