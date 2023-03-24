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
import java.util.List;

import com.sistemadelocacao.build.entities.Produto;
import com.sistemadelocacao.build.services.ProdutoService;



@RestController
@RequestMapping("/apirest/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoService service;
	
	@GetMapping("{id}")
	public Produto getProdutoById(@PathVariable Integer id) {
		return service.buscarProdutoPorId(id);
	}
	
	@PostMapping
	public void save(Produto produto) { 
		service.novo(produto);
	}
	
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete( @PathVariable Integer id ){
        service.delete(id);
    }
    
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update( @PathVariable Integer id,
                        @RequestBody Produto produto ){
        service.atualizarProduto(id, produto);
    }
    
    @GetMapping
    public List<Produto> find(){
        return service.buscarProdutos();
    }
}