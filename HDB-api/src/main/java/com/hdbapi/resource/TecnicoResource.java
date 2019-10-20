package com.hdbapi.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdbapi.model.Tecnico;
import com.hdbapi.repository.TecnicoRepository;

@RestController
@RequestMapping("/tecnico")
public class TecnicoResource {
	
	@Autowired
	private TecnicoRepository  tecnicoRepository;
	
	@GetMapping
	public ResponseEntity<?> listarTecnicos(){
		
		List<Tecnico> tecnico = tecnicoRepository.findAll();
		
		return ! tecnico.isEmpty() ? ResponseEntity.ok(tecnico) : ResponseEntity.noContent().build();
		
	}

}
