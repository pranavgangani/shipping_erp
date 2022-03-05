package com.shipping.model.vessel;

import com.shipping.common.Collection;
import com.shipping.model.company.Employee;
import com.shipping.util.DateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

@org.springframework.data.mongodb.core.mapping.Document(collection = Collection.VESSEL_VACANCY)
public class VesselVacancy {
	@Transient
	public static final String SEQUENCE_NAME = Collection.VESSEL_VACANCY;

	@Id
	private long id;
	private long vesselId;
	private long filledByCrewId;
	private String remarks;
	private DateTime crewEmbarkDate;
	private DateTime vacancyStartDate;
	private DateTime vacancyEndDate;
	private Employee enteredBy;
	private DateTime enteredDateTime;

	//Other Vacancy Conditions/Attributes
	private VesselVacancyAttributes vacancyAttributes;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getVesselId() {
		return vesselId;
	}

	public void setVesselId(long vesselId) {
		this.vesselId = vesselId;
	}

	public long getFilledByCrewId() {
		return filledByCrewId;
	}

	public void setFilledByCrewId(long filledByCrewId) {
		this.filledByCrewId = filledByCrewId;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}



	public DateTime getCrewEmbarkDate() {
		return crewEmbarkDate;
	}

	public void setCrewEmbarkDate(DateTime crewEmbarkDate) {
		this.crewEmbarkDate = crewEmbarkDate;
	}

	public DateTime getVacancyStartDate() {
		return vacancyStartDate;
	}

	public void setVacancyStartDate(DateTime vacancyStartDate) {
		this.vacancyStartDate = vacancyStartDate;
	}

	public DateTime getVacancyEndDate() {
		return vacancyEndDate;
	}

	public void setVacancyEndDate(DateTime vacancyEndDate) {
		this.vacancyEndDate = vacancyEndDate;
	}

	public Employee getEnteredBy() {
		return enteredBy;
	}

	public void setEnteredBy(Employee enteredBy) {
		this.enteredBy = enteredBy;
	}

	public DateTime getEnteredDateTime() {
		return enteredDateTime;
	}

	public void setEnteredDateTime(DateTime enteredDateTime) {
		this.enteredDateTime = enteredDateTime;
	}

	public VesselVacancyAttributes getVacancyAttributes() {
		return vacancyAttributes;
	}

	public void setVacancyAttributes(VesselVacancyAttributes vacancyAttributes) {
		this.vacancyAttributes = vacancyAttributes;
	}

	@Override
	public String toString() {
		return "VesselVacancy{" +
				"vesselId=" + vesselId +
				", filledByCrewId=" + filledByCrewId +
				", remarks='" + remarks + '\'' +
				", vacancyAttributes=" + vacancyAttributes +
				'}';
	}
}
