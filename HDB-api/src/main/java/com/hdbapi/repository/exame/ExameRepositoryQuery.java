package com.hdbapi.repository.exame;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.hdbapi.model.Exame;
import com.hdbapi.repository.filter.ExameFilter;

public interface ExameRepositoryQuery {
	
	public Page<Exame> filtrarExame(ExameFilter exameFilter, Pageable pageable);
		
		
	

	
}
