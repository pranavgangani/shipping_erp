package com.intuitbrains.model.company;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import com.intuitbrains.common.Collection;
import com.intuitbrains.common.Person;

@org.springframework.data.mongodb.core.mapping.Document(collection = Collection.EMPLOYEE)
public class Employee extends Person {
	@Transient
	public static final String SEQUENCE_NAME = Collection.EMPLOYEE;
	
	@Id
	private long id;
	private Office office;
	private Designation designation;
	private Department department;
	private List<Role> userRoles;
	private String empId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

	public Designation getDesignation() {
		return designation;
	}

	public void setDesignation(Designation designation) {
		this.designation = designation;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<Role> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<Role> userRoles) {
		this.userRoles = userRoles;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

}
