package com.hdbapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hdbapi.model.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long> {

}
