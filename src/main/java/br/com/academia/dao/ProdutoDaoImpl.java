package br.com.academia.dao;

import br.com.academia.domain.Produto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ProdutoDaoImpl implements ProdutoDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Produto produto){
        entityManager.persist(produto);
    }

    @Override
    public void update(Produto produto) {
        entityManager.merge(produto);
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(entityManager.getReference(Produto.class, id));
    }

    @Override
    public Produto findById(Long id) {
        return entityManager.find(Produto.class, id);
    }

    @Override
    public List<Produto> findAll() {
        return entityManager
                .createQuery( "select c from Produtos c", Produto.class)
                .getResultList();
    }
}
