package com.intuitbrains.model.crew;

import com.intuitbrains.model.company.Employee;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class IllnessAndInjury {
	private MedicalType medicalType;
	private String nameOfVessel;
	private LocalDate dateOfOccurence;
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
		return dateOfOccurence;
	}

	public void setDateOfOccurence(LocalDate dateOfOccurance) {
		this.dateOfOccurence = dateOfOccurance;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
