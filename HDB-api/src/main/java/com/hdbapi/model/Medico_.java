package com.hdbapi.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Medico.class)
public abstract class Medico_ {

	public static volatile SingularAttribute<Medico, Especialidade> especialidade;
	public static volatile SingularAttribute<Medico, Boolean> Ativo;
	public static volatile SingularAttribute<Medico, Long> Idmedico;
	public static volatile SingularAttribute<Medico, String> Nomecompleto;
	public static volatile SingularAttribute<Medico, String> Medico;
	public static volatile SingularAttribute<Medico, String> Cpfmed;
	public static volatile SingularAttribute<Medico, String> Nomedr;
	public static volatile SingularAttribute<Medico, String> CRM;

	public static final String ESPECIALIDADE = "especialidade";
	public static final String ATIVO = "Ativo";
	public static final String IDMEDICO = "Idmedico";
	public static final String NOMECOMPLETO = "Nomecompleto";
	public static final String MEDICO = "Medico";
	public static final String CPFMED = "Cpfmed";
	public static final String NOMEDR = "Nomedr";
	public static final String C_RM = "CRM";

}

