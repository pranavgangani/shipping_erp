package com.intuitbrains.model.company.compensation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class DeductionType {
    public static final DeductionType NIL = new DeductionType(0, "NIL", PaymentFrequency.NA);
    private int id;
    private String name;
    private PaymentFrequency paymentFrequency;

    public DeductionType(int id, String name, PaymentFrequency paymentFrequency) {
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

    public static List<DeductionType> getList() {
        return new ArrayList<>(Arrays.asList(NIL));
    }

    public static DeductionType createFromId(int typeId) {
        return ((getList().stream().filter(o -> o.getId() == typeId).collect(Collectors.toList())).get(0));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeductionType that = (DeductionType) o;
        return id == that.id && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}