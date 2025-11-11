package com.devnelson.clinica.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devnelson.clinica.domain.Departamento;

import com.devnelson.clinica.domain.Cargo;
import com.devnelson.clinica.repository.CargoRepository;
import com.devnelson.clinica.repository.DepartamentoRepository;

@Service
@Transactional
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository repository;
    @Autowired
    private CargoRepository Cargorepository;

    public Departamento salvar(Departamento departamento) {
        return repository.save(departamento);
    }

    public Departamento editar(Departamento departamento) {
        return repository.save(departamento);
    }

    public void remover(Long id) {
        repository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Optional<Departamento> buscarPorId(Long id) {
        return repository.findById(id);
    }

    @Transactional(readOnly = true)
    public List<Departamento> buscarTodos() {
        return repository.findAll();
    }
    
    //@Override
	public boolean departamentoTemCargos(Long id) {
	if(buscarPorId(id).get().getCargos().isEmpty()) {
		return false;	
	}
	return true;
		
	}

	

  
}
