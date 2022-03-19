package com.intuitbrains.model.crew;

import com.intuitbrains.common.Flag;
import com.intuitbrains.model.common.document.category.EducationDocument;
import com.intuitbrains.util.DateTime;
import org.springframework.data.annotation.Id;

import java.util.List;

public class Education {
    @Id
    private long id;
    protected String instituteName, instituteAddress;
    private String educationName;
    private DateTime startDate, endDate;
    private List<EducationDocument> educationDocuments;
    private float percentage;
    private String grade;
    private Flag flag;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public String getEducationName() {
        return educationName;
    }

    public void setEducationName(String educationName) {
        this.educationName = educationName;
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

    public List<EducationDocument> getEducationDocuments() {
        return educationDocuments;
    }

    public void setEducationDocuments(List<EducationDocument> educationDocuments) {
        this.educationDocuments = educationDocuments;
    }

    public Flag getFlag() {
        return flag;
    }

    public void setFlag(Flag flag) {
        this.flag = flag;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
