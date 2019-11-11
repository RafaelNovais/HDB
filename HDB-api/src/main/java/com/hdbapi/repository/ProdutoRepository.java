package com.hdbapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hdbapi.model.Produto;
import com.hdbapi.repository.produto.ProdutoRepositoryQuery;

public interface ProdutoRepository extends JpaRepository<Produto, Long>, ProdutoRepositoryQuery {

}
