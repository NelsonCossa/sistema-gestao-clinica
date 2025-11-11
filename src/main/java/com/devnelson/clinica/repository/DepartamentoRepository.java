package com.devnelson.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devnelson.clinica.domain.Departamento;


@Repository
public interface DepartamentoRepository  extends JpaRepository<Departamento, Long>{
	
	
}
