package com.hdbapi.repository.filter;

import com.hdbapi.model.TipoProduto;

public class ProdutoFilter {
	
	private Long codigoses;
	private String material;
	private String especificacao;
	private Integer estoqueminimo;
	private TipoProduto tipoproduto;
	private boolean descontinuado;
	private String codbar;
	
	public Long getCodigoses() {
		return codigoses;
	}
	public void setCodigoses(Long codigoses) {
		this.codigoses = codigoses;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getEspecificacao() {
		return especificacao;
	}
	public void setEspecificacao(String especificacao) {
		this.especificacao = especificacao;
	}
	public Integer getEstoqueminimo() {
		return estoqueminimo;
	}
	public void setEstoqueminimo(Integer estoqueminimo) {
		this.estoqueminimo = estoqueminimo;
	}
	public TipoProduto getTipoproduto() {
		return tipoproduto;
	}
	public void setTipoproduto(TipoProduto tipoproduto) {
		this.tipoproduto = tipoproduto;
	}
	public boolean isDescontinuado() {
		return descontinuado;
	}
	public void setDescontinuado(boolean descontinuado) {
		this.descontinuado = descontinuado;
	}
	public String getCodbar() {
		return codbar;
	}
	public void setCodbar(String codbar) {
		this.codbar = codbar;
	}

	
	
}
