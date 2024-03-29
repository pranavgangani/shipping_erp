package com.intuitbrains.common;

public class Collection {
	//Crew
	public final static String CREW = "Crew";
	public final static String CREW_PHOTO = "CrewPhoto";
	
	public final static String MEDICAL_HISTORY = "MedicalHistory";
	public final static String TRAVEL_HISTORY = "TravelHistory";
	
	//Vessel
	public final static String VESSEL = "Vessel";
	public final static String VESSEL_OWNER = "VesselOwner";
	public final static String VESSEL_PHOTO = "VesselPhoto";
	public final static String VESSEL_OWNER_PHOTO = "VesselOwnerPhoto";
	public final static String VESSEL_VACANCY = "VesselVacancy";

	public final static String JOURNEY = "VesselJourney";

	public final static String COMMUNICATION = "VesselCommunication";
	
	//Common
	public final static String FLAG = "Flag";
	public final static String PORT = "SeaPort";

	//Document
	//public final static String MANDATORY_CREW_DOCUMENT = "MandatoryCrewDocument";
	public final static String CREW_DOCUMENT = "CrewDocument";
	public final static String CREW_CERTIFICATION = "CrewCertification";
	public final static String CREW_DOCUMENT_TAG = "CrewDocumentTag";
	//public final static String CERTIFICATION = "Certification";
	public final static String DOC_SUB_CAT = "CrewDocumentSubCategory";
	public final static String DOCUMENT_TYPE = "DocumentType";

	//Contract
	public final static String CREW_CONTRACT = "CrewContract";
	public final static String TRAVEL_AND_ACCOMODATION = "TravelAndAccomodation";
	public final static String CONTRACT_RULE = "ContractRule";

	//Audit
	public final static String CREW_FIELD_AUDIT = "CrewFieldAudit";
	public final static String AUDIT_TRAIL = "AuditTrail";
	public final static String FS_AUDIT_TRAIL = "FieldStatusAuditTrail";
	public final static String COMMENT = "Comment";

	//Company
	public final static String EMPLOYEE = "Employee";
	public final static String ROLE = "Role";
	//public final static String USER = "User";
	
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
