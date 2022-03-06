package com.shipping.model.crew;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.shipping.common.Collection;
import com.shipping.util.DateTime;

@Document(collection = Collection.TRAVEL)
public class TravelAudit {
	@Transient
	public static final String SEQUENCE_NAME = Collection.TRAVEL;
	
	@Id
	private long id;
	private String startDest, endDest;
	private DateTime travelStartDate, travelEndDate;

}