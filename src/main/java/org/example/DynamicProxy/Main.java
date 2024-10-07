package org.example.DynamicProxy;

import org.example.model.Pessoa;
import org.example.repository.PessoaRepositoryImpl;
import org.example.repository.PessoaRespository;
import org.example.service.PessoaService;
import org.example.service.PessoaServiceImpl;

import java.lang.reflect.Proxy;

public class Main {
    public static void main(String[] args) {

        PessoaService pessoa = (PessoaService) Proxy.newProxyInstance(
                PessoaService.class.getClassLoader(),
                PessoaServiceImpl.class.getInterfaces(),
                new ProxyHandler(new PessoaServiceImpl(new PessoaRepositoryImpl()))
        );

        pessoa.save(new Pessoa("eduardo", 21, 1.75));

        pessoa.findById(1L);
        pessoa.findById(1L);


    }
}
