package com.intuitbrains.model.common.document;

import com.intuitbrains.model.common.document.category.TravelDocument;

public class Passport extends TravelDocument {
    private int blankPages;
    private boolean isECNRRequired;

    public int getBlankPages() {
        return blankPages;
    }

    public void setBlankPages(int blankPages) {
        this.blankPages = blankPages;
    }

    public boolean isECNRRequired() {
        return isECNRRequired;
    }

    public void setECNRRequired(boolean ECNRRequired) {
        isECNRRequired = ECNRRequired;
    }
}
