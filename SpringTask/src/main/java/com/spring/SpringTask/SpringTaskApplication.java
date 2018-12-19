package com.spring.SpringTask;

import hibernate.CRUDService;
import hibernate.dao.interfaces.DisplayDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTaskApplication {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CRUDService crudService = context.getBean("crudService", CRUDService.class);
		DisplayDao displayDao = context.getBean("displayDao", DisplayDao.class);
		displayDao.display(crudService.searchAll());
	}

}

