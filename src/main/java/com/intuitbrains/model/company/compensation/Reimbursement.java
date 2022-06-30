package com.intuitbrains.model.company.compensation;

public class Reimbursement extends Compensation{
    private ReimbursementType type;

    public ReimbursementType getType() {
        return type;
    }

    public void setType(ReimbursementType type) {
        this.type = type;
    }
}
