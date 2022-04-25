package com.intuitbrains.common;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@org.springframework.data.mongodb.core.mapping.Document(collection = Collection.AUDIT_TRAIL)
public class AuditTrail {
    @Transient
    public static final String SEQUENCE_NAME = Collection.AUDIT_TRAIL;

    @Id
    private long id;
    private String collection;
    private String action;
    private String actionBy;
    private LocalDateTime actionLocalDateTime;
    private String text;
    private long uniqueId;
    private String ago;
    private String colour;

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

    public LocalDateTime getActionLocalDateTime() {
        return actionLocalDateTime;
    }

    public void setActionLocalDateTime(LocalDateTime actionLocalDateTime) {
        this.actionLocalDateTime = actionLocalDateTime;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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
        String ago = null;
        if(getActionLocalDateTime()!=null) {
            if (ChronoUnit.MINUTES.between(getActionLocalDateTime(), LocalDateTime.now()) < 60) {
                ago = ChronoUnit.MINUTES.between(getActionLocalDateTime(), LocalDateTime.now()) + " min ago";
            } else if (ChronoUnit.HOURS.between(getActionLocalDateTime(), LocalDateTime.now()) < 24) {
                ago = ChronoUnit.HOURS.between(getActionLocalDateTime(), LocalDateTime.now()) + " hr ago";
            } else if (ChronoUnit.DAYS.between(getActionLocalDateTime(), LocalDateTime.now()) <= 31) {
                ago = ChronoUnit.DAYS.between(getActionLocalDateTime(), LocalDateTime.now()) + " days ago";
            } else if (ChronoUnit.MONTHS.between(getActionLocalDateTime(), LocalDateTime.now()) <= 3) {
                ago = ChronoUnit.MONTHS.between(getActionLocalDateTime(), LocalDateTime.now()) + " months ago";
            } else {
                ago = ChronoUnit.YEARS.between(getActionLocalDateTime(), LocalDateTime.now()) + " years ago";
            }
        }
        return ago;
    }
}
