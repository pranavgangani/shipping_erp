package com.shipping.model.crew;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import com.shipping.company.Employee;
import com.shipping.model.common.DurationType;
import com.shipping.model.crew.DocumentSubType;
import com.shipping.model.crew.DocumentType;
import com.shipping.util.DateTime;

@org.springframework.data.mongodb.core.mapping.Document(collection = "RankDocument")
public class RankDocument {
	@Transient
	public static final String SEQUENCE_NAME = "RankDocument";
	
	@Id
	private long id;
	private String name, desc;

	private int validity;
	private DurationType durationType;	
	private DocumentType docType;	
	private DocumentSubType docSubType;

	private int rankSubCategoryId;
	private int rankCategoryId;
	private int rankId;
}
