package com.hdbapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hdbapi.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
