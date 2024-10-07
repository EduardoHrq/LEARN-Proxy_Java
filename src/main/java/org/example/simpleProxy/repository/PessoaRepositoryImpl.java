package org.example.simpleProxy.repository;

import org.example.simpleProxy.model.Pessoa;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PessoaRepositoryImpl implements PessoaRespository {

    private Map<Long, Pessoa> persist = new HashMap<>();
    public static Long counterId = (long) 1;

    @Override
    public Pessoa save(Pessoa pessoa) {
        persist.put(counterId, pessoa);
        counterId++;
        return pessoa;
    }

    @Override
    public Pessoa findById(Long id) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Pessoa pessoa = null;
        if (Objects.nonNull(persist.get(id))) {
            pessoa = persist.get(id);
        }
        return pessoa;
    }
}
