package com.intuitbrains.model.crew.contract;

public abstract class Travel extends TravelAndAccomodation {
    protected int travelModeId;
    protected String travelCompanyName;
    protected String travelCompanyAddress;
    protected String travelCompanyContact1;
    protected String travelCompanyContact2;

    public int getTravelModeId() {
        return travelModeId;
    }

    public void setTravelModeId(int travelModeId) {
        this.travelModeId = travelModeId;
    }

    public String getTravelCompanyName() {
        return travelCompanyName;
    }

    public void setTravelCompanyName(String travelCompanyName) {
        this.travelCompanyName = travelCompanyName;
    }

    public String getTravelCompanyAddress() {
        return travelCompanyAddress;
    }

    public void setTravelCompanyAddress(String travelCompanyAddress) {
        this.travelCompanyAddress = travelCompanyAddress;
    }

    public String getTravelCompanyContact1() {
        return travelCompanyContact1;
    }

    public void setTravelCompanyContact1(String travelCompanyContact1) {
        this.travelCompanyContact1 = travelCompanyContact1;
    }

    public String getTravelCompanyContact2() {
        return travelCompanyContact2;
    }

    public void setTravelCompanyContact2(String travelCompanyContact2) {
        this.travelCompanyContact2 = travelCompanyContact2;
    }

    public enum TravelMode {
        FLIGHT(1, "Flight"),
        TRAIN(2, "Train"),
        CAB(3, "Cab");

        private int id;
        private String name;

        TravelMode(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public static TravelMode createFromId(int typeId) {
            for (int i = 0; i < values().length; i++) {
                if (values()[i].getId() == typeId) {
                    return values()[i];
                }
            }
            return null;
        }
    }
}
