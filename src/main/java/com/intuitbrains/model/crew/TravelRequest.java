package com.intuitbrains.model.crew;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public class TravelRequest extends Request {
	@Id
	private long id;
	private String travelName, source, destination;
	private LocalDateTime fromDate, toDate;
	private LocalDateTime requestedLocalDateTime;
	private String requestedBy;
}
