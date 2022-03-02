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
	private String docType;
	private DocumentCategory docCategory;	
	private DocumentSubCategory docSubCategory;
	private String givenName;

	//Other datapoints
	private int validity;
	private DurationType durationType;	
	private DateTime issueDate, expiryDate;
	private String docRemarks;

	//Passport specific	
	private String nationality, countryCode;
	
	//Visa specific
	private String entries, issuingPostName, annotation, controlNumber;
	
	//Training course specific
	private String regulation, sectionTable, chapter;
	private int pap;//Professional Attitude Points
	private boolean isPhysical, isRecertRequired, isPaid;

	//Contract
	private List<ContractRule> contractRules;

	private boolean isMandatory;

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

	public DocumentMatrix getDocumentMatrix() {
		return documentMatrix;
	}

	public void setDocumentMatrix(DocumentMatrix documentMatrix) {
		this.documentMatrix = documentMatrix;
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

	public String getDocType() {
		return docType;
	}

	public void setDocType(String docType) {
		this.docType = docType;
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

	public String getIssuingPostName() {
		return issuingPostName;
	}

	public void setIssuingPostName(String issuingPostName) {
		this.issuingPostName = issuingPostName;
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

	public String getChapter() {
		return chapter;
	}

	public void setChapter(String chapter) {
		this.chapter = chapter;
	}

	public boolean isMandatory() {
		return isMandatory;
	}

	public void setMandatory(boolean mandatory) {
		isMandatory = mandatory;
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

	public int getPap() {
		return pap;
	}

	public void setPap(int pap) {
		this.pap = pap;
	}

	public boolean isPhysical() {
		return isPhysical;
	}

	public void setPhysical(boolean physical) {
		isPhysical = physical;
	}

	public boolean isRecertRequired() {
		return isRecertRequired;
	}

	public void setRecertRequired(boolean recertRequired) {
		isRecertRequired = recertRequired;
	}

	public boolean isPaid() {
		return isPaid;
	}

	public void setPaid(boolean paid) {
		isPaid = paid;
	}
}
