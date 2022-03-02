package com.shipping.model.crew;

import org.springframework.data.annotation.Id;
import com.shipping.common.Collection;

@org.springframework.data.mongodb.core.mapping.Document(collection = Collection.CREW_DOCUMENT_TAG)
public class DocumentTag {
	
	@Id
	private long id;
	private String name;
	
	public final static DocumentTag CERTIFICATION = new DocumentTag(1, "Training/Courses");
	public final static DocumentTag MEDICAL = new DocumentTag(2, "Medical");
	public final static DocumentTag LICENSE = new DocumentTag(3, "License");
	public final static DocumentTag PASSPORT = new DocumentTag(4, "Passport");
	public final static DocumentTag VISA = new DocumentTag(5, "VISA");
	public final static DocumentTag INSURANCE = new DocumentTag(6, "Insurance");
	public final static DocumentTag DECLRATION = new DocumentTag(7, "Declaration");
	public final static DocumentTag BRIEFING = new DocumentTag(8, "Briefing");
	public final static DocumentTag OTHER = new DocumentTag(9, "Other");

	public DocumentTag(long id, String name) {
		this.id = id;
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		DocumentTag other = (DocumentTag) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
		
	
	
	
}
