package br.edu.fafic.ppi.dao;

import java.util.List;

public interface IGenericDAO <T>{

    void saveOrUpdate(T entity);
    void delete(T entity);
    T findById(Class<T> tClass, Long id);
    List<T> findAll(String namedQuery);


}
