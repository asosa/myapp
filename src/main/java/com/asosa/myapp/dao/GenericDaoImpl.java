package com.asosa.myapp.dao;

import java.io.Serializable;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public abstract class GenericDaoImpl<T, PK extends Serializable> extends HibernateDaoSupport implements GenericDao<T, PK> {
	private final Class<T> type;

	public GenericDaoImpl(Class<T> type) {
		this.type = type;
	}

	@SuppressWarnings("unchecked")
	public T find(PK id) {
		return (T) getHibernateTemplate().get(type, id);
	};
}
