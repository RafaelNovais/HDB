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
import com.hdbapi.model.Exame;
import com.hdbapi.repository.ExameRepository;

@RestController
@RequestMapping("/exame")
public class ExameResource {
	
	@Autowired
	private ExameRepository exameRepository;
	
	@GetMapping
	public ResponseEntity<?> listarExame(){
		
		List<Exame> exames = exameRepository.findAll();
		
		return !exames.isEmpty() ? ResponseEntity.ok(exames) : ResponseEntity.noContent().build();
			
	}
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@PostMapping
	public ResponseEntity<Exame> incluirExame(@Valid @RequestBody Exame exame, HttpServletResponse response){
		
		Exame exameSalva = exameRepository.save(exame);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, exameSalva.getIDExame()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(exameSalva);
	
	}
	
	@GetMapping("/{IDExame}")
	public Optional<Exame> buscarExame(@PathVariable Long IDExame){
		
		return exameRepository.findById(IDExame);
		
	}

}
