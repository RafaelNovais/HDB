package com.hdbapi.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Produto.class)
public abstract class Produto_ {

	public static volatile SingularAttribute<Produto, String> codbar;
	public static volatile SingularAttribute<Produto, String> material;
	public static volatile SingularAttribute<Produto, TipoProduto> tipoproduto;
	public static volatile SingularAttribute<Produto, String> especificacao;
	public static volatile SingularAttribute<Produto, Integer> estoqueminimo;
	public static volatile SingularAttribute<Produto, Boolean> descontinuado;
	public static volatile SingularAttribute<Produto, Long> codigoses;

	public static final String CODBAR = "codbar";
	public static final String MATERIAL = "material";
	public static final String TIPOPRODUTO = "tipoproduto";
	public static final String ESPECIFICACAO = "especificacao";
	public static final String ESTOQUEMINIMO = "estoqueminimo";
	public static final String DESCONTINUADO = "descontinuado";
	public static final String CODIGOSES = "codigoses";

}

