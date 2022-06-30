package com.intuitbrains.model.company.compensation;

public class Remuneration extends Compensation {
    private RemunerationType type;
    private String typeLabel, paymentFrequencyLabel;

    public RemunerationType getType() {
        return type;
    }

    public void setType(RemunerationType type) {
        this.type = type;
    }

    public Remuneration(RemunerationType type, Double wages) {
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
