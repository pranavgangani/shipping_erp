package com.intuitbrains.model.crew;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.intuitbrains.model.common.document.category.Document;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import com.intuitbrains.common.AuditTrail;
import com.intuitbrains.common.Collection;
import com.intuitbrains.common.Comment;
import com.intuitbrains.common.Person;

@org.springframework.data.mongodb.core.mapping.Document(collection = Collection.CREW)
public class Crew extends Person {
    @Transient
    public static final String SEQUENCE_NAME = Collection.CREW;

    @Id
    private long id;
    private String passportNumber, visaNumber;
    private String distinguishMark;
    private Rank rank;
    private String manningOffice;
    private long photoId;
    private ObjectId nationalityFlagId;
    private String nationality;
    private int age;

    //Personal
    private String permAddress, presentAddress;
    private String contact1, contact2;
    private String nearestAirport, maritalStatus;

    // Past
    private List<Experience> employmentHistory;
    private List<Education> educationHistory;
    private List<TravelAudit> travelHistory;

    //Current
    private List<Document> existingDocuments;
    private List<Document> preJoiningDocuments;
    private List<Document> postJoiningDocuments;

    //Medical
    private List<IllnessAndInjury> illnessInjury;
    private boolean isSignedOffForMedicalReasons, isSufferingFromDiseaseThatEndangersLife, isDrugAlcoholAddict,
            hasMalaria, hasEpilepsy, hasDiabetes, hasNervousDisability;

    // KYC
    private List<NextOfKin> nextOfKins;
    private List<Bank> banks;
    private LocalDate dob;

    private String enteredBy, updatedBy;
    private LocalDateTime enteredLocalDateTime, updatedLocalDateTime;

    private int statusId;

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public Crew() {
        if (this.getFieldStatus() == null) this.setFieldStatus(new CrewFieldStatus());
    }

    //Audit
    private List<Comment> comments;
    private List<AuditTrail> auditTails;

    private CrewFieldStatus fieldStatus;

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

    public List<Experience> getEmploymentHistory() {
        return employmentHistory;
    }

    public void setEmploymentHistory(List<Experience> employmentHistory) {
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

    public String getManningOffice() {
        return manningOffice;
    }

    public void setManningOffice(String manningOffice) {
        this.manningOffice = manningOffice;
    }

    public ObjectId getNationalityFlagId() {
        return nationalityFlagId;
    }

    public void setNationalityFlagId(ObjectId nationalityFlagId) {
        this.nationalityFlagId = nationalityFlagId;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(long photoId) {
        this.photoId = photoId;
    }

    public List<TravelAudit> getTravelHistory() {
        return travelHistory;
    }

    public void setTravelHistory(List<TravelAudit> travelAuditHistory) {
        this.travelHistory = travelAuditHistory;
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

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
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


    public List<Document> getExistingDocuments() {
        return existingDocuments;
    }

    public void setExistingDocuments(List<Document> existingDocuments) {
        this.existingDocuments = existingDocuments;
    }


    public String getPermAddress() {
        return permAddress;
    }

    public void setPermAddress(String permAddress) {
        this.permAddress = permAddress;
    }

    public String getPresentAddress() {
        return presentAddress;
    }

    public void setPresentAddress(String presentAddress) {
        this.presentAddress = presentAddress;
    }

    public String getContact1() {
        return contact1;
    }

    public void setContact1(String contact1) {
        this.contact1 = contact1;
    }

    public String getContact2() {
        return contact2;
    }

    public void setContact2(String contact2) {
        this.contact2 = contact2;
    }

    public String getNearestAirport() {
        return nearestAirport;
    }

    public void setNearestAirport(String nearestAirport) {
        this.nearestAirport = nearestAirport;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public int getAge() {
        if (getDob() != null) {
            return (int) ChronoUnit.YEARS.between(getDob(), LocalDate.now());
        } else {
            return 0;
        }
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

    public CrewFieldStatus getFieldStatus() {
        return fieldStatus;
    }

    public void setFieldStatus(CrewFieldStatus fieldStatus) {
        this.fieldStatus = fieldStatus;
    }

    public String getEnteredBy() {
        return enteredBy;
    }

    public void setEnteredBy(String enteredBy) {
        this.enteredBy = enteredBy;
    }

    public LocalDateTime getEnteredLocalDateTime() {
        return enteredLocalDateTime;
    }

    public void setEnteredLocalDateTime(LocalDateTime enteredLocalDateTime) {
        this.enteredLocalDateTime = enteredLocalDateTime;
    }
    public boolean isSignedOffForMedicalReasons() {
        return isSignedOffForMedicalReasons;
    }

    public void setSignedOffForMedicalReasons(boolean signedOffForMedicalReasons) {
        isSignedOffForMedicalReasons = signedOffForMedicalReasons;
    }

    public boolean isSufferingFromDiseaseThatEndangersLife() {
        return isSufferingFromDiseaseThatEndangersLife;
    }

    public void setSufferingFromDiseaseThatEndangersLife(boolean sufferingFromDiseaseThatEndangersLife) {
        isSufferingFromDiseaseThatEndangersLife = sufferingFromDiseaseThatEndangersLife;
    }

    public boolean isDrugAlcoholAddict() {
        return isDrugAlcoholAddict;
    }

    public void setDrugAlcoholAddict(boolean drugAlcoholAddict) {
        isDrugAlcoholAddict = drugAlcoholAddict;
    }

    public boolean isHasMalaria() {
        return hasMalaria;
    }

    public void setHasMalaria(boolean hasMalaria) {
        this.hasMalaria = hasMalaria;
    }

    public boolean isHasEpilepsy() {
        return hasEpilepsy;
    }

    public void setHasEpilepsy(boolean hasEpilepsy) {
        this.hasEpilepsy = hasEpilepsy;
    }

    public boolean isHasDiabetes() {
        return hasDiabetes;
    }

    public void setHasDiabetes(boolean hasDiabetes) {
        this.hasDiabetes = hasDiabetes;
    }

    public boolean isHasNervousDisability() {
        return hasNervousDisability;
    }

    public void setHasNervousDisability(boolean hasNervousDisability) {
        this.hasNervousDisability = hasNervousDisability;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDateTime getUpdatedLocalDateTime() {
        return updatedLocalDateTime;
    }

    public void setUpdatedLocalDateTime(LocalDateTime updatedLocalDateTime) {
        this.updatedLocalDateTime = updatedLocalDateTime;
    }

    public enum Status {
        NEW_RECRUIT(1, "New Recruit"),
        PENDING_DOCS(2, "Pending Docs"),
        SIGN_ON_READY(3, "Sign-On Ready"),
        SIGNED_ON(4, "Signed-On"),
        SIGNED_OFF(5, "Signed-Off"),
        INJURED(10, "Injured");

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

        public static Status createFromId(int typeId) {
            return ((Status) (getList().stream().filter(o -> o.getId() == typeId).collect(Collectors.toList())).get(0));
        }

        public static List<Status> getList() {
            return new ArrayList<>(Arrays.asList(values()));
        }
    }
}
