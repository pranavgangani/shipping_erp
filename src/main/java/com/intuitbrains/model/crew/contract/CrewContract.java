package com.intuitbrains.model.crew.contract;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import com.intuitbrains.common.Collection;
import com.intuitbrains.common.Flag;
import com.intuitbrains.model.crew.Crew;
import com.intuitbrains.model.crew.CrewDocument;
import com.intuitbrains.model.crew.ContractRule;
import com.intuitbrains.model.crew.Rank;
import com.intuitbrains.model.vessel.Vessel;
import org.springframework.data.annotation.Id;

import org.springframework.data.annotation.Transient;

@org.springframework.data.mongodb.core.mapping.Document(collection = Collection.CREW_CONTRACT)
public class CrewContract {
    @Transient
    public static final String SEQUENCE_NAME = Collection.CREW_CONTRACT;

	@Id
	private long id;
    private Crew crew;
    private Rank rank;
    private Vessel vessel;
	private String contractName;
	private LocalDate startDate, endDate;
	private String embarkPort, placeOfContract;
    private Flag placeOfContractFlag;
	
	private List<CrewDocument> documents;
	private List<ContractRule> otherContractRules;
	private BigDecimal monthlyWage;
	private String wageCurrency;
    private int statusId;

    private List<TravelAndAccomodation> travelAndAccomodations;

	//Audit
    private String enteredBy;
    private LocalDateTime enteredDateTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Crew getCrew() {
        return crew;
    }

    public void setCrew(Crew crew) {
        this.crew = crew;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public void setVessel(Vessel vessel) {
        this.vessel = vessel;
    }

    public Vessel getVessel() {
        return vessel;
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getPlaceOfContract() {
        return placeOfContract;
    }

    public void setPlaceOfContract(String placeOfContract) {
        this.placeOfContract = placeOfContract;
    }

    public String getEmbarkPort() {
        return embarkPort;
    }

    public void setEmbarkPort(String embarkPort) {
        this.embarkPort = embarkPort;
    }

    public List<CrewDocument> getDocuments() {
        return documents;
    }

    public void setDocuments(List<CrewDocument> documents) {
        this.documents = documents;
    }

    public List<ContractRule> getOtherContractRules() {
        return otherContractRules;
    }

    public void setOtherContractRules(List<ContractRule> otherContractRules) {
        this.otherContractRules = otherContractRules;
    }

    public BigDecimal getMonthlyWage() {
        return monthlyWage;
    }

    public void setMonthlyWage(BigDecimal monthlyWage) {
        this.monthlyWage = monthlyWage;
    }

    public String getWageCurrency() {
        return wageCurrency;
    }

    public void setWageCurrency(String wageCurrency) {
        this.wageCurrency = wageCurrency;
    }

    public String getEnteredBy() {
        return enteredBy;
    }

    public void setEnteredBy(String enteredBy) {
        this.enteredBy = enteredBy;
    }

    public LocalDateTime getEnteredDateTime() {
        return enteredDateTime;
    }

    public void setEnteredDateTime(LocalDateTime enteredDateTime) {
        this.enteredDateTime = enteredDateTime;
    }

    public Flag getPlaceOfContractFlag() {
        return placeOfContractFlag;
    }

    public void setPlaceOfContractFlag(Flag placeOfContractFlag) {
        this.placeOfContractFlag = placeOfContractFlag;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }
    public List<TravelAndAccomodation> getTravelAndAccomodations() {
        return travelAndAccomodations;
    }

    public void setTravelAndAccomodations(List<TravelAndAccomodation> travelAndAccomodations) {
        this.travelAndAccomodations = travelAndAccomodations;
    }

    public enum Status {
        GENERATED(1, "Generated"),
        STARTED(2, "Started"),
        ENDED(3, "Ended"),
        CANCELLED(4, "Generated");

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
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CrewContract that = (CrewContract) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "CrewContract{" +
                "id=" + id +
                ", crewId=" + crew +
                ", rankId=" + rank.getName() +
                ", vesselId=" + vessel.getVesselName() +
                ", placeOfContract='" + placeOfContract + '\'' +
                ", wageCurrency=" + wageCurrency +
                ", statusId=" + statusId +
                '}';
    }
}
