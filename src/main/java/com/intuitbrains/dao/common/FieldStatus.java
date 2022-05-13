package com.intuitbrains.dao.common;

import java.time.LocalDateTime;

public class FieldStatus {
    private String makerBy, checkerBy;
    private LocalDateTime makerLocalDateTime, checkerLocalDateTime;

    public FieldStatus() {
    }

    public FieldStatus(String makerBy, LocalDateTime makerLocalDateTime, String checkerBy, LocalDateTime checkerLocalDateTime) {
        this.makerBy = makerBy;
        this.checkerBy = checkerBy;
        this.makerLocalDateTime = makerLocalDateTime;
        this.checkerLocalDateTime = checkerLocalDateTime;
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

    public LocalDateTime getMakerLocalDateTime() {
        return makerLocalDateTime;
    }

    public void setMakerLocalDateTime(LocalDateTime makerLocalDateTime) {
        this.makerLocalDateTime = makerLocalDateTime;
    }

    public LocalDateTime getCheckerLocalDateTime() {
        return checkerLocalDateTime;
    }

    public void setCheckerLocalDateTime(LocalDateTime checkerLocalDateTime) {
        this.checkerLocalDateTime = checkerLocalDateTime;
    }
}
