package com.intuitbrains.model.crew;

import java.time.LocalDate;

public class MedicalRecord {
    private MedicalType medicalType;
    private String nameOfVessel;
    private LocalDate dateOfOccurance;
    private String description;

    public MedicalType getMedicalType() {
        return medicalType;
    }

    public void setMedicalType(MedicalType medicalType) {
        this.medicalType = medicalType;
    }

    public String getNameOfVessel() {
        return nameOfVessel;
    }

    public void setNameOfVessel(String nameOfVessel) {
        this.nameOfVessel = nameOfVessel;
    }

    public LocalDate getDateOfOccurance() {
        return dateOfOccurance;
    }

    public void setDateOfOccurance(LocalDate dateOfOccurance) {
        this.dateOfOccurance = dateOfOccurance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /*private String name, desc;

    private int validity;
    private DurationType durationType;
    private MedicalType medicalType;

    private int rankSubCategoryId;
    private int rankCategoryId;
    private int rankId;

    private List<Document> documents;*/
}
