package com.intuitbrains.model.common.document;

import com.intuitbrains.model.crew.CrewDocument;

public class License extends CrewDocument {
    private String grade;

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
