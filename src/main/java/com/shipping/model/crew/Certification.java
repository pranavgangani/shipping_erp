package com.shipping.model.crew;

import com.shipping.common.Collection;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.shipping.model.common.DurationType;
import com.shipping.util.DateTime;

@Document(collection = Collection.CERTIFICATION)
public class Certification {
	@Transient
	public static final String SEQUENCE_NAME = Collection.CERTIFICATION;
	
	@Id
	private long id;
	private String name, desc;

	private Rank rank;
	private RankCategory rankCategory;
	private RankSubCategory rankSubCategory;
	private int rankSubCategoryId;
	private int rankCategoryId;
	private int rankId;
	private boolean isRenewalRequired;
	
	private DateTime completionDateTime;
	
	private int validity;
	private DurationType durationType;
	
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
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
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
	public int getRankId() {
		return rankId;
	}
	public void setRankId(int rankId) {
		this.rankId = rankId;
	}
	public int getValidity() {
		return validity;
	}
	public void setValidity(int validity) {
		this.validity = validity;
	}
	public DurationType getDurationType() {
		return durationType;
	}
	public void setDurationType(DurationType durationType) {
		this.durationType = durationType;
	}
	public Rank getRank() {
		return rank;
	}
	public void setRank(Rank rank) {
		this.rank = rank;
	}
	public RankCategory getRankCategory() {
		return rankCategory;
	}
	public void setRankCategory(RankCategory rankCategory) {
		this.rankCategory = rankCategory;
	}
	public RankSubCategory getRankSubCategory() {
		return rankSubCategory;
	}
	public void setRankSubCategory(RankSubCategory rankSubCategory) {
		this.rankSubCategory = rankSubCategory;
	}
	
	
}
