package com.devnelson.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devnelson.clinica.domain.Cargo;


@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {

}
