package com.intuitbrains.model.crew;

import com.intuitbrains.common.Flag;
import com.intuitbrains.model.common.document.category.EmploymentDocument;
import com.intuitbrains.model.vessel.Vessel;
import com.intuitbrains.model.vessel.VesselSubType;
import com.intuitbrains.util.DateTime;
import org.springframework.data.annotation.Id;

import java.util.List;

public class Employment {
    @Id
    private long id;
    private String employerName, employerAddress;
    private String jobDescription;
    private Rank lastRank;
    private Vessel vessel;
    private VesselSubType vesselSubType;
    private DateTime startDate, endDate;
    private List<EmploymentDocument> employmentDocuments;
    private Flag flag;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmployerName() {
        return employerName;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    public String getEmployerAddress() {
        return employerAddress;
    }

    public void setEmployerAddress(String employerAddress) {
        this.employerAddress = employerAddress;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public Rank getLastRank() {
        return lastRank;
    }

    public void setLastRank(Rank lastRank) {
        this.lastRank = lastRank;
    }

    public Vessel getVessel() {
        return vessel;
    }

    public void setVessel(Vessel vessel) {
        this.vessel = vessel;
    }

    public DateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(DateTime startDate) {
        this.startDate = startDate;
    }

    public DateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(DateTime endDate) {
        this.endDate = endDate;
    }

    public List<EmploymentDocument> getEmploymentDocuments() {
        return employmentDocuments;
    }

    public void setEmploymentDocuments(List<EmploymentDocument> employmentDocuments) {
        this.employmentDocuments = employmentDocuments;
    }

    public VesselSubType getVesselSubType() {
        return vesselSubType;
    }

    public void setVesselSubType(VesselSubType vesselSubType) {
        this.vesselSubType = vesselSubType;
    }

    public Flag getFlag() {
        return flag;
    }

    public void setFlag(Flag flag) {
        this.flag = flag;
    }
}
