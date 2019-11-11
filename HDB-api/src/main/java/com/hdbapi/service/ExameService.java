package com.hdbapi.service;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.hdbapi.model.Exame;
import com.hdbapi.model.SubTipoExame;
import com.hdbapi.model.TipoExame;
import com.hdbapi.repository.ExameRepository;
import com.hdbapi.service.exeception.SubTipoExameInexistenteOuInativo;
import com.hdbapi.service.exeception.TipoExameInexistenteOuInativo;

@Service
public class ExameService {
	
	@Autowired
	private ExameRepository exameRepository;
	
	@Autowired
	private TipoExameService tipoExameService;
	
	@Autowired
	private SubTipoExameService subtipoExameService;
	
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

	public Exame salvarExame(@Valid Exame exame) {
		
		TipoExame tipoExame = tipoExameService.buscarTipoExame(exame.getTipoExame().getIdtipo());
		SubTipoExame subTipoExame =  subtipoExameService.buscarSubTipoExame(exame.getSubtipoExame().getIdsubtipo());
		
		if(tipoExame == null || !tipoExame.isAtivo()    ) {
			
			throw new TipoExameInexistenteOuInativo();
		}
		
		if (  subTipoExame == null  ) {
			
			throw new SubTipoExameInexistenteOuInativo();
		}
		
			
		return exameRepository.save(exame);
	}

}
