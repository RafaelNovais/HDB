package com.hdbapi.service;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.hdbapi.model.Arteria;
import com.hdbapi.repository.ArteriaRepository;

@Service
public class ArteriaService {
	
	@Autowired
	private ArteriaRepository arteriaRepository;

	public Arteria atualizarArteria(Long codarteria,Arteria arteria) {
	
		Arteria arteriaAtualizada = buscarArteria(codarteria);
			
			BeanUtils.copyProperties(arteria, arteriaAtualizada, "codarteria");
			return arteriaRepository.save(arteriaAtualizada);
		
	}

	public Arteria buscarArteria(Long codarteria) {
		Arteria arteriaAtualizada = arteriaRepository.findById(codarteria).orElse(null);
		
		if(arteriaAtualizada == null){
			
			throw new EmptyResultDataAccessException(1);	
		}
		return arteriaAtualizada;
	}
	
	
			
		
		
		
}


