package com.shipping.model.crew;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.shipping.model.vessel.VesselSubType;
import com.shipping.model.vessel.VesselType;

@Document(collection = "RankSubCategory")
public class RankSubCategory {
	@Transient
	public static final String SEQUENCE_NAME = "RankSubCategory";
	
	public static final RankSubCategory OFFICER = new RankSubCategory(1, "Officer");
	public static final RankSubCategory RATING = new RankSubCategory(2, "Rating");
	public static final RankSubCategory ENGINEER = new RankSubCategory(3, "Engineer");
	public static final RankSubCategory OTHER = new RankSubCategory(0, "Other");
	
	
	@Id
	private int id;	
	private String name;
	
	public RankSubCategory(int id, String name) {
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
		RankSubCategory other = (RankSubCategory) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "RankSubCategory [id=" + id + ", name=" + name + "]";
	}
	
	
}
