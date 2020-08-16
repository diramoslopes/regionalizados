package com.regionalizados.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.regionalizados.model.Apoiador;
import com.regionalizados.model.StatusApoio;
import com.regionalizados.repository.Apoiadores;

@Service
public class CadastroApoiadorService {

	@Autowired
	private Apoiadores apoiadores;
	
	public void salvar(Apoiador apoiador) {
		apoiadores.save(apoiador);
	}

	public void excluir(Long codigo) {
		apoiadores.deleteById(codigo);	
	}
	
	public String confirmarApoio(Long codigo) {
		Apoiador apoiador = apoiadores.getOne(codigo);
		apoiador.setStatus(StatusApoio.SIM);
		apoiadores.save(apoiador);
		
		return StatusApoio.SIM.getDescricao();
	}
	
}
