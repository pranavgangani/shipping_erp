package com.shipping.common;

import org.springframework.data.annotation.Id;

import com.shipping.company.Employee;
import com.shipping.util.DateTime;

public class Comment {	
	@Id
	private long id;
	
	private Employee enteredBy;
	private DateTime enteredDateTime;
	
}
