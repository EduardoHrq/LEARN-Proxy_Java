package org.example.repository;

import org.example.model.Pessoa;

public interface PessoaRespository {

    Pessoa save(Pessoa pessoa);

    Pessoa findById(Long id);

}
