package com.hdbapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tblexames")
public class Exame {
	
	@Id
	@NotNull
	private Long IDExame;
	
	@NotNull
	@Size(min=0, max=11)
	private String Codigoexame;
	
	@Size(min=0, max=100)
	private String Exame;
	
	//ChaveSecundaria
	
	@ManyToOne
	@JoinColumn(name = "Idtipo")
	private TipoExame tipoExame;
	
	
	@ManyToOne
	@JoinColumn(name = "Idsubtipo")
	private SubTipoExame subtipoExame;
	
	@Size(min=0, max=1000)
	private String Laudo;
	
	
	private double ValorSP;
	private double ValorSH;
	
	@NotNull
	private boolean Terapeutico;
	
	
	
	public Long getIDExame() {
		return IDExame;
	}
	public void setIDExame(Long iDExame) {
		IDExame = iDExame;
	}

	public String getExame() {
		return Exame;
	}
	public void setExame(String exame) {
		Exame = exame;
	}

	public String getLaudo() {
		return Laudo;
	}
	public void setLaudo(String laudo) {
		Laudo = laudo;
	}
	public double getValorSP() {
		return ValorSP;
	}
	public void setValorSP(double valorSP) {
		ValorSP = valorSP;
	}
	public double getValorSH() {
		return ValorSH;
	}
	public void setValorSH(double valorSH) {
		ValorSH = valorSH;
	}
	public boolean isTerapeutico() {
		return Terapeutico;
	}
	public void setTerapeutico(boolean terapeutico) {
		Terapeutico = terapeutico;
	}
	public String getCodigoexame() {
		return Codigoexame;
	}
	public void setCodigoexame(String codigoexame) {
		Codigoexame = codigoexame;
	}
	
	public TipoExame getTipoExame() {
		return tipoExame;
	}
	public void setTipoExame(TipoExame tipoExame) {
		this.tipoExame = tipoExame;
	}
	public SubTipoExame getSubtipoExame() {
		return subtipoExame;
	}
	public void setSubtipoExame(SubTipoExame subtipoExame) {
		this.subtipoExame = subtipoExame;
	}

	
	

}
