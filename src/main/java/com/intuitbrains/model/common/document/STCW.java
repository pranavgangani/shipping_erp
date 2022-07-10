package com.intuitbrains.model.common.document;

public class STCW extends MerchantNavyCertificate {
    protected String chapter;
    protected String regulation;
    protected String sectionTable;

    public String getChapter() {
        return chapter;
    }

    public void setChapter(String chapter) {
        this.chapter = chapter;
    }

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
}
