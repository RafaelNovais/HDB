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
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<SubTipoExame> incluirSubTipoExame(@RequestBody SubTipoExame subTipoExame, HttpServletResponse response){
		
		SubTipoExame subTipoExameSalva = subTipoExameRepository.save(subTipoExame);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{Idsubtipo}").buildAndExpand(subTipoExameSalva.getIdsubtipo()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(subTipoExameSalva);
		 
	}

	@GetMapping("/{Idsubtipo}")
	public Optional<SubTipoExame> buscarSubTipoExame(@PathVariable Long Idsubtipo) {

		return subTipoExameRepository.findById(Idsubtipo);

	}

}
	


