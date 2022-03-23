package com.intuitbrains.model.crew;

import com.intuitbrains.model.company.Employee;

import java.time.LocalDateTime;

public class CrewRating {
	private int contractId;
	private int crewId;
	private float qualityScore, efficiencyScore, timelineScore, accuracyScore;
	private String remarks;
	
	private Employee evaluationBy;
	private LocalDateTime evaluationLocalDateTime;
}
