package com.asosa.myapp.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

public abstract class GenericDaoImpl<T, PK extends Serializable> implements GenericDao<T, PK> {
	private final Class<T> type;
	private HibernateTemplate hibernateTemplate;

	public GenericDaoImpl(Class<T> type) {
		this.type = type;
	}
	
	@Autowired(required=true)
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.hibernateTemplate = new HibernateTemplate(sessionFactory);
    }
	
    public HibernateTemplate getHibernateTemplate() {
        return hibernateTemplate;
    }

	@SuppressWarnings("unchecked")
	public T find(PK id) {
		return (T) getHibernateTemplate().get(type, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return (List<T>) getHibernateTemplate().loadAll(type);
	}
	
	@SuppressWarnings("unchecked")
	public PK save(T newInstance) {
		return (PK) getHibernateTemplate().save(newInstance);
	}
	
	public void update(T transientObject) {
		getHibernateTemplate().update(transientObject);
	}
	
	public void delete(T persistentObject) {
		getHibernateTemplate().delete(persistentObject);
	}
	
	public void saveOrUpdate(T transientObject) {
		getHibernateTemplate().saveOrUpdate(transientObject);
	}
}
