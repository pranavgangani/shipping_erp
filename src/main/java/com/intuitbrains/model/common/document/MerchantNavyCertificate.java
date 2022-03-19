package com.intuitbrains.model.common.document;

public class MerchantNavyCertificate extends Certificate{
    protected String regulation;
    protected String sectionTable;
    protected int trainingHours;
    protected String chapter;

    public String getRegulation() {
        return regulation;
    }

    public void setRegulation(String regulation) {
        this.regulation = regulation;
    }

    public String getSectionTable() {
        return sectionTable;
    }

    public void setSectionTable(String sectionTable) {
        this.sectionTable = sectionTable;
    }

    public int getTrainingHours() {
        return trainingHours;
    }

    public void setTrainingHours(int trainingHours) {
        this.trainingHours = trainingHours;
    }

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }


}
