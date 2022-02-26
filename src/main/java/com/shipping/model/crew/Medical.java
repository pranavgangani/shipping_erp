package com.shipping.model.crew;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.shipping.model.common.DurationType;
import com.shipping.model.crew.MedicalType;
import com.shipping.util.DateTime;

@Document(collection = "RankMedical")
public class Medical {
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
