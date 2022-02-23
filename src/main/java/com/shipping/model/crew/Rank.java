package com.shipping.model.crew;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Rank")
public class Rank {
	@Transient
	public static final String SEQUENCE_NAME = "Rank";
	
	@Id
	private long id;	
	private String name;
	private RankCategory rankCategory;
	private int rankSubCategoryId;
	private int rankCategoryId;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public RankCategory getRankCategory() {
		return rankCategory;
	}
	public void setRankCategory(RankCategory rankCategory) {
		this.rankCategory = rankCategory;
	}
	
	public int getRankSubCategoryId() {
		return rankSubCategoryId;
	}
	public void setRankSubCategoryId(int rankSubCategoryId) {
		this.rankSubCategoryId = rankSubCategoryId;
	}
	public int getRankCategoryId() {
		return rankCategoryId;
	}
	public void setRankCategoryId(int rankCategoryId) {
		this.rankCategoryId = rankCategoryId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + rankCategoryId;
		result = prime * result + rankSubCategoryId;
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
		Rank other = (Rank) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (rankCategoryId != other.rankCategoryId)
			return false;
		if (rankSubCategoryId != other.rankSubCategoryId)
			return false;
		return true;
	}
	
	
	
	
	
	
}
