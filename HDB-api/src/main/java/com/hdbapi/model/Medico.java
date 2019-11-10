package com.hdbapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="tblmedico")
public class Medico {
	
	
	@Id
	private long Idmedico;
	
	@Size(min=0, max=50)
	private String Medico;
	
	@Size(min=0, max=50)
	private String Nomedr;
	
	@Size(min=0, max=50)
	private String Nomecompleto;
	
	@Size(min=0, max=25)
	private String CRM;
	
	//ChaveSecundaria
	private Especialidade especialidade;
	
	@NotNull
	private boolean Ativo;
	
	@Size(min=0, max=50)
	private String Cpfmed;
	

	
	public long getIdmedico() {
		return Idmedico;
	}
	public void setIdmedico(long idmedico) {
		Idmedico = idmedico;
	}
	public String getMedico() {
		if(Medico ==null) {
		return "0";
		}
		return Medico;
	}
	public void setMedico(String medico) {
		Medico = medico;
	}
	public String getNomedr() {
		return Nomedr;
	}
	public void setNomedr(String nomedr) {
		Nomedr = nomedr;
	}
	public String getNomecompleto() {
		return Nomecompleto;
	}
	public void setNomecompleto(String nomecompleto) {
		Nomecompleto = nomecompleto;
	}
	public String getCRM() {
		
		if(CRM == null) {
			return "0";
		}
		return CRM;
	}
	public void setCRM(String cRM) {
		CRM = cRM;
	}

	public boolean isAtivo() {
		return Ativo;
	}
	public void setAtivo(boolean ativo) {
		Ativo = ativo;
	}
	public String getCpfmed() {
		
		if(Cpfmed == null) {
			return "0";
		}
		return Cpfmed;
	}
	public void setCpfmed(String cpfmed) {
		Cpfmed = cpfmed;
	}
	public Especialidade getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

	
	
	

}
