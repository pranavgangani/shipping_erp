package com.shipping.common;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import com.shipping.model.crew.RankCertification;
import com.shipping.model.ship.ShipCertification;

@org.springframework.data.mongodb.core.mapping.Document(collection = "Flag")
public class Flag {
	@Transient
	public static final String SEQUENCE_NAME = "Flag";
	
	@Id
	private long id;
	private String name;
	
	private List<RankCertification> rankCertifications;
	private List<ShipCertification> shipCertifications;
}
