package com.sistemadelocacao.build.controller.apirest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

import com.sistemadelocacao.build.entities.Boleto;
import com.sistemadelocacao.build.entities.Pedido;
import com.sistemadelocacao.build.repository.Boletos;
import com.sistemadelocacao.build.repository.Pedidos;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("/apirest/boleto")
public class BoletoController {
	
	private Boletos boletos;
	private Pedidos pedidos;
	
	public BoletoController(Boletos boletos, Pedidos pedidos) {
		this.boletos = boletos;
		this.pedidos = pedidos;
	}
	
	@GetMapping("/{id}")
	public Boleto getBoletoById(@PathVariable(value = "id", required = true) Integer id) {
		return boletos
				.findById(id)
		        .orElseThrow(() -> 
		        	new ResponseStatusException(
		        			HttpStatus.NOT_FOUND,
		                    "Boleto não encontrado"));
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Boleto save(@RequestParam(value = "valor") float valor, @RequestParam(name = "idpedido") int idPedido) { 
		Boleto boleto = new Boleto(valor);
		Pedido pedido = pedidos.findById(idPedido).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		
		boleto.setPedido(pedido);
		/* pedido.adicionarBoleto();
		pedidos.save(pedido); */
		return boletos.save(boleto);
	}
	
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id ){
        boletos.findById(id)
                .map( boleto -> {
                    boletos.delete(boleto);
                    return boleto;
                })
                .orElseThrow(() -> new ResponseStatusException(
                		HttpStatus.NOT_FOUND,
                        "Boleto não encontrado"));
    }
    
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update( @PathVariable Integer id,
                        @RequestBody Boleto boleto ){
        boletos
                .findById(id)
                .map( boletoExistente -> {
                    boleto.setId(boletoExistente.getId());
                    boletos.save(boleto);
                    return boletoExistente;
                }).orElseThrow(() -> new ResponseStatusException(
                		HttpStatus.NOT_FOUND, 
                		"Boleto não encontrado"));
    }
    
    @PutMapping("/pagar/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<HttpStatus> pagarBoleto(@PathVariable Integer id) throws JsonProcessingException{
        Boleto b = boletos.findById(id).orElseThrow(() -> new ResponseStatusException(
        		HttpStatus.NOT_FOUND, 
            	"Boleto não encontrado"
        		));
        b.pagarBoleto();
        boletos.save(b);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    
    @PutMapping("/definir-data-pagamento/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<HttpStatus> definirDataPagamento(@PathVariable Integer id, @RequestParam(name = "dataPagamento") LocalDate dataPagamento) throws JsonProcessingException{
        Boleto b = boletos.findById(id).orElseThrow(() -> new ResponseStatusException(
        		HttpStatus.NOT_FOUND, 
            	"Boleto não encontrado"
        		));
        b.setDataPagamento(dataPagamento);
        boletos.save(b);
        return ResponseEntity.ok(HttpStatus.OK);
    }
	
	@GetMapping 
	public List<Boleto> findAllBoletos(){
	return boletos.findAll();
	}
	 
}
