package com.shipping.model.vessel;

import com.shipping.model.company.Employee;
import com.shipping.util.DateTime;

public class Document {
	private int documentId;
	private String documentName;
	private DateTime validityStartDate;
	private DateTime validityEndDate;
	private boolean isActive;
	
	private Employee enteredBy;
	private DateTime enteredDateTime;
}
