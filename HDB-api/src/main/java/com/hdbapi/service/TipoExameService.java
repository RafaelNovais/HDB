package com.hdbapi.service;



import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.hdbapi.model.TipoExame;
import com.hdbapi.repository.TipoExameRepository;

@Service
public class TipoExameService {
	
	@Autowired
	public TipoExameRepository tipoExameRepository;

	public TipoExame atualizarTipoExame(Long idtipo,TipoExame tipoExame) {
		
		TipoExame tipoExameAtualiza = tipoExameRepository.findById(idtipo).orElse(null);

		if(tipoExameAtualiza == null) {			
			
			throw new EmptyResultDataAccessException(1);
			
		}else {

			BeanUtils.copyProperties(tipoExame, tipoExameAtualiza, "idtipo");
			return tipoExameRepository.save(tipoExameAtualiza);


		}
	}

}
