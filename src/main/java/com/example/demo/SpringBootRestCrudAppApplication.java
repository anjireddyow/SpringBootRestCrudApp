package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * Spring Boot Rest application with Spring security
 * 
 * @author 
 *
 */
@SpringBootApplication
public class SpringBootRestCrudAppApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(SpringBootRestCrudAppApplication.class);

	public static void main(String[] args) {
		ApplicationContext actx = SpringApplication.run(SpringBootRestCrudAppApplication.class, args);
		logger.info("Welcome info log message");
	}
}
