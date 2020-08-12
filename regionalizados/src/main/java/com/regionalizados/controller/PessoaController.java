package com.regionalizados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.regionalizados.model.Pessoa;
import com.regionalizados.repository.Pessoas;

@Controller
@RequestMapping("/pessoa")
public class PessoaController {
	
	@Autowired
	private Pessoas pessoas;
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("CadastroPessoa");
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(Pessoa pessoa) {
		pessoas.save(pessoa);
		ModelAndView mv = new ModelAndView("CadastroPessoa");
		mv.addObject("mensagem", "Cadastro efetuado com sucesso!");
		return mv;
	}
}
