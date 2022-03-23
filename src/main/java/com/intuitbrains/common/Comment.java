package com.intuitbrains.common;

import org.springframework.data.annotation.Id;

import com.intuitbrains.model.company.Employee;

import java.time.LocalDateTime;

public class Comment {	
	@Id
	private long id;
	
	private Employee enteredBy;
	private LocalDateTime enteredLocalDateTime;
	
}
