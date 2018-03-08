package com.example.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * This is a class to hold Custom Key and value pair messages in the application.properties file
 * This properties will start with "custom.name", "custom.value" etc
 * 
 * @author 
 *
 */
@Component
@ConfigurationProperties("custom")
public class CustomConfigurationProperties {

	private String message;
	private int age;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
