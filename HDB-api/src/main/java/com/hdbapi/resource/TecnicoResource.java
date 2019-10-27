package com.hdbapi.resource;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdbapi.event.RecursoCriadoEvent;
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
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@PostMapping
	
	public ResponseEntity<Tecnico> incluirTecnico(@Valid @RequestBody Tecnico tecnico, HttpServletResponse response){
		
		Tecnico tecnicoSalva = tecnicoRepository.save(tecnico);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, tecnicoSalva.getIdtecnico()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(tecnicoSalva);
				
	}
	
	@GetMapping("/{Idtecnico}")
	public Optional<Tecnico> buscarTecnico(@PathVariable Long Idtecnico){
		
		return tecnicoRepository.findById(Idtecnico);
		
	}

}
