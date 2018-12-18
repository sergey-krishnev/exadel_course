package com.spring.SpringTask;

import org.springframework.context.ApplicationContext;

public class SpringTaskApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringTaskApplication.class, args);
		HelloWorld helloWorld = (HelloWorld) ctx.getBean("helloWorld");
		helloWorld.sayHello();
	}

}

