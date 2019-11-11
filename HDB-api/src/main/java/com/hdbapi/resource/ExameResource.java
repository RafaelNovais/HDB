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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hdbapi.event.RecursoCriadoEvent;
import com.hdbapi.model.Exame;
import com.hdbapi.repository.ExameRepository;
import com.hdbapi.repository.filter.ExameFilter;
import com.hdbapi.service.ExameService;


@RestController
@RequestMapping("/exame")
public class ExameResource {
	
	@Autowired
	private ExameRepository exameRepository;
	

	@Autowired 
	private ExameService exameService;
	
	@GetMapping
	public ResponseEntity<?> pesquisarExame(ExameFilter exameFilter){
		
		List<Exame> exames = exameRepository.filtrarExame(exameFilter);
		
		return !exames.isEmpty() ? ResponseEntity.ok(exames) : ResponseEntity.noContent().build();
			
	}
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@PostMapping
	public ResponseEntity<Exame> incluirExame(@Valid @RequestBody Exame exame, HttpServletResponse response){
		
		Exame exameSalva = exameService.salvarExame(exame);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, exameSalva.getIDExame()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(exameSalva);
	
	}
	
	@GetMapping("/{IDExame}")
	public Optional<Exame> buscarExame(@PathVariable Long IDExame){
		
		return exameRepository.findById(IDExame);
		
	}
	
	@DeleteMapping("/{IDExame}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarExame(@PathVariable Long IDExame) {
		
		exameRepository.deleteById(IDExame);
		
	}
	
	@PutMapping("/{IDExame}")
	public ResponseEntity<Exame> atualizarExame(@PathVariable Long IDExame, @Valid @RequestBody Exame exame){
		
		Exame exameAtualizado = exameService.atualizarExame(IDExame, exame);
		return ResponseEntity.ok(exameAtualizado);
		
	}
	
	@PutMapping("/{IDExame}/Ativo")
	public void atualizarExame(@PathVariable Long IDExame, @Valid @RequestBody boolean terapeutico){
		
		 exameService.atualizarExameTerapeutico(IDExame, terapeutico);

	}
	
	

}
