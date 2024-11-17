package br.edu.infnet.victorhdcampos.service;

import java.util.List;

public interface GenericService<T> {

    List<T> obterLista();

    T obterPorId(Long id);

    void incluir(T entity);

    void alterar(T entity);

    boolean excluir(Long id);
}
