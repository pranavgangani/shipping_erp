package com.intuitbrains.model.vessel;

import com.intuitbrains.model.company.Employee;
import com.intuitbrains.util.DateTime;

public class Document {
	private int documentId;
	private String documentName;
	private DateTime validityStartDate;
	private DateTime validityEndDate;
	private boolean isActive;
	
	private Employee enteredBy;
	private DateTime enteredDateTime;
}
