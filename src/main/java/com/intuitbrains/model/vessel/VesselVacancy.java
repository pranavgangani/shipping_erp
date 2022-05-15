package com.intuitbrains.model.vessel;

import com.intuitbrains.common.Collection;
import com.intuitbrains.model.company.Employee;
import com.intuitbrains.model.crew.Crew;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import java.time.LocalDateTime;

@org.springframework.data.mongodb.core.mapping.Document(collection = Collection.VESSEL_VACANCY)
public class VesselVacancy {
    @Transient
    public static final String SEQUENCE_NAME = Collection.VESSEL_VACANCY;

    @Id
    private long id;
    private long vesselId;
    private String remarks;
    private int statusId;
    private int openPositions;
    private Status status;
    private LocalDateTime vacancyStartDate;
    private LocalDateTime vacancyEndDate;
    private Employee enteredBy;
    private LocalDateTime enteredLocalDateTime;


    private Vessel vessel;
    private Crew filledByCrew;

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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public int getOpenPositions() {
        return openPositions;
    }

    public void setOpenPositions(int openPositions) {
        this.openPositions = openPositions;
    }

    public LocalDateTime getVacancyStartDate() {
        return vacancyStartDate;
    }

    public void setVacancyStartDate(LocalDateTime vacancyStartDate) {
        this.vacancyStartDate = vacancyStartDate;
    }

    public LocalDateTime getVacancyEndDate() {
        return vacancyEndDate;
    }

    public void setVacancyEndDate(LocalDateTime vacancyEndDate) {
        this.vacancyEndDate = vacancyEndDate;
    }

    public Employee getEnteredBy() {
        return enteredBy;
    }

    public void setEnteredBy(Employee enteredBy) {
        this.enteredBy = enteredBy;
    }

    public LocalDateTime getEnteredLocalDateTime() {
        return enteredLocalDateTime;
    }

    public void setEnteredLocalDateTime(LocalDateTime enteredLocalDateTime) {
        this.enteredLocalDateTime = enteredLocalDateTime;
    }

    public VesselVacancyAttributes getVacancyAttributes() {
        return vacancyAttributes;
    }

    public void setVacancyAttributes(VesselVacancyAttributes vacancyAttributes) {
        this.vacancyAttributes = vacancyAttributes;
    }

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

    public Vessel getVessel() {
        return vessel;
    }

    public void setVessel(Vessel vessel) {
        this.vessel = vessel;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Crew getFilledByCrew() {
        return filledByCrew;
    }

    public void setFilledByCrew(Crew filledByCrew) {
        this.filledByCrew = filledByCrew;
    }

    @Override
    public String toString() {
        return "VesselVacancy{" +
                "vesselId=" + vesselId +
                ", remarks='" + remarks + '\'' +
                ", vacancyAttributes=" + vacancyAttributes +
                '}';
    }

    public enum Status {
		OPEN(1, "Open"),
		PENDING_DOCS(2, "Pending Docs"),
		CLOSED(3, "Closed");

		private int id;
		private String desc;

		Status(int id, String desc) {
			this.id = id;
			this.desc = desc;
		}

		public int getId() {
			return id;
		}

		public String getDesc() {
			return desc;
		}

        public static VesselVacancy.Status createFromId(int typeId) {
            for (int i = 0; i < values().length; i++) {
                if (values()[i].getId() == typeId) {
                    return values()[i];
                }
            }
            return null;
        }
	}
}
