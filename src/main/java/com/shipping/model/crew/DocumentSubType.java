package com.shipping.model.crew;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "DocumentSubType")
public class DocumentSubType {
	@Transient
	public static final String SEQUENCE_NAME = "DocumentSubType";
	
	@Id
	private long id;

}
