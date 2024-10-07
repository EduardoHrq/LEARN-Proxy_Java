package org.example.DynamicProxy;

import org.example.model.Pessoa;
import org.example.service.PessoaService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

public class ProxyHandler implements InvocationHandler {

    private Logger log = Logger.getLogger(ProxyHandler.class.getName());

    private static Map<Long, Pessoa> pessoasEmCache = new HashMap<>();

    PessoaService target;

    public ProxyHandler(PessoaService pessoaService) {
        this.target = pessoaService;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        log.info("Entrou no proxy");

        if (method.getName().equals("save")) {
            log.info("Salvando...");
//            System.out.println(args[0]);
            method.invoke(target, args);
            log.info("Salvo");
        }

        if (method.getName().equals("findById")) {
            log.info("Buscando...");

            Pessoa pessoa = null;
            if (Objects.nonNull(pessoasEmCache.get(args[0]))) {
                pessoa = pessoasEmCache.get(args[0]);
            }else {
                pessoa = (Pessoa) method.invoke(target, args);
                pessoasEmCache.put((Long) args[0], pessoa);
            }

            System.out.println(pessoa);
            log.info("Encontrado");
        }



        return null;
    }
}
