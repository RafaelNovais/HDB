package com.hdbapi.repository.filter;

import com.hdbapi.model.SubTipoExame;
import com.hdbapi.model.TipoExame;

public class ExameFilter {
	
	
	private String Codigoexame;
	private String Exame;
	private TipoExame tipoExame;
	private SubTipoExame subtipoExame;
	private String Laudo;
	private Double ValorSPMenor;
	private Double ValorSHMenor;
	private Double ValorSPMaior;
	private Double ValorSHMaior;
	private boolean Terapeutico;
	
	
	public String getCodigoexame() {
		return Codigoexame;
	}
	public void setCodigoexame(String codigoexame) {
		Codigoexame = codigoexame;
	}
	public String getExame() {
		return Exame;
	}
	public void setExame(String exame) {
		Exame = exame;
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
	public String getLaudo() {
		return Laudo;
	}
	public void setLaudo(String laudo) {
		Laudo = laudo;
	}
	public double getValorSPMenor() {
		return ValorSPMenor;
	}
	public void setValorSPMenor(double valorSPMenor) {
		ValorSPMenor = valorSPMenor;
	}
	public double getValorSHMenor() {
		return ValorSHMenor;
	}
	public void setValorSHMenor(double valorSHMenor) {
		ValorSHMenor = valorSHMenor;
	}
	public double getValorSPMaior() {
		return ValorSPMaior;
	}
	public void setValorSPMaior(double valorSPMaior) {
		ValorSPMaior = valorSPMaior;
	}
	public double getValorSHMaior() {
		return ValorSHMaior;
	}
	public void setValorSHMaior(double valorSHMaior) {
		ValorSHMaior = valorSHMaior;
	}
	public boolean isTerapeutico() {
		return Terapeutico;
	}
	public void setTerapeutico(boolean terapeutico) {
		Terapeutico = terapeutico;
	}

	
	
	
}
