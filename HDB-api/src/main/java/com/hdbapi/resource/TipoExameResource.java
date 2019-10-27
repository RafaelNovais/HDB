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
	
	@PostMapping
	
	public ResponseEntity<TipoExame> incluirTipoExame(@Valid @RequestBody TipoExame tipoExame, HttpServletResponse response){
		
		TipoExame tipoExameSalva = tipoExameRepository.save(tipoExame);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{Idtipo}").buildAndExpand(tipoExameSalva.getIdtipo()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(tipoExameSalva);
		
	}
	
	@GetMapping("/{Idtipo}")
	public Optional<TipoExame> buscarTipoExame(@PathVariable Long Idtipo){
		
		return tipoExameRepository.findById(Idtipo);
		
	}	
		
		
}

