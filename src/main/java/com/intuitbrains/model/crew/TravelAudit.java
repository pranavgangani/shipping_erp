package com.intuitbrains.model.crew;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.intuitbrains.common.Collection;

import java.time.LocalDateTime;

@Document(collection = Collection.TRAVEL_HISTORY)
public class TravelAudit {
	@Transient
	public static final String SEQUENCE_NAME = Collection.TRAVEL_HISTORY;
	
	@Id
	private long id;
	private String startDest, endDest;
	private LocalDateTime travelStartDate, travelEndDate;

}