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

	private int validity;
	private DurationType durationType;	
	private DateTime expiryDate;

	private DocumentCategory docCategory;	
	private DocumentSubCategory docSubCategory;

	private int rankSubCategoryId;
	private int rankCategoryId;
	private int rankId;
	
	private String docTitle;
	
	private List<Comment> comments;
}
