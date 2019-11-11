package com.hdbapi.repository.exame;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.hdbapi.model.Exame;
import com.hdbapi.model.Exame_;
import com.hdbapi.repository.filter.ExameFilter;

public class ExameRepositoryImpl implements ExameRepositoryQuery{
	
	@PersistenceContext
	private EntityManager manager;
	

	@Override
	public List<Exame> filtrarExame(ExameFilter exameFilter) {
		
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Exame> criteria = builder.createQuery(Exame.class);
		
		Root<Exame> root = criteria.from(Exame.class);
		
		
		Predicate[] predicates = criarRestricoes(exameFilter, builder ,root);
		criteria.where(predicates);
		
		TypedQuery<Exame> query = manager.createQuery(criteria);
		
		return query.getResultList();
	}


	private Predicate[] criarRestricoes(ExameFilter exameFilter, CriteriaBuilder builder ,Root<Exame> root) {
		
		List<Predicate> predicates = new ArrayList<>();
		
		if(exameFilter.getCodigoexame() != null) {
			predicates.add(builder.like(builder.lower(root.get(Exame_.CODIGOEXAME)), "%" + exameFilter.getCodigoexame().toLowerCase() + "%"));
			
		}
		
		if(exameFilter.getExame() != null) {
			predicates.add(builder.like(builder.lower(root.get(Exame_.EXAME)), "%" + exameFilter.getExame().toLowerCase() + "%"));
			
		}
		
		if(exameFilter.getLaudo() != null) {
			predicates.add(builder.like(builder.lower(root.get(Exame_.LAUDO)), "%" + exameFilter.getLaudo().toLowerCase() + "%"));
			
		}
		
		if(exameFilter.getSubtipoExame() != null) {
			predicates.add(builder.equal(root.get(Exame_.SUBTIPO_EXAME), exameFilter.getSubtipoExame()));
			
		}
		
		if(exameFilter.getTipoExame() != null) {
			predicates.add(builder.equal(root.get(Exame_.TIPO_EXAME), exameFilter.getTipoExame()));
			
		}
		
//		if(exameFilter.getValorSHMaior() != null) {
//			predicates.add(e);
//			
//		}
//		
//		if(exameFilter.getValorSHMenor() != null) {
//			predicates.add(e);
//			
//		}
//		
//		if(exameFilter.getValorSPMaior() != null) {
//			predicates.add(e);
//			
//		}
//		
//		if(exameFilter.getValorSPMenor() != null) {
//			predicates.add(e);
//			
//		}
//		
//		if(exameFilter.isTerapeutico() ) {
//			predicates.add(builder.equal(root.get(Exame_.SUBTIPO_EXAME)), exameFilter.isTerapeutico()));
//			
//		}
		
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}
	
}
