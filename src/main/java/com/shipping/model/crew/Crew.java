package com.shipping.model.crew;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import com.shipping.common.Collection;
import com.shipping.common.Gender;
import com.shipping.company.Employee;
import com.shipping.model.crew.Rank;
import com.shipping.model.crew.RankCertification;
import com.shipping.model.crew.RankDocument;
import com.shipping.model.crew.RankMedical;
import com.shipping.util.DateTime;

@org.springframework.data.mongodb.core.mapping.Document(collection = Collection.CREW)
public class Crew {
	@Transient
	public static final String SEQUENCE_NAME = Collection.CREW;
	
	@Id
	private long id;
	private String fName, lName, mName;
	private String passportNumber, visaNumber;
	private int genderId;
	private Rank rank;
	private long manningOfficeId;
	
	private Gender gender;
	private ManningOffice manningOffice;
	

	// Past
	private List<Employment> employeeHistory;
	private List<Education> educatonHistory;
	private List<RankDocument> documents;
	private List<RankCertification> certifications;
	private List<RankMedical> medicalHistory;

	// KYC
	private List<Nominee> nominees;
	private List<Bank> banks;
	private String passportNum, visaNum;
	private DateTime dob;

	// Requests
	private List<TrainingRequest> trainingRequests;
	private List<TravelRequest> travelRequests;
	private List<MedicalRequest> medicalRequests;

	private DateTime enteredDateTime;
	private Employee enteredByEmp;

	public long getId() {
		return id;
	}

	public void setId(long l) {
		this.id = l;
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

	public List<RankDocument> getDocuments() {
		return documents;
	}

	public void setDocuments(List<RankDocument> documents) {
		this.documents = documents;
	}

	public List<RankMedical> getMedicalHistory() {
		return medicalHistory;
	}

	public void setMedicalHistory(List<RankMedical> medicalHistory) {
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

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getVisaNumber() {
		return visaNumber;
	}

	public void setVisaNumber(String visaNumber) {
		this.visaNumber = visaNumber;
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
		Crew other = (Crew) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
