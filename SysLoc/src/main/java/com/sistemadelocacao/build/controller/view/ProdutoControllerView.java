package com.sistemadelocacao.build.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sistemadelocacao.build.entities.Produto;
import com.sistemadelocacao.build.repository.Produtos;
import com.sistemadelocacao.build.services.ProdutoService;


@Controller
@RequestMapping(path = "/produtos")
public class ProdutoControllerView {
	
	@Autowired
	private ProdutoService service;
	
	@GetMapping
	public String buscarProdutos(Model model) {
		model.addAttribute("produtos", service.buscarProdutos());
		return "produtos";
	}
	
	@GetMapping("/new")
	public ModelAndView novoProduto() {
		ModelAndView mv = new ModelAndView("novoProduto");
		
		return mv;
	}
	
	@GetMapping("/{id}/delete")
	public String delete(@PathVariable int id) {
		service.delete(id);
		return "redirect:/produtos";
	}
	
	@PostMapping
	public String save(Produto produto) { 
		service.novo(produto);
		return "redirect:/produtos";
	}
}
