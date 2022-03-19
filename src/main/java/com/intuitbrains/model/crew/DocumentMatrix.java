package com.intuitbrains.model.crew;

import java.util.List;

import org.springframework.data.annotation.Id;

import com.intuitbrains.common.Flag;

public class DocumentMatrix {
	@Id
	private long id;
	
	private List<Flag> flags;
	private List<Integer> vesselTypeIds;
	private List<Integer> vesselSubTypeIds;
	private List<Integer> rankSubCategoryIds; 
	private List<Integer> rankCategoryIds;
	private List<Integer> rankIds;
	private List<String> gender;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public List<Flag> getFlags() {
		return flags;
	}
	public void setFlags(List<Flag> flags) {
		this.flags = flags;
	}
	public List<Integer> getVesselTypeIds() {
		return vesselTypeIds;
	}
	public void setVesselTypeIds(List<Integer> vesselTypeIds) {
		this.vesselTypeIds = vesselTypeIds;
	}
	public List<Integer> getVesselSubTypeIds() {
		return vesselSubTypeIds;
	}
	public void setVesselSubTypeIds(List<Integer> vesselSubTypeIds) {
		this.vesselSubTypeIds = vesselSubTypeIds;
	}
	public List<Integer> getRankSubCategoryIds() {
		return rankSubCategoryIds;
	}
	public void setRankSubCategoryIds(List<Integer> rankSubCategoryIds) {
		this.rankSubCategoryIds = rankSubCategoryIds;
	}
	public List<Integer> getRankCategoryIds() {
		return rankCategoryIds;
	}
	public void setRankCategoryIds(List<Integer> rankCategoryIds) {
		this.rankCategoryIds = rankCategoryIds;
	}
	public List<Integer> getRankIds() {
		return rankIds;
	}
	public void setRankIds(List<Integer> rankIds) {
		this.rankIds = rankIds;
	}
	public List<String> getGender() {
		return gender;
	}
	public void setGender(List<String> gender) {
		this.gender = gender;
	}

	
}
