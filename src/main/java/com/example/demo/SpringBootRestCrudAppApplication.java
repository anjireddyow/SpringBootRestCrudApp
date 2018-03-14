package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.common.CommonConstants;

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
		SpringApplication.run(SpringBootRestCrudAppApplication.class, args);
		// ApplicationContext actx =
		// SpringApplication.run(SpringBootRestCrudAppApplication.class, args);
		logger.info(CommonConstants.APP_NAME_FOR_LOG + "Welcome info log message");
	}
}
