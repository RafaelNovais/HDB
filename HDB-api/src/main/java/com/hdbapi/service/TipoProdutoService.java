package com.hdbapi.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.hdbapi.model.TipoProduto;
import com.hdbapi.repository.TipoProdutoRepository;


@Service
public class TipoProdutoService {
	
	@Autowired
	private TipoProdutoRepository tipoProdutoRepository;

	public TipoProduto atualizarTipoProduto(Long idtipoproduto, TipoProduto tipoProduto) {

		TipoProduto tipoProdutoAtualiza = buscarTipoProduto(idtipoproduto);

			BeanUtils.copyProperties(tipoProduto, tipoProdutoAtualiza, "codigo");
			return tipoProdutoRepository.save(tipoProdutoAtualiza);


		}

	public TipoProduto buscarTipoProduto(Long idtipoproduto) {
		TipoProduto tipoProdutoAtualiza = tipoProdutoRepository.findById(idtipoproduto).orElse(null);

		if(tipoProdutoAtualiza == null) {			
			
			
			throw new EmptyResultDataAccessException(1);
			
		}
		return tipoProdutoAtualiza;
	}
		
		
}


