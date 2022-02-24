package com.shipping.common;

public enum EntityType {	
	SHIP(1,"Ship"),
	CREW(2,"Crew"),
	COMPONENT(3,"Component");
	
	private int typeId;
	private String typeName;
	
	private EntityType(int typeId, String typeName) {
		this.typeId = typeId;
		this.typeName = typeName;
	}

	public int getTypeId() {
		return typeId;
	}

	public String getTypeName() {
		return typeName;
	}
	
	
}
