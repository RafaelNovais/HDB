package com.hdbapi.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.hdbapi.model.Medico;
import com.hdbapi.repository.MedicoRepository;

@Service
public class MedicoService {

	@Autowired
	private MedicoRepository medicoRepository;
	
	public Medico atualizarMedico(Long Idmedico, Medico medico) {
		
		Medico medicoAtualizado = medicoRepository.findById(Idmedico).orElse(null);
		
		if(medicoAtualizado == null) {
			
			throw new EmptyResultDataAccessException(1);
			
		}else {
			
			BeanUtils.copyProperties(medico, medicoAtualizado, "Idmedico");
			return medicoRepository.save(medicoAtualizado);
		}	
		
	}
}
