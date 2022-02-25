package com.shipping.model.vessel;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import com.shipping.common.Collection;
import com.shipping.common.Flag;

@org.springframework.data.mongodb.core.mapping.Document(collection = Collection.VESSEL)
public class Vessel {
	@Transient
	public static final String SEQUENCE_NAME = Collection.VESSEL;
	
	@Id
	private long id;

	private VesselType vesselType;
	private VesselSubType vesselSubType;
	private int vesselTypeId, vesselSubTypeId;
	private int vesselOwnerId;
	
	private String vesselName;
	private int capacity;
	private int flagId;
	private int yearOfBuilt;
		
	private double grossTonnage;
	private long length, beam, draught;
	private String imo, mmsi, callSign;
	private int homePortId;
	private Port homePort;
	private Flag flag;
	private VesselStatus vesselStatus;
	private boolean isActive;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public VesselType getVesselType() {
		return vesselType;
	}
	public void setVesselType(VesselType vesselType) {
		this.vesselType = vesselType;
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
	public int getFlagId() {
		return flagId;
	}
	public void setFlagId(int flagId) {
		this.flagId = flagId;
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
	public int getHomePortId() {
		return homePortId;
	}
	public void setHomePortId(int homePortId) {
		this.homePortId = homePortId;
	}
	public Port getHomePort() {
		return homePort;
	}
	public void setHomePort(Port homePort) {
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
	public int getVesselTypeId() {
		return vesselTypeId;
	}
	public void setVesselTypeId(int vesselTypeId) {
		this.vesselTypeId = vesselTypeId;
	}
	public int getVesselSubTypeId() {
		return vesselSubTypeId;
	}
	public void setVesselSubTypeId(int vesselSubTypeId) {
		this.vesselSubTypeId = vesselSubTypeId;
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
	public int getVesselOwnerId() {
		return vesselOwnerId;
	}
	public void setVesselOwnerId(int vesselOwnerId) {
		this.vesselOwnerId = vesselOwnerId;
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
		return "Vessel [id=" + id + ", vesselOwnerId=" + vesselOwnerId + ", imo=" + imo + ", mmsi=" + mmsi
				+ ", callSign=" + callSign + "]";
	}
	
	
}
