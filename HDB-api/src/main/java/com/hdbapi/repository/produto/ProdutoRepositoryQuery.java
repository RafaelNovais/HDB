package com.hdbapi.repository.produto;

import java.util.List;

import com.hdbapi.model.Produto;
import com.hdbapi.repository.filter.ProdutoFilter;

public interface ProdutoRepositoryQuery {
	
	public List<Produto> filtrarProduto(ProdutoFilter produtoFilter);
	

}
