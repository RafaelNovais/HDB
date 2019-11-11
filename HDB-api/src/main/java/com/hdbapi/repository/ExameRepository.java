package com.hdbapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hdbapi.model.Exame;
import com.hdbapi.repository.exame.ExameRepositoryQuery;

public interface ExameRepository extends JpaRepository<Exame, Long>,  ExameRepositoryQuery {

}
