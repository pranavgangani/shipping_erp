package com.shipping.common;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import com.shipping.model.crew.RankCertification;
import com.shipping.model.vessel.VesselCertification;

@org.springframework.data.mongodb.core.mapping.Document(collection = Collection.FLAG)
public class Flag {
	@Transient
	public static final String SEQUENCE_NAME = Collection.FLAG;
	
	@Id
	private long id;
	private String name;
	
	private List<RankCertification> rankCertifications;
	private List<VesselCertification> shipCertifications;
}
