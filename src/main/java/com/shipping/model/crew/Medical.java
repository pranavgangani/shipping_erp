package com.shipping.model.crew;

import com.shipping.util.DateTime;

public class Medical {
	private int medicalId;
	private int crewId;
	private MedicalType medicalType;
	private DateTime validityStartDate;
	private DateTime validityEndDate;
	private int validityPeriodInDays;
}
