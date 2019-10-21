package com.hdbapi.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	@PostMapping
	
	public ResponseEntity<Exame> incluirExame(@RequestBody Exame exame, HttpServletResponse response){
		
		Exame exameSalva = exameRepository.save(exame);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{IDExame}").buildAndExpand(exameSalva.getCodigoexame()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(exameSalva);
	
	}
	
	@GetMapping("/{IDExame}")
	public Optional<Exame> buscarExame(@PathVariable Long IDExame){
		
		return exameRepository.findById(IDExame);
		
	}

}
