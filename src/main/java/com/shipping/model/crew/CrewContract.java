package com.shipping.model.crew;

import java.util.List;

import com.shipping.model.crew.Document;
import com.shipping.util.DateTime;

public class CrewContract {
	private int contractId;
	private int crewId;
	private int rankId;
	private int shipId;
	private int shipManagerId;
	
	private int contractName;
	private DateTime contractStartDate;
	private DateTime contractEndDate;
	
	private List<Document> documents; 
	
	private List<ContractRule> contractRules;
}
