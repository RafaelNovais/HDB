package com.hdbapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tbltipoexame")
public class TipoExame {
	
	@Id
	private long Idtipo;
	
	@Size(min=0, max=35)
	private String Tipo;
	
	public long getIdtipo() {
		return Idtipo;
	}
	public void setIdtipo(long idtipo) {
		Idtipo = idtipo;
	}
	public String getTipo() {
		return Tipo;
	}
	public void setTipo(String tipo) {
		Tipo = tipo;
	}

	
	

}
