package com.intuitbrains.model.crew;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.intuitbrains.common.*;
import com.intuitbrains.model.common.document.Contract;
import com.intuitbrains.model.crew.contract.TravelAndAccomodation;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

@org.springframework.data.mongodb.core.mapping.Document(collection = Collection.CREW)
public class Crew extends Person {
    @Transient
    public static final String SEQUENCE_NAME = Collection.CREW;

    @Id
    private long id;
    private String fileNum;
    protected String firstName, middleName, lastName;
    protected String gender;
    protected String userName, password, emailId;

    private String passportNumber, indosNumber;
    private String distinguishMark;
    private Rank rank;
    private double height, weight;
    private String manningOffice;
    private long photoId;
    private Flag nationalityFlag;
    private String placeOfBirth;
    private LocalDate dob, passportExpirationDate, indosExpirationDate, availableFromDate;
    private int age;
    private Contract currentContract;
    private long assignedVacancyId;
    private LocalDateTime assignedVacancyDateTime;
    private String assignedVacancyBy;

    //Contracts
    private List<Contract> historicalContracts;

    //Personal
    private String permAddress, presentAddress;
    private String contact1, contact2;
    private String nearestAirport;
    private String maritalStatus;

    // Past
    private List<Experience> employmentHistory;
    private List<Education> educationHistory;
    private List<TravelAndAccomodation> travelAndAccomodationHistory;

    //Current
    private List<CrewDocument> existingDocuments;
    private List<CrewDocument> mandatoryDocuments;

    //Medical
    private List<IllnessAndInjury> illnessInjury;
    private boolean isSignedOffForMedicalReasons, isSufferingFromDiseaseThatEndangersLife, isDrugAlcoholAddict,
            hasMalaria, hasEpilepsy, hasDiabetes, hasNervousDisability;

    // KYC
    private List<NextOfKin> nextOfKins;
    private List<Bank> banks;

    private String enteredBy, updatedBy;
    private LocalDateTime enteredDateTime, updatedDateTime;

    private int statusId;
    private Status status;

    public String getFileNum() {
        return fileNum;
    }

    public void setFileNum(String fileNum) {
        this.fileNum = fileNum;
    }

    public String getFullName() {
        return (getFirstName() + " " + getMiddleName() + " " + getLastName());
    }

    public String getDefaultGivenName() {
        return (getLastName() + " " + getFirstName() + " " + getMiddleName());
    }
    public String getFirstName() {
        return firstName;
    }

    public long getAssignedVacancyId() {
        return assignedVacancyId;
    }

    public void setAssignedVacancyId(long assignedVacancyId) {
        this.assignedVacancyId = assignedVacancyId;
    }

    @ACrew(name = CrewField.FIRST_NAME)
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    @ACrew(name = CrewField.MIDDLE_NAME)
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    @ACrew(name = CrewField.LAST_NAME)
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    @ACrew(name = CrewField.GENDER)
    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailId() {
        return emailId;
    }

    @ACrew(name = CrewField.EMAILID)
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public Status getStatus() {
        return (this.getStatusId() > 0 ? Status.createFromId(this.getStatusId()) : null);
    }

