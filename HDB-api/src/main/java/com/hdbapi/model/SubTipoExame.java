package com.hdbapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tblsubtipo")
public class SubTipoExame {
	
	@Id
	private long Idsubtipo;
	private String Subtipo;
	
	
	public String getSubtipo() {
		return Subtipo;
	}
	public void setSubtipo(String subtipo) {
		Subtipo = subtipo;
	}
	public long getIdsubtipo() {
		return Idsubtipo;
	}
	public void setIdsubtipo(long idsubtipo) {
		Idsubtipo = idsubtipo;
	}
	

}
