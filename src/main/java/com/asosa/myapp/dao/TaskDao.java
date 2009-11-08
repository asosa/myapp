package com.asosa.myapp.dao;

import org.springframework.stereotype.Repository;

import com.asosa.myapp.domain.Task;

@Repository
public class TaskDao extends GenericDaoImpl<Task, Long> implements GenericDao<Task, Long> {
	public TaskDao() {
		super(Task.class);
	}
}
