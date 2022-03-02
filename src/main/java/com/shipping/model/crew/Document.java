package com.shipping.model.crew;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import com.shipping.common.Collection;
import com.shipping.common.Comment;
import com.shipping.company.Employee;
import com.shipping.model.common.DurationType;
import com.shipping.util.DateTime;

@org.springframework.data.mongodb.core.mapping.Document(collection = Collection.CREW_DOCUMENT)
public class Document {
	@Transient
	public static final String SEQUENCE_NAME = Collection.CREW_DOCUMENT;
	
	@Id
	private long id;
	private String name, desc;

	//Validity Level
	private DocumentMatrix documentMatrix;

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
	
	//Training course specific
	private String regulation, sectionTable;
	
	//Contract
	private boolean isMandatory;
	private DocumentTag documentTag;
	private List<ContractRule> contractRules;
		
	//Required when storing against Crew
	private List<Comment> comments;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getDocTitle() {
		return docTitle;
	}

	public void setDocTitle(String docTitle) {
		this.docTitle = docTitle;
	}

	public String getDocNumber() {
		return docNumber;
	}

	public void setDocNumber(String docNumber) {
		this.docNumber = docNumber;
	}

	public DocumentCategory getDocCategory() {
		return docCategory;
	}

	public void setDocCategory(DocumentCategory docCategory) {
		this.docCategory = docCategory;
	}

	public DocumentSubCategory getDocSubCategory() {
		return docSubCategory;
	}

	public void setDocSubCategory(DocumentSubCategory docSubCategory) {
		this.docSubCategory = docSubCategory;
	}

	public String getGivenName() {
		return givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public int getValidity() {
		return validity;
	}

	public void setValidity(int validity) {
		this.validity = validity;
	}

	public DurationType getDurationType() {
		return durationType;
	}

	public void setDurationType(DurationType durationType) {
		this.durationType = durationType;
	}

	public DateTime getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(DateTime issueDate) {
		this.issueDate = issueDate;
	}

	public DateTime getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(DateTime expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDocRemarks() {
		return docRemarks;
	}

	public void setDocRemarks(String docRemarks) {
		this.docRemarks = docRemarks;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getEntries() {
		return entries;
	}

	public void setEntries(String entries) {
		this.entries = entries;
	}

	public String getIssingPostName() {
		return issingPostName;
	}

	public void setIssingPostName(String issingPostName) {
		this.issingPostName = issingPostName;
	}

	public String getAnnotation() {
		return annotation;
	}

	public void setAnnotation(String annotation) {
		this.annotation = annotation;
	}

	public String getControlNumber() {
		return controlNumber;
	}

	public void setControlNumber(String controlNumber) {
		this.controlNumber = controlNumber;
	}

	public List<ContractRule> getContractRules() {
		return contractRules;
	}

	public void setContractRules(List<ContractRule> contractRules) {
		this.contractRules = contractRules;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}


	public boolean isMandatory() {
		return isMandatory;
	}

	public void setMandatory(boolean isMandatory) {
		this.isMandatory = isMandatory;
	}

	public DocumentMatrix getDocumentMatrix() {
		return documentMatrix;
	}

	public void setDocumentMatrix(DocumentMatrix documentMatrix) {
		this.documentMatrix = documentMatrix;
	}

	public DocumentTag getDocumentTag() {
		return documentTag;
	}

	public void setDocumentTag(DocumentTag documentTag) {
		this.documentTag = documentTag;
	}

	public String getRegulation() {
		return regulation;
	}

	public void setRegulation(String regulation) {
		this.regulation = regulation;
	}

	public String getSectionTable() {
		return sectionTable;
	}

	public void setSectionTable(String sectionTable) {
		this.sectionTable = sectionTable;
	}
	
	
}
