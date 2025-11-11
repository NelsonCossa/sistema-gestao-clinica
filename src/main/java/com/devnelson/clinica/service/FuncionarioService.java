package com.devnelson.clinica.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devnelson.clinica.domain.Funcionario;
import com.devnelson.clinica.repository.FuncionarioRepository;

@Service
@Transactional
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository repository;

	public Funcionario salvar(Funcionario funcionario) {
		return repository.save(funcionario);
	}


	public Funcionario editar(Funcionario funcionario) {
		return repository.save(funcionario);
	}

	public void remover(Long id) {
		repository.deleteById(id);
	}

	@Transactional(readOnly = true)
	public Optional<Funcionario> buscarPorId(Long id) {
		return repository.findById(id);
	}

	@Transactional(readOnly = true)
	public List<Funcionario> buscarTodos() {
		return repository.findAll();
	}


	public List<Funcionario> buscarPorNome(String nome) {
		return repository.buscarPorNome(nome);
	}


	public List<Funcionario> buscarPorCargo(Long id) {

		return repository.buscarPorCargoId(id);
	}

	public List<Funcionario> buscarPorData(LocalDate entrada,  LocalDate saida){


		if (entrada != null && saida != null) {	    	
			return repository.buscarPorDatas(entrada, saida);
		} else if (entrada != null) {        	
			return repository.buscarPorDataEntrada(entrada);
		} else if (saida != null) {        	
			return repository.buscarPorDataSaida(saida);
		} else {
			return new ArrayList<>();
		}

	}
}






