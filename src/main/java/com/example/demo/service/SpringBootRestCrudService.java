package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeeJDBCTemplateDAO;
import com.example.demo.model.Employee;

@Service
public class SpringBootRestCrudService {

	@Autowired
	private EmployeeJDBCTemplateDAO employeeJDBCTemplateDAO;
	
	/**
	 * 
	 * @return
	 */
	public List<Employee> getEmployees(){
		return employeeJDBCTemplateDAO.getEmployees();
	}
}
