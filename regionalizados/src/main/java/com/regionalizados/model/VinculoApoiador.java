package com.regionalizados.model;

public enum VinculoApoiador {

	FAMILIA("Familia"),
	VIZINHO("Vizinho"),
	TRABALHO("Trabalho");
	
	private String descricao;
	
	VinculoApoiador(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}