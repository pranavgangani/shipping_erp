package com.intuitbrains.common;

import org.springframework.data.annotation.Id;

import com.intuitbrains.model.company.Employee;
import com.intuitbrains.util.DateTime;

public class Comment {	
	@Id
	private long id;
	
	private Employee enteredBy;
	private DateTime enteredDateTime;
	
}
