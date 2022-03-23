package com.intuitbrains.model.crew;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "CrewManningOffice")
public class CrewManningOffice {
	@Transient
	public static final String SEQUENCE_NAME = "CrewManningOffice";
	
	@Id
	private long id;
	
	private long crewId;
	private long manningOfficeId;
	private boolean isLatest;
	private LocalDateTime officeStartLocalDateTime;
	private LocalDateTime officeEndLocalDateTime;
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
	public LocalDateTime getOfficeStartLocalDateTime() {
		return officeStartLocalDateTime;
	}
	public void setOfficeStartLocalDateTime(LocalDateTime officeStartLocalDateTime) {
		this.officeStartLocalDateTime = officeStartLocalDateTime;
	}
	public LocalDateTime getOfficeEndLocalDateTime() {
		return officeEndLocalDateTime;
	}
	public void setOfficeEndLocalDateTime(LocalDateTime officeEndLocalDateTime) {
		this.officeEndLocalDateTime = officeEndLocalDateTime;
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
				+ ", isLatest=" + isLatest + ", officeStartLocalDateTime=" + officeStartLocalDateTime + ", officeEndLocalDateTime="
				+ officeEndLocalDateTime + "]";
	}
	
	
}
