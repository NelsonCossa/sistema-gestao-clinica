package com.devnelson.clinica.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devnelson.clinica.domain.Cargo;

import com.devnelson.clinica.repository.CargoRepository;
import com.devnelson.clinica.repository.FuncionarioRepository;

@Service
@Transactional
public class CargoService {

    @Autowired
    private CargoRepository repository;
 

    public Cargo salvar(Cargo cargo) {
        return repository.save(cargo);
    }

    public Cargo editar(Cargo cargo) {
        return repository.save(cargo);
    }


    public void remover(Long id) {
        repository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Optional<Cargo> buscarPorId(Long id) {
        return repository.findById(id);
    }

 
    @Transactional(readOnly = true)
    public List<Cargo> buscarTodos() {
        return repository.findAll();
    }

	public boolean CargoTemFuncionarios(Long id) {
	if(buscarPorId(id).get().getFuncionarios().isEmpty()) {
		return false;	
	}
		return true;
	}

   
}
