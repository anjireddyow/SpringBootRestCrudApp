package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.model.Employee;

@Service
public class SpringBootRestCrudService {

	@Autowired
	private EmployeeDAO employeeDAO;
	
	/**
	 * 
	 * @return
	 */
	public List<Employee> getEmployeeList(){
		return employeeDAO.getEmployeeList();
	}
}
