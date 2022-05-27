package com.intuitbrains.model.crew;

import com.intuitbrains.model.common.document.Passport;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.stream.Collectors;

public class NextOfKin  {
	private int nomineeId;
	private String nomineeName;
	private String relationType;
	private String address;
	private LocalDate dateOfBirth;
	private Passport passport;
	private Boolean hasUSVisa;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public float getPerOfAmount() {
		return perOfAmount;
	}

	public void setPerOfAmount(float perOfAmount) {
		this.perOfAmount = perOfAmount;
	}

	public Passport getPassport() {
		return passport;
	}

	public void setPassport(Passport passport) {
		this.passport = passport;
	}

	public Boolean getHasUSVisa() {
		return hasUSVisa;
	}

	public void setHasUSVisa(Boolean hasUSVisa) {
		this.hasUSVisa = hasUSVisa;
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

		public static void main(String[] args) {
			Arrays.stream(RelationType.values()).forEach(v->System.out.println(v.getRelationTypeName()));
		}
		public static RelationType createFromDesc(String name) {
			return ((Arrays.stream(values()).filter(o->o.getRelationTypeName().equalsIgnoreCase(name)).collect(Collectors.toList())).get(0));
		}
	}
}
