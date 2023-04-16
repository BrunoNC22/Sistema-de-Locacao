package com.sistemadelocacao.build.controller.apirest;

import org.springframework.web.bind.annotation.RestController;

import com.sistemadelocacao.build.entities.Pedido;
import com.sistemadelocacao.build.services.PedidoService;

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

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/apirest/pedido")
public class PedidoController {

	@Autowired
	private PedidoService service;

	@GetMapping("/{id}")
	public Pedido buscarBoleto(@PathVariable Integer id) {
		return service.buscarPedido(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void save(
			@RequestParam(name = "dataInicio") LocalDate dataInicio,
			@RequestParam(name = "periodo") int periodo, 
			@RequestParam(name = "endereco") String endereco
			) {
		Pedido pedido = new Pedido(dataInicio, periodo, endereco);
		service.save(pedido);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@PathVariable Integer id, @RequestBody Pedido pedido) {
		service.update(id, pedido);
	}

	@PutMapping("/adicionar-produto/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void adicionarProduto(@PathVariable Integer id, @RequestParam(name = "produtoid") int produtoId) {
		service.adicionarProduto(id, produtoId);
	}

	@PutMapping("/atribuir-cliente/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atribuirCliente(@PathVariable Integer id, @RequestParam(name = "clienteid") int clienteId) {
		service.atribuirCliente(id, clienteId);
	}

	@GetMapping
	public List<Pedido> find() {
		return service.find();
	}

}
