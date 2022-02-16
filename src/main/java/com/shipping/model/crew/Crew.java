package com.shipping.model.crew;

import java.util.List;

import com.shipping.common.Gender;
import com.shipping.util.DateTime;

public class Crew {
	private int id;
	private String fName, lName, mName;
	private int genderId;
	private Gender gender;	
	private Rank rank;
	
	//Past
	private List<Employment> employeeHistory;
	private List<Education> educatonHistory;
	private List<Document> documents;	
	private List<Medical> medicalHistory;
	
	//KYC
	private List<Nominee> nominees;	
	private List<Bank> banks;	
	private String passportNum, visaNum;
	private DateTime dob;
		
	//Requests
	private List<TrainingRequest> trainingRequests;
	private List<TravelRequest> travelRequests;
	private List<MedicalRequest> medicalRequests;
}
