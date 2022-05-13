package com.intuitbrains.model.crew;

import com.intuitbrains.common.Flag;
import com.intuitbrains.model.common.document.category.EmploymentDocument;
import com.intuitbrains.model.vessel.VesselSubType;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Experience {
    @Id
    private long id;
    private String employerName, employerAddress;
    private String jobDescription;
    private int lastRankId;
    private Rank lastRank;
    private String vesselName;
    private VesselSubType vesselSubType;
    private LocalDate startDate, endDate;
    private List<EmploymentDocument> employmentDocuments;
    private Flag flag;
    private ReasonForSingOff reasonForSingOff;

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

    public int getLastRankId() {
        return lastRankId;
    }

    public void setLastRankId(int lastRankId) {
        this.lastRankId = lastRankId;
    }

    public Rank getLastRank() {
        return lastRank;
    }

    public void setLastRank(Rank lastRank) {
        this.lastRank = lastRank;
    }

    public String getVesselName() {
        return vesselName;
    }

    public void setVesselName(String vesselName) {
        this.vesselName = vesselName;
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

    public ReasonForSingOff getReasonForSingOff() {
        return reasonForSingOff;
    }

    public void setReasonForSingOff(ReasonForSingOff reasonForSingOff) {
        this.reasonForSingOff = reasonForSingOff;
    }

    public enum ReasonForSingOff {
        PROMOTED(1,"Promoted"),
        RESIGNED(2,"Resigned"),
        SHORE_JOB(3,"Shore Job"),
        SHORT_CONTRACT(4,"Short Contract"),
        TRANSFER(5,"Transfer"),
        VESSEL_NAME_CHANGE(6,"Vessel Name Change"),
        VESSEL_SOLD(7,"Vessel Sold"),
        VESSEL_SCRAPED(8,"Vessel Scraped");

        private int typeId;
        private String typeName;

        ReasonForSingOff(int typeId, String typeName) {
            this.typeId = typeId;
            this.typeName = typeName;
        }

        public int getTypeId() {
            return typeId;
        }

        public String getTypeName() {
            return typeName;
        }

        public static ReasonForSingOff createFromId(int typeId) {
            return ((Arrays.stream(values()).filter(o->o.getTypeId() == typeId).collect(Collectors.toList())).get(0));
        }

        public static ReasonForSingOff createFromDesc(String desc) {
            return ((Arrays.stream(values()).filter(o->o.getTypeName().equalsIgnoreCase(desc)).collect(Collectors.toList())).get(0));
        }
    }
}
