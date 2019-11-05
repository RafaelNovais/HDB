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
import com.hdbapi.model.Medico;
import com.hdbapi.repository.MedicoRepository;
import com.hdbapi.service.MedicoService;

@RestController
@RequestMapping("/medico")
public class MedicoResource {
	
	@Autowired
	private MedicoRepository medicoRepository;
	
	@Autowired
	private MedicoService medicoService;
	
	@GetMapping
	public ResponseEntity<?> listarMedico (){
		
		List<Medico> medico = medicoRepository.findAll();
		
		return !medico.isEmpty() ? ResponseEntity.ok(medico) : ResponseEntity.noContent().build();
		
		}
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@PostMapping
	
	public ResponseEntity<Medico> incluiMedico(@Valid @RequestBody Medico medico, HttpServletResponse response){
		
		Medico medicoSalva = medicoRepository.save(medico);
		
		publisher.publishEvent(new RecursoCriadoEvent(this,response, medicoSalva.getIdmedico()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(medicoSalva);
		
	}
	
	@GetMapping("/{Idmedico}")
	public Optional<Medico> buscarMedico(@PathVariable Long Idmedico){
		
		return medicoRepository.findById(Idmedico);
		
		
	}
	
	@DeleteMapping("/{Idmedico}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarMedico(@PathVariable Long Idmedico) {
		
		medicoRepository.deleteById(Idmedico);
		
	}
	
	@PutMapping("/{Idmedico}")
	public ResponseEntity<Medico> atualizarMedico(@PathVariable Long Idmedico, @Valid @RequestBody Medico medico){
		
		Medico medicoAtualizado = medicoService.atualizarMedico(Idmedico, medico);
		return ResponseEntity.ok(medicoAtualizado);
		
	}
	
	@PutMapping("/{Idmedico}/Ativo")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizarMedicoAtivo(@PathVariable Long Idmedico, @Valid @RequestBody boolean ativo){
		
		medicoService.atualizarMedicoAtivo(Idmedico, ativo);
		
	}
	

}
