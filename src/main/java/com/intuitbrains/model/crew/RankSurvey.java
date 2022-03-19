package com.intuitbrains.model.crew;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.intuitbrains.model.common.DurationType;

@Document(collection = "RankMedical")
public class RankSurvey {
	@Transient
	public static final String SEQUENCE_NAME = "RankMedical";
	
	@Id
	private long id;
	private String name, desc;
	
	private int validity;
	private DurationType durationType;	
	private MedicalType medicalType;	

	private int rankSubCategoryId;
	private int rankCategoryId;
	private int rankId;

}
