package br.edu.fafic.ppi.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Objects;

public class GenericDAOImpl<T> implements IGenericDAO<T> {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("concessionaria_PU");
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        if(Objects.isNull(entityManager)){
            entityManager = emf.createEntityManager();
        }
        return entityManager;
    }

    @Override
    public void saveOrUpdate(T entity) {
        getEntityManager().getTransaction().begin();
        getEntityManager().merge(entity);
        getEntityManager().getTransaction().commit();
    }

    @Override
    public void delete(Class<T> tClass, Long id) {
        T obj = findById(tClass, id);
        getEntityManager().remove(obj);
        getEntityManager().getTransaction().commit();
    }

    @Override
    public T findById(Class<T> tClass, Long id) {
        if(!getEntityManager().getTransaction().isActive()){
            getEntityManager().getTransaction().begin();
        }
        T obj = getEntityManager().find(tClass, id);
        return obj;
    }

    @Override
    public List<T> findAll(String namedQuery) {
        return null;
    }

    @Override
    public void saveList(List<T> entities) {
         entities.forEach( e -> {
            getEntityManager().getTransaction().begin();
            getEntityManager().merge(e);
            getEntityManager().getTransaction().commit();
        });

    }
}
