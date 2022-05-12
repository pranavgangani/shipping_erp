package com.intuitbrains.model.crew;

public enum CrewField {
    FIRST_NAME("firstName"),
    MIDDLE_NAME("middleName"),
    LAST_NAME("lastName"),
    DOB("dob");

    private String fieldName;

    CrewField(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldName() {
        return fieldName;
    }
}
