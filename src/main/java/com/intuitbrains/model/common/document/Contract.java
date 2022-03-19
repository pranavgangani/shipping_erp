package com.intuitbrains.model.common.document;

import com.intuitbrains.model.common.document.category.EmploymentDocument;
import com.intuitbrains.model.crew.ContractRule;

import java.time.LocalDate;
import java.util.List;

public class Contract extends EmploymentDocument {
    private List<ContractRule> contractRules;
    private LocalDate startDate, endDate;
	public List<ContractRule> getContractRules() {
		return contractRules;
	}
	public void setContractRules(List<ContractRule> contractRules) {
		this.contractRules = contractRules;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
    
    
}
