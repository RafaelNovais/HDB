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
	
	@PostMapping
	
	public ResponseEntity<TipoProduto> incluirTipoProduto(@RequestBody TipoProduto tipoProduto, HttpServletResponse response) {
		
		TipoProduto tipoProdutoSalva = tipoProdutoRepository.save(tipoProduto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{idtipoproduto}").buildAndExpand(tipoProdutoSalva.getIdtipoproduto()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(tipoProdutoSalva);
		
		
	}
	
	@GetMapping("/{idtipoproduto}")
	public Optional<TipoProduto> buscarTipoProduto(@PathVariable Long idtipoproduto ){
		
		return tipoProdutoRepository.findById(idtipoproduto);
		
	}
	
	

}
