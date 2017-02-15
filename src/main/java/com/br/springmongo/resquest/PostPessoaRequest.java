package com.br.springmongo.resquest;

import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

public class PostPessoaRequest {

	@NotEmpty(message="Campo nome não pode ser nulo!")
	private String nome;
	
	@NotEmpty(message="Campo sobrenome não pode ser nulo!")
	private String sobrenome;
	
	private List<String> telefones;

	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public List<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<String> telefones) {
		this.telefones = telefones;
	}

	
	
}
