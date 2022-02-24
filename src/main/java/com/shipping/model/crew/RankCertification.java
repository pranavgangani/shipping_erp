package com.shipping.model.crew;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.shipping.model.common.DurationType;

@Document(collection = "RankCertification")
public class RankCertification {
	@Transient
	public static final String SEQUENCE_NAME = "RankCertification";
	
	@Id
	private long id;
	private String name, desc;
	
	private int rankSubCategoryId;
	private int rankCategoryId;
	private int rankId;
	
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
	
	
}
