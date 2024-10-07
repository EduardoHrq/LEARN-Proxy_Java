package org.example.simpleProxy.proxy;

import org.example.model.Pessoa;
import org.example.repository.PessoaRepositoryImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

public class PessoaRepositoryProxy extends PessoaRepositoryImpl {

    private static Logger log = Logger.getLogger(PessoaRepositoryProxy.class.getName());

    // usando cache
    private static Map<Long, Pessoa> pessoasEmCache = new HashMap<>();

    @Override
    public Pessoa save(Pessoa pessoa) {
        log.info("Salvando pessoa");
        super.save(pessoa);
        log.info("Pessoa Salva");
        return pessoa;
    }

    @Override
    public Pessoa findById(Long id) {
        log.info("Buscando Pessoa");

        Pessoa pessoaEncontrada = null;

        if (Objects.nonNull(pessoasEmCache.get(id))) {
            log.info("Já esta em cache, buscando do cache");
            pessoaEncontrada = pessoasEmCache.get(id);
        } else {
            pessoaEncontrada = super.findById(id);
            pessoasEmCache.put(id, pessoaEncontrada);
        }

        log.info("Finalizado");
        return pessoaEncontrada;
    }
}
