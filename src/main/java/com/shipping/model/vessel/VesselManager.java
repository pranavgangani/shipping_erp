package com.shipping.model.vessel;

import com.shipping.common.Person;

public class VesselManager extends Person {
    private boolean isOnboard;

    public boolean isOnboard() {
        return isOnboard;
    }

    public void setOnboard(boolean onboard) {
        isOnboard = onboard;
    }
}
