package com.shipping.model.common.document;

import com.shipping.model.common.document.category.EmploymentDocument;
import com.shipping.model.crew.ContractRule;

import java.util.List;

public class Contract extends EmploymentDocument {
    private List<ContractRule> contractRules;
}
