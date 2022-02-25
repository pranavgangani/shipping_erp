package com.shipping.service.vessel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.shipping.dao.vessel.VesselOwnerRepository;
import com.shipping.dao.vessel.VesselRepository;
import com.shipping.model.crew.Crew;
import com.shipping.model.vessel.Vessel;
import com.shipping.model.vessel.VesselOwner;
import com.shipping.service.common.SequenceGeneratorService;

@Service("vesselService")
public class VesselService {
	@Autowired
	private VesselRepository vesselDao;
	@Autowired
	private VesselOwnerRepository vesselOwnerDao;
	@Autowired
	private SequenceGeneratorService sequenceGenerator;
	
	public void addVesselOwner(VesselOwner owner) {
		owner.setId(sequenceGenerator.generateSequence(VesselOwner.SEQUENCE_NAME));
		vesselOwnerDao.insert(owner);
	}
	
	public void addVessel(Vessel vessel) {
		vessel.setId(sequenceGenerator.generateSequence(Vessel.SEQUENCE_NAME));
		vesselDao.insert(vessel);
	}
	
	public List<Vessel> getVesselList(Vessel filterVessel) {
		return vesselDao.findAll();
	}
	
	public List<VesselOwner> getVesselOwnerList(VesselOwner filterOwner) {
		return vesselOwnerDao.findAll();
	}
}
