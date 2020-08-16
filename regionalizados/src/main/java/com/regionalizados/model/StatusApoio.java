package com.regionalizados.model;

public enum StatusApoio {
	
	SIM("SIM"),
	NÃO("NÃO");
	
	private String descricao;
	
	StatusApoio(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}