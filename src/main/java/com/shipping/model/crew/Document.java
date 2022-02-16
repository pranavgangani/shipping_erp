package com.shipping.model.crew;

import com.shipping.company.Employee;
import com.shipping.util.DateTime;

public class Document {
	private int documentId;
	private int crewId;

	private DateTime validityStartDate;
	private DateTime validityEndDate;
	private boolean isActive;
	
	private float versionId;
	
	private Employee enteredBy;
	private DateTime enteredDateTime;
}
