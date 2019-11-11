package com.hdbapi.repository.produto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.hdbapi.model.Produto;
import com.hdbapi.model.Produto_;
import com.hdbapi.repository.filter.ProdutoFilter;

public class ProdutoRepositoryImpl implements ProdutoRepositoryQuery  {

	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Produto> filtrarProduto(ProdutoFilter produtoFilter) {
		
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Produto> criteria = builder.createQuery(Produto.class);
		Root<Produto> root = criteria.from(Produto.class);
		
		
		Predicate[] predicates = criarRestricoes(produtoFilter, builder, root);
		criteria.where(predicates);
		
		
		TypedQuery<Produto> query = manager.createQuery(criteria);
		return query.getResultList();
	}

	private Predicate[] criarRestricoes(ProdutoFilter produtoFilter, CriteriaBuilder builder, Root<Produto> root) {
		
		List<Predicate> predicates = new ArrayList<>();
		
		if(produtoFilter.getCodigoses() != null) {
			predicates.add(builder.like(builder.lower(root.get(Produto_.CODIGOSES)),"%" + produtoFilter.getCodigoses() ));
		
		}
		
		if(produtoFilter.getMaterial() != null) {
			predicates.add(builder.like(builder.lower(root.get(Produto_.MATERIAL)),"%" + produtoFilter.getMaterial().toLowerCase() + "%" ));
			
		}
		
		if(produtoFilter.getEspecificacao() != null) {
			predicates.add(builder.like(builder.lower(root.get(Produto_.ESPECIFICACAO)),"%" + produtoFilter.getEspecificacao().toLowerCase() + "%" ));
			
		}
		
		if(produtoFilter.getEstoqueminimo() != null) {
			predicates.add(builder.like(builder.lower(root.get(Produto_.ESTOQUEMINIMO)),"%" + produtoFilter.getEstoqueminimo() + "%" ));
			
		}
		
		if(produtoFilter.getTipoproduto() != null) {
			predicates.add(builder.equal(root.get(Produto_.TIPOPRODUTO),produtoFilter.getTipoproduto() ));
			
		}
		
		if(produtoFilter.getCodbar() != null) {
			predicates.add(builder.like(builder.lower(root.get(Produto_.CODBAR)),"%" + produtoFilter.getCodbar().toLowerCase() + "%" ));
			
		}
		
//		if(produtoFilter.isDescontinuado() != null) {
//			
//			
//		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}
	
	
	

}
