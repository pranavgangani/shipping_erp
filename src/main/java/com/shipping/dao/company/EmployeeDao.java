package com.shipping.dao.company;

import java.util.List;

import com.shipping.company.Employee;


public interface EmployeeDao {
	void add(Employee employee);
	void delete(Employee filterEmployee);
	void update(Employee filterEmployee);
	Employee get(Employee filterEmployee);
	List<Employee> getFilteredList(Employee filterEmployee);
}
