package com.br.springmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.br.springmongo.model.Pessoa;

public interface PessoaRepository extends MongoRepository<Pessoa, String>{

}
