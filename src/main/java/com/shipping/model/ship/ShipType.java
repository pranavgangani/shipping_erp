package com.shipping.model.ship;

public enum ShipType {
	CARGO(1, "Cargo"), CONTAINER(2, "Container"), OIL(3, "Oil"), GAS(4, "Gas");

	private int typeId;
	private String desc;

	ShipType(int typeId, String desc) {
		this.typeId = typeId;
		this.desc = desc;
	}

	public int getTypeId() {
		return typeId;
	}

	public String getDesc() {
		return desc;
	}
	
}
