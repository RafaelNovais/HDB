package com.hdbapi.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdbapi.model.TipoExame;
import com.hdbapi.repository.TipoExameRepository;

@RestController
@RequestMapping("/tipoexame")
public class TipoExameResource {
	
	@Autowired
	private TipoExameRepository tipoExameRepository;
	
	@GetMapping
	public ResponseEntity<?> listarTipoExame(){
		
		List<TipoExame> tipoExame = tipoExameRepository.findAll();
		
		return ! tipoExame.isEmpty() ? ResponseEntity.ok(tipoExame) : ResponseEntity.noContent().build();
		
		
	}
	
	

}
