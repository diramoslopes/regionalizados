package com.regionalizados.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.regionalizados.model.Pessoa;

public interface Pessoas extends JpaRepository<Pessoa, Long>{

}
