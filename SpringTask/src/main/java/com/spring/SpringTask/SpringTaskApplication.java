package com.spring.SpringTask;

import hibernate.service.CRUDService;
import hibernate.dao.interfaces.DisplayDao;
import hibernate.model.Subject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class SpringTaskApplication {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CRUDService crudService = context.getBean("crudService", CRUDService.class);
		DisplayDao displayDao = context.getBean("displayDao", DisplayDao.class);
		List<Subject> list = crudService.searchAll();
		displayDao.display(list);
	}

}

