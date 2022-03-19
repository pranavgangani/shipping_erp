package com.intuitbrains.model.vessel;

import com.intuitbrains.dao.common.FieldStatus;

public class VesselFieldStatus {
    private FieldStatus name, registeredFlag, emailId, contact1, contact2;

    public VesselFieldStatus() {
        name = new FieldStatus(null,null,null,null);
        registeredFlag = new FieldStatus(null,null,null,null);
        emailId = new FieldStatus(null,null,null,null);
        contact1 = new FieldStatus(null,null,null,null);
        contact2 = new FieldStatus(null,null,null,null);
    }

    public FieldStatus getName() {
        return name;
    }

    public void setName(FieldStatus name) {
        this.name = name;
    }

    public FieldStatus getRegisteredFlag() {
        return registeredFlag;
    }

    public void setRegisteredFlag(FieldStatus registeredFlag) {
        this.registeredFlag = registeredFlag;
    }

    public FieldStatus getEmailId() {
        return emailId;
    }

    public void setEmailId(FieldStatus emailId) {
        this.emailId = emailId;
    }

    public FieldStatus getContact1() {
        return contact1;
    }

    public void setContact1(FieldStatus contact1) {
        this.contact1 = contact1;
    }

    public FieldStatus getContact2() {
        return contact2;
    }

    public void setContact2(FieldStatus contact2) {
        this.contact2 = contact2;
    }
}
