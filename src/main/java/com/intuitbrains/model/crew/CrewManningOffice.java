package com.intuitbrains.model.crew;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.intuitbrains.util.DateTime;

@Document(collection = "CrewManningOffice")
public class CrewManningOffice {
	@Transient
	public static final String SEQUENCE_NAME = "CrewManningOffice";
	
	@Id
	private long id;
	
	private long crewId;
	private long manningOfficeId;
	private boolean isLatest;
	private DateTime officeStartDateTime;
	private DateTime officeEndDateTime;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getCrewId() {
		return crewId;
	}
	public void setCrewId(long crewId) {
		this.crewId = crewId;
	}
	public long getManningOfficeId() {
		return manningOfficeId;
	}
	public void setManningOfficeId(long manningOfficeId) {
		this.manningOfficeId = manningOfficeId;
	}
	public boolean isLatest() {
		return isLatest;
	}
	public void setLatest(boolean isLatest) {
		this.isLatest = isLatest;
	}
	public DateTime getOfficeStartDateTime() {
		return officeStartDateTime;
	}
	public void setOfficeStartDateTime(DateTime officeStartDateTime) {
		this.officeStartDateTime = officeStartDateTime;
	}
	public DateTime getOfficeEndDateTime() {
		return officeEndDateTime;
	}
	public void setOfficeEndDateTime(DateTime officeEndDateTime) {
		this.officeEndDateTime = officeEndDateTime;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CrewManningOffice other = (CrewManningOffice) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CrewManningOffice [id=" + id + ", crewId=" + crewId + ", manningOfficeId=" + manningOfficeId
				+ ", isLatest=" + isLatest + ", officeStartDateTime=" + officeStartDateTime + ", officeEndDateTime="
				+ officeEndDateTime + "]";
	}
	
	
}
