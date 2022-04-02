package br.com.academia.dao;

import br.com.academia.domain.Produto;
import br.com.academia.exception.NaoExisteDaoException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
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
        try {
            entityManager.remove(entityManager.getReference(Produto.class, id));
        } catch( EntityNotFoundException e ) {
            throw new NaoExisteDaoException("Produto não encontrado");
        }
    }

    @Override
    public Produto findById(Long id) {

        Produto produto = entityManager.find(Produto.class, id);

        if(produto == null){
            throw new NaoExisteDaoException("Produto não encontrado");
        }
        return produto;

    }

    @Override
    public List<Produto> findAll() {
        return entityManager
                .createQuery( "select c from Produto c", Produto.class)
                .getResultList();
    }
}