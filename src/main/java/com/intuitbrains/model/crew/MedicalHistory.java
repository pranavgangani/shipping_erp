package com.intuitbrains.model.crew;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.intuitbrains.common.Collection;

//@Document(collection = Collection.MEDICAL_HISTORY)
public class MedicalHistory {
	//@Transient
	//public static final String SEQUENCE_NAME = Collection.MEDICAL_HISTORY;

	//@Id
	//private long id;

	//private long crewId;
	private boolean isSignedOffForMedicalReasons, isSufferingFromDiseaseThatEndangersLife, isDrugAlcoholAddict,
			hasMalaria, hasEpilepsy, hasDiabetes, hasNervousDisability;
	private List<MedicalRecord> medicalRecords;

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

	public List<MedicalRecord> getMedicalRecords() {
		return medicalRecords;
	}

	public void setMedicalRecords(List<MedicalRecord> medicalRecords) {
		this.medicalRecords = medicalRecords;
	}
}
