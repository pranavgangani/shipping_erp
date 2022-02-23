package com.shipping.model.crew;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Rank")
public class Rank {
	@Transient
	public static final String SEQUENCE_NAME = "Rank";
	
	@Id
	private int id;	
	private String name;
	private RankCategory rankCategory;
	private int rankCategoryId;
	
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
	public RankCategory getRankCategory() {
		return rankCategory;
	}
	public void setRankCategory(RankCategory rankCategory) {
		this.rankCategory = rankCategory;
	}
	public int getRankCategoryId() {
		return rankCategoryId;
	}
	public void setRankCategoryId(int rankCategoryId) {
		this.rankCategoryId = rankCategoryId;
	}
	
	@Override
	public String toString() {
		return "Rank [id=" + id + ", name=" + name + ", rankCategory=" + rankCategory + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + rankCategoryId;
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
		return true;
	}
	
	
}
