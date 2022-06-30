package com.intuitbrains.model.common.document;

import com.intuitbrains.model.common.document.category.EmploymentDocument;
import com.intuitbrains.model.company.compensation.Deduction;
import com.intuitbrains.model.company.compensation.Reimbursement;
import com.intuitbrains.model.company.compensation.Remuneration;

import java.util.List;

public class EmploymentLetter extends EmploymentDocument {
    private List<Remuneration> remunerations;
    private List<Reimbursement> reimbursements;
    private List<Deduction> deductions;

    public List<Remuneration> getRemunerations() {
        return remunerations;
    }

    public void setRemunerations(List<Remuneration> remunerations) {
        this.remunerations = remunerations;
    }

    public List<Reimbursement> getReimbursements() {
        return reimbursements;
    }

    public void setReimbursements(List<Reimbursement> reimbursements) {
        this.reimbursements = reimbursements;
    }

    public List<Deduction> getDeductions() {
        return deductions;
    }

    public void setDeductions(List<Deduction> deductions) {
        this.deductions = deductions;
    }
}
