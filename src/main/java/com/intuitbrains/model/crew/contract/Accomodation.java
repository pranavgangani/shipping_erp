package com.intuitbrains.model.crew.contract;

import com.intuitbrains.common.Flag;

public abstract class Accomodation extends TravelAndAccomodation{
    protected int accomodationTypeId;
    protected String accomodationName;
    protected String accomodationAddress;
    protected String accomodationContact1;
    protected String accomodationContact2;
    protected Flag accomodationFlag;


    public int getAccomodationTypeId() {
        return accomodationTypeId;
    }

    public void setAccomodationTypeId(int accomodationTypeId) {
        this.accomodationTypeId = accomodationTypeId;
    }

    public String getAccomodationName() {
        return accomodationName;
    }

    public void setAccomodationName(String accomodationName) {
        this.accomodationName = accomodationName;
    }

    public String getAccomodationAddress() {
        return accomodationAddress;
    }

    public void setAccomodationAddress(String accomodationAddress) {
        this.accomodationAddress = accomodationAddress;
    }

    public String getAccomodationContact1() {
        return accomodationContact1;
    }

    public void setAccomodationContact1(String accomodationContact1) {
        this.accomodationContact1 = accomodationContact1;
    }

    public String getAccomodationContact2() {
        return accomodationContact2;
    }

    public void setAccomodationContact2(String accomodationContact2) {
        this.accomodationContact2 = accomodationContact2;
    }

    public Flag getAccomodationFlag() {
        return accomodationFlag;
    }

    public void setAccomodationFlag(Flag accomodationFlag) {
        this.accomodationFlag = accomodationFlag;
    }

    public enum AccomodationType {
        HOTEL(1, "Hotel"),
        HOME(2, "Home");

        private int id;
        private String name;

        AccomodationType(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public static AccomodationType createFromId(int typeId) {
            for (int i = 0; i < values().length; i++) {
                if (values()[i].getId() == typeId) {
                    return values()[i];
                }
            }
            return null;
        }
    }
}
