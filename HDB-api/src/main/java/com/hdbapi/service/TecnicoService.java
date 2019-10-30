package com.hdbapi.service;

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

	public Tecnico atualizarCategoria(Long Idtecnico, Tecnico tecnico) {

		Tecnico tecnicoAtualiza = tecnicoRepository.findById(Idtecnico).orElse(null);

		if(tecnicoAtualiza == null) {			
			
			
			throw new EmptyResultDataAccessException(1);
			
		}else {

			BeanUtils.copyProperties(tecnico, tecnicoAtualiza, "Idtecnico");
			return tecnicoRepository.save(tecnicoAtualiza);


		}

	}

}
