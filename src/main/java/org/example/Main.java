package org.example;

import org.example.model.Pessoa;
import org.example.proxy.PessoaRepositoryProxy;
import org.example.repository.PessoaRepositoryImpl;
import org.example.service.PessoaService;
import org.example.service.PessoaServiceImpl;

public class Main {
    public static void main(String[] args) {
        // implementação direta, mas como não pode mudar a classe criasse um proxy para usar o logging
//        PessoaService pessoaService = new PessoaServiceImpl(new PessoaRepositoryImpl());

        PessoaService pessoaService = new PessoaServiceImpl(new PessoaRepositoryProxy());

        Pessoa pessoaSalva = pessoaService.save(new Pessoa("Eduardo", 21, 1.75));

//        System.out.println(pessoaSalva);

        System.out.println(pessoaService.findById(1L));
        System.out.println(pessoaService.findById(1L));
    }
}