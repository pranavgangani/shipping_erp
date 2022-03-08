package com.shipping.model.company;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import com.shipping.common.Collection;
import com.shipping.common.Person;

@org.springframework.data.mongodb.core.mapping.Document(collection = Collection.EMPLOYEE)
public class Employee extends Person {
	@Transient
	public static final String SEQUENCE_NAME = Collection.EMPLOYEE;
	
	@Id
	private long id;
	private Office office;
	private Designation designation;
	private Department department;
	private List<UserRole> userRoles;

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

	public List<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
}
