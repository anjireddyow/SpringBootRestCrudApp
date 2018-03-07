package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootRestCrudAppApplication {

	public static void main(String[] args) {
		ApplicationContext actx = SpringApplication.run(SpringBootRestCrudAppApplication.class, args);
	}
}
