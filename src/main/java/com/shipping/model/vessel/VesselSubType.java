package com.shipping.model.vessel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum VesselSubType {
	BULK_CARRIER(VesselType.CARGO, 1, "Bulk Carrier"), GENERAL_CARGO(VesselType.CARGO, 2, "General Cargo"),
	CONTAINER_SHIP(VesselType.CARGO, 3, "Container Ship"), REFEER(VesselType.CARGO, 4, "Reefer"),
	RORO(VesselType.CARGO, 5, "Ro-Ro"), VEHICLE_CARRIER(VesselType.CARGO, 6, "Vehicles Carrier"),
	CEMENT_CARRIER(VesselType.CARGO, 7, "Cement Carrier"), WOODCHIPS_CARRIER(VesselType.CARGO, 8, "Wood Chips Carrier"),
	UREA_CARRIER(VesselType.CARGO, 9, "Urea Carrier"), AGGREGATE_CARRIER(VesselType.CARGO, 10, "Aggregates Carrier"),
	LIMESTONE_CARGO(VesselType.CARGO, 11, "Limestone Carrier"), LANDING_CRAFT(VesselType.CARGO, 12, "Landing Craft"),
	LIVESTOCK_CARRIER(VesselType.CARGO, 13, "Livestock Carrier"),
	HEAVY_LOAD_CARRIER(VesselType.CARGO, 14, "Heavy Load Carrier"),

	CRUDE_OIL_TANKER(VesselType.TANKER, 15, "Crude Oil Tanker"),
	OIL_PROD_TANKER(VesselType.TANKER, 16, "Oil Products Tanker"),
	CHEMICAL_TANKER(VesselType.TANKER, 17, "Chemical/Oil Tanker"), LNG_TANKER(VesselType.TANKER, 18, "LNG Tanker"),
	LPG_TANKER(VesselType.TANKER, 19, "LPG Tanker"), ASPHALT_TANKER(VesselType.TANKER, 20, "Asphalt/Bitumen"),

	BUNKER_TANKER(VesselType.TANKER, 21, "Bunkering Tanker"), FSO_TANKER(VesselType.TANKER, 22, "FSO/FPSO"),
	OTHER_TANKER(VesselType.TANKER, 23, "Other Tanker"),

	CRUISE_SHIP(VesselType.PASSENGER, 24, "Cruise Ship"), CARGO_SHIP(VesselType.PASSENGER, 25, "Passenger/Cargo Ship"),
	RORO_SHIP(VesselType.PASSENGER, 26, "Passenger/Ro-Ro Ship"),
	PASSENGER_SHIP(VesselType.PASSENGER, 27, "Passenger Ship"),

	FISHING(VesselType.OTHER, 28, "Fishing ships"), YACHT(VesselType.OTHER, 29, "Yachts/Sailing Vessels"),
	SAR(VesselType.OTHER, 30, "SAR/Military"), CRAFT(VesselType.OTHER, 31, "High speed crafts"),
	OTHER_AUX(VesselType.OTHER, 32, "Other type/ Auxiliary"), OTHER_UNKOWN(VesselType.OTHER, 33, "Unknown");

	private int typeId;
	private String desc;
	private VesselType vesselType;

	VesselSubType(VesselType vesselType, int typeId, String desc) {
		this.vesselType = vesselType;
		this.typeId = typeId;
		this.desc = desc;
	}

	public int getTypeId() {
		return typeId;
	}

	public String getDesc() {
		return desc;
	}

	public VesselType getVesselType() {
		return vesselType;
	}

	public static Map<String, List<VesselSubType>> getByGroup() {
		Map<String, List<VesselSubType>> vesselSubTypeMap = new HashMap<>();
		for (int i = 0; i < values().length; i++) {
			VesselSubType sType = values()[i];
			String key = sType.getVesselType().getDesc();
			if (!vesselSubTypeMap.containsKey(key)) {
				List<VesselSubType> list = new ArrayList<>();
				list.add(sType);
				vesselSubTypeMap.put(key, list);
			} else {
				List<VesselSubType> list = vesselSubTypeMap.get(key);
				list.add(sType);
				vesselSubTypeMap.put(key, list);
			}
		}
		return vesselSubTypeMap;
	}

}
