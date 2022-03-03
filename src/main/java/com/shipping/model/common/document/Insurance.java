package com.shipping.model.common.document;

import com.shipping.model.common.document.category.FinancialDocument;

public class Insurance extends FinancialDocument {
    protected double insuredSum;
    protected String insuranceCompanyName;
    protected String insuranceCompanyAddress;

    public double getInsuredSum() {
        return insuredSum;
    }

    public void setInsuredSum(double insuredSum) {
        this.insuredSum = insuredSum;
    }

    public String getInsuranceCompanyName() {
        return insuranceCompanyName;
    }

    public void setInsuranceCompanyName(String insuranceCompanyName) {
        this.insuranceCompanyName = insuranceCompanyName;
    }

    public String getInsuranceCompanyAddress() {
        return insuranceCompanyAddress;
    }

    public void setInsuranceCompanyAddress(String insuranceCompanyAddress) {
        this.insuranceCompanyAddress = insuranceCompanyAddress;
    }
}
