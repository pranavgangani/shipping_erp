package com.intuitbrains.common;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@org.springframework.data.mongodb.core.mapping.Document(collection = Collection.FS_AUDIT_TRAIL)
public class FieldStatusAuditTrail {
    @Transient
    public static final String SEQUENCE_NAME = Collection.FS_AUDIT_TRAIL;

    @Id
    private long id;
    private String collection;
    private String propertyName;
    private long uniqueId;
    private String action;
    private String actionBy;
    private LocalDateTime actionDateTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCollection() {
        return collection;
    }

    public void setCollection(String collection) {
        this.collection = collection;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getActionBy() {
        return actionBy;
    }

    public void setActionBy(String actionBy) {
        this.actionBy = actionBy;
    }

    public LocalDateTime getActionDateTime() {
        return actionDateTime;
    }

    public void setActionDateTime(LocalDateTime actionDateTime) {
        this.actionDateTime = actionDateTime;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public long getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(long uniqueId) {
        this.uniqueId = uniqueId;
    }

    public String getColour() {
        if (action.equalsIgnoreCase("add")) {
            return "green";
        } else if (action.equalsIgnoreCase("modify")) {
            return "purple";
        } else if (action.equalsIgnoreCase("delete")) {
            return "yellow";
        } else {
            return "blue";
        }
    }

    public String getAgo() {
        String ago;
        if (ChronoUnit.MINUTES.between(getActionDateTime(), LocalDateTime.now()) < 60) {
            ago = ChronoUnit.MINUTES.between(getActionDateTime(), LocalDateTime.now()) + " min ago";
        } else if (ChronoUnit.HOURS.between(getActionDateTime(), LocalDateTime.now()) < 24) {
            ago = ChronoUnit.HOURS.between(getActionDateTime(), LocalDateTime.now()) + " hr ago";
        } else if (ChronoUnit.DAYS.between(getActionDateTime(), LocalDateTime.now()) <= 31) {
            ago = ChronoUnit.DAYS.between(getActionDateTime(), LocalDateTime.now()) + " days ago";
        } else if (ChronoUnit.MONTHS.between(getActionDateTime(), LocalDateTime.now()) <= 3) {
            ago = ChronoUnit.MONTHS.between(getActionDateTime(), LocalDateTime.now()) + " months ago";
        } else {
            ago = ChronoUnit.YEARS.between(getActionDateTime(), LocalDateTime.now()) + " years ago";
        }
        return ago;
    }
}
