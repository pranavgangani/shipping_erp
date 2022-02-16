package com.shipping.model.ship;

import com.shipping.company.Employee;
import com.shipping.util.DateTime;

public class ShipVacancy {
	private int vacancyId;
	private int shipId;
	private Ship ship;
	private int numOfVacancy;
	private DateTime startDate;
	private DateTime endDate;
	
	private Employee enteredBy;
	private DateTime enteredDateTime;

}
