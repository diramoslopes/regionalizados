package com.regionalizados.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.regionalizados.model.Apoiador;
import com.regionalizados.model.SegmentoApoiador;
import com.regionalizados.model.StatusApoio;
import com.regionalizados.model.VinculoApoiador;
import com.regionalizados.repository.Apoiadores;

@Controller
@RequestMapping("/apoiador")
public class ApoiadorController {
	
	@Autowired
	private Apoiadores apoiadores;
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("CadastroApoiador");
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(Apoiador apoiador) {
		apoiadores.save(apoiador);
		ModelAndView mv = new ModelAndView("CadastroApoiador");
		mv.addObject("mensagem", "Cadastro efetuado com sucesso!");
		return mv;
	}
	
	@RequestMapping
	public ModelAndView pesquisar() {
	    List<Apoiador> todosApoiadores =	apoiadores.findAll();
	    ModelAndView mv = new ModelAndView("PesquisaApoiadores");
		mv.addObject("apoiadores", todosApoiadores);
		return mv;
	}
	
	@ModelAttribute("todosStatusApoio")
	public List<StatusApoio> todosStatusApoio() {
		return Arrays.asList(StatusApoio.values());
	}
	
	@ModelAttribute("todosVinculos")
	public List<VinculoApoiador> todosVinculos() {
		return Arrays.asList(VinculoApoiador.values());
	}
	
	@ModelAttribute("todosSegmentos")
	public List<SegmentoApoiador> todosSegmentos() {
		return Arrays.asList(SegmentoApoiador.values());
	}
}
