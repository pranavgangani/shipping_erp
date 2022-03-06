package com.shipping.model.crew.contract;

public class Cab extends Travel {
    protected String cabNumber;

    public String getCabNumber() {
        return cabNumber;
    }

    public void setCabNumber(String cabNumber) {
        this.cabNumber = cabNumber;
    }
}
