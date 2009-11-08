package com.asosa.myapp.resources;

import javax.annotation.Resource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.asosa.myapp.dao.TaskDao;
import com.asosa.myapp.domain.Hashimoto;
import com.asosa.myapp.domain.Speakable;

@Component
@Path("/hibernate")
@Scope("request")
public class HibernateTestResource {
	@Resource(type=Hashimoto.class)
	private Speakable speaker;
	
	@Resource
	private TaskDao taskDao;

	@GET
	@Produces("text/plain")
	public String getIt() {
		try {
			taskDao.find(1L);
			return "hello" + speaker.sayHello();
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
}
