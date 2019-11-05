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
		
		Medico medicoAtualizado = buscarMedicoId(Idmedico);
			
			BeanUtils.copyProperties(medico, medicoAtualizado, "Idmedico");
			return medicoRepository.save(medicoAtualizado);
		}
	

	public void atualizarMedicoAtivo(Long Idmedico, boolean Ativo) {
	
		Medico medicoAtualizado = buscarMedicoId(Idmedico);
		medicoAtualizado.setAtivo(Ativo);
		medicoRepository.save(medicoAtualizado);
		
	}
	
	
	
	public Medico buscarMedicoId(Long Idmedico) {
		Medico medicoAtualizado = medicoRepository.findById(Idmedico).orElse(null);
		
		if(medicoAtualizado == null) {
			
			throw new EmptyResultDataAccessException(1);
			
		}
		return medicoAtualizado;
	}	
		

}
