package com.shipping.dao.common;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class FieldStatus {
    private String makerBy, checkerBy;
    private LocalDateTime makerDateTime, checkerDateTime;

    public FieldStatus(String makerBy, LocalDateTime makerDateTime, String checkerBy, LocalDateTime checkerDateTime) {
        this.makerBy = makerBy;
        this.checkerBy = checkerBy;
        this.makerDateTime = makerDateTime;
        this.checkerDateTime = checkerDateTime;
    }

    public String getMakerBy() {
        return makerBy;
    }

    public void setMakerBy(String makerBy) {
        this.makerBy = makerBy;
    }

    public String getCheckerBy() {
        return checkerBy;
    }

    public void setCheckerBy(String checkerBy) {
        this.checkerBy = checkerBy;
    }

    public LocalDateTime getMakerDateTime() {
        return makerDateTime;
    }

    public void setMakerDateTime(LocalDateTime makerDateTime) {
        this.makerDateTime = makerDateTime;
    }

    public LocalDateTime getCheckerDateTime() {
        return checkerDateTime;
    }

    public void setCheckerDateTime(LocalDateTime checkerDateTime) {
        this.checkerDateTime = checkerDateTime;
    }
}
