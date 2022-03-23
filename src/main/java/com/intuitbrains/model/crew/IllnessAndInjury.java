package com.intuitbrains.model.crew;

import com.intuitbrains.model.company.Employee;

import java.time.LocalDateTime;

public class IllnessAndInjury {
	private int crewId;
	private String note;
	private boolean isActive;
	private Employee enteredBy;
	private LocalDateTime enteredLocalDateTime;
}
