package org.example.service;

import org.example.model.Pessoa;

public interface PessoaService {

    Pessoa save(Pessoa pessoa);

    Pessoa findById(Long id);
}
