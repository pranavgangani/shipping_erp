package com.intuitbrains.model.common.document.category;

import com.intuitbrains.model.crew.CrewDocument;

public abstract class TravelDocument extends CrewDocument {
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
