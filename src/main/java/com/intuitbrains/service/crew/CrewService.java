package com.intuitbrains.service.crew;

import com.intuitbrains.common.AuditTrail;
import com.intuitbrains.common.Collection;
import com.intuitbrains.dao.common.AuditTrailRepository;
import com.intuitbrains.dao.crew.CrewRepository;
import com.intuitbrains.model.common.document.Contract;
import com.intuitbrains.model.common.document.category.Document;
import com.intuitbrains.model.crew.*;
import com.intuitbrains.model.crew.contract.Travel;
import com.intuitbrains.model.crew.contract.TravelAndAccomodation;
import com.intuitbrains.service.common.SequenceGeneratorService;
import com.intuitbrains.util.StandardWebParameter;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class CrewService {
    @Autowired
    private CrewExcelService crewExcelService;
    @Autowired
    private CrewRepository crewDao;
    @Autowired
    private SequenceGeneratorService sequenceGenerator;
    @Autowired
    private AuditTrailRepository auditTrailDao;
    @Autowired
    private MongoDatabase db;

    public List<Crew> getList() {
        MongoCollection<Crew> collection = db.getCollection(Collection.CREW, Crew.class);
        Bson projection = Projections.fields(Projections.include("firstName"));
        List<Crew> crewList = new LinkedList<>();
        Bson filter = Filters.empty();
        collection.find(filter).projection(projection).into(crewList);
        return crewList;
    }

    public Crew getById(long crewId) {
        MongoCollection<Crew> collection = db.getCollection("Crew", Crew.class);
        Bson filter = Filters.eq("_id", crewId);
        return collection.find(filter).first();
    }

    public Crew addCrew(Crew crew) {
        crew.setEnteredLocalDateTime(LocalDateTime.now());
        crew.setStatusId(Crew.Status.NEW_RECRUIT.getId());
        crew.setId(sequenceGenerator.generateSequence(Crew.SEQUENCE_NAME));
        crewDao.insert(crew);

        //Audit
        AuditTrail audit = new AuditTrail();
        audit.setAction(StandardWebParameter.ADD);
        audit.setActionLocalDateTime(LocalDateTime.now());
        audit.setCollection(Collection.CREW);
        audit.setActionBy(crew.getEnteredBy());
        audit.setUniqueId(crew.getId());
        audit.setText("New Crew - <b>" + (crew.getFullName()) + "</b> recruited!");
        audit.setId(sequenceGenerator.generateSequence(AuditTrail.SEQUENCE_NAME));
        auditTrailDao.insert(audit);
        return crew;
    }

    public Crew uploadCrewData(String uploadByEmpId, FileInputStream file) throws IOException {
        Crew crew = crewExcelService.upload(file);
        crew.setEnteredBy(uploadByEmpId);
        this.addCrew(crew);
        return crew;
    }

    public Crew updateCrew(Crew crew) {
        crew.setUpdatedLocalDateTime(LocalDateTime.now());
        crewDao.save(crew);

        //Audit
        AuditTrail audit = new AuditTrail();
        audit.setAction(StandardWebParameter.ADD);
        audit.setActionBy(crew.getUpdatedBy());
        audit.setActionLocalDateTime(LocalDateTime.now());
        audit.setCollection(Collection.CREW);
        audit.setText("Updated Crew - <b>" + (crew.getFullName()) + "</b> updated!");
        audit.setId(sequenceGenerator.generateSequence(AuditTrail.SEQUENCE_NAME));
        audit.setUniqueId(crew.getId());
        auditTrailDao.insert(audit);
        return crew;
    }

    public List<Experience> getEmploymentHistory(long crewId) {
        List<Experience> list = db.getCollection(Collection.CREW, Crew.class).find(Filters.eq("_id", crewId)).projection(Projections.fields(Projections.include("employmentHistory"))).first().getEmploymentHistory();
        return list;
    }

    public List<Education> getEducationHistory(long crewId) {
        List<Education> list = db.getCollection(Collection.CREW, Crew.class).find(Filters.eq("_id", crewId)).projection(Projections.fields(Projections.include("educationtHistory"))).first().getEducationHistory();
        return list;
    }

    public List<TravelAndAccomodation> getTravelAndAccomodationHistory(long crewId) {
        List<TravelAndAccomodation> list = db.getCollection(Collection.CREW, Crew.class).find(Filters.eq("_id", crewId)).projection(Projections.fields(Projections.include("travelAndAccomodationHistory"))).first().getTravelAndAccomodationHistory();
        return list;
    }

    public List<NextOfKin> getNextOfKins(long crewId) {
        List<NextOfKin> list = db.getCollection(Collection.CREW, Crew.class).find(Filters.eq("_id", crewId)).projection(Projections.fields(Projections.include("nextOfKins"))).first().getNextOfKins();
        return list;
    }

    public List<Document> getExistingDocuments(long crewId) {
        List<Document> list = db.getCollection(Collection.CREW, Crew.class).find(Filters.eq("_id", crewId)).projection(Projections.fields(Projections.include("existingDocuments"))).first().getExistingDocuments();
        return list;
    }

    public List<Bank> getBanks(long crewId) {
        List<Bank> list = db.getCollection(Collection.CREW, Crew.class).find(Filters.eq("_id", crewId)).projection(Projections.fields(Projections.include("banks"))).first().getBanks();
        return list;
    }
    public List<Contract> getContracts(long crewId) {
        List<Contract> list = db.getCollection(Collection.CREW, Crew.class).find(Filters.eq("_id", crewId)).projection(Projections.fields(Projections.include("historicalContracts"))).first().getHistoricalContracts();
        return list;
    }
}
