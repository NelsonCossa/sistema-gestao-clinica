package com.devnelson.clinica.domain;

import com.devnelson.clinica.domain.enums.UF;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@SuppressWarnings("serial")
@Table(name="ENDERECOS")
public class Endereco extends AbstractEntity<Long> {
	

	   @NotBlank(message = "{javax.validation.constraints.NotBlank.message}")
	   @Size(min = 3, max = 255, message = "{javax.validation.constraints.Size.message}")
	
	@Column(nullable = false)
	private String logradouro;
	
	   @NotBlank(message = "{javax.validation.constraints.NotBlank.message}")
	    @Size(min = 3, max = 255, message = "{javax.validation.constraints.Size.message}")
	
	@Column(nullable = false)
	private String bairro;
	
	   @NotBlank(message = "{javax.validation.constraints.NotBlank.message}")
	    @Size(min = 3, max = 255, message = "{javax.validation.constraints.Size.message}")
	
	@Column(nullable = false)
	private String cidade;
	
	@NotNull(message = "{NotNull.endereco.uf}")
	@Column(nullable = false, length = 2)
	@Enumerated(EnumType.STRING)
	private UF uf;
	
	  @NotBlank(message = "{javax.validation.constraints.NotBlank.message}")
	   	@Size(min = 9, max = 9, message = "{Size.endereco.cep}")
	@Column(nullable = false, length = 9)
	private String cep;
	
	@NotNull(message = "{NotNull.endereco.numero}")
	 @Digits(integer = 5, fraction = 0, message = "{javax.validation.constraints.Digits.message}")
	@Column(nullable = false, length = 5)
	private Integer numero;
	
	   @Size(max = 255, message = "{javax.validation.constraints.Size.message}")
	private String complemento;

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public UF getUf() {
		return uf;
	}

	public void setUf(UF uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	
	

}
