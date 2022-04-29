package com.intuitbrains.model.common.document.category;

public abstract class TravelDocument extends Document {
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
