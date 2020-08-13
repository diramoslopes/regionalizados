package com.regionalizados.model;

public enum StatusApoio {
	
	SIM("Sim"),
	NÃO("Não");
	
	private String descricao;
	
	StatusApoio(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}