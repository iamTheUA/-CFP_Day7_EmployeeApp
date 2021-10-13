package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import ch.qos.logback.core.Context;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class EmployeeApplication {

	
	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(EmployeeApplication.class, args);
		log.info("Employee Application started! in {} Environment",  context.getEnvironment().getProperty("environment"));
	}

}
