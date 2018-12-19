package com.spring.SpringTask;

import hibernate.CRUDService;
import hibernate.dao.Interfaces.CRUDDao;
import hibernate.dao.Interfaces.DisplayDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTaskApplication {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-hibernate-xml.xml");
		CRUDService crudService = context.getBean("crudService", CRUDService.class);
		DisplayDao displayDao = (DisplayDao) context.getBean("displayDao");
		displayDao.display(crudService.searchAll());
	}

}

