package com.hdbapi.service;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;


import com.hdbapi.model.Tecnico;
import com.hdbapi.repository.TecnicoRepository;


@Service
public class TecnicoService {

	@Autowired
	private TecnicoRepository tecnicoRepository; 

	public Tecnico atualizarTecnico(Long Idtecnico, Tecnico tecnico) {

		Tecnico tecnicoAtualiza = buscarTecnicoId(Idtecnico);

			BeanUtils.copyProperties(tecnico, tecnicoAtualiza, "Idtecnico");
			return tecnicoRepository.save(tecnicoAtualiza);
		

	}

	public Tecnico buscarTecnicoId(Long Idtecnico) {
		Tecnico tecnicoAtualiza = tecnicoRepository.findById(Idtecnico).orElse(null);

		if(tecnicoAtualiza == null) {			
			
			
			throw new EmptyResultDataAccessException(1);
			
		}
		return tecnicoAtualiza;
	}

	public void atualizarTecnicoAtivo(Long idtecnico, @Valid boolean ativo) {

		Tecnico tecnicoAtualiza = buscarTecnicoId(idtecnico);
		tecnicoAtualiza.setAtivo(ativo);
		tecnicoRepository.save(tecnicoAtualiza);
		
	}

}
