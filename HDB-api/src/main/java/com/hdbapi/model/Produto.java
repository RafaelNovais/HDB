package com.hdbapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tblprodutos")
public class Produto {
	
	@Id
	private long codigoses;
	
	@Size(min=0, max=250)
	private String material;
	
	@Size(min=0, max=1000)
	private String especificacao;
	private Integer estoqueminimo;
	
	@ManyToOne
	@JoinColumn(name = "idtipoproduto")
	private TipoProduto tipoproduto;
	
	
	
	@NotNull
	private boolean descontinuado;
	
	@Size(min=0, max=20)
	private String codbar;
	
	
	
	public long getCodigoses() {
		return codigoses;
	}
	public void setCodigoses(long codigoses) {
		this.codigoses = codigoses;
	}
	public String getMaterial() {
		
		if(material == null ) {
		return "0";
		}
		return material;			
	
		
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public int getEstoqueminimo() {
		
		if(estoqueminimo == null ) {
		return 0;
		}
		return estoqueminimo;			
		
		
	}
	public void setEstoqueminimo(int estoqueminimo) {
		this.estoqueminimo = estoqueminimo;
	}
	

	public boolean isDescontinuado() {
		return descontinuado;
	}
	public void setDescontinuado(boolean descontinuado) {
		this.descontinuado = descontinuado;
	}
	public String getCodbar() {
		
		if(codbar == null ) {
		return "0";
		}	
		return codbar;			
		
		
	}
	public void setCodbar(String codbar) {
		this.codbar = codbar;
	}
	public String getEspecificacao() {
		
		if(especificacao == null ) {
		return "0";
		}
		return especificacao;			
		
		
	}
	public void setEspecificacao(String especificacao) {
		this.especificacao = especificacao;
	}

	public TipoProduto getTipoproduto() {
		return tipoproduto;
	}
	public void setTipoproduto(TipoProduto tipoproduto) {
		this.tipoproduto = tipoproduto;
	}
	public void setEstoqueminimo(Integer estoqueminimo) {
		this.estoqueminimo = estoqueminimo;
	}
}
