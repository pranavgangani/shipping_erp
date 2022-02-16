package com.shipping.model.crew;

import com.shipping.company.User;
import com.shipping.util.DateTime;

public class Document {
	private int documentId;
	private String documentName;
	private DateTime validityStartDate;
	private DateTime validityEndDate;
	private boolean isActive;
	
	private User enteredBy;
	private DateTime enteredDateTime;
}
