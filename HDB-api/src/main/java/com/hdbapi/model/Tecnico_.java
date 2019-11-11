package com.hdbapi.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Tecnico.class)
public abstract class Tecnico_ {

	public static volatile SingularAttribute<Tecnico, Long> Idtecnico;
	public static volatile SingularAttribute<Tecnico, Boolean> ativo;
	public static volatile SingularAttribute<Tecnico, String> tecnico;

	public static final String IDTECNICO = "Idtecnico";
	public static final String ATIVO = "ativo";
	public static final String TECNICO = "tecnico";

}

