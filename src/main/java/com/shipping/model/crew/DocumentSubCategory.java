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
	private String catName;
	private DateTime expiryDate;
	private boolean isValid;
}

