package com.asosa.myapp.dao;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.asosa.myapp.domain.Task;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"/applicationContext-test.xml"})
public final class TaskDaoTest extends BaseTest {
	@Resource
	private TaskDao taskDao;
	
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
