package com.intuitbrains.model.vessel;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import com.intuitbrains.common.Collection;
import com.intuitbrains.common.Flag;

import java.time.LocalDateTime;
import java.util.List;

@org.springframework.data.mongodb.core.mapping.Document(collection = Collection.VESSEL)
public class Vessel {
	@Transient
	public static final String SEQUENCE_NAME = Collection.VESSEL;
	
	@Id
	private long id;

	//private VesselType vesselType;
	private VesselSubType vesselSubType;
	private VesselOwner vesselOwner;
	private long photoId;

	private String vesselName, vesselDesc;
	private int capacity;
	private int yearOfBuilt;
		
	private double grossTonnage;
	private long length, beam, draught;
	private String imo, mmsi, callSign;
	private String homePort;
	private Flag flag;
	private VesselStatus vesselStatus;
	private boolean isActive;

	private String enteredBy;
	private LocalDateTime enteredLocalDateTime;
	private String reviewedBy;
	private LocalDateTime reviewedLocalDateTime;

	private List<VesselVacancy> vacancies;
	private List<VesselManager> vesselManagers;
	private VesselFieldStatus fieldStatus;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	/*
	 * public VesselType getVesselType() { return vesselType; } public void
	 * setVesselType(VesselType vesselType) { this.vesselType = vesselType; }
	 */

	public List<VesselVacancy> getVacancies() {
		return vacancies;
	}

	public void setVacancies(List<VesselVacancy> vacancies) {
		this.vacancies = vacancies;
	}

	public String getVesselName() {
		return vesselName;
	}
	public void setVesselName(String vesselName) {
		this.vesselName = vesselName;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getYearOfBuilt() {
		return yearOfBuilt;
	}
	public void setYearOfBuilt(int yearOfBuilt) {
		this.yearOfBuilt = yearOfBuilt;
	}
	public double getGrossTonnage() {
		return grossTonnage;
	}
	public void setGrossTonnage(double grossTonnage) {
		this.grossTonnage = grossTonnage;
	}
	public long getLength() {
		return length;
	}
	public void setLength(long length) {
		this.length = length;
	}
	public long getBeam() {
		return beam;
	}
	public void setBeam(long beam) {
		this.beam = beam;
	}
	public String getImo() {
		return imo;
	}
	public void setImo(String imo) {
		this.imo = imo;
	}
	public String getMmsi() {
		return mmsi;
	}
	public void setMmsi(String mmsi) {
		this.mmsi = mmsi;
	}
	
	public long getDraught() {
		return draught;
	}
	public void setDraught(long draught) {
		this.draught = draught;
	}
	public String getCallSign() {
		return callSign;
	}
	public void setCallSign(String callSign) {
		this.callSign = callSign;
	}
	public String getHomePort() {
		return homePort;
	}
	public void setHomePort(String homePort) {
		this.homePort = homePort;
	}
	public Flag getFlag() {
		return flag;
	}
	public void setFlag(Flag flag) {
		this.flag = flag;
	}
	public VesselSubType getVesselSubType() {
		return vesselSubType;
	}
	public void setVesselSubType(VesselSubType vesselSubType) {
		this.vesselSubType = vesselSubType;
	}

	public VesselStatus getVesselStatus() {
		return vesselStatus;
	}
	public void setVesselStatus(VesselStatus vesselStatus) {
		this.vesselStatus = vesselStatus;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public VesselOwner getVesselOwner() {
		return vesselOwner;
	}
	public void setVesselOwner(VesselOwner vesselOwner) {
		this.vesselOwner = vesselOwner;
	}

	public List<VesselManager> getVesselManagers() {
		return vesselManagers;
	}

	public void setVesselManagers(List<VesselManager> vesselManagers) {
		this.vesselManagers = vesselManagers;
	}

	public LocalDateTime getEnteredLocalDateTime() {
		return enteredLocalDateTime;
	}
	public void setEnteredLocalDateTime(LocalDateTime enteredLocalDateTime) {
		this.enteredLocalDateTime = enteredLocalDateTime;
	}

	public String getEnteredBy() {
		return enteredBy;
	}

	public void setEnteredBy(String enteredBy) {
		this.enteredBy = enteredBy;
	}

	public long getPhotoId() {
		return photoId;
	}

	public String getVesselDesc() {
		return vesselDesc;
	}

	public void setVesselDesc(String vesselDesc) {
		this.vesselDesc = vesselDesc;
	}

	public void setPhotoId(long photoId) {
		this.photoId = photoId;
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

	public VesselFieldStatus getFieldStatus() {
		return fieldStatus;
	}

	public void setFieldStatus(VesselFieldStatus fieldStatus) {
		this.fieldStatus = fieldStatus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Vessel other = (Vessel) obj;
		if (id != other.id)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Vessel [id=" + id + ", vesselOwner=" + vesselOwner + ", imo=" + imo + ", mmsi=" + mmsi
				+ ", callSign=" + callSign + "]";
	}
	
	
}
