package com.shipping.common;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import java.time.LocalDate;
import java.time.LocalDateTime;

@org.springframework.data.mongodb.core.mapping.Document(collection = Collection.AUDIT_TRAIL)
public class AuditTrail {
	@Transient
	public static final String SEQUENCE_NAME = Collection.AUDIT_TRAIL;
	
	@Id
	private long id;
	private String collection;
	private String action;
	private String actionBy;
	private LocalDateTime actionDateTime;
	private String text;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCollection() {
		return collection;
	}

	public void setCollection(String collection) {
		this.collection = collection;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getActionBy() {
		return actionBy;
	}

	public void setActionBy(String actionBy) {
		this.actionBy = actionBy;
	}

	public LocalDateTime getActionDateTime() {
		return actionDateTime;
	}

	public void setActionDateTime(LocalDateTime actionDateTime) {
		this.actionDateTime = actionDateTime;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
}
