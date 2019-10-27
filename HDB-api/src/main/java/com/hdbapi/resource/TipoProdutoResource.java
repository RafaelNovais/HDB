package com.hdbapi.resource;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdbapi.event.RecursoCriadoEvent;
import com.hdbapi.model.TipoProduto;
import com.hdbapi.repository.TipoProdutoRepository;

@RestController
@RequestMapping("/tipoproduto")
public class TipoProdutoResource {
	
	@Autowired
	private TipoProdutoRepository tipoProdutoRepository;
	
	@GetMapping
	public ResponseEntity<?> listarTipoProduto(){
		
		List<TipoProduto> tipoProduto = tipoProdutoRepository.findAll();
		
		return !tipoProduto.isEmpty() ? ResponseEntity.ok(tipoProduto) : ResponseEntity.noContent().build();
		
	}
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@PostMapping
	
	public ResponseEntity<TipoProduto> incluirTipoProduto(@Valid @RequestBody TipoProduto tipoProduto, HttpServletResponse response) {
		
		TipoProduto tipoProdutoSalva = tipoProdutoRepository.save(tipoProduto);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, tipoProdutoSalva.getIdtipoproduto() ));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(tipoProdutoSalva);
		
		
	}
	
	@GetMapping("/{idtipoproduto}")
	public Optional<TipoProduto> buscarTipoProduto(@PathVariable Long idtipoproduto ){
		
		return tipoProdutoRepository.findById(idtipoproduto);
		
	}
	
	

}
