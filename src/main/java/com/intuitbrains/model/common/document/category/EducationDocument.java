package com.intuitbrains.model.common.document.category;


import java.time.LocalDate;

public abstract class EducationDocument extends Document {
    protected String instituteName, instituteAddress;
    protected LocalDate startDate, endDate;
    private long certificateTypeId;

    public String getInstituteName() {
        return instituteName;
    }

    public void setInstituteName(String instituteName) {
        this.instituteName = instituteName;
    }

    public String getInstituteAddress() {
        return instituteAddress;
    }

    public void setInstituteAddress(String instituteAddress) {
        this.instituteAddress = instituteAddress;
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

    public long getCertificateTypeId() {
        return certificateTypeId;
    }

    public void setCertificateTypeId(long certificateTypeId) {
        this.certificateTypeId = certificateTypeId;
    }
}
