package com.intuitbrains.model.vessel;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import com.intuitbrains.common.Collection;
import com.intuitbrains.common.Country;
import com.intuitbrains.common.Flag;

@org.springframework.data.mongodb.core.mapping.Document(collection = Collection.VESSEL_OWNER)
public class VesselOwner {
	@Transient
	public static final String SEQUENCE_NAME = Collection.VESSEL_OWNER;
	
	@Id
	private long id;
	private String ownerName;
	private int yearOfStart;
	private int flagId;
	private Flag flag;
	
	private String primaryContact;
	private String secondaryContact;
	
	private String primaryAddress;
	private String registerdAddress;
	
	private Country primaryCountry;
	private Country registerdCountry;
	
	private String website;
	private String emailId;
	
	
	private List<Vessel> managedVessels;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public int getYearOfStart() {
		return yearOfStart;
	}

	public void setYearOfStart(int yearOfStart) {
		this.yearOfStart = yearOfStart;
	}

	public int getFlagId() {
		return flagId;
	}

	public void setFlagId(int flagId) {
		this.flagId = flagId;
	}

	public Flag getFlag() {
		return flag;
	}

	public void setFlag(Flag flag) {
		this.flag = flag;
	}

	public String getPrimaryContact() {
		return primaryContact;
	}

	public void setPrimaryContact(String primaryContact) {
		this.primaryContact = primaryContact;
	}

	public String getSecondaryContact() {
		return secondaryContact;
	}

	public void setSecondaryContact(String secondaryContact) {
		this.secondaryContact = secondaryContact;
	}

	public String getPrimaryAddress() {
		return primaryAddress;
	}

	public void setPrimaryAddress(String primaryAddress) {
		this.primaryAddress = primaryAddress;
	}

	public String getRegisterdAddress() {
		return registerdAddress;
	}

	public void setRegisterdAddress(String registerdAddress) {
		this.registerdAddress = registerdAddress;
	}

	public Country getPrimaryCountry() {
		return primaryCountry;
	}

	public void setPrimaryCountry(Country primaryCountry) {
		this.primaryCountry = primaryCountry;
	}

	public Country getRegisterdCountry() {
		return registerdCountry;
	}

	public void setRegisterdCountry(Country registerdCountry) {
		this.registerdCountry = registerdCountry;
	}

	public List<Vessel> getManagedVessels() {
		return managedVessels;
	}

	public void setManagedVessels(List<Vessel> managedVessels) {
		this.managedVessels = managedVessels;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	
	
	
}
