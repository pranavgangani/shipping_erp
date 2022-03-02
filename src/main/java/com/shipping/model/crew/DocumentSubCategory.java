package com.shipping.model.crew;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import com.shipping.common.Collection;
import com.shipping.util.DateTime;
@org.springframework.data.mongodb.core.mapping.Document(collection = Collection.DOC_SUB_CAT)
public class DocumentSubCategory {
	@Transient
	public static final String SEQUENCE_NAME = Collection.DOC_SUB_CAT;
	
	@Id
	private long id;
	private String name;
	private boolean isValid;
	private DocumentCategory documentCategory;
	
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
	public boolean isValid() {
		return isValid;
	}
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	public DocumentCategory getDocumentCategory() {
		return documentCategory;
	}

	public void setDocumentCategory(DocumentCategory documentCategory) {
		this.documentCategory = documentCategory;
	}
}

