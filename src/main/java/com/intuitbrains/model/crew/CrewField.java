package com.intuitbrains.model.crew;

public enum CrewField {
    FIRST_NAME("firstName"),
    MIDDLE_NAME("middleName"),
    LAST_NAME("lastName"),
    DOB("dob"), 
    GENDER("gender"), 
    PASSPORT_NUM("passportNumber"),
    INDOS_NUM("indosNumber"), 
    MANNING_OFFICE("manningOffice"),
    NATIONALITY_ID("nationalityId"), 
    NATIONALITY("Nationality"), 
    PERMANENT_ADDRRESS("permanentAddress"),
    PRESENT_ADDRRESS("presentAddress"),
    CONTACT_1("contact1"),
    CONTACT_2("contact2"),
    NEAREST_AIRPORT("nearestAirport"),
    MARITAL_STATUS_ID("maritalStatusId"),
    EMAILID("emailId");

    private String fieldName;

    CrewField(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }


}
