package com.shipping.model.crew;

import org.springframework.data.annotation.Id;

import com.shipping.model.company.Employee;
import com.shipping.util.DateTime;

public class ContractRule {
	@Id
	private int id;
	private String ruleName;
	private String ruleHeadingText;
	private String ruleText;
	private int rulePriority;
	
	private DateTime enteredDateTime;
	private Employee enteredByEmp;
}
