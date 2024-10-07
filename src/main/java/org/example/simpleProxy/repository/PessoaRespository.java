package org.example.simpleProxy.repository;

import org.example.simpleProxy.model.Pessoa;

public interface PessoaRespository {

    Pessoa save(Pessoa pessoa);

    Pessoa findById(Long id);

}
