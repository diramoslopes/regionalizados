package com.regionalizados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.regionalizados.model.Pessoa;
import com.regionalizados.repository.Pessoas;

@Controller
@RequestMapping("/pessoa")
public class PessoaController {
	
	@Autowired
	private Pessoas pessoas;
	
	@RequestMapping("/novo")
	public String novo() {
		return "CadastroPessoa";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(Pessoa pessoa) {
		
		pessoas.save(pessoa);
		return "CadastroPessoa";
	}
}
