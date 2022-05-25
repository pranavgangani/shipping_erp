package com.intuitbrains.model.vessel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.data.annotation.Id;

public class VesselSubType {
	public static final VesselSubType ALL = new VesselSubType(VesselType.ALL, 0, "All");
	public static final VesselSubType BULK_CARRIER = new VesselSubType(VesselType.CARGO, 1, "Bulk Carrier");
	public static final VesselSubType GENERAL_CARGO = new VesselSubType(VesselType.CARGO, 2, "General Cargo");
	public static final VesselSubType CONTAINER_SHIP = new VesselSubType(VesselType.CARGO, 3, "Container Ship");
	public static final VesselSubType REEFER = new VesselSubType(VesselType.CARGO, 4, "Reefer");
	public static final VesselSubType RORO = new VesselSubType(VesselType.CARGO, 5, "Ro-Ro");
	public static final VesselSubType VEHICLE_CARRIER = new VesselSubType(VesselType.CARGO, 6, "Vehicles Carrier");
	public static final VesselSubType CEMENT_CARRIER = new VesselSubType(VesselType.CARGO, 7, "Cement Carrier");
	public static final VesselSubType WOODCHIPS_CARRIER = new VesselSubType(VesselType.CARGO, 8, "Wood Chips Carrier");
	public static final VesselSubType UREA_CARRIER = new VesselSubType(VesselType.CARGO, 9, "Urea Carrier");
	public static final VesselSubType AGGREGATE_CARRIER = new VesselSubType(VesselType.CARGO, 10, "Aggregates Carrier");
	public static final VesselSubType LIMESTONE_CARGO = new VesselSubType(VesselType.CARGO, 11, "Limestone Carrier");
	public static final VesselSubType LANDING_CRAFT = new VesselSubType(VesselType.CARGO, 12, "Landing Craft");
	public static final VesselSubType LIVESTOCK_CARRIER = new VesselSubType(VesselType.CARGO, 13, "Livestock Carrier");
	public static final VesselSubType HEAVY_LOAD_CARRIER = new VesselSubType(VesselType.CARGO, 14, "Heavy Load Carrier");

	public static final VesselSubType CRUDE_OIL_TANKER = new VesselSubType(VesselType.TANKER, 15, "Crude Oil Tanker");
	public static final VesselSubType OIL_PROD_TANKER = new VesselSubType(VesselType.TANKER, 16, "Oil Products Tanker");
	public static final VesselSubType CHEMICAL_TANKER = new VesselSubType(VesselType.TANKER, 17, "Chemical/Oil Tanker");
	public static final VesselSubType LNG_TANKER = new VesselSubType(VesselType.TANKER, 18, "LNG Tanker");
	public static final VesselSubType LPG_TANKER = new VesselSubType(VesselType.TANKER, 19, "LPG Tanker");
	public static final VesselSubType ASPHALT_TANKER = new VesselSubType(VesselType.TANKER, 20, "Asphalt/Bitumen");
	public static final VesselSubType BUNKER_TANKER = new VesselSubType(VesselType.TANKER, 21, "Bunkering Tanker");
	public static final VesselSubType FSO_TANKER = new VesselSubType(VesselType.TANKER, 22, "FSO/FPSO");
	public static final VesselSubType OTHER_TANKER = new VesselSubType(VesselType.TANKER, 23, "Other Tanker");
	
	public static final VesselSubType CRUISE_SHIP = new VesselSubType(VesselType.PASSENGER, 24, "Cruise Ship");
	public static final VesselSubType CARGO_SHIP = new VesselSubType(VesselType.PASSENGER, 25, "Passenger/Cargo Ship");
	public static final VesselSubType RORO_SHIP = new VesselSubType(VesselType.PASSENGER, 26, "Passenger/Ro-Ro Ship");
	public static final VesselSubType PASSENGER_SHIP = new VesselSubType(VesselType.PASSENGER, 27, "Passenger Ship");
	
	public static final VesselSubType FISHING = new VesselSubType(VesselType.OTHER, 28, "Fishing ships");
	public static final VesselSubType YACHT = new VesselSubType(VesselType.OTHER, 29, "Yachts/Sailing Vessels");
	public static final VesselSubType SAR = new VesselSubType(VesselType.OTHER, 30, "SAR/Military");
	public static final VesselSubType CRAFT = new VesselSubType(VesselType.OTHER, 31, "High speed crafts");
	public static final VesselSubType OTHER_AUX = new VesselSubType(VesselType.OTHER, 32, "Other type/ Auxiliary");
	public static final VesselSubType OTHER_UNKOWN = new VesselSubType(VesselType.OTHER, 33, "Unknown");

	@Id
	private int id;
	private String desc;
	private VesselType vesselType;

	public VesselSubType() {
	}

	VesselSubType(VesselType vesselType, int id, String desc) {
		this.vesselType = vesselType;
		this.id = id;
		this.desc = desc;
	}

	public int getId() {
		return id;
	}

	public String getDesc() {
		return desc;
	}

	public VesselType getVesselType() {
		return vesselType;
	}
	
	public static VesselSubType createFromId(int typeId) {
		return ((getList().stream().filter(o->o.getId() == typeId).collect(Collectors.toList())).get(0));
	}

	public static VesselSubType createFromDesc(String desc) {
		return ((getList().stream().filter(o->o.getDesc().equalsIgnoreCase(desc)).collect(Collectors.toList())).get(0));
	}


	public static List<VesselSubType> getList(){
		return new ArrayList<>(Arrays.asList(ALL, BULK_CARRIER, GENERAL_CARGO, CONTAINER_SHIP, REEFER, RORO, VEHICLE_CARRIER, CEMENT_CARRIER, WOODCHIPS_CARRIER,
				UREA_CARRIER, AGGREGATE_CARRIER, LIMESTONE_CARGO, LANDING_CRAFT, LIVESTOCK_CARRIER, HEAVY_LOAD_CARRIER,
				CRUDE_OIL_TANKER,OIL_PROD_TANKER,CHEMICAL_TANKER,LNG_TANKER,LPG_TANKER, ASPHALT_TANKER,BUNKER_TANKER, FSO_TANKER, OTHER_TANKER, 
				CRUISE_SHIP, CARGO_SHIP, RORO_SHIP, PASSENGER_SHIP, FISHING, YACHT, SAR, CRAFT, OTHER_AUX, OTHER_UNKOWN));
	}

	public static Map<String, List<VesselSubType>> getByGroup() {
		Map<String, List<VesselSubType>> vesselSubTypeMap = new HashMap<>();
		for (VesselSubType sType : getList()) {
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

	public static void main(String[] args) {
		VesselSubType.getList().forEach(v->System.out.println(v.getDesc()));
	}

}
