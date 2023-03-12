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


@Controller
@RequestMapping(path = "/produtos")
public class ProdutoControllerView {
	
	@Autowired
	private Produtos produtos;
	
	@GetMapping
	public String buscarProdutos(Model model) {
		model.addAttribute("produtos", produtos.findAll());
		return "produtos";
	}
	
	@GetMapping("/new")
	public ModelAndView novoProduto() {
		ModelAndView mv = new ModelAndView("novoProduto");
		
		return mv;
	}
	
	@GetMapping("/{id}/delete")
	public String delete(@PathVariable int id) {
		produtos.deleteById(id);
		return "redirect:/produtos";
	}
	
	@PostMapping
	public String save(Produto produto) { 
		produtos.save(produto);
		return "redirect:/produtos";
	}
}
