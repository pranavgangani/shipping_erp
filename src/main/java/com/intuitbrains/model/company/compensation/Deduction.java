package com.intuitbrains.model.company.compensation;

public class Deduction extends Compensation {
    private DeductionType type;
    private String typeLabel, paymentFrequencyLabel;

    public DeductionType getType() {
        return type;
    }

    public void setType(DeductionType type) {
        this.type = type;
    }

    public Deduction(DeductionType type, Double wages) {
        this.type = type;
        this.wages = wages;
        this.typeLabel = type.getName();
        this.paymentFrequencyLabel = type.getPaymentFrequency().getName();
    }

    public String getTypeLabel() {
        return typeLabel;
    }

    public String getPaymentFrequencyLabel() {
        return paymentFrequencyLabel;
    }
}

