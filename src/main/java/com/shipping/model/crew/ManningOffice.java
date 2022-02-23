package com.shipping.model.crew;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ManningOffice")
public class ManningOffice {

	@Transient
	public static final String SEQUENCE_NAME = "ManningOffice";
	
	@Id
	private long id;
	private int countryId;
	private String officeName;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getCountryId() {
		return countryId;
	}
	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}
	public String getOfficeName() {
		return officeName;
	}
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}
	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + countryId;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((officeName == null) ? 0 : officeName.hashCode());
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
		ManningOffice other = (ManningOffice) obj;
		if (countryId != other.countryId)
			return false;
		if (id != other.id)
			return false;
		if (officeName == null) {
			if (other.officeName != null)
				return false;
		} else if (!officeName.equals(other.officeName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ManningOffice [id=" + id + ", countryId=" + countryId + ", officeName=" + officeName + "]";
	}
	
	
}
