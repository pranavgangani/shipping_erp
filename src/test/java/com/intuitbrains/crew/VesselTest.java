package com.intuitbrains.crew;

import com.intuitbrains.common.Flag;
import com.intuitbrains.dao.common.CrewDocumentRepository;
import com.intuitbrains.dao.common.FlagRepository;
import com.intuitbrains.dao.vessel.VesselOwnerRepository;
import com.intuitbrains.dao.vessel.VesselRepository;
import com.intuitbrains.dao.vessel.VesselVacancyRepository;
import com.intuitbrains.main.CrewManagementApplication;
import com.intuitbrains.model.vessel.*;
import com.intuitbrains.service.common.SequenceGeneratorService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = CrewManagementApplication.class)
@AutoConfigureMockMvc
class VesselTest {
    @Autowired
    private VesselRepository vesselDao;
    @Autowired
    private VesselVacancyRepository vesselVacancyDao;
    @Autowired
    private VesselOwnerRepository vesselOwnerDao;
    @Autowired
    private CrewDocumentRepository documentDao;
    @Autowired
    private SequenceGeneratorService sequenceGenerator;
    @Autowired
    private FlagRepository flagDao;
    @Autowired
    private MongoTemplate mongoTemplate;


    @Test
    void addVessel() {
        VesselOwner vesselOwner = vesselOwnerDao.findById(2l).get();
        Flag flag = flagDao.getByCode("IN");
        Vessel vessel = new Vessel();
        vessel.setVesselOwner(vesselOwner);
        vessel.setId(sequenceGenerator.generateSequence(Vessel.SEQUENCE_NAME));
        vessel.setVesselName("Some Indian Vessel");
        vessel.setBeam(100);
        vessel.setLength(101);
        vessel.setDraught(103);
        vessel.setYearOfBuilt(2001);
        vessel.setFlag(flag);
        vessel.setCapacity(10);
        vessel.setCallSign("AHS12A");
        vessel.setGrossTonnage(5100);
        vessel.setActive(true);
        vessel.setMmsi("JA8081MA");
        vessel.setVesselSubType(VesselSubType.BULK_CARRIER);
        vesselDao.insert(vessel);
    }

   /* @Test
    void addVesselJourney() {
        Vessel vesselOwner = vesselDao.findById(2l).get();
        Flag flag = flagDao.getByCode("IN");
        Vessel vessel = new Vessel();
        vessel.setVesselOwner(vesselOwner);
        vessel.setId(sequenceGenerator.generateSequence(Vessel.SEQUENCE_NAME));
        vessel.setVesselName("Some Indian Vessel");
        vessel.setBeam(100);
        vessel.setLength(101);
        vessel.setDraught(103);
        vessel.setYearOfBuilt(2001);
        vessel.setFlag(flag);
        vessel.setCapacity(10);
        vessel.setCallSign("AHS12A");
        vessel.setGrossTonnage(5100);
        vessel.setActive(true);
        vessel.setMmsi("JA8081MA");
        vessel.setVesselSubType(VesselSubType.BULK_CARRIER);
        vesselDao.insert(vessel);
    }*/

}
