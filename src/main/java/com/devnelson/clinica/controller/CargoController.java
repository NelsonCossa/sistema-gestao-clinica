package com.devnelson.clinica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.devnelson.clinica.domain.Cargo;
import com.devnelson.clinica.domain.Departamento;
import com.devnelson.clinica.service.CargoService;
import com.devnelson.clinica.service.DepartamentoService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/cargos")
public class CargoController {
	
	@Autowired
	private CargoService cargoService;
	
	@Autowired
	private DepartamentoService departamentoService;
	
	@GetMapping("/cadastrar")
	public String cadastrar( Cargo cargo) {
		return "/cargo/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model)  {
		model.addAttribute("cargos",cargoService.buscarTodos());
		return "/cargo/lista";
	}
	@PostMapping("/salvar")
	public String salvar (@Valid Cargo cargo, BindingResult result, RedirectAttributes attr) {
		if(result.hasErrors()) {
			return "/cargo/cadastro";
		}
		cargoService.salvar(cargo);
		attr.addFlashAttribute("success","Cargo inserido com sucesso");
		return "redirect:/cargos/cadastrar";	
	}
	@ModelAttribute("departamentos")
	public List<Departamento> listaDeDepartamentos(){
		return departamentoService.buscarTodos();
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
	    Cargo cargo = cargoService.buscarPorId(id)
	        .orElseThrow(() -> new IllegalArgumentException("Cargo não encontrado"));
	    model.addAttribute("cargo", cargo);
	    return "/cargo/cadastro";
	}
	@PostMapping("/editar")
	public String editar (@Valid Cargo cargo,BindingResult result, RedirectAttributes attr) {
		if(result.hasErrors()) {
			return "/cargo/cadastro";
		}
		cargoService.editar(cargo);
		attr.addFlashAttribute("success","Cargo editado com sucesso");
		return "redirect:/cargos/cadastrar";
	}
	@GetMapping("/excluir/{id}")
	public String excluir (@PathVariable ("id") Long id, ModelMap model) {
	if(cargoService.CargoTemFuncionarios(id)) {
	model.addAttribute("fail", "Cargo nao removido. Possui funcionarios vinculados");
	}else {
		cargoService.remover(id)	;	
		model.addAttribute("success", "Cargo removido com sucesso");
	}
	return listar(model);
	
}
	

}
