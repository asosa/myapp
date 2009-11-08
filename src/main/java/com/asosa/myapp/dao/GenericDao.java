package com.asosa.myapp.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, PK extends Serializable> {
    PK save(T newInstance);
    void update(T transientObject);
    void saveOrUpdate(T transientObject);
    void delete(T persistentObject);
    T find(PK id);
    List<T> findAll();
//    List<T> findAllByProperty(String propertyName,Object value);
}
