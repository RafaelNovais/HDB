package com.hdbapi.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdbapi.model.TipoProduto;
import com.hdbapi.repository.TipoProdutoRepository;

@RestController
@RequestMapping("/tipoproduto")
public class TipoProdutoResource {
	
	@Autowired
	private TipoProdutoRepository tipoProdutoRepository;
	
	@GetMapping
	public ResponseEntity<?> ListarTipoProduto(){
		
		List<TipoProduto> tipoProduto = tipoProdutoRepository.findAll();
		
		return !tipoProduto.isEmpty() ? ResponseEntity.ok(tipoProduto) : ResponseEntity.noContent().build();
		
		
		
	}
	
	

}
