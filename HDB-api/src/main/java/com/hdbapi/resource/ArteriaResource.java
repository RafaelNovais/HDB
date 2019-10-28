package com.hdbapi.resource;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hdbapi.event.RecursoCriadoEvent;
import com.hdbapi.model.Arteria;
import com.hdbapi.repository.ArteriaRepository;

@RestController
@RequestMapping("/arteria")
public class ArteriaResource {
	
	@Autowired 
	private ArteriaRepository arteriaRepository;
	
	@GetMapping
	public ResponseEntity<?> listarArteria(){
		
		List<Arteria> arteria = arteriaRepository.findAll();
				
		return !arteria.isEmpty() ? ResponseEntity.ok(arteria) : ResponseEntity.noContent().build();
		
	}
	
	@Autowired
	private ApplicationEventPublisher publisher; 
	
	@PostMapping
	public ResponseEntity<Arteria> incluirArteria(@Valid @RequestBody Arteria arteria, HttpServletResponse response){
		
		Arteria arteriaSalva = arteriaRepository.save(arteria);

		publisher.publishEvent(new RecursoCriadoEvent(this, response, arteriaSalva.getCodarteria()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(arteriaSalva);
		
		
	}
	
	@GetMapping("/{codarteria}")
	public Optional<Arteria> buscarArteria(@PathVariable Long codarteria){
		
		return arteriaRepository.findById(codarteria);
		
	}
	
	@DeleteMapping("/{codarteria}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarArteria(@PathVariable Long codarteria) {
		
		arteriaRepository.deleteById(codarteria);
		
	}
	
	

}
