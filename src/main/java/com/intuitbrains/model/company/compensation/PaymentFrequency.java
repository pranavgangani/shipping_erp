package com.intuitbrains.model.company.compensation;

import java.util.Objects;

public class PaymentFrequency {

    public static final PaymentFrequency END_OF_CONTRACT = new PaymentFrequency(0, "End of Contract");
    public static final PaymentFrequency BEGINNING_OF_CONTRACT = new PaymentFrequency(1, "Beginning of Contract");
    public static final PaymentFrequency MONTHLY = new PaymentFrequency(2, "Monthly");
    public static final PaymentFrequency SUCCESSFUL_COMPLETION = new PaymentFrequency(3, "Successful Completion of Contract");
    public static final PaymentFrequency NA = new PaymentFrequency(4, "NA");

    private int id;
    private String name;

    public PaymentFrequency(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentFrequency that = (PaymentFrequency) o;
        return id == that.id && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}