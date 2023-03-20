package com.guilherme_bueno.projeto_mm.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.guilherme_bueno.projeto_mm.data.entity.Pessoa;
import com.guilherme_bueno.projeto_mm.data.repository.PessoaRepository;

@Controller
public class PessoaController implements Serializable {

	private static final long serialVersionUID = 2022657577117408878L;

	@Autowired
	private PessoaRepository pessoaRepository;

	@GetMapping("/")
	public ModelAndView gerenciar() {
		ModelAndView mv = new ModelAndView();
		List<Pessoa> pessoa = pessoaRepository.findAll();
		mv.addObject("pessoas", pessoa);
		mv.setViewName("gerenciar");
		return mv;
	}

	@PostMapping("/salvar")
	public String salvar(Pessoa pessoa) {
		pessoaRepository.save(pessoa);

		return "redirect:/";
	}

	@GetMapping("/cadastrar")
	public ModelAndView cadastrar(ModelAndView mv) {
		mv.setViewName("/cadastrar");
		return mv;
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable Long id) {
		pessoaRepository.deleteById(id);

		return "redirect:/";
	}

	@GetMapping("/alterar/{id}")
	public ModelAndView alterar(@PathVariable Long id, ModelAndView mv) {
		mv.addObject("pessoa", pessoaRepository.findById(id).get());
		mv.setViewName("/alterar");

		return mv;
	}

	@PostMapping("/atualizar")
	public String atualizar(Pessoa nova) {
		Pessoa pessoa = pessoaRepository.findById(nova.getId()).get();

		pessoa.setNome(nova.getNome());
		pessoa.setTelefone(nova.getTelefone());
		pessoa.setEMail(nova.getEMail());

		pessoaRepository.save(pessoa);

		return "redirect:/";
	}
}
