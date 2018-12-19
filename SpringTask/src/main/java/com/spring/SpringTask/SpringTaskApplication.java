package com.spring.SpringTask;

import hibernate.dao.Interfaces.CRUDDao;
import hibernate.dao.Interfaces.DisplayDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTaskApplication {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-hibernate-xml.xml");
		CRUDDao crudDao = (CRUDDao) context.getBean("crudDao");
		DisplayDao displayDao = (DisplayDao) context.getBean("displayDao");
		displayDao.display(crudDao.searchAll());
	}

}

