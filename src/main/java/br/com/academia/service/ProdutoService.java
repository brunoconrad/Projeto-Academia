package br.com.academia.service;

import br.com.academia.domain.Produto;

import java.util.List;

public interface ProdutoService {

    void save(Produto produto);

    void update(Long id, Produto produto);

    void delete(Long id);

    Produto findById(Long id);

    List<Produto> findAll();

}
