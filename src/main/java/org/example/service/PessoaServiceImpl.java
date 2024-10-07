package org.example.service;

import org.example.model.Pessoa;
import org.example.repository.PessoaRepositoryImpl;
import org.example.repository.PessoaRespository;

public class PessoaServiceImpl implements PessoaService{

    private final PessoaRespository pessoaRespository;

    public PessoaServiceImpl(PessoaRespository pessoaRespository) {
        this.pessoaRespository = pessoaRespository;
    }

    @Override
    public Pessoa save(Pessoa pessoa) {
        return this.pessoaRespository.save(pessoa);
    }

    @Override
    public Pessoa findById(Long id) {
        return this.pessoaRespository.findById(id);
    }
}
