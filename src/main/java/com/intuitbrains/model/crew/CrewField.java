package com.intuitbrains.model.crew;

public enum CrewField {
    FIRST_NAME("firstName"),
    MIDDLE_NAME("middleName"),
    LAST_NAME("lastName"),
    DOB("dob"), 
    GENDER("gender"), 
    PASSPORT_NUM("passportNumber"),
    PASSPORT_EXPIRY_DATE("passportExpirationDate"),
    INDOS_NUM("indosNumber"),
    INDOS_EXPIRY_DATE("indosExpirationDate"),
    MANNING_OFFICE("manningOffice"),
    PLACE_OF_BIRTH("placeOfBirth"),
    NATIONALITY_ID("nationalityId"), 
    //NATIONALITY("Nationality"),
    PERMANENT_ADDRRESS("permanentAddress"),
    PRESENT_ADDRRESS("presentAddress"),
    CONTACT_1("contact1"),
    CONTACT_2("contact2"),
    NEAREST_AIRPORT("nearestAirport"),
    MARITAL_STATUS("maritalStatus"),
    EMAILID("emailId"),
    AVAILABILITY_DATE("availableFromDate"),
    HEIGHT("height"),
    WEIGHT("weight");

    private String fieldName;

    CrewField(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }


}
