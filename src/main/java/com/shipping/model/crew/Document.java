package com.shipping.model.crew;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import com.shipping.common.Collection;
import com.shipping.common.Comment;
import com.shipping.company.Employee;
import com.shipping.model.common.DurationType;
import com.shipping.util.DateTime;

@org.springframework.data.mongodb.core.mapping.Document(collection = Collection.DOCUMENT)
public class Document {
	@Transient
	public static final String SEQUENCE_NAME = Collection.DOCUMENT;
	
	@Id
	private long id;
	private String name, desc;

	//Validity Level
	private int rankSubCategoryId;
	private int rankCategoryId;
	private int rankId;
	private String gender;

	//Doc details
	private String docTitle;
	private String docNumber;
	private DocumentCategory docCategory;	
	private DocumentSubCategory docSubCategory;
	private String givenName;

	//Other datapoints
	private int validity;
	private DurationType durationType;	
	private DateTime issueDate, expiryDate;	
	private String type;
	private String docRemarks;
	
	//Passport specific	
	private String nationality, countryCode;
	
	//Visa specific
	private String entries, issingPostName, annotation, controlNumber;
	
	//Contract
	private boolean isRequiredForContract, isDeclaration, isPassport, isVisa ,isBriefing;
	private List<ContractRule> contractRules;
		
	//Required when storing against Crew
	private List<Comment> comments;
}
