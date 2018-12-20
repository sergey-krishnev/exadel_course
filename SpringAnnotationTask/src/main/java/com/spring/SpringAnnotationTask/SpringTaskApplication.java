package com.spring.SpringAnnotationTask;

import hibernate.configuration.AppConfig;
import hibernate.service.CRUDService;
import hibernate.dao.interfaces.DisplayDao;
import hibernate.model.Subject;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class SpringTaskApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(AppConfig.class);
		CRUDService crudService = context.getBean(CRUDService.class);
		DisplayDao displayDao = context.getBean(DisplayDao.class);
		List list = crudService.searchAll();
		displayDao.display(list);
	}

}

