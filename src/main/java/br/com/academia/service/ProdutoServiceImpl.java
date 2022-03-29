package br.com.academia.service;

import br.com.academia.dao.ProdutoDao;
import br.com.academia.domain.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProdutoServiceImpl implements ProdutoService{

    @Autowired
    private ProdutoDao dao;

    @Override
    public void save(Produto produto) {
        dao.save(produto);
    }

    @Override
    public void update(Long id, Produto produto) {
        produto.setId(id);
        dao.update(produto);
    }

    @Override
    public void delete(Long id) {
        dao.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Produto findById(Long id) {
        return dao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Produto> findAll() {
        return dao.findAll();
    }


}
