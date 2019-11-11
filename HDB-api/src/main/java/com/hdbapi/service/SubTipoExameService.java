package com.hdbapi.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdbapi.model.SubTipoExame;
import com.hdbapi.repository.SubTipoExameRepository;
import com.hdbapi.service.exeception.SubTipoExameInexistenteOuInativo;

@Service
public class SubTipoExameService {
	
	@Autowired
	private SubTipoExameRepository subTipoExameRepository;
	
	public SubTipoExame atualizarSubTipoExame(Long Idsubtipo, SubTipoExame subTipoExame) {
		
		SubTipoExame subTipoExameAtualiza = buscarSubTipoExame(Idsubtipo);
			
			BeanUtils.copyProperties(subTipoExame, subTipoExameAtualiza, "Idsubtipo");
			return subTipoExameRepository.save(subTipoExameAtualiza);
			
		}

	public SubTipoExame buscarSubTipoExame(Long Idsubtipo) {
		SubTipoExame subTipoExameAtualiza = subTipoExameRepository.findById(Idsubtipo).orElse(null);
		
		if(subTipoExameAtualiza == null) {
			
			throw new SubTipoExameInexistenteOuInativo();
			
		}
		return subTipoExameAtualiza;
	}
		
			
}
	


