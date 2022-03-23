package com.intuitbrains.model.vessel;

import java.time.LocalDateTime;
import java.util.List;

import org.bson.types.ObjectId;
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
	private long photoId;

	private String primaryContact;
	private String secondaryContact;
	
	private String primaryAddress;
	private String registerdAddress;
	
	private ObjectId primaryFlag;
	private ObjectId registerdFlag;

	private Flag primaryFlagObj;
	private Flag registerdFlagObj;
	
	private String website;
	private String emailId;

	private String enteredBy;
	private LocalDateTime enteredLocalDateTime;

	private String reviewedBy;
	private LocalDateTime reviewedLocalDateTime;

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

	public ObjectId getPrimaryFlag() {
		return primaryFlag;
	}

	public void setPrimaryFlag(ObjectId primaryFlag) {
		this.primaryFlag = primaryFlag;
	}

	public ObjectId getRegisterdFlag() {
		return registerdFlag;
	}

	public void setRegisterdFlag(ObjectId registerdFlag) {
		this.registerdFlag = registerdFlag;
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

	public long getPhotoId() {
		return photoId;
	}

	public void setPhotoId(long photoId) {
		this.photoId = photoId;
	}

	public String getEnteredBy() {
		return enteredBy;
	}

	public void setEnteredBy(String enteredBy) {
		this.enteredBy = enteredBy;
	}

	public LocalDateTime getEnteredLocalDateTime() {
		return enteredLocalDateTime;
	}

	public void setEnteredLocalDateTime(LocalDateTime enteredLocalDateTime) {
		this.enteredLocalDateTime = enteredLocalDateTime;
	}

	public String getReviewedBy() {
		return reviewedBy;
	}

	public void setReviewedBy(String reviewedBy) {
		this.reviewedBy = reviewedBy;
	}

	public LocalDateTime getReviewedLocalDateTime() {
		return reviewedLocalDateTime;
	}

	public void setReviewedLocalDateTime(LocalDateTime reviewedLocalDateTime) {
		this.reviewedLocalDateTime = reviewedLocalDateTime;
	}

	public Flag getPrimaryFlagObj() {
		return primaryFlagObj;
	}

	public void setPrimaryFlagObj(Flag primaryFlagObj) {
		this.primaryFlagObj = primaryFlagObj;
	}

	public Flag getRegisterdFlagObj() {
		return registerdFlagObj;
	}

	public void setRegisterdFlagObj(Flag registerdFlagObj) {
		this.registerdFlagObj = registerdFlagObj;
	}
}
