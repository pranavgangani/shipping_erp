package com.intuitbrains.common;

import org.springframework.data.annotation.Id;

import com.intuitbrains.model.company.Employee;

import java.time.LocalDateTime;

public class Comment {
	private long id;
	private String text;
	private Employee enteredBy, updatedBy;
	private LocalDateTime enteredDateTime, updatedDateTime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Employee getEnteredBy() {
		return enteredBy;
	}

	public void setEnteredBy(Employee enteredBy) {
		this.enteredBy = enteredBy;
	}

	public Employee getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Employee updatedBy) {
		this.updatedBy = updatedBy;
	}

	public LocalDateTime getEnteredDateTime() {
		return enteredDateTime;
	}

	public void setEnteredDateTime(LocalDateTime enteredDateTime) {
		this.enteredDateTime = enteredDateTime;
	}

	public LocalDateTime getUpdatedDateTime() {
		return updatedDateTime;
	}

	public void setUpdatedDateTime(LocalDateTime updatedDateTime) {
		this.updatedDateTime = updatedDateTime;
	}
}
