package com.devnelson.clinica.conversor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.devnelson.clinica.domain.Departamento;
import com.devnelson.clinica.service.DepartamentoService;

@Component
public class StringToDepartmentConverter implements Converter<String, Departamento> {
	
   @Autowired
  private DepartamentoService service;
	@Override
	public Departamento convert(String text) {
		if(text.isEmpty()) {
			return null;	
		}
		Long id=Long.valueOf(text);
		return service.buscarPorId(id).orElseThrow();
	}

}
