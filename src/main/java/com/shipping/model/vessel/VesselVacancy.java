package com.shipping.model.vessel;

import com.shipping.company.Employee;
import com.shipping.model.crew.Rank;
import com.shipping.util.DateTime;
import org.springframework.data.annotation.Id;

public class VesselVacancy {
	@Id
	private long id;
	private Rank rank;
	private String remarks;
	private DateTime startDate;
	private DateTime endDate;
	private Employee enteredBy;
	private DateTime enteredDateTime;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public DateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(DateTime startDate) {
		this.startDate = startDate;
	}

	public DateTime getEndDate() {
		return endDate;
	}

	public void setEndDate(DateTime endDate) {
		this.endDate = endDate;
	}

	public Employee getEnteredBy() {
		return enteredBy;
	}

	public void setEnteredBy(Employee enteredBy) {
		this.enteredBy = enteredBy;
	}

	public DateTime getEnteredDateTime() {
		return enteredDateTime;
	}

	public void setEnteredDateTime(DateTime enteredDateTime) {
		this.enteredDateTime = enteredDateTime;
	}
}
