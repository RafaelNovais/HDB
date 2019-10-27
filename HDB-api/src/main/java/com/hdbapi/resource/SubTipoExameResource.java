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
import com.hdbapi.model.SubTipoExame;
import com.hdbapi.repository.SubTipoExameRepository;

@RestController
@RequestMapping("/subtipoexame")
public class SubTipoExameResource {
	
	@Autowired
	private SubTipoExameRepository subTipoExameRepository;
	
	@GetMapping
	public ResponseEntity<?> listaSubTipoExame(){
		
		List<SubTipoExame> subTipoExame = subTipoExameRepository.findAll();
		
		return !subTipoExame.isEmpty() ? ResponseEntity.ok(subTipoExame) : ResponseEntity.noContent().build();
		
	}
	
	@Autowired
	private ApplicationEventPublisher publisher;
		
	@PostMapping
	
	public ResponseEntity<SubTipoExame> incluirSubTipoExame(@Valid @RequestBody SubTipoExame subTipoExame, HttpServletResponse response){
		
		SubTipoExame subTipoExameSalva = subTipoExameRepository.save(subTipoExame);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, subTipoExameSalva.getIdsubtipo()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(subTipoExameSalva);
		 
	}

	@GetMapping("/{Idsubtipo}")
	public Optional<SubTipoExame> buscarSubTipoExame(@PathVariable Long Idsubtipo) {

		return subTipoExameRepository.findById(Idsubtipo);

	}
	
	@DeleteMapping("/{Idsubtipo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarSubTipo(@PathVariable Long Idsubtipo) {
		
		subTipoExameRepository.deleteById(Idsubtipo);
		
		
	}

}
	


