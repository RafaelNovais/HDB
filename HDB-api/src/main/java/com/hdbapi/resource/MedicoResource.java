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

import com.hdbapi.model.Medico;
import com.hdbapi.repository.MedicoRepository;

@RestController
@RequestMapping("/medico")
public class MedicoResource {
	
	@Autowired
	private MedicoRepository medicoRepository;
	
	@GetMapping
	public ResponseEntity<?> listarMedico (){
		
		List<Medico> medico = medicoRepository.findAll();
		
		return !medico.isEmpty() ? ResponseEntity.ok(medico) : ResponseEntity.noContent().build();
		
		
	}
	
	@PostMapping
	
	public ResponseEntity<Medico> incluiMedico(@RequestBody Medico medico, HttpServletResponse response){
		
		Medico medicoSalva = medicoRepository.save(medico);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{Idmedico}").buildAndExpand(medicoSalva.getIdmedico()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(medicoSalva);
		
	}
	
	@GetMapping("/{Idmedico}")
	public Optional<Medico> buscarMedico(@PathVariable Long Idmedico){
		
		return medicoRepository.findById(Idmedico);
		
		
	}
	

}
