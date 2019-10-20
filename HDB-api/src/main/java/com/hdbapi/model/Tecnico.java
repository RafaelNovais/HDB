package com.hdbapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbltecnico")
public class Tecnico {
	
	@Id
	private long Idtecnico;
	private String tecnico;
	private boolean ativo;
	
	public long getIdtecnico() {
		return Idtecnico;
	}
	public void setIdtecnico(long idtecnico) {
		Idtecnico = idtecnico;
	}
	public String getTecnico() {
		return tecnico;
	}
	public void setTecnico(String tecnico) {
		this.tecnico = tecnico;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}


}
