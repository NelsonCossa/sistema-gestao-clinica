package com.devnelson.clinica.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.devnelson.clinica.domain.Funcionario;
@Repository
public interface FuncionarioRepository  extends JpaRepository<Funcionario, Long> {

	
	   
    @Query("SELECT f FROM Funcionario f WHERE LOWER(f.nome) LIKE LOWER(CONCAT('%', :nome, '%'))")
    List<Funcionario> buscarPorNome(@Param("nome") String nome);
    
    @Query("SELECT f FROM Funcionario f WHERE f.cargo.id = :cargoId")
    List<Funcionario> buscarPorCargoId(@Param("cargoId") Long cargoId);
    

    
    
    @Query("SELECT f FROM Funcionario f " +
            "WHERE f.dataEntrada <= :saida " +
            "  AND (f.dataSaida IS NULL OR f.dataSaida >= :entrada) " +
            "ORDER BY f.dataEntrada ASC")
     List<Funcionario> buscarPorDatas(@Param("entrada") LocalDate entrada,
                                      @Param("saida") LocalDate saida);

    @Query("SELECT f FROM Funcionario f "
         + "WHERE f.dataEntrada = :entrada "
         + "ORDER BY f.dataEntrada ASC")
    List<Funcionario> buscarPorDataEntrada(@Param("entrada") LocalDate entrada);

 
    @Query("SELECT f FROM Funcionario f "
         + "WHERE f.dataSaida = :saida "
         + "ORDER BY f.dataEntrada ASC")
    List<Funcionario> buscarPorDataSaida(@Param("saida") LocalDate saida);

}
