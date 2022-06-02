package com.intuitbrains.model.crew;

import com.intuitbrains.common.Collection;
import org.springframework.data.annotation.Id;

import com.intuitbrains.model.company.Employee;
import org.springframework.data.annotation.Transient;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@org.springframework.data.mongodb.core.mapping.Document(collection = Collection.CONTRACT_RULE)
public class ContractRule {
	@Transient
	public static final String SEQUENCE_NAME = Collection.CONTRACT_RULE;

	@Id
	private long id;
	private List<String> ruleHeading;
	private List<String> ruleBody;
	private RuleType ruleType;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<String> getRuleHeading() {
		return ruleHeading;
	}

	public void setRuleHeading(List<String> ruleHeading) {
		this.ruleHeading = ruleHeading;
	}

	public List<String> getRuleBody() {
		return ruleBody;
	}

	public void setRuleBody(List<String> ruleBody) {
		this.ruleBody = ruleBody;
	}

	public RuleType getRuleType() {
		return ruleType;
	}

	public void setRuleType(RuleType ruleType) {
		this.ruleType = ruleType;
	}

	public enum RuleType{
		JOINING_DOCS("JOINING DOCUMENTS/CERTIFICATE CHECKLIST"),
		BRIEFING("SEAFARERS BRIEFING"),
		DOCS_HANDED_OVER("DOCUMENTS HANDED OVER TO SEAFARER AT THE TIME OG JOINING"),
		DRUG_ALCOHOL_DECLARATION("DECLARATION AGAINST USE OF DRUGS AND ALCOHOL"),
		OBJ_MATERIAL_DECLARATION("DECLARATION AGAINST USE OF ANY OBJECTIONABLE MATERIAL"),
		NOK_DECLARATION("NEXT OF KIN (NOK) DECLARATION"),
		SIGNON_DECLARATION("SIGN-ON DECLARATION"),
		SINGON_PERF_GOALS("SIGN-ON PERFORMANCE GOALS"),
		TRAVEL_HISTORY("DECLARATION OF TRAVEL HISTORY OF SEAFARER (past 28 days)");

		private String name;

		RuleType(String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}
	}
}
