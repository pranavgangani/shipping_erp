package com.intuitbrains.service.crew;

import com.intuitbrains.common.AuditTrail;
import com.intuitbrains.common.Collection;
import com.intuitbrains.dao.common.AuditTrailRepository;
import com.intuitbrains.dao.common.FieldStatus;
import com.intuitbrains.dao.company.EmployeeRepository;
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
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Projections.elemMatch;
import static com.mongodb.client.model.Projections.fields;

@Service
public class CrewService {
    @Autowired
    private CrewExcelService crewExcelService;
    @Autowired
    private CrewRepository crewDao;
    @Autowired
    private EmployeeRepository employeeDao;
    @Autowired
    private SequenceGeneratorService sequenceGenerator;
    @Autowired
    private AuditTrailRepository auditTrailDao;
    @Autowired
    private MongoDatabase db;
    private static Bson projections = Projections.include("firstName", "middleName", "lastName", "rankId", "dob", "gender", "statusId", "passportNumber", "indosNumber",
            "Distinguishing Mark", "photoId", "nationalityFlagId", "nationality", "permAddress", "presentAddress", "fieldStatus");

    public List<Crew> getList() {
        MongoCollection<Crew> collection = db.getCollection(Collection.CREW, Crew.class);
        Bson projection = fields(projections);
        List<Crew> crewList = new LinkedList<>();
        Bson filter = Filters.empty();
        collection.find(filter).projection(projection).into(crewList);
        return crewList;
    }

    public Crew getById(long crewId) {
        MongoCollection<Crew> collection = db.getCollection("Crew", Crew.class);
        Bson filter = eq("_id", crewId);
        return collection.find(filter).projection(projections).first();
    }

    public Crew addCrew(Crew crew) {
        crew.setEnteredLocalDateTime(LocalDateTime.now());
        crew.setStatusId(Crew.Status.NEW_RECRUIT.getId());

        addToAudit(crew);

        crew.setId(sequenceGenerator.generateSequence(Crew.SEQUENCE_NAME));

        crewDao.insert(crew);

        //Audit
        AuditTrail audit = new AuditTrail();
        audit.setAction(StandardWebParameter.ADD);
        audit.setActionLocalDateTime(LocalDateTime.now());
        audit.setCollection(Collection.CREW);
        audit.setActionBy(crew.getEnteredBy());
        audit.setUniqueId(crew.getId());
        audit.setText("New Crew - <b>" + (crew.getFullName()) + "</b> added by "+employeeDao.findByEmpId(crew.getEnteredBy()).getFullName());
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
        List<Experience> list = db.getCollection(Collection.CREW, Crew.class).find(eq("_id", crewId)).projection(fields(Projections.include("employmentHistory"))).first().getEmploymentHistory();
        return list;
    }

    public List<Education> getEducationHistory(long crewId) {
        List<Education> list = db.getCollection(Collection.CREW, Crew.class).find(eq("_id", crewId)).projection(fields(Projections.include("educationHistory"))).first().getEducationHistory();
        return list;
    }

    public List<Document> getPassportVisa(long crewId) {
        Bson filters = and(eq("_id", crewId));
        Bson projections = fields(elemMatch("existingDocuments", or(eq("docTypeId", 1), eq("docTypeId", 13), eq("docTypeId", 14), eq("docTypeId", 15))));
        List<Document> documents = db.getCollection(Collection.CREW, Crew.class).find(filters).projection(projections).first().getExistingDocuments();
        return documents;
    }

    public List<TravelAndAccomodation> getTravelAndAccomodationHistory(long crewId) {
        List<TravelAndAccomodation> list = db.getCollection(Collection.CREW, Crew.class).find(eq("_id", crewId)).projection(fields(Projections.include("travelAndAccomodationHistory"))).first().getTravelAndAccomodationHistory();
        return list;
    }

    public List<NextOfKin> getNextOfKins(long crewId) {
        List<NextOfKin> list = db.getCollection(Collection.CREW, Crew.class).find(eq("_id", crewId)).projection(fields(Projections.include("nextOfKins"))).first().getNextOfKins();
        return list;
    }

    public List<Document> getExistingDocuments(long crewId) {
        List<Document> list = db.getCollection(Collection.CREW, Crew.class).find(eq("_id", crewId)).projection(fields(Projections.include("existingDocuments"))).first().getExistingDocuments();
        return list;
    }

    public List<Bank> getBanks(long crewId) {
        List<Bank> list = db.getCollection(Collection.CREW, Crew.class).find(eq("_id", crewId)).projection(fields(Projections.include("banks"))).first().getBanks();
        return list;
    }

    public List<Contract> getContracts(long crewId) {
        List<Contract> list = db.getCollection(Collection.CREW, Crew.class).find(eq("_id", crewId)).projection(fields(Projections.include("historicalContracts"))).first().getHistoricalContracts();
        return list;
    }

    public void addToAudit(Crew modifiedCrew) {
        List<CrewFieldAudit> audits = new LinkedList<>();
        String maker = modifiedCrew.getEnteredBy();
        CrewFieldStatus fs = modifiedCrew.getFieldStatus();
        String enteredBy = modifiedCrew.getEnteredBy();
        long crewId = modifiedCrew.getId();
        Class clazz = modifiedCrew.getClass();
        Class fsClazz = fs.getClass();
        LocalDateTime now = LocalDateTime.now();

        for (final Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(ACrew.class)) {
                try {
                    String setterMethodName = method.getName();
                    String getterMethodName = setterMethodName.replace("set", "get");
                    Method getterMethod = clazz.getMethod(getterMethodName);
                    Object val = getterMethod.invoke(modifiedCrew);
                    ACrew aCrew = method.getAnnotation(ACrew.class);
                    CrewField field = aCrew.name();
                    if (val != null) {
                        Method setterMethod = fsClazz.getDeclaredMethod(setterMethodName, FieldStatus.class);
                        CrewFieldAudit crewFieldAudit = new CrewFieldAudit();
                        if (val.getClass().equals(String.class)) {
                            String txt = (String) val;
                            crewFieldAudit.setFieldValue(txt);
                        }
                        else if (val.getClass().equals(Boolean.class)) {
                            Boolean value = (Boolean) val;
                            crewFieldAudit.setFieldValue((value ? "YES" : "NO"));
                        }
                        else if (val.getClass().equals(Integer.class)) {
                            Integer value = (Integer) val;
                            crewFieldAudit.setFieldValue(String.valueOf(value));
                        }
                        else if (val.getClass().equals(Double.class)) {
                            Double value = (Double) val;
                            crewFieldAudit.setFieldValue(String.valueOf(value));
                        }
                        else if (val.getClass().equals(LocalDate.class)) {
                            LocalDate value = (LocalDate) val;
                            crewFieldAudit.setFieldValue(value.toString());
                        }

                        crewFieldAudit.setCrewId(crewId);
                        crewFieldAudit.setFieldName(field.getFieldName());
                        crewFieldAudit.setEnteredBy(enteredBy);
                        crewFieldAudit.setEnteredDateTime(LocalDateTime.now());
                        audits.add(crewFieldAudit);

                        setterMethod.invoke(fs, new FieldStatus(maker, now, null, null));

                    }

                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
        }
        modifiedCrew.setFieldStatus(fs);
    }

}
