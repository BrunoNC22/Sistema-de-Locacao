package com.sistemadelocacao.build.controller.apirest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sistemadelocacao.build.entities.Funcionario;
import com.sistemadelocacao.build.services.FuncionarioService;

import java.util.List;

@RestController
@RequestMapping("/apirest/funcionario")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService service;
	
	@GetMapping("{id}")
	public Funcionario getBoletoById(@PathVariable Integer id) {
		return service.getBoletoById(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Funcionario save(@RequestBody Funcionario funcionario) { 
		return service.save(funcionario);
	}
	
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete( @PathVariable Integer id ){
        service.delete(id);;
    }
    
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update( @PathVariable Integer id,
                        @RequestBody Funcionario funcionario ){
        service.update(id, funcionario);
    }
    
    @GetMapping
    public List<Funcionario> find(){
        return service.find();
    }
	
}
