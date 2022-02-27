package com.shipping.common;

public class Collection {
	public final static String CREW = "Crew";
	public final static String VESSEL = "Vessel";
	public final static String VESSEL_OWNER = "VesselOwner";
	public final static String FLAG = "Flag";
	public final static String CREW_PHOTO = "CrewPhoto";
	public final static String VESSEL_PHOTO = "VesselPhoto";
	public final static String VESSEL_OWNER_PHOTO = "VesselOwnerPhoto";
	public final static String AUDIT_TRAIL = "AuditTrail";
	public final static String CERTIFICATION = "Certification";
	
	public final static String DOC_SUB_CAT = "DocumentSubCategory";
	
	private String name;
	
	Collection(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return name;
	}
	
	
}
