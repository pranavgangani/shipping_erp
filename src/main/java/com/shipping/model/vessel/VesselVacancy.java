package com.shipping.model.vessel;

import com.shipping.company.Employee;
import com.shipping.util.DateTime;

public class VesselVacancy {
	private int vacancyId;
	private int shipId;
	private Vessel ship;
	private int numOfVacancy;
	private DateTime startDate;
	private DateTime endDate;
	
	private Employee enteredBy;
	private DateTime enteredDateTime;

}
