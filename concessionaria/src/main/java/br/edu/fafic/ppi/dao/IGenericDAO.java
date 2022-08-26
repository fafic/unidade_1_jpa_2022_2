package br.edu.fafic.ppi.dao;

import java.util.List;

public interface IGenericDAO <T>{

    void saveOrUpdate(T entity);
    void delete(Class<T> tClass, Long id);
    T findById(Class<T> tClass, Long id);
    List<T> findAll(String namedQuery);
    void saveList(List<T> entities);


}
