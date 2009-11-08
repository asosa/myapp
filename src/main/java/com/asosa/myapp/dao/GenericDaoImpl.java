package com.asosa.myapp.dao;

import java.io.Serializable;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public abstract class GenericDaoImpl<T, PK extends Serializable> extends HibernateDaoSupport implements GenericDao<T, PK> {
	private final Class<T> type;

	public GenericDaoImpl(Class<T> type) {
		this.type = type;
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
