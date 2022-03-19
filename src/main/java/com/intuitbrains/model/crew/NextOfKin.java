package com.intuitbrains.model.crew;

public class NextOfKin  {
	private int nomineeId;
	private String nomineeName;
	private String relationType;
	private String gender;
	private String address;
	private String dateOfBirth;
	private float perOfAmount;

	public int getNomineeId() {
		return nomineeId;
	}

	public void setNomineeId(int nomineeId) {
		this.nomineeId = nomineeId;
	}

	public String getNomineeName() {
		return nomineeName;
	}

	public void setNomineeName(String nomineeName) {
		this.nomineeName = nomineeName;
	}

	public String getRelationType() {
		return relationType;
	}

	public void setRelationType(String relationType) {
		this.relationType = relationType;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public float getPerOfAmount() {
		return perOfAmount;
	}

	public void setPerOfAmount(float perOfAmount) {
		this.perOfAmount = perOfAmount;
	}

	public enum RelationType{
		MOTHER("Mother"),
		FATHER("Father"),
		SISTER("Sister"),
		BROTHER("Brother"),
		DAUGHTER("Daughter"),
		SON("Son"),
		WIFE("Wife"),
		HUSBAND("Husband"),
		COUSIN("Cousin"),
		GRANDMOTHER("Grandmother"),
		GRANDFATHER("Grandfather");

		private String relationTypeName;

		RelationType(String relationTypeName) {
			this.relationTypeName = relationTypeName;
		}

		public String getRelationTypeName() {
			return relationTypeName;
		}
		
	}
}
