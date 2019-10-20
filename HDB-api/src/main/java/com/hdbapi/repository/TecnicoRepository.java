package com.hdbapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hdbapi.model.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Long> {

}
