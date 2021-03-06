package com.regionalizados.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.regionalizados.model.Apoiador;

public interface Apoiadores extends JpaRepository<Apoiador, Long>{
	
	public List<Apoiador> findByNomeContaining(String nome);
	
}
