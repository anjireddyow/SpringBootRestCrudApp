package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;

/**
 * Spring provides JdbcTemplate class for database operations using JDBC. 
 * JdbcTemplate class is auto-configured and we get its object using @Autowire 
 * annotation in our class that is annotated with spring stereotypes such as 
 * @Component. JdbcTemplate provides methods such as queryForObject(), query(), update() 
 * etc to perform database operations. In application.properties file we configure 
 * DataSource and connection pooling. Spring boot chooses tomcat pooling by default. 
 * Transaction management is performed by using spring @Transactional annotation either 
 * at class level or method level. Spring JDBC provides RowMapper interface that is 
 * implemented to map a database table row with java object. If table column name and 
 * java entity fields name are same, then we can directly use Spring JDBC 
 * BeanPropertyRowMapper to map a row with java object. 
 * 
 * @author 
 *
 */
@Repository
public class EmployeeJDBCTemplateDAO {
	
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public EmployeeJDBCTemplateDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<Employee> getEmployees(){
		String getEmployeesSQL = "SELECT employee_number, employee_name, employee_position FROM springboot.employee";

		RowMapper<Employee> rowMapper = new EmployeeRowMapper();
//      Instead of Custom EmployeeRowMapper, we can use the BeanPropertyRowMapper	
//		RowMapper<Employee> allEmployeesRowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
		
		return this.jdbcTemplate.query(getEmployeesSQL, rowMapper);
	}
	

}
