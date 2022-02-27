package com.shipping.model.crew;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.annotation.Id;

public class DocumentSubCategory {
	public final static DocumentSubCategory ADDRESS_AND_CONTACT = new DocumentSubCategory(1, "Address and Contact");
	public final static DocumentSubCategory APPROVALS = new DocumentSubCategory(2, "Approval, Contracts and Agreements");
	public final static DocumentSubCategory AUDITS = new DocumentSubCategory(3, "Audits");
	public final static DocumentSubCategory BANK_DOCS = new DocumentSubCategory(4, "Bank Documents");
	public final static DocumentSubCategory DUE_DILIGENCE = new DocumentSubCategory(5, "Due Diligence and RFI");
	public final static DocumentSubCategory GOVERNING_DOCS = new DocumentSubCategory(6, "Governing Documents");
	public final static DocumentSubCategory TAX_DOCS = new DocumentSubCategory(7, "Tax Documents");
	public final static DocumentSubCategory FINANCIALS = new DocumentSubCategory(8, "Financials");
	public final static DocumentSubCategory KYC = new DocumentSubCategory(9, "KYC");
	public final static DocumentSubCategory MISC = new DocumentSubCategory(10, "Miscallaneous");

	@Id
	private int id;	
	private String name;
	private DocumentCategory docCategory;
	
	public DocumentSubCategory(DocumentCategory docCategory, int id, String name) {
		this.id = id;
		this.name = name;
		this.docCategory = docCategory;
	}
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	
	public DocumentCategory getDocCategory() {
		return docCategory;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((docCategory == null) ? 0 : docCategory.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DocumentSubCategory other = (DocumentSubCategory) obj;
		if (docCategory == null) {
			if (other.docCategory != null)
				return false;
		} else if (!docCategory.equals(other.docCategory))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	public static List<DocumentSubCategory> getList(){
		return new ArrayList<>(Arrays.asList(ADDRESS_AND_CONTACT, APPROVALS, AUDITS, BANK_DOCS, DUE_DILIGENCE, GOVERNING_DOCS, TAX_DOCS, FINANCIALS, KYC, MISC));
	}
	
	public static DocumentSubCategory createFromId(int typeId) {
		return ((DocumentSubCategory)(getList().stream().filter(o->o.getId() == typeId).collect(Collectors.toList())).get(0));
	}	
}
