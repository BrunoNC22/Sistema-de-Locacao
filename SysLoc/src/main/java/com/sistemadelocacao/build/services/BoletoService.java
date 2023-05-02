package com.sistemadelocacao.build.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemadelocacao.build.entities.Boleto;
import com.sistemadelocacao.build.entities.Pedido;
import com.sistemadelocacao.build.repository.Boletos;
import com.sistemadelocacao.build.repository.Pedidos;

@Service
public class BoletoService {
	
	@Autowired
	private Boletos boletos;
	private Pedidos pedidos;
	
	public Boleto getBoletoById(Integer id) {
		return boletos
				.findById(id)
		        .orElseThrow();
	}
	
	public void save(Boleto boleto, int idPedido) { 
		Pedido pedido = pedidos.findById(idPedido).orElseThrow();
		boleto.setPedido(pedido);
		boletos.save(boleto);
	}
	
    public void delete(Integer id){
        boletos.deleteById(id);
    }
    
    public void update(Integer id, Boleto novoBoleto){
        Boleto antigoBoleto = boletos.findById(id).orElseThrow();
        novoBoleto.setId(antigoBoleto.getId());
        boletos.save(novoBoleto);
    }
    
    public void pagarBoleto(Integer id){
        Boleto b = boletos.findById(id).orElseThrow();
        b.pagarBoleto();
        boletos.save(b);
    }
    
    public void definirDataPagamento(Integer id, LocalDate dataPagamento){
        Boleto b = boletos.findById(id).orElseThrow();
        b.setDataPagamento(dataPagamento);
        boletos.save(b);
    }
	
	public List<Boleto> findAllBoletos(){
	return boletos.findAll();
	}
}
