package com.regionalizados.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.regionalizados.model.Apoiador;
import com.regionalizados.model.SegmentoApoiador;
import com.regionalizados.model.StatusApoio;
import com.regionalizados.model.VinculoApoiador;
import com.regionalizados.repository.Apoiadores;

@Controller
@RequestMapping("/apoiador")
public class ApoiadorController {
	
	
	private static final String CADASTRO_VIEW = "CadastroApoiador";
	
	@Autowired
	private Apoiadores apoiadores;
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(new Apoiador());
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Apoiador apoiador, Errors errors, RedirectAttributes attributes) {

		if(errors.hasErrors()) {
			return CADASTRO_VIEW;
		}
		
		apoiadores.save(apoiador);
		attributes.addFlashAttribute("mensagem", "Cadastro efetuado com sucesso!");
		return "redirect:/apoiador/novo";
	}
	
	@RequestMapping
	public ModelAndView pesquisar() {
	    List<Apoiador> todosApoiadores =	apoiadores.findAll();
	    ModelAndView mv = new ModelAndView("PesquisaApoiadores");
		mv.addObject("apoiadores", todosApoiadores);
		return mv;
	}
	
	@RequestMapping("{codigo}")
	public ModelAndView edicao (@PathVariable("codigo") Apoiador apoiador) { // (@PathVariable Long codigo) {
//		Apoiador apoiador = apoiadores.getOne(codigo);
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(apoiador);
		return mv;
	}
	
	@RequestMapping(value="{codigo}", method = RequestMethod.DELETE)
	public String excluir(@PathVariable Long codigo, RedirectAttributes attributes) {
		apoiadores.deleteById(codigo);
		
		attributes.addFlashAttribute("mensagem", "Apoiador excluido com sucesso");
		return "redirect:/apoiador";
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
