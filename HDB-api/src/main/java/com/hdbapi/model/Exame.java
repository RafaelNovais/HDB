package com.hdbapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblexames")
public class Exame {
	
	@Id
	private Long IDExame;
	private String Codigoexame;
	private String Exame;
	private int Idtipo;
	private int Idsubtipo;
	private String Laudo;
	private double ValorSP;
	private double ValorSH;
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
	public int getIdtipo() {
		return Idtipo;
	}
	public void setIdtipo(int idtipo) {
		Idtipo = idtipo;
	}
	public int getIdsubtipo() {
		return Idsubtipo;
	}
	public void setIdsubtipo(int idsubtipo) {
		Idsubtipo = idsubtipo;
	}

	
	
	

}
