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


}
