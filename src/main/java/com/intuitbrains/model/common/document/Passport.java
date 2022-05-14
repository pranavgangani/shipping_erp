package com.intuitbrains.model.common.document;

import com.intuitbrains.model.common.document.category.TravelDocument;

public class Passport extends TravelDocument {
    private int blankPages;
    private boolean isRequiredECNR;

    public int getBlankPages() {
        return blankPages;
    }

    public void setBlankPages(int blankPages) {
        this.blankPages = blankPages;
    }

    public boolean isRequiredECNR() {
        return isRequiredECNR;
    }

    public void setRequiredECNR(boolean requiredECNR) {
        isRequiredECNR = requiredECNR;
    }
}
