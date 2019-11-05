package com.hdbapi.service;

import javax.validation.Valid;

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
		
		Exame exameAtualizado = buscarExameId(IDExame);
			
			BeanUtils.copyProperties(exame, exameAtualizado, "IDExame");
			return exameRepository.save(exameAtualizado);
		
		
	}

	public Exame buscarExameId(Long IDExame) {
		Exame exameAtualizado = exameRepository.findById(IDExame).orElse(null);
		
		if(exameAtualizado == null) {
			
		throw new EmptyResultDataAccessException(1);
		
		}
		return exameAtualizado;
	}

	public void atualizarExameTerapeutico(Long iDExame, @Valid boolean terapeutico) {
		
		Exame exameAtualizado = buscarExameId(iDExame);
		exameAtualizado.setTerapeutico(terapeutico);
		exameRepository.save(exameAtualizado);
		
	}

}
