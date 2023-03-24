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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

import com.sistemadelocacao.build.entities.Boleto;
import com.sistemadelocacao.build.services.BoletoService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("/apirest/boleto")
public class BoletoController {
	
	@Autowired
	private BoletoService service;
	
	@GetMapping("/{id}")
	public Boleto getBoletoById(@PathVariable(value = "id", required = true) Integer id) {
		return service.getBoletoById(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void save(@RequestParam(value = "valor") float valor, @RequestParam(name = "idpedido") int idPedido) { 
		service.save(null, idPedido);
	}
	
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id ){
        service.delete(id);
    }
    
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update( @PathVariable Integer id,
                        @RequestBody Boleto boleto ){
        service.update(id, boleto);
    }
    
    @PutMapping("/pagar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void pagarBoleto(@PathVariable Integer id){
        service.pagarBoleto(id);
    }
    
    @PutMapping("/definir-data-pagamento/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void definirDataPagamento(@PathVariable Integer id, @RequestParam(name = "dataPagamento") LocalDate dataPagamento) throws JsonProcessingException{
        service.definirDataPagamento(id, dataPagamento);
    }
	
	@GetMapping 
	public List<Boleto> findAllBoletos(){
	return service.findAllBoletos();
	}
	 
}
