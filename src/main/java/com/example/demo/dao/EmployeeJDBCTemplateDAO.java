package com.example.demo.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.common.CommonConstants;
import com.example.demo.config.MessageConfigurationProperties;
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
 *  JdbcTemplate : Run SQL Queries
JdbcTemplate provides methods to run DML and DDL SQL queries. Find the example of some of them.
a. JdbcTemplate.queryForObject :

<T> T queryForObject(String sql, RowMapper<T> rowMapper, Object... args) 

This method fetches data for a given SQL query as an object using RowMapper. SQL query can have bind parameters. Find the description of parameters.
sql: SQL containing bind parameter.
rowMapper: Object of RowMapper implemented class. RowMapper will map one object per row.
args: Arguments that bind to the query.

b. JdbcTemplate.query:

<T> List<T> query(String sql,RowMapper<T> rowMapper) 

This method executes static query and maps rows to java objects using RowMapper. Find the description of parameters.
sql: SQL query to execute.
rowMapper: Object of RowMapper implemented class. RowMapper will map one object per row.

c. JdbcTemplate.update:

int update(String sql, Object... args) 

This method executes insert, update and delete statements. Find the description of parameters.
sql: SQL containing bind parameter.
args: Arguments that bind to the query.
 * @author 
 *
 */
@Repository
public class EmployeeJDBCTemplateDAO {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeJDBCTemplateDAO.class);
	
	/**
	 * Create a Database as : springboot
	 * 
	 * Table Name as : Employee 
	 * Columns : employee_number as int with primary key
	 * employee_name as varchar(45) 
	 * employee_position as varchar(45)
	 * 
	 */
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private MessageConfigurationProperties messageConfigurationProperties;
	
	@Autowired
	public EmployeeJDBCTemplateDAO(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public List<Employee> getEmployees(){
		String getEmployeesSQL = "SELECT employee_number, employee_name, employee_position FROM employee";

		RowMapper<Employee> rowMapper = new EmployeeRowMapper();
//      Instead of Custom EmployeeRowMapper, we can use the BeanPropertyRowMapper	
//		RowMapper<Employee> allEmployeesRowMapper = new BeanPropertyRowMapper<Employee>(Employee.class);
		
		return this.jdbcTemplate.query(getEmployeesSQL, rowMapper);
	}
	
	/**
	 * 
	 * @param employee
	 */
	public String addEmployee(Employee addEmployee) throws DataAccessException {
		String addEmployeeStatus = messageConfigurationProperties.getAddemployeefailure();
		String insertEmployeeSQL = "INSERT INTO EMPLOYEE (EMPLOYEE_NUMBER, EMPLOYEE_NAME, EMPLOYEE_POSITION) VALUES (?,?,?)";
		int insertStatus = this.jdbcTemplate.update(insertEmployeeSQL, addEmployee.getEmpNo(), addEmployee.getEmpName(), addEmployee.getEmpPosition());
		logger.info("Employee Added with the status :" + insertStatus);
		if(insertStatus == CommonConstants.DATABASE_SUCCESS) {
			addEmployeeStatus = messageConfigurationProperties.getAddemployeesuccess();
		}
		return addEmployeeStatus;
	}
	
	public void updateEmployee(Employee updateEmployee) {
		String updateEmployeeSQL = "UPDATE EMPLOYEE SET EMPLOYEE_NAME = ?, EMPLOYEE_POSITION = ? WHERE EMPLOYEE_NUMBER = ?";
		int updateStatus = this.jdbcTemplate.update(updateEmployeeSQL, updateEmployee.getEmpName(), updateEmployee.getEmpPosition(), updateEmployee.getEmpNo());
		logger.info("Employee Updated with the status :" + updateStatus);
	}
	
	public void deleteEmployee(int employee_number) {
		String deleteEmployeeSQL = "DELETE FROM EMPLOYEE WHERE EMPLOYEE_NUMBER = ?";
		int deleteStatus = this.jdbcTemplate.update(deleteEmployeeSQL, employee_number);
		logger.info("Employee Deleted with the status :"+ deleteStatus);
	}
}
