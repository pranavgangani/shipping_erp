package com.intuitbrains.model.crew;

import org.springframework.data.annotation.Id;

import com.intuitbrains.util.DateTime;

public class TravelRequest extends Request {
	@Id
	private long id;
	private String travelName, source, destination;
	private DateTime fromDate, toDate;
	private DateTime requestedDateTime;
	private String requestedBy;
}
