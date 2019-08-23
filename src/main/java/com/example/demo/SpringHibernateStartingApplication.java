package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.demo.examplebeans.FakeDataSource;

@SpringBootApplication
public class SpringHibernateStartingApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringHibernateStartingApplication.class, args);
		
//		FakeDataSource customProperties = (FakeDataSource)context.getBean(FakeDataSource.class);
//		
//		System.out.println(customProperties);
	}

}
