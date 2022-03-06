package com.shipping.model.crew;

import java.util.List;

import com.shipping.model.common.document.category.Document;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import com.shipping.common.AuditTrail;
import com.shipping.common.Collection;
import com.shipping.common.Comment;
import com.shipping.common.Flag;
import com.shipping.common.Person;
import com.shipping.model.company.Employee;
import com.shipping.util.DateTime;

@org.springframework.data.mongodb.core.mapping.Document(collection = Collection.CREW)
public class Crew extends Person {
    @Transient
    public static final String SEQUENCE_NAME = Collection.CREW;

    @Id
    private long id;
    private String passportNumber, visaNumber;
    private String distinguishMark;
    private Rank rank;
    private Flag manningOffice;
    private long photoId;
    private Flag citizenFlag;

    private String permAddress, tempAddress;

    // Past
    private List<Employment> employmentHistory;
    private List<Education> educationHistory;
    private List<Medical> medicalHistory;
    private List<Travel> travelHistory;

    //Current
    private List<Document> existingDocuments;
    private List<Document> preJoiningDocuments;
    private List<Document> postJoiningDocuments;

    //Medical
    private List<IllnessAndInjury> illnessInjury;

    // KYC
    private List<NextOfKin> nextOfKins;
    private List<Bank> banks;
    private String passportNum, visaNum;
    private DateTime dob;

    private int statusId;

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }
    // Requests
	/*private List<CourseRequest> trainingRequests;
	private List<TravelRequest> travelRequests;
	private List<MedicalRequest> medicalRequests;*/

    //Audit
    private List<Comment> comments;
    private List<AuditTrail> auditTails;

    private Employee enteredByEmp;
    private DateTime enteredDateTime;
    private Employee reviewedByEmp;
    private DateTime reviewedDateTime;

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

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public List<Employment> getEmploymentHistory() {
        return employmentHistory;
    }

    public void setEmploymentHistory(List<Employment> employmentHistory) {
        this.employmentHistory = employmentHistory;
    }

    public List<Education> getEducationHistory() {
        return educationHistory;
    }

    public void setEducationHistory(List<Education> educationHistory) {
        this.educationHistory = educationHistory;
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

    public String getDistinguishMark() {
        return distinguishMark;
    }

    public void setDistinguishMark(String distinguishMark) {
        this.distinguishMark = distinguishMark;
    }

    public Flag getManningOffice() {
        return manningOffice;
    }

    public void setManningOffice(Flag manningOffice) {
        this.manningOffice = manningOffice;
    }

    public long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(long photoId) {
        this.photoId = photoId;
    }

    public List<Medical> getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(List<Medical> medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public List<Travel> getTravelHistory() {
        return travelHistory;
    }

    public void setTravelHistory(List<Travel> travelHistory) {
        this.travelHistory = travelHistory;
    }

    public List<Document> getPreJoiningDocuments() {
        return preJoiningDocuments;
    }

    public void setPreJoiningDocuments(List<Document> preJoiningDocuments) {
        this.preJoiningDocuments = preJoiningDocuments;
    }

    public List<Document> getPostJoiningDocuments() {
        return postJoiningDocuments;
    }

    public void setPostJoiningDocuments(List<Document> postJoiningDocuments) {
        this.postJoiningDocuments = postJoiningDocuments;
    }

    public List<IllnessAndInjury> getIllnessInjury() {
        return illnessInjury;
    }

    public void setIllnessInjury(List<IllnessAndInjury> illnessInjury) {
        this.illnessInjury = illnessInjury;
    }

    public List<NextOfKin> getNextOfKins() {
        return nextOfKins;
    }

    public void setNextOfKins(List<NextOfKin> nextOfKins) {
        this.nextOfKins = nextOfKins;
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

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<AuditTrail> getAuditTails() {
        return auditTails;
    }

    public void setAuditTails(List<AuditTrail> auditTails) {
        this.auditTails = auditTails;
    }

    public Employee getEnteredByEmp() {
        return enteredByEmp;
    }

    public void setEnteredByEmp(Employee enteredByEmp) {
        this.enteredByEmp = enteredByEmp;
    }

    public DateTime getEnteredDateTime() {
        return enteredDateTime;
    }

    public void setEnteredDateTime(DateTime enteredDateTime) {
        this.enteredDateTime = enteredDateTime;
    }

    public Employee getReviewedByEmp() {
        return reviewedByEmp;
    }

    public void setReviewedByEmp(Employee reviewedByEmp) {
        this.reviewedByEmp = reviewedByEmp;
    }

    public DateTime getReviewedDateTime() {
        return reviewedDateTime;
    }

    public void setReviewedDateTime(DateTime reviewedDateTime) {
        this.reviewedDateTime = reviewedDateTime;
    }

    public List<Document> getExistingDocuments() {
        return existingDocuments;
    }

    public void setExistingDocuments(List<Document> existingDocuments) {
        this.existingDocuments = existingDocuments;
    }

    public Flag getCitizenFlag() {
        return citizenFlag;
    }

    public void setCitizenFlag(Flag citizenFlag) {
        this.citizenFlag = citizenFlag;
    }

    public String getPermAddress() {
        return permAddress;
    }

    public void setPermAddress(String permAddress) {
        this.permAddress = permAddress;
    }

    public String getTempAddress() {
        return tempAddress;
    }

    public void setTempAddress(String tempAddress) {
        this.tempAddress = tempAddress;
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

    public enum Status {
        NEW_RECRUIT(1, "New Recruit"),
        PENDING_DOCS(2, "Pending Docs"),
        SIGN_ON_READY(3, "Sign-On Ready"),
        SIGNED_ON(4, "Signed-On"),
        SIGNED_OFF(5, "Signed-Off");


        private int id;
        private String desc;

        Status(int id, String desc) {
            this.id = id;
            this.desc = desc;
        }

        public int getId() {
            return id;
        }

        public String getDesc() {
            return desc;
        }
    }
}
