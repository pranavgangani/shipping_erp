package com.shipping.model.crew;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.annotation.Id;

import com.shipping.model.crew.Document;
import com.shipping.util.DateTime;

public class Contract {
	@Id
	private int id;
	
	private String contractName;
	private DateTime startDate;
	private DateTime endDate;
	private String placeOfContract;
	
	private List<Document> documents; 	
	private List<ContractRule> otherContractRules;
	private BigDecimal monthlyWage;
	private String wageCurrency;
	
	//Audit
	private DateTime generatedDateTime;
}
