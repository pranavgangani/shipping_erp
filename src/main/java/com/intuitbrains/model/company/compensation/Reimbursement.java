package com.intuitbrains.model.company.compensation;

public class Reimbursement extends Compensation{
    private ReimbursementType type;
    private String typeLabel, paymentFrequencyLabel;

    public ReimbursementType getType() {
        return type;
    }

    public Reimbursement(ReimbursementType type, Double wages) {
        this.type = type;
        this.wages = wages;
        this.typeLabel= type.getName();
        this.paymentFrequencyLabel = type.getPaymentFrequency().getName();
    }

    public String getTypeLabel() {
        return typeLabel;
    }

    public String getPaymentFrequencyLabel() {
        return paymentFrequencyLabel;
    }
}
