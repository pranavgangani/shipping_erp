package com.intuitbrains.model.company.compensation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ReimbursementType {
    public static final ReimbursementType JOINING_ALLOWANCE = new ReimbursementType(1, "Joining Allowance", PaymentFrequency.BEGINNING_OF_CONTRACT);
    private int id;
    private String name;
    private PaymentFrequency paymentFrequency;

    public ReimbursementType(int id, String name, PaymentFrequency paymentFrequency) {
        this.id = id;
        this.name = name;
        this.paymentFrequency = paymentFrequency;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public PaymentFrequency getPaymentFrequency() {
        return paymentFrequency;
    }

    public static List<ReimbursementType> getList() {
        return new ArrayList<>(Arrays.asList(JOINING_ALLOWANCE));
    }

    public static ReimbursementType createFromId(int typeId) {
        return ((getList().stream().filter(o -> o.getId() == typeId).collect(Collectors.toList())).get(0));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReimbursementType that = (ReimbursementType) o;
        return id == that.id && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}