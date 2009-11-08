package com.asosa.myapp.dao;

import javax.annotation.Resource;

import org.junit.Test;

import com.asosa.myapp.domain.Task;

import junit.framework.TestCase;

public class TaskDaoTest extends TestCase {
	@Resource
	private TaskDao taskDao;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	@Test
	public void testCRUD() {
		Task task = new Task();
		task.setTitle("mock");
		
		Long taskId = taskDao.save(task);
		assertNotNull(taskId);
		
		task = taskDao.find(taskId);
		assertEquals("mock", task.getTitle());
		
		task.setTitle("mock2");
		taskDao.update(task);
		task = taskDao.find(taskId);
		assertEquals("mock2", task.getTitle());
		
		taskDao.delete(task);
		task = taskDao.find(taskId);
		assertNull(task);
	}
	
	
}
