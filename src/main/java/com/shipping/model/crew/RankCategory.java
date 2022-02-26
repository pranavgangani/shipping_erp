package com.shipping.model.crew;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.shipping.model.vessel.VesselSubType;
import com.shipping.model.vessel.VesselType;

@Document(collection = "RankCategory")
public class RankCategory {
	@Transient
	public static final String SEQUENCE_NAME = "RankCategory";
	
	public static final RankCategory DECK_DEPARTMENT = new RankCategory(1, "Deck Department");
	public static final RankCategory ENGINE_DEPARTMENT = new RankCategory(2, "Engine Department");
	public static final RankCategory GALLEY_DEPARTMENT = new RankCategory(3, "Galley Department");
	
	@Id
	private int id;	
	private String name;
	
	public RankCategory(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		RankCategory other = (RankCategory) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "RankCategory [id=" + id + ", name=" + name + "]";
	}
	
	
}
