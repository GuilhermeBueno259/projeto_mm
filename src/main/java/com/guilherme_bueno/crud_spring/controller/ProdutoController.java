package com.guilherme_bueno.crud_spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.guilherme_bueno.crud_spring.data.entity.Produto;
import com.guilherme_bueno.crud_spring.data.repository.ProdutoRepository;

@Controller
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;

	@GetMapping
	public String index() {
		return "index";
	}

	@GetMapping("/gerenciar")
	public ModelAndView gerenciar() {
		ModelAndView mv = new ModelAndView();
		List<Produto> produtos = produtoRepository.findAll();
		mv.addObject("produtos", produtos);
		mv.setViewName("/gerenciar");
		return mv;
	}

	@PostMapping("/salvar")
	public String salvar(Produto produto) {
		produtoRepository.save(produto);

		return "redirect:/gerenciar";
	}

	@GetMapping("/cadastrar")
	public ModelAndView cadastrar(ModelAndView mv) {
		mv.setViewName("/cadastrar");
		return mv;
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable Long id) {
		produtoRepository.deleteById(id);

		return "redirect:/gerenciar";
	}

	@GetMapping("/alterar/{id}")
	public ModelAndView alterar(@PathVariable Long id, ModelAndView mv) {
		mv.addObject("produto", produtoRepository.findById(id).get());
		mv.setViewName("/alterar");

		return mv;
	}

	@PostMapping("/atualizar")
	public String atualizar(Produto novo) {
		Produto produto = produtoRepository.findById(novo.getId()).get();

		produto.setNome(novo.getNome());
		produto.setQuantidade(novo.getQuantidade());

		produtoRepository.save(produto);

		return "redirect:/gerenciar";
	}
}
