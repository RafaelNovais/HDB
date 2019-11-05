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
		
		Produto produtoAualiza = buscarProdutoPeloCodigo(codigoses);
			
			BeanUtils.copyProperties(produto, produtoAualiza, "codigoses");
			return produtoRepository.save(produtoAualiza);
	
	}

	public Produto buscarProdutoPeloCodigo(Long codigoses) {
		Produto produtoAualiza = produtoRepository.findById(codigoses).orElse(null);
		
		if(produtoAualiza == null) {
			
			throw new EmptyResultDataAccessException(1);
			
		}
		return produtoAualiza;
	}

	public void atualizarDescontinuado(Long codigoses, boolean descontinuado) {

		Produto produtoAualiza = buscarProdutoPeloCodigo(codigoses);
		produtoAualiza.setDescontinuado(descontinuado);
		produtoRepository.save(produtoAualiza);
	}

}
