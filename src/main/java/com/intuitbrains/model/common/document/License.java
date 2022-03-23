package com.intuitbrains.model.common.document;

import com.intuitbrains.model.common.document.category.Document;

public class License extends Document {
    private String grade;

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}
