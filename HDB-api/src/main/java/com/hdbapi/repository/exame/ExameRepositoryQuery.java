package com.hdbapi.repository.exame;

import java.util.List;

import com.hdbapi.model.Exame;
import com.hdbapi.repository.filter.ExameFilter;

public interface ExameRepositoryQuery {
	
	public List<Exame> filtrarExame(ExameFilter exameFilter);
		
		
	

	
}
