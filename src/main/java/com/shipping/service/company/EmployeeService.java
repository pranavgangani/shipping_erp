package com.shipping.service.company;

import java.util.List;

import com.shipping.model.company.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shipping.dao.company.EmployeeRepository;

@Service("employeeService")
public class EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;
	
	
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
