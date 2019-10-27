package com.hdbapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tbltipoproduto")
public class TipoProduto {
	
	@Id
	private long idtipoproduto;
	
	@Size(min=0, max=50)
	private String tipoproduto;
	
	public long getIdtipoproduto() {
		return idtipoproduto;
	}
	public void setIdtipoproduto(long idtipoproduto) {
		this.idtipoproduto = idtipoproduto;
	}
	public String getTipoproduto() {
		return tipoproduto;
	}
	public void setTipoproduto(String tipoproduto) {
		this.tipoproduto = tipoproduto;
	}
	

}
