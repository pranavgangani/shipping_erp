package com.shipping.model.vessel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.annotation.Id;

public class VesselType {
	public final static VesselType ALL = new VesselType(0, "All");
	public final static VesselType CARGO = new VesselType(1, "Cargo");
	public final static VesselType TANKER = new VesselType(2, "Tanker");
	public final static VesselType PASSENGER = new VesselType(3, "Passenger/Cruise");
	public final static VesselType OTHER = new VesselType(4, "Other");
	
	@Id
	private int id;
	private String desc;

	VesselType(int id, String desc) {
		this.id = id;
		this.desc = desc;
	}

	public int getId() {
		return id;
	}

	public String getDesc() {
		return desc;
	}
	
	public static List<VesselType> getList(){
		return new ArrayList<>(Arrays.asList(CARGO, TANKER, PASSENGER, OTHER));
	}
	
	public static VesselType createFromId(int typeId) {
		return ((VesselType)(getList().stream().filter(o->o.getId() == typeId).collect(Collectors.toList())).get(0));
	}
	
}
