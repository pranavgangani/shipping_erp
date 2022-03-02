package com.shipping.model.crew;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.annotation.Id;

public class DocumentCategory {
	public final static DocumentCategory ON_BOARDING = new DocumentCategory(1, "On-Boarding Documents");
	public final static DocumentCategory KYC = new DocumentCategory(2, "KYC");
	/*public final static DocumentCategory ADDRESS_AND_CONTACT = new DocumentCategory(1, "Address and Contact");
	public final static DocumentCategory APPROVALS = new DocumentCategory(2, "Approval, Contracts and Agreements");
	public final static DocumentCategory AUDITS = new DocumentCategory(3, "Audits");
	public final static DocumentCategory BANK_DOCS = new DocumentCategory(4, "Bank Documents");
	public final static DocumentCategory DUE_DILIGENCE = new DocumentCategory(5, "On-Boarding Documents");
	public final static DocumentCategory GOVERNING_DOCS = new DocumentCategory(6, "Governing Documents");
	public final static DocumentCategory TAX_DOCS = new DocumentCategory(7, "Tax Documents");
	public final static DocumentCategory FINANCIALS = new DocumentCategory(8, "Financials");
	public final static DocumentCategory KYC = new DocumentCategory(9, "KYC");
	public final static DocumentCategory MISC = new DocumentCategory(10, "Miscallaneous");*/

	@Id
	private int id;	
	private String name;
	
	public DocumentCategory(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
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
		DocumentCategory other = (DocumentCategory) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "RankCategory [id=" + id + ", name=" + name + "]";
	}
	
	public static List<DocumentCategory> getList(){
		return new ArrayList<>(Arrays.asList(ON_BOARDING, KYC));
	}
	
	public static DocumentCategory createFromId(int typeId) {
		return ((DocumentCategory)(getList().stream().filter(o->o.getId() == typeId).collect(Collectors.toList())).get(0));
	}	
}
