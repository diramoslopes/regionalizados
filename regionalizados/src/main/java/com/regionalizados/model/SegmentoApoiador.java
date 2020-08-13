package com.regionalizados.model;

public enum SegmentoApoiador {

	SAUDE("Saúde"),
	EDUCACAO("Educação"),
	SEGURANCA("Segurança");
	
	private String descricao;
	
	SegmentoApoiador(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}