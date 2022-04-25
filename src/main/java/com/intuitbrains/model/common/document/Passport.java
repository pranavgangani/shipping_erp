package com.intuitbrains.model.common.document;

import com.intuitbrains.model.common.document.category.TravelDocument;

public class Passport extends TravelDocument {
    private int blankPages;
    private Boolean isECNRRequired;

    public int getBlankPages() {
        return blankPages;
    }

    public void setBlankPages(int blankPages) {
        this.blankPages = blankPages;
    }

    public Boolean isECNRRequired() {
        return isECNRRequired;
    }

    public void setECNRRequired(Boolean ECNRRequired) {
        isECNRRequired = ECNRRequired;
    }
}
