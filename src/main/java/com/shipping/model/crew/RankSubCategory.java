package com.shipping.model.crew;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "RankSubCategory")
public class RankSubCategory {
	@Transient
	public static final String SEQUENCE_NAME = "RankSubCategory";
	
	@Id
	private int id;	
	private String name;
	private int rankCategoryId;
	private RankCategory rankCategory;
	
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
	public int getRankCategoryId() {
		return rankCategoryId;
	}
	public void setRankCategoryId(int rankCategoryId) {
		this.rankCategoryId = rankCategoryId;
	}
	public RankCategory getRankCategory() {
		return rankCategory;
	}
	public void setRankCategory(RankCategory rankCategory) {
		this.rankCategory = rankCategory;
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
		return "RankSubCategory [id=" + id + ", name=" + name + ", rankCategory=" + rankCategory + "]";
	}
	
	
}
