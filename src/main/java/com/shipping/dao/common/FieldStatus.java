package com.shipping.dao.common;

import java.time.LocalDate;

public class FieldStatus {
    private String makerBy, checkerBy;
    private LocalDate makerDateTime, checkerDateTime;

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

    public LocalDate getMakerDateTime() {
        return makerDateTime;
    }

    public void setMakerDateTime(LocalDate makerDateTime) {
        this.makerDateTime = makerDateTime;
    }

    public LocalDate getCheckerDateTime() {
        return checkerDateTime;
    }

    public void setCheckerDateTime(LocalDate checkerDateTime) {
        this.checkerDateTime = checkerDateTime;
    }
}
