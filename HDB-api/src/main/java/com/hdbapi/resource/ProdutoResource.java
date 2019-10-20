package com.hdbapi.resource;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import com.hdbapi.model.Produto;
import com.hdbapi.repository.ProdutoRepository;

@RestController
@RequestMapping("/produto")
public class ProdutoResource {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping
	public ResponseEntity<?> listarProduto(){
		
		List<Produto> produto = produtoRepository.findAll();
		
		return !produto.isEmpty() ? ResponseEntity.ok(produto) : ResponseEntity.noContent().build();
		
	}
	
	@PostMapping
	public ResponseEntity<Produto> incluirProduto(@RequestBody Produto produto, HttpServletResponse response){
		
		Produto produtoSalva = produtoRepository.save(produto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigoses}").buildAndExpand(produtoSalva.getCodigoses()).toUri();
		response.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(produtoSalva);
		 
	}

	@GetMapping("/{codigoses}")
	public Optional<Produto> buscarCategoria(@PathVariable Long codigoses) {

		return produtoRepository.findById(codigoses);

	}

}
