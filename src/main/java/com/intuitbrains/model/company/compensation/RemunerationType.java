package com.intuitbrains.model.company.compensation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RemunerationType {

    public static final RemunerationType BASIC = new RemunerationType(1, "Basic", PaymentFrequency.MONTHLY);
    public static final RemunerationType FIXED_OVETIME = new RemunerationType(2, "Fixed Overtime", PaymentFrequency.MONTHLY);
    public static final RemunerationType LW8DAYS = new RemunerationType(3, "LW @8 Days", PaymentFrequency.MONTHLY);
    public static final RemunerationType SUBS_ALLOWED = new RemunerationType(4, "Subs Allowed", PaymentFrequency.END_OF_CONTRACT);
    public static final RemunerationType PENSION_FUND = new RemunerationType(5, "Pension Fund", PaymentFrequency.MONTHLY);
    public static final RemunerationType UNIFORM_ALLOWANCE = new RemunerationType(6, "Uniform Allowance", PaymentFrequency.MONTHLY);
    public static final RemunerationType OTH_ONBOARD = new RemunerationType(7, "Other Onboard Monthly Wages", PaymentFrequency.MONTHLY);
    public static final RemunerationType OT_LOYALTY_BONUS = new RemunerationType(8, "One Time SIMS Loyalty Bonus", PaymentFrequency.SUCCESSFUL_COMPLETION);
    public static final RemunerationType PERF_BONUS = new RemunerationType(9, "Performance Bonus", PaymentFrequency.SUCCESSFUL_COMPLETION);

    private int id;
    private String name;
    private PaymentFrequency paymentFrequency;

    public RemunerationType(int id, String name, PaymentFrequency paymentFrequency) {
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
    public static List<RemunerationType> getList() {
        return new ArrayList<>(Arrays.asList(BASIC,FIXED_OVETIME,LW8DAYS,SUBS_ALLOWED,PENSION_FUND,UNIFORM_ALLOWANCE, OTH_ONBOARD, OT_LOYALTY_BONUS, PERF_BONUS));
    }

    public static RemunerationType createFromId(int typeId) {
        return ((getList().stream().filter(o -> o.getId() == typeId).collect(Collectors.toList())).get(0));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RemunerationType that = (RemunerationType) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(paymentFrequency, that.paymentFrequency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, paymentFrequency);
    }
}