package com.shipping.model.crew;

import com.shipping.model.company.Employee;
import com.shipping.util.DateTime;

public class CrewRating {
	private int contractId;
	private int crewId;
	private float qualityScore, efficiencyScore, timelineScore, accuracyScore;
	private String remarks;
	
	private Employee evaluationBy;
	private DateTime evaluationDateTime;
}
