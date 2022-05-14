package com.intuitbrains.model.vessel;

import com.intuitbrains.model.company.Employee;

import java.time.LocalDateTime;

public class VesselDocument {
	private int documentId;
	private String documentName;
	private LocalDateTime validityStartDate;
	private LocalDateTime validityEndDate;
	private boolean isActive;
	
	private Employee enteredBy;
	private LocalDateTime enteredLocalDateTime;
}
