package com.hdbapi.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.hdbapi.model.Exame;
import com.hdbapi.repository.ExameRepository;

@Service
public class ExameService {
	
	@Autowired
	private ExameRepository exameRepository;
	
	public Exame atualizarExame(Long IDExame, Exame exame) {
		
		Exame exameAtualizado = exameRepository.findById(IDExame).orElse(null);
		
		if(exameAtualizado == null) {
			
		throw new EmptyResultDataAccessException(1);
		
		}else {
			
			BeanUtils.copyProperties(exame, exameAtualizado, "IDExame");
			return exameRepository.save(exameAtualizado);
		}
		
	}

}
