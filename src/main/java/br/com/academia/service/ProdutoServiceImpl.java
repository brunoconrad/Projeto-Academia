package br.com.academia.service;

import br.com.academia.dao.ProdutoDao;
import br.com.academia.domain.Produto;
import br.com.academia.exception.IdNaoValidoServiceException;
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

        produto.setId(idValido(id));
        dao.findById(id);
        dao.update(produto);
    }

    @Override
    public void delete(Long id) {
        dao.delete(idValido(id));
    }

    @Override
    @Transactional(readOnly = true)
    public Produto findById(Long id) {
        return dao.findById(idValido(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Produto> findAll() {
        return dao.findAll();
    }

    private Long idValido(Long id){
        if(id <= 0){
            throw new IdNaoValidoServiceException("Id com valor inválido, deve ser um valor inteiro maior que zero");
        }
        return id;
    }

}
