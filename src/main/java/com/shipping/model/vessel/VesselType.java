package com.shipping.model.vessel;

public enum VesselType {
	CARGO(1, "Cargo"), 
	TANKER(2, "Tanker"), 
	PASSENGER(3, "Passenger/Cruise"), 
	OTHER(0, "Other");

	private int typeId;
	private String desc;

	VesselType(int typeId, String desc) {
		this.typeId = typeId;
		this.desc = desc;
	}

	public int getTypeId() {
		return typeId;
	}

	public String getDesc() {
		return desc;
	}
	
}
