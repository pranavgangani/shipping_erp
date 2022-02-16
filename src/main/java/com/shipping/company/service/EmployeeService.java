package com.shipping.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.shipping.company.Employee;
import com.shipping.dao.company.EmployeeDao;
import com.shipping.dao.crew.CrewDao;
import com.shipping.model.crew.Crew;

@Service("employeeService")
public class EmployeeService {
	@Autowired
    EmployeeDao employeeDao;
	
	
	void addEmployee(Employee emp) {
		  	
	}
	void deleteEmployee(Employee filterEmp) {
		
	}
	void updateEmployee(Employee filterEmp) {
		
	}
	Employee get(Employee filterEmp) {
		return null;
	}
	
	List<Employee> getFilteredList(Employee filterEmp) {
		return null;
	}
}
