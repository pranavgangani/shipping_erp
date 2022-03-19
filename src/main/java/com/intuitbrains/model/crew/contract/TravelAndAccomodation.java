package com.intuitbrains.model.crew.contract;


import com.intuitbrains.common.Flag;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

//@org.springframework.data.mongodb.core.mapping.Document(collection = Collection.TRAVEL_AND_ACCOMODATION)
public abstract class TravelAndAccomodation {
    //@Transient
    //public static final String SEQUENCE_NAME = Collection.TRAVEL_AND_ACCOMODATION;

    @Id
    private long id;
    protected LocalDateTime startDateTime, endDateTime;
    protected Flag startFlag, endFlag;
    protected int statusId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public Flag getStartFlag() {
        return startFlag;
    }

    public void setStartFlag(Flag startFlag) {
        this.startFlag = startFlag;
    }

    public Flag getEndFlag() {
        return endFlag;
    }

    public void setEndFlag(Flag endFlag) {
        this.endFlag = endFlag;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public enum Status {
        GENERATED(0, "Generated"),
        CHECKED_IN(1, "Check-In"),
        CHECKED_OUT(2, "Check-Out");

        private int id;
        private String name;

        Status(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public static Status createFromId(int id) {
            for (int i = 0; i < values().length; i++) {
                if (values()[i].getId() == id) {
                    return values()[i];
                }
            }
            return null;
        }
    }
}
