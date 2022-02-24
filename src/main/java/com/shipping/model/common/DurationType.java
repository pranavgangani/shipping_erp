package com.shipping.model.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum DurationType {

	MINS(1, "Minutes"),
	HOURS(2, "Hours"),
	DAYS(3, "Days"),
	MONTHS(4, "Months"),
	YEARS(5, "Years");
	
	private int typeId;
	private String typeName;
	
	DurationType(int typeId, String typeName) {
		this.typeId = typeId;
		this.typeName = typeName;
	}
	
	public int getTypeId() {
		return typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public DurationType createFromId(int typeId) {
		List<DurationType> types = new ArrayList(Arrays.asList(values()));
		types = types.stream()
		  .filter(c -> c.getTypeId() == typeId)
		  .collect(Collectors.toList());		  
		return types.get(0);
	}
}
