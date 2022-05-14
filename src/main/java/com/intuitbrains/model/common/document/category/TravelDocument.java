package com.intuitbrains.model.common.document.category;

public abstract class TravelDocument extends CrewDocument {
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
