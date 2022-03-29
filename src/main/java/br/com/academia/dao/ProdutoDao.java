package br.com.academia.dao;

import br.com.academia.domain.Produto;

import java.util.List;

public interface ProdutoDao {

    void save(Produto produto);

    void update(Produto produto);

    void delete(Long id);

    Produto findById(Long id);

    List<Produto> findAll();

}
