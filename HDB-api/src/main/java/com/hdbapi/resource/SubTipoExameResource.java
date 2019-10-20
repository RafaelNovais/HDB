package com.hdbapi.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdbapi.model.SubTipoExame;
import com.hdbapi.repository.SubTipoExameRepository;

@RestController
@RequestMapping("/subtipoexame")
public class SubTipoExameResource {
	
	@Autowired
	private SubTipoExameRepository subTipoExameRepository;
	
	@GetMapping
	public ResponseEntity<?> listaSubTipoExame(){
		
		List<SubTipoExame> subTipoExame = subTipoExameRepository.findAll();
		
		return !subTipoExame.isEmpty() ? ResponseEntity.ok(subTipoExame) : ResponseEntity.noContent().build();
		
		
		
	}
	
	

}
