package com.hdbapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tblarteria")
public class Arteria {
	
	@Id
	@NotNull
	private long codarteria;
	
	@NotNull
	@Size(min=0, max=20)
	private String nomearteria;	
	
	public long getCodarteria() {
		return codarteria;
	}
	public void setCodarteria(long codarteria) {
		this.codarteria = codarteria;
	}
	public String getNomearteria() {
		return nomearteria;
	}
	public void setNomearteria(String nomearteria) {
		this.nomearteria = nomearteria;
	}

	
	
	

}
