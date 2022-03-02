package com.shipping.common;

public class Collection {
	//Crew
	public final static String CREW = "Crew";
	public final static String CREW_PHOTO = "CrewPhoto";
	
	public final static String MEDICAL = "Medical";
	public final static String TRAVEL = "Travel";
	
	//Vessel
	public final static String VESSEL = "Vessel";
	public final static String VESSEL_OWNER = "VesselOwner";
	public final static String VESSEL_PHOTO = "VesselPhoto";
	public final static String VESSEL_OWNER_PHOTO = "VesselOwnerPhoto";
	
	//Common
	public final static String FLAG = "Flag";

	//Document 
	public final static String CREW_DOCUMENT = "CrewDocument";
	public final static String CREW_CERTIFICATION = "CrewCertification";
	public final static String CREW_DOCUMENT_TAG = "CrewDocumentTag";
	//public final static String CERTIFICATION = "Certification";
	public final static String DOC_SUB_CAT = "CrewDocumentSubCategory";
	
	//Audit 
	public final static String AUDIT_TRAIL = "AuditTrail";
	public final static String COMMENT = "Comment";
	
	
	//Company
	public final static String EMPLOYEE = "Employee";
	
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
