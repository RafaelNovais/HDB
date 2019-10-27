package com.hdbapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tbltecnico")
public class Tecnico {
	
	@Id
	private long Idtecnico;
	
	@Size(min=0, max=50)
	private String tecnico;
	
	@NotNull
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
