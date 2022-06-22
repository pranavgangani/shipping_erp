package com.intuitbrains.model.common.document;

import com.intuitbrains.model.common.Duration;
import com.intuitbrains.model.crew.Rank;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class OfferLetter extends Letter {
    private String vesselName;
    private double agreedWages;
    private Rank agreedRank;

    private Duration contractPeriod;
    private LocalDateTime acceptedDateTime, rejectedDateTime;

    public String getVesselName() {
        return vesselName;
    }

    public void setVesselName(String vesselName) {
        this.vesselName = vesselName;
    }

    public double getAgreedWages() {
        return agreedWages;
    }

    public void setAgreedWages(double agreedWages) {
        this.agreedWages = agreedWages;
    }

    public Duration getContractPeriod() {
        return contractPeriod;
    }

    public void setContractPeriod(Duration contractPeriod) {
        this.contractPeriod = contractPeriod;
    }

    public LocalDateTime getAcceptedDateTime() {
        return acceptedDateTime;
    }

    public void setAcceptedDateTime(LocalDateTime acceptedDateTime) {
        this.acceptedDateTime = acceptedDateTime;
    }

    public LocalDateTime getRejectedDateTime() {
        return rejectedDateTime;
    }

    public void setRejectedDateTime(LocalDateTime rejectedDateTime) {
        this.rejectedDateTime = rejectedDateTime;
    }

    public Rank getAgreedRank() {
        return agreedRank;
    }

    public void setAgreedRank(Rank agreedRank) {
        this.agreedRank = agreedRank;
    }
}
