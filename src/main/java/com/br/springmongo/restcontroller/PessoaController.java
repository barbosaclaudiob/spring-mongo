package com.br.springmongo.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.br.springmongo.model.Pessoa;
import com.br.springmongo.repositories.PessoaRepository;
import com.br.springmongo.resquest.PostPessoaRequest;
import com.br.springmongo.utils.ValidationErrorBuilder;

@RestController
@RequestMapping(value="/pessoa")
public class PessoaController extends GenericRestController {
	
	@Autowired
	private PessoaRepository repository;
	
	@RequestMapping(method=RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public List<Pessoa> obtemTodasPessoas() {
		return repository.findAll();
	}
	
	
	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity salvarPessoa(@RequestBody @Validated PostPessoaRequest postPessoaRequest,
			BindingResult bindingResult, Errors errors) {
		if (errors.hasErrors()) {
			return ResponseEntity.badRequest().body(ValidationErrorBuilder.fromBindingErrors(errors));
        }
		Pessoa p = new Pessoa();
		Pessoa pessoa = repository.save(p.preenheObjeto(postPessoaRequest));
		return new ResponseEntity<Pessoa>(pessoa, HttpStatus.OK);
	}



}
