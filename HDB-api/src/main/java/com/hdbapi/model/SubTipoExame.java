package com.hdbapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="tblsubtipo")
public class SubTipoExame {
	
	@Id
	private long Idsubtipo;
	
	@Size(min=0, max=25)
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
