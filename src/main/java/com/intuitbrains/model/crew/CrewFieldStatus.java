package com.intuitbrains.model.crew;

import com.intuitbrains.dao.common.FieldStatus;

public class CrewFieldStatus {
    private FieldStatus firstName, middleName, lastName, maritalStatusId, gender, nationalityFlagId, nationality, rank, manningOffice, nearestAirport,
            distinguishingMark, permAddress, presentAddress, emailId, contact1, contact2, dob, passportNumber, indosNumber;

    public CrewFieldStatus() {
        init();
    }
    private void init() {
        firstName = new FieldStatus(null, null, null, null);
        middleName = new FieldStatus(null, null, null, null);
        lastName = new FieldStatus(null, null, null, null);
        maritalStatusId = new FieldStatus(null, null, null, null);
        gender = new FieldStatus(null, null, null, null);
        nationalityFlagId = new FieldStatus(null, null, null, null);
        nationality = new FieldStatus(null, null, null, null);
        rank = new FieldStatus(null, null, null, null);
        manningOffice = new FieldStatus(null, null, null, null);
        nearestAirport = new FieldStatus(null, null, null, null);
        distinguishingMark = new FieldStatus(null, null, null, null);
        permAddress = new FieldStatus(null, null, null, null);
        presentAddress = new FieldStatus(null, null, null, null);
        emailId = new FieldStatus(null, null, null, null);
        contact1 = new FieldStatus(null, null, null, null);
        contact2 = new FieldStatus(null, null, null, null);
        dob = new FieldStatus(null, null, null, null);
        passportNumber = new FieldStatus(null, null, null, null);
        indosNumber = new FieldStatus(null, null, null, null);
    }

    //Setters
    public void setPassportNumber(FieldStatus passportNumber) {
        this.passportNumber = passportNumber;
    }

    public void setIndosNumber(FieldStatus indosNumber) {
        this.indosNumber = indosNumber;
    }

    public void setFirstName(FieldStatus firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(FieldStatus middleName) {
        this.middleName = middleName;
    }

    public void setLastName(FieldStatus lastName) {
        this.lastName = lastName;
    }

    public void setMaritalStatusId(FieldStatus maritalStatusId) {
        this.maritalStatusId = maritalStatusId;
    }

    public void setGender(FieldStatus gender) {
        this.gender = gender;
    }

    public void setNationalityFlagId(FieldStatus nationalityFlagId) {
        this.nationalityFlagId = nationalityFlagId;
    }

    public void setNationality(FieldStatus nationality) {
        this.nationality = nationality;
    }

    public void setRank(FieldStatus rank) {
        this.rank = rank;
    }

    public void setManningOffice(FieldStatus manningOffice) {
        this.manningOffice = manningOffice;
    }

    public void setNearestAirport(FieldStatus nearestAirport) {
        this.nearestAirport = nearestAirport;
    }

    public void setDistinguishingMark(FieldStatus distinguishingMark) {
        this.distinguishingMark = distinguishingMark;
    }

    public void setPermAddress(FieldStatus permAddress) {
        this.permAddress = permAddress;
    }

    public void setPresentAddress(FieldStatus presentAddress) {
        this.presentAddress = presentAddress;
    }

    public void setEmailId(FieldStatus emailId) {
        this.emailId = emailId;
    }

    public void setContact1(FieldStatus contact1) {
        this.contact1 = contact1;
    }

    public void setContact2(FieldStatus contact2) {
        this.contact2 = contact2;
    }

    public void setDob(FieldStatus dob) {
        this.dob = dob;
    }

    //Getters


    public FieldStatus getPassportNumber() {
        return passportNumber;
    }

    public FieldStatus getIndosNumber() {
        return indosNumber;
    }

    public FieldStatus getFirstName() {
        return firstName;
    }

    public FieldStatus getMiddleName() {
        return middleName;
    }

    public FieldStatus getLastName() {
        return lastName;
    }

    public FieldStatus getMaritalStatusId() {
        return maritalStatusId;
    }

    public FieldStatus getGender() {
        return gender;
    }

    public FieldStatus getNationalityFlagId() {
        return nationalityFlagId;
    }

    public FieldStatus getNationality() {
        return nationality;
    }

    public FieldStatus getRank() {
        return rank;
    }

    public FieldStatus getManningOffice() {
        return manningOffice;
    }

    public FieldStatus getNearestAirport() {
        return nearestAirport;
    }

    public FieldStatus getDistinguishingMark() {
        return distinguishingMark;
    }

    public FieldStatus getPermAddress() {
        return permAddress;
    }

    public FieldStatus getPresentAddress() {
        return presentAddress;
    }

    public FieldStatus getEmailId() {
        return emailId;
    }

    public FieldStatus getContact1() {
        return contact1;
    }

    public FieldStatus getContact2() {
        return contact2;
    }

    public FieldStatus getDob() {
        return dob;
    }
}
