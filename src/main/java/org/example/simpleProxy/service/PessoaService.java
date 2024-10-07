package org.example.simpleProxy.service;

import org.example.simpleProxy.model.Pessoa;

public interface PessoaService {

    Pessoa save(Pessoa pessoa);

    Pessoa findById(Long id);
}
