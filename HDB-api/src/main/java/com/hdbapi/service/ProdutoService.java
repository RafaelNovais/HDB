package com.hdbapi.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.hdbapi.model.Produto;
import com.hdbapi.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;

	public Produto atualizarProduto(Long codigoses, Produto produto) {
		
		Produto produtoAualiza = produtoRepository.findById(codigoses).orElse(null);
		
		if(produtoAualiza == null) {
			
			throw new EmptyResultDataAccessException(1);
			
		}else {
			
			BeanUtils.copyProperties(produto, produtoAualiza, "codigoses");
			return produtoRepository.save(produtoAualiza);
			
		}
	
	}

}
