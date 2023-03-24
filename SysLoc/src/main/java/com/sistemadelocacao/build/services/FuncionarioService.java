package com.sistemadelocacao.build.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sistemadelocacao.build.entities.Funcionario;
import com.sistemadelocacao.build.repository.Funcionarios;

public class FuncionarioService {
	
	@Autowired
	private Funcionarios funcionarios;
	
	public Funcionario getBoletoById(Integer id) {
		return funcionarios.findById(id).orElseThrow();
	}
	
	public Funcionario save(Funcionario funcionario) { 
		return funcionarios.save(funcionario);
	}
	
    public void delete(Integer id ){
        funcionarios.deleteById(id);
    }
    
    public void update(Integer id, Funcionario novoFuncionario){
        Funcionario antigoFuncionario = funcionarios.findById(id).orElseThrow();
        novoFuncionario.setId(antigoFuncionario.getId());
        funcionarios.save(novoFuncionario);
    }
    
    public List<Funcionario> find(){
        return funcionarios.findAll();
    }

}
