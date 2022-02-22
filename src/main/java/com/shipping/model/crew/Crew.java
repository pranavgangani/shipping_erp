package com.shipping.model.crew;

import java.util.List;

import org.springframework.data.annotation.Id;

import com.shipping.common.Gender;
import com.shipping.company.Employee;
import com.shipping.util.DateTime;
 
//@Document(collection="Crew")
public class Crew {
	@Id
	private int crewId;
	private String fName, lName, mName;
	private int genderId;
	private Gender gender;
	private int rankId;
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
	
	private DateTime enteredDateTime;
	private Employee enteredByEmp;
	public int getCrewId() {
		return crewId;
	}
	public void setCrewId(int crewId) {
		this.crewId = crewId;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public int getGenderId() {
		return genderId;
	}
	public void setGenderId(int genderId) {
		this.genderId = genderId;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public int getRankId() {
		return rankId;
	}
	public void setRankId(int rankId) {
		this.rankId = rankId;
	}
	public Rank getRank() {
		return rank;
	}
	public void setRank(Rank rank) {
		this.rank = rank;
	}
	public List<Employment> getEmployeeHistory() {
		return employeeHistory;
	}
	public void setEmployeeHistory(List<Employment> employeeHistory) {
		this.employeeHistory = employeeHistory;
	}
	public List<Education> getEducatonHistory() {
		return educatonHistory;
	}
	public void setEducatonHistory(List<Education> educatonHistory) {
		this.educatonHistory = educatonHistory;
	}
	public List<Document> getDocuments() {
		return documents;
	}
	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}
	public List<Medical> getMedicalHistory() {
		return medicalHistory;
	}
	public void setMedicalHistory(List<Medical> medicalHistory) {
		this.medicalHistory = medicalHistory;
	}
	public List<Nominee> getNominees() {
		return nominees;
	}
	public void setNominees(List<Nominee> nominees) {
		this.nominees = nominees;
	}
	public List<Bank> getBanks() {
		return banks;
	}
	public void setBanks(List<Bank> banks) {
		this.banks = banks;
	}
	public String getPassportNum() {
		return passportNum;
	}
	public void setPassportNum(String passportNum) {
		this.passportNum = passportNum;
	}
	public String getVisaNum() {
		return visaNum;
	}
	public void setVisaNum(String visaNum) {
		this.visaNum = visaNum;
	}
	public DateTime getDob() {
		return dob;
	}
	public void setDob(DateTime dob) {
		this.dob = dob;
	}
	public List<TrainingRequest> getTrainingRequests() {
		return trainingRequests;
	}
	public void setTrainingRequests(List<TrainingRequest> trainingRequests) {
		this.trainingRequests = trainingRequests;
	}
	public List<TravelRequest> getTravelRequests() {
		return travelRequests;
	}
	public void setTravelRequests(List<TravelRequest> travelRequests) {
		this.travelRequests = travelRequests;
	}
	public List<MedicalRequest> getMedicalRequests() {
		return medicalRequests;
	}
	public void setMedicalRequests(List<MedicalRequest> medicalRequests) {
		this.medicalRequests = medicalRequests;
	}
	public DateTime getEnteredDateTime() {
		return enteredDateTime;
	}
	public void setEnteredDateTime(DateTime enteredDateTime) {
		this.enteredDateTime = enteredDateTime;
	}
	public Employee getEnteredByEmp() {
		return enteredByEmp;
	}
	public void setEnteredByEmp(Employee enteredByEmp) {
		this.enteredByEmp = enteredByEmp;
	}
	
	
}