    public void setStatus(Status status) {
        this.status = status;
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

    @ACrew(name = CrewField.PASSPORT_NUM)
    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public LocalDate getPassportExpirationDate() {
        return passportExpirationDate;
    }

    @ACrew(name = CrewField.PASSPORT_EXPIRY_DATE)
    public void setPassportExpirationDate(LocalDate passportExpirationDate) {
        this.passportExpirationDate = passportExpirationDate;
    }

    public LocalDate getIndosExpirationDate() {
        return indosExpirationDate;
    }

    @ACrew(name = CrewField.INDOS_EXPIRY_DATE)
    public void setIndosExpirationDate(LocalDate indosExpirationDate) {
        this.indosExpirationDate = indosExpirationDate;
    }

    public String getIndosNumber() {
        return indosNumber;
    }

    @ACrew(name = CrewField.INDOS_NUM)
    public void setIndosNumber(String indosNumber) {
        this.indosNumber = indosNumber;
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

    @ACrew(name = CrewField.MANNING_OFFICE)
    public void setManningOffice(String manningOffice) {
        this.manningOffice = manningOffice;
    }

    public Flag getNationalityFlag() {
        return nationalityFlag;
    }

    @ACrew(name = CrewField.NATIONALITY_ID)
    public void setNationalityFlag(Flag nationalityFlagId) {
        this.nationalityFlag = nationalityFlag;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    @ACrew(name = CrewField.PLACE_OF_BIRTH)
    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(long photoId) {
        this.photoId = photoId;
    }

    public String getPermAddress() {
        return permAddress;
    }

    @ACrew(name = CrewField.PERMANENT_ADDRRESS)
    public void setPermAddress(String permAddress) {
        this.permAddress = permAddress;
    }

    public String getPresentAddress() {
        return presentAddress;
    }

    @ACrew(name = CrewField.PRESENT_ADDRRESS)
    public void setPresentAddress(String presentAddress) {
        this.presentAddress = presentAddress;
    }

    public String getContact1() {
        return contact1;
    }

    @ACrew(name = CrewField.CONTACT_1)
    public void setContact1(String contact1) {
        this.contact1 = contact1;
    }

    public String getContact2() {
        return contact2;
    }

    @ACrew(name = CrewField.CONTACT_2)
    public void setContact2(String contact2) {
        this.contact2 = contact2;
    }

    public String getNearestAirport() {
        return nearestAirport;
    }

    @ACrew(name = CrewField.NEAREST_AIRPORT)
    public void setNearestAirport(String nearestAirport) {
        this.nearestAirport = nearestAirport;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    @ACrew(name = CrewField.MARITAL_STATUS)
    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public LocalDate getDob() {
        return dob;
    }

    @ACrew(name = CrewField.DOB)
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public List<TravelAndAccomodation> getTravelAndAccomodationHistory() {
        return travelAndAccomodationHistory;
    }

    public void setTravelAndAccomodationHistory(List<TravelAndAccomodation> travelAndAccomodationHistory) {
        this.travelAndAccomodationHistory = travelAndAccomodationHistory;
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


    public List<CrewDocument> getExistingDocuments() {
        return existingDocuments;
    }

    public void setExistingDocuments(List<CrewDocument> existingDocuments) {
        this.existingDocuments = existingDocuments;
    }

    public List<CrewDocument> getMandatoryDocuments() {
        return mandatoryDocuments;
    }

    public void setMandatoryDocuments(List<CrewDocument> mandatoryDocuments) {
        this.mandatoryDocuments = mandatoryDocuments;
    }

    public double getHeight() {
        return height;
    }

    @ACrew(name = CrewField.HEIGHT)
    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    @ACrew(name = CrewField.WEIGHT)
    public void setWeight(double weight) {
        this.weight = weight;
    }

    public LocalDate getAvailableFromDate() {
        return availableFromDate;
    }

    @ACrew(name = CrewField.AVAILABILITY_DATE)
    public void setAvailableFromDate(LocalDate availableFromDate) {
        this.availableFromDate = availableFromDate;
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

    public void setAssignedVacancyDateTime(LocalDateTime assignedVacancyDateTime) {
        this.assignedVacancyDateTime = assignedVacancyDateTime;
    }

    public void setAssignedVacancyBy(String assignedVacancyBy) {
        this.assignedVacancyBy = assignedVacancyBy;
    }

    public void setEnteredDateTime(LocalDateTime enteredDateTime) {
        this.enteredDateTime = enteredDateTime;
    }

    public void setUpdatedDateTime(LocalDateTime updatedDateTime) {
        this.updatedDateTime = updatedDateTime;
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

    public Contract getCurrentContract() {
        return currentContract;
    }

    public void setCurrentContract(Contract currentContract) {
        this.currentContract = currentContract;
    }

    public List<Contract> getHistoricalContracts() {
        return historicalContracts;
    }

    public void setHistoricalContracts(List<Contract> historicalContracts) {
        this.historicalContracts = historicalContracts;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public LocalDateTime getAssignedVacancyDateTime() {
        return assignedVacancyDateTime;
    }

    public String getAssignedVacancyBy() {
        return assignedVacancyBy;
    }

    public LocalDateTime getEnteredDateTime() {
        return enteredDateTime;
    }

    public LocalDateTime getUpdatedDateTime() {
        return updatedDateTime;
    }

    public enum Status {
        NEW_RECRUIT(1, "New Recruit"),
        PENDING_DOCS(2, "Pending Docs"),
        SIGN_ON_READY(3, "Sign-On Ready"),
        ASSIGNED(4, "Assigned"),
        SIGNED_ON(5, "Signed-On"),
        SIGNED_OFF(6, "Signed-Off"),
        INJURED(7, "Injured"),
        INACTIVE(8, "Inactive/Left");

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
            return ((getList().stream().filter(o -> o.getId() == typeId).collect(Collectors.toList())).get(0));
        }

        public static List<Status> getList() {
            return new ArrayList<>(Arrays.asList(values()));
        }
    }


    public enum MaritalStatus {
        SINGLE("Single"),
        MARRIED("Married");

        private String desc;

        MaritalStatus(String desc) {
            this.desc = desc;
        }

        public String getDesc() {
            return desc;
        }

        public static List<MaritalStatus> getList() {
            return new ArrayList<>(Arrays.asList(values()));
        }
    }
}
