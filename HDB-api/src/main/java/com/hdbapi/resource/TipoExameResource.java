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
	
	@Autowired
	private ApplicationEventPublisher publisher;
		
	@PostMapping
	
	public ResponseEntity<TipoExame> incluirTipoExame(@Valid @RequestBody TipoExame tipoExame, HttpServletResponse response){
		
		TipoExame tipoExameSalva = tipoExameRepository.save(tipoExame);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, tipoExameSalva.getIdtipo()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(tipoExameSalva);
		
	}
	
	@GetMapping("/{Idtipo}")
	public Optional<TipoExame> buscarTipoExame(@PathVariable Long Idtipo){
		
		return tipoExameRepository.findById(Idtipo);
		
	}
	
	@DeleteMapping("/{Idtipo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarTipoExame(@PathVariable Long Idtipo) {
		
		tipoExameRepository.deleteById(Idtipo);
		
	}

		
		
}

