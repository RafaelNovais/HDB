package com.hdbapi.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping
	public ResponseEntity<Arteria> incluirArteria(@Valid @RequestBody Arteria arteria, HttpServletResponse response){
		
		Arteria arteriaSalva = arteriaRepository.save(arteria);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/codarteria").buildAndExpand(arteriaSalva.getCodarteria()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(arteriaSalva);
		
		
	}
	
	@GetMapping("/{codarteria}")
	public Optional<Arteria> buscarArteria(@PathVariable Long codarteria){
		
		return arteriaRepository.findById(codarteria);
		
	}

}
