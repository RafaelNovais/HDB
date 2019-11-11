package com.hdbapi.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Exame.class)
public abstract class Exame_ {

	public static volatile SingularAttribute<Exame, String> Codigoexame;
	public static volatile SingularAttribute<Exame, String> Exame;
	public static volatile SingularAttribute<Exame, SubTipoExame> subtipoExame;
	public static volatile SingularAttribute<Exame, Double> ValorSP;
	public static volatile SingularAttribute<Exame, TipoExame> tipoExame;
	public static volatile SingularAttribute<Exame, String> Laudo;
	public static volatile SingularAttribute<Exame, Boolean> Terapeutico;
	public static volatile SingularAttribute<Exame, Double> ValorSH;
	public static volatile SingularAttribute<Exame, Long> IDExame;

	public static final String CODIGOEXAME = "Codigoexame";
	public static final String EXAME = "Exame";
	public static final String SUBTIPO_EXAME = "subtipoExame";
	public static final String VALOR_SP = "ValorSP";
	public static final String TIPO_EXAME = "tipoExame";
	public static final String LAUDO = "Laudo";
	public static final String TERAPEUTICO = "Terapeutico";
	public static final String VALOR_SH = "ValorSH";
	public static final String I_DEXAME = "IDExame";

}

