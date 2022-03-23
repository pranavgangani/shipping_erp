package com.intuitbrains.model.crew;

import org.springframework.data.annotation.Id;

import com.intuitbrains.model.company.Employee;

import java.time.LocalDateTime;

public class ContractRule {
	@Id
	private int id;
	private String ruleName;
	private String ruleHeadingText;
	private String ruleText;
	private int rulePriority;
	
	private LocalDateTime enteredLocalDateTime;
	private Employee enteredByEmp;
}
