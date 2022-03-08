package com.shipping.model.crew;

import com.shipping.dao.common.FieldStatus;

public class CrewFieldStatus {
    private FieldStatus name, maritalStatus, gender, nationalityCode, nationality, rank, manningOffice, nearestAirport,
            distinguishingMark, homeAddress, emailId, contact1, contact2, dob;

    public CrewFieldStatus() {
        name = new FieldStatus(null,null,null,null);
        maritalStatus = new FieldStatus(null,null,null,null);
        gender = new FieldStatus(null,null,null,null);
        nationalityCode = new FieldStatus(null,null,null,null);
        nationality = new FieldStatus(null,null,null,null);
        rank = new FieldStatus(null,null,null,null);
        manningOffice = new FieldStatus(null,null,null,null);
        nearestAirport = new FieldStatus(null,null,null,null);
        distinguishingMark = new FieldStatus(null,null,null,null);
        homeAddress = new FieldStatus(null,null,null,null);
        emailId = new FieldStatus(null,null,null,null);
        contact1 = new FieldStatus(null,null,null,null);
        contact2 = new FieldStatus(null,null,null,null);
        dob = new FieldStatus(null,null,null,null);
    }

    public FieldStatus getName() {
        return name;
    }

    public void setName(FieldStatus name) {
        this.name = name;
    }

    public FieldStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(FieldStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public FieldStatus getGender() {
        return gender;
    }

    public void setGender(FieldStatus gender) {
        this.gender = gender;
    }

    public FieldStatus getNationalityCode() {
        return nationalityCode;
    }

    public void setNationalityCode(FieldStatus nationalityCode) {
        this.nationalityCode = nationalityCode;
    }

    public FieldStatus getNationality() {
        return nationality;
    }

    public void setNationality(FieldStatus nationality) {
        this.nationality = nationality;
    }

    public FieldStatus getRank() {
        return rank;
    }

    public void setRank(FieldStatus rank) {
        this.rank = rank;
    }

    public FieldStatus getManningOffice() {
        return manningOffice;
    }

    public void setManningOffice(FieldStatus manningOffice) {
        this.manningOffice = manningOffice;
    }

    public FieldStatus getNearestAirport() {
        return nearestAirport;
    }

    public void setNearestAirport(FieldStatus nearestAirport) {
        this.nearestAirport = nearestAirport;
    }

    public FieldStatus getDistinguishingMark() {
        return distinguishingMark;
    }

    public void setDistinguishingMark(FieldStatus distinguishingMark) {
        this.distinguishingMark = distinguishingMark;
    }

    public FieldStatus getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(FieldStatus homeAddress) {
        this.homeAddress = homeAddress;
    }

    public FieldStatus getEmailId() {
        return emailId;
    }

    public void setEmailId(FieldStatus emailId) {
        this.emailId = emailId;
    }

    public FieldStatus getContact1() {
        return contact1;
    }

    public void setContact1(FieldStatus contact1) {
        this.contact1 = contact1;
    }

    public FieldStatus getContact2() {
        return contact2;
    }

    public void setContact2(FieldStatus contact2) {
        this.contact2 = contact2;
    }

    public FieldStatus getDob() {
        return dob;
    }

    public void setDob(FieldStatus dob) {
        this.dob = dob;
    }
}
