package com.shipping.model.crew;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "RankCategory")
public class RankCategory {
	@Transient
	public static final String SEQUENCE_NAME = "RankCategory";
	
	@Id
	private int id;	
	private String name;
	
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
		RankCategory other = (RankCategory) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "RankCategory [id=" + id + ", name=" + name + "]";
	}
	
	
}
