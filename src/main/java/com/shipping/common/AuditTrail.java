package com.shipping.common;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

@org.springframework.data.mongodb.core.mapping.Document(collection = Collection.AUDIT_TRAIL)
public class AuditTrail {
	@Transient
	public static final String SEQUENCE_NAME = Collection.AUDIT_TRAIL;
	
	@Id
	private long id;
	private String docName;
	private String action;
	private String actionBy;
	private String actionDateTime;
	private String text;
}
