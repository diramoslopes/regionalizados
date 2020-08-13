package com.regionalizados.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Apoiador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;

	private String nome;
	private String sobreNome;
	
	@Enumerated(EnumType.STRING)
	private VinculoApoiador vinculoApoiador;
	
	@Enumerated(EnumType.STRING)
	private SegmentoApoiador segmentoApoiador;
	
	@Enumerated(EnumType.STRING)
	private StatusApoio status;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date dataRegistro;
	
	public Long getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSobreNome() {
		return sobreNome;
	}
	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}
	
	public VinculoApoiador getVinculoApoiador() {
		return vinculoApoiador;
	}

	public void setVinculoApoiador(VinculoApoiador vinculoApoiador) {
		this.vinculoApoiador = vinculoApoiador;
	}

	public SegmentoApoiador getSegmentoApoiador() {
		return segmentoApoiador;
	}

	public void setSegmentoApoiador(SegmentoApoiador segmentoApoiador) {
		this.segmentoApoiador = segmentoApoiador;
	}

	public StatusApoio getStatus() {
		return status;
	}

	public void setStatus(StatusApoio status) {
		this.status = status;
	}
	
	public Date getDataRegistro() {
		return dataRegistro;
	}
	
	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}
	
	public boolean isSim() {
		return StatusApoio.SIM.equals(this.status);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Apoiador other = (Apoiador) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
}
