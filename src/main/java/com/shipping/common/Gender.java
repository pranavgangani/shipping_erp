package com.shipping.common;

public enum Gender {
	FEMALE(0, "Female"), MALE(1, "Male"), TRANSGENDER(3, "Transgender");

	private int genderId;
	private String genderName;

	Gender(int genderId, String genderName) {
		this.genderId = genderId;
		this.genderName = genderName;
	}

	public int getGenderId() {
		return genderId;
	}

	public String getGenderName() {
		return genderName;
	}
	
	
}
