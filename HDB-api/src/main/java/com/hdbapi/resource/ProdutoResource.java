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
import com.hdbapi.model.Produto;
import com.hdbapi.repository.ProdutoRepository;
import com.hdbapi.service.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoResource {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping
	public ResponseEntity<?> listarProduto(){
		
		List<Produto> produto = produtoRepository.findAll();
		
		return !produto.isEmpty() ? ResponseEntity.ok(produto) : ResponseEntity.noContent().build();
		
	}
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	
	@PostMapping
	
	public ResponseEntity<Produto> incluirProduto(@Valid @RequestBody Produto produto, HttpServletResponse response){
		
		Produto produtoSalva = produtoRepository.save(produto);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, produtoSalva.getCodigoses()));
		
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalva);
		 
	}

	@GetMapping("/{codigoses}")
	public Optional<Produto> buscarCategoria(@PathVariable Long codigoses) {

		return produtoRepository.findById(codigoses);

	}
	
	@DeleteMapping("/{codigoses}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarProduto(@PathVariable Long codigoses) {
		
		produtoRepository.deleteById(codigoses);
		
	}
	
	@PutMapping("/{codigoses}")
	public ResponseEntity<Produto> atualizarProduto(@PathVariable Long codigoses,@Valid @RequestBody Produto produto ){
		
		Produto produtoAtualizado = produtoService.atualizarProduto(codigoses, produto);
		return ResponseEntity.ok(produtoAtualizado);
		
	}
	
	@PutMapping("/{codigoses}/ativo")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizarDescontinuado(@PathVariable Long codigoses, @RequestBody boolean descontinuado) {
		
		produtoService.atualizarDescontinuado(codigoses, descontinuado);
		
		
		
	}
	
	
	

}
