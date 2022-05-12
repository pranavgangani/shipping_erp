package com.intuitbrains.service.crew;

import com.intuitbrains.common.AuditTrail;
import com.intuitbrains.common.Collection;
import com.intuitbrains.dao.common.AuditTrailRepository;
import com.intuitbrains.dao.crew.CrewRepository;
import com.intuitbrains.model.crew.Crew;
import com.intuitbrains.model.crew.Experience;
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

    public Crew uploadCrewData(String uploadByEmpId, FileInputStream file) throws IOException {
        Crew crew = crewExcelService.upload(file);
        crew.setEnteredBy(uploadByEmpId);
        this.addCrew(crew);
        return crew;
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

    public List<Experience> getEmploymentHistory(long crewId) {
        MongoCollection<Crew> collection = db.getCollection(Collection.CREW, Crew.class);
        Bson projection = Projections.fields(Projections.include("employmentHistory"));
        List<Experience> experienceList = new LinkedList<>();
        Bson filter = Filters.eq("_id", crewId);
        return collection.find(filter).projection(projection).first().getEmploymentHistory();
    }
}
