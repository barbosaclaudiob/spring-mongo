package com.br.springmongo.model;

import java.util.List;

import org.springframework.data.annotation.Id;

import com.br.springmongo.resquest.PostPessoaRequest;

public class Pessoa {
	
	@Id
	private String id;
	private String nome;
	private String sobreNome;
	private List<String> telefones;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobreNome() {
		return sobreNome;
	}
	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}
	public List<String> getTelefones() {
		return telefones;
	}
	public void setTelefones(List<String> telefones) {
		this.telefones = telefones;
	}
	public Pessoa preenheObjeto(PostPessoaRequest postPessoaRequest) {
		Pessoa p = new Pessoa();
		p.setNome(postPessoaRequest.getNome());
		p.setSobreNome(postPessoaRequest.getSobrenome());
		p.getTelefones().addAll(postPessoaRequest.getTelefones());
		
		return p;
	}
	
	
	
	

}
