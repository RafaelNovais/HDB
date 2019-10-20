package com.hdbapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbltipoproduto")
public class TipoProduto {
	
	@Id
	private long idtipoproduto;
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
