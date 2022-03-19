package com.intuitbrains.model.common.document.category;

import com.intuitbrains.util.DateTime;

public abstract class EducationDocument extends Document {
    protected String instituteName, instituteAddress;
    protected DateTime startDate, endDate;
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

    public long getCertificateTypeId() {
        return certificateTypeId;
    }

    public void setCertificateTypeId(long certificateTypeId) {
        this.certificateTypeId = certificateTypeId;
    }
}
