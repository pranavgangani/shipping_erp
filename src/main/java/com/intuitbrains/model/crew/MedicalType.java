package com.intuitbrains.model.crew;

public enum MedicalType {
    ILLNESS(1, "Illness"),
    INJURY(2, "Injury"),
    ACCIDENT(3, "Accident");

    private int id;
    private String name;

    MedicalType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
