package br.edu.infnet.victorhdcampos.service.impl;

import br.edu.infnet.victorhdcampos.service.GenericService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public class GenericServiceImpl<T, ID, R extends JpaRepository<T, ID>> implements GenericService<T> {
    protected final R repository;

    public GenericServiceImpl(R repository){ this.repository = repository; }

    @Override
    public List<T> obterLista() {
        return repository.findAll();
    }

    @Override
    public T obterPorId(Long id){
        return repository.findById((ID) id).orElse(null);
    }

    @Override
    public void incluir(T entity) {
        repository.save(entity);
    }

    @Override
    public void alterar(T entity) {
        repository.save(entity);
    }

    @Override
    public boolean excluir(Long id) {
        repository.deleteById((ID) id);

        return true;
    }
}

