package com.shipping.model.ship;

import com.shipping.company.User;
import com.shipping.util.DateTime;

public class ShipVacancy {
	private int vacancyId;
	private int shipId;
	private Ship ship;
	private int numOfVacancy;
	private DateTime startDate;
	private DateTime endDate;
	
	private User enteredBy;
	private DateTime enteredDateTime;

}
