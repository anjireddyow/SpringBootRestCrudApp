package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.model.Employee;

@RestController
public class SpringBootRestCrudController {
	
	/**
	 * •	To create a resource on the server, use POST.
	 * •	To retrieve a resource, use GET.
	 * •	To change the state of a resource or to update it, use PUT.
	 * •	To remove or delete a resource, use DELETE.
	 * 
	 * JSON <==> Java
	 * The spring-boot-starter-web has built in jackson-databind, which helps to convert JSON into Java object 
	 * and vice versa. 
	 * 
	 * The Spring Boot uses  JAXB (available in JDK) as a default library to convert XML and  Java. 
	 * However, Java classes need to be annotated by @XmlRootElement,... 
	 * Therefore, my advice is that you should use the  jackson-dataformat-xml as a 
	 * library to convert XML and  Java. To use the  jackson-dataformat-xml, you need to declare it in the  pom.xml file:
	 * 
	 * <dependency>
	 *         <groupId>com.fasterxml.jackson.dataformat</groupId>
 	 *        <artifactId>jackson-dataformat-xml</artifactId>
  	 * </dependency>
	 */
	@Autowired
	public EmployeeDAO employeeDAO;
	
	@RequestMapping("/")
	@ResponseBody
	public String welcome() {
		return "Welcome to Spring Boot App with Restful";
	}
	
	/**
	 * To retrieve
	 * @return
	 */
	
	// URL:
    // http://localhost:8080/SomeContextPath/employees
    // http://localhost:8080/SomeContextPath/employees.xml
    // http://localhost:8080/SomeContextPath/employees.json
	// produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE } -- This tags will be helpful
	// to return the content both in either JSON or XML format
	@RequestMapping(value = "/employees", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })	@ResponseBody
	public List<Employee> getEmployees() {
		return employeeDAO.getEmployeeList();
	}
	
	// This is a GET request to retreive the resource (employee)
	// {empNo} value will be dynamically passed from the url
	// @PathVariable to be added for "empNo" parameter, to indicate empNo will be dynamically passed as a parameter 
	@RequestMapping(value="/getEmployee/{empNo}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public Employee getEmployee(@PathVariable String empNo) {
		return employeeDAO.getEmployee(empNo);
	}
	
	// This is a POST method for creating a resource (create a employee)
	// Employee information will be passed as a JSON or XML and "@RequestBody" will be mapped with the passed employee object
	@RequestMapping(value="/addEmployee", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	@ResponseBody
	public Map<String, Employee> addEmployee(@RequestBody Employee addEmployee) {
		return employeeDAO.addEmployee(addEmployee);
	}
	
	@RequestMapping (value="/updateEmployee", method = RequestMethod.PUT, produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public Map<String, Employee> updateEmployee(@RequestBody Employee updateEmployee) {
		return employeeDAO.updateEmployee(updateEmployee);
	}
	
	@RequestMapping
	public void deleteEmployee(String empNo) {
		Map<String, Employee> employeeMap = employeeDAO.deleteEmployee(empNo);
	}
	

}
