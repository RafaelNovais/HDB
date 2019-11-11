package com.hdbapi.service;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.hdbapi.model.Categoria;
import com.hdbapi.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public Categoria atualizarCategoria(Long codigo, Categoria categoria) {

		Categoria categoriaAtualiza = buscarCategoria(codigo);

			BeanUtils.copyProperties(categoria, categoriaAtualiza, "codigo");
			return categoriaRepository.save(categoriaAtualiza);
	

	}

	public Categoria buscarCategoria(Long codigo) {
		Categoria categoriaAtualiza = categoriaRepository.findById(codigo).orElse(null);

		if(categoriaAtualiza == null) {			
			
			
			throw new EmptyResultDataAccessException(1);
			
		}
		return categoriaAtualiza;
	}

}
