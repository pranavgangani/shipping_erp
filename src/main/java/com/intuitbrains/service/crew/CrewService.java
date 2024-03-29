package com.intuitbrains.service.crew;

import com.intuitbrains.common.AuditTrail;
import com.intuitbrains.common.Collection;
import com.intuitbrains.dao.common.AuditTrailRepository;
import com.intuitbrains.dao.common.CrewDocumentRepository;
import com.intuitbrains.dao.common.DocumentTypeRepository;
import com.intuitbrains.dao.common.FieldStatus;
import com.intuitbrains.dao.company.EmployeeRepository;
import com.intuitbrains.dao.crew.CrewRepository;
import com.intuitbrains.model.common.document.Contract;
import com.intuitbrains.model.company.Employee;
import com.intuitbrains.model.crew.CrewDocument;
import com.intuitbrains.model.crew.*;
import com.intuitbrains.model.crew.contract.TravelAndAccomodation;
import com.intuitbrains.service.common.SequenceGeneratorService;
import com.intuitbrains.util.DateTimeUtil;
import com.intuitbrains.util.ListUtil;
import com.intuitbrains.util.StandardWebParameter;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

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
    private CrewDocumentRepository documentDao;
    @Autowired
    private DocumentTypeRepository docTypeDao;
    @Autowired
    private EmployeeRepository employeeDao;
    @Autowired
    private SequenceGeneratorService sequenceGenerator;
    @Autowired
    private AuditTrailRepository auditTrailDao;
    @Autowired
    private MongoDatabase db;
    private static Bson projections = Projections.include("firstName", "middleName", "lastName", "rank", "height", "weight", "manningOffice", "dob", "gender", "statusId", "passportNumber", "indosNumber",
            "distinguishMark", "photoId", "nationalityFlagId", "nationality", "nearestAirport", "maritalStatus", "fileNum", "permAddress", "contact1", "contact2", "presentAddress", "fieldStatus");

    public List<Crew> getList() {
        /*MongoCollection<Crew> collection = db.getCollection(Collection.CREW, Crew.class);
        Bson projection = fields(projections);
        List<Crew> crewList = new LinkedList<>();
        Bson filter = Filters.empty();
        collection.find(filter).projection(projection).into(crewList);
        return crewList;*/
        return crewDao.findAll().stream()
                .sorted(Comparator.comparing(Crew::getEnteredDateTime).reversed())
                .collect(Collectors.toList());
    }

    public List<Crew> getFilteredList(Crew filterCrew) {
        MongoCollection<Crew> collection = db.getCollection(Collection.CREW, Crew.class);
        Bson projection = fields(projections);
        List<Crew> crewList = new LinkedList<>();
        Bson filter = eq("statusId", filterCrew.getStatusId());
        collection.find(filter).projection(projection).into(crewList);
        return crewList;
    }

    public Crew getById(long crewId) {
        MongoCollection<Crew> collection = db.getCollection(Collection.CREW, Crew.class);
        Bson filter = eq("_id", crewId);
        return collection.find(filter).first();
    }

    public Crew getObjectById(long crewId) {
        return crewDao.findById(crewId).get();
    }

    public Crew addCrew(Crew crew) {
        crew.setEnteredDateTime(LocalDateTime.now());
        crew.setStatusId(Crew.Status.NEW_RECRUIT.getId());

        //addToAudit(crew);

        crew.setId(sequenceGenerator.generateSequence(Crew.SEQUENCE_NAME));
        String id = String.valueOf(crew.getId());
        String zeros = "000";
        zeros.substring((zeros.length() - (zeros.length() - id.length())), zeros.length() - 1);
        crew.setFileNum("SAAR-PD/" + zeros + id);
        crewDao.insert(crew);

        //Audit
        AuditTrail audit = new AuditTrail();
        audit.setAction(StandardWebParameter.ADD);
        audit.setActionLocalDateTime(LocalDateTime.now());
        audit.setCollection(Collection.CREW);
        audit.setActionBy(crew.getEnteredBy());
        audit.setUniqueId(crew.getId());
        audit.setText("New Crew - <b>" + (crew.getFullName()) + "</b> added by " + employeeDao.findByEmpId(crew.getEnteredBy().getFullName()));
        audit.setId(sequenceGenerator.generateSequence(AuditTrail.SEQUENCE_NAME));
        auditTrailDao.insert(audit);
        return crew;
    }

    public void addBank(long crewId, Bank bank) {
        List<Bank> banks = this.getBanks(crewId);
        if (ListUtil.isEmpty(banks)) {
            banks = new ArrayList<>();
            banks.add(bank);
        } else {
            banks.forEach(b -> b.setPrimary(false));
            banks.add(bank);
        }
        Bson filter = Filters.all("_id", crewId);
        db.getCollection(Collection.CREW, Crew.class).updateMany(filter, Updates.set("banks", banks));

    }

    public Crew uploadCrewData(Employee uploadByEmp, FileInputStream file) throws IOException {
        Crew crew = crewExcelService.readFromExcel(file);
        crew.setEnteredBy(uploadByEmp);
        List<CrewDocument> docsToUpload = crew.getExistingDocuments();
        crew.setExistingDocuments(null);//Don't store in Crew object
        this.addCrew(crew);

        for (CrewDocument doc : docsToUpload) {
            doc.setCrewId(crew.getId());
            doc.setGivenName(crew.getDefaultGivenName());
            doc.setId(sequenceGenerator.generateSequence(CrewDocument.SEQUENCE_NAME));
        }
        documentDao.insert(docsToUpload);

        return crew;
    }

    public Crew updateCrew(Crew crew) {
        addToAudit(crew);

        crew.setUpdatedDateTime(LocalDateTime.now());
        crew.setUpdatedBy(crew.getEnteredBy());
        crewDao.save(crew);

        //Audit
        AuditTrail audit = new AuditTrail();
        audit.setAction(StandardWebParameter.MODIFY);
        audit.setActionBy(crew.getUpdatedBy());
        audit.setActionLocalDateTime(LocalDateTime.now());
        audit.setCollection(Collection.CREW);
        audit.setText("Updated Crew - <b>" + (crew.getFullName()) + "</b> by " + employeeDao.findByEmpId(crew.getEnteredBy().getFullName()));
        audit.setId(sequenceGenerator.generateSequence(AuditTrail.SEQUENCE_NAME));
        audit.setUniqueId(crew.getId());
        auditTrailDao.insert(audit);
        return crew;
    }

    public void updateVacancy(long vacancyId, List<Long> crewIds, String assignedBy) {
        Bson updates = Updates.combine(
                Updates.set("statusId", Crew.Status.ASSIGNED.getId()),
                Updates.set("assignedVacancyId", vacancyId),
                Updates.set("assignedVacancyDateTime", LocalDateTime.now()),
                Updates.set("assignedVacancyBy", assignedBy)
        );
        Bson filter = Filters.all("_id", crewIds);
        db.getCollection(Collection.CREW, Crew.class).updateMany(filter, updates);
    }

    public List<Experience> getEmploymentHistory(long crewId) {
        List<Experience> list = db.getCollection(Collection.CREW, Crew.class).find(eq("_id", crewId)).projection(fields(Projections.include("employmentHistory"))).first().getEmploymentHistory();
        return list;
    }

    public List<Education> getEducationHistory(long crewId) {
        List<Education> list = db.getCollection(Collection.CREW, Crew.class).find(eq("_id", crewId)).projection(fields(Projections.include("educationHistory"))).first().getEducationHistory();
        return list;
    }

    public List<CrewDocument> getPassportVisa(long crewId) {
        Bson filters = and(eq("crewId", crewId),
                (or(eq("docType.documentPool", "VISA"),
                        eq("docType.documentPool", "PASSPORT"))));
        //Bson projections = (or(eq("docTypeId", 1), eq("docTypeId", 13), eq("docTypeId", 14), eq("docTypeId", 15)));
        //Bson projections = Projections.include("existingDocuments");
        List<CrewDocument> documents = new ArrayList<>();
/*        db.getCollection(Collection.CREW_DOCUMENT).find(filters).into(documents);
        for(Document doc : documents) {
            CrewDocument cDoc = (CrewDocument)doc.;
        }*/
        //filters.toString();
        documents = documentDao.getPassportAndVisa(crewId);
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

    public List<? extends CrewDocument> getExistingDocuments(long crewId) {
        List<? extends CrewDocument> list = db.getCollection(Collection.CREW, Crew.class).find(eq("_id", crewId)).projection(fields(Projections.include("existingDocuments"))).first().getExistingDocuments();
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

    public List<Crew> getReadyToSignOffCrew() {
        //List<Contract> list = db.getCollection(Collection.CREW, Crew.class).find(eq("_id", crewId)).projection(fields(Projections.include("historicalContracts"))).first().getHistoricalContracts();
        return crewDao.findAll();
    }

    public void assignVacancy(long vacancyId, long[] crewIds) {
        //db.getCollection(Collection.CREW, Crew.class).
    }

    public void addToAudit(Crew modifiedCrew) {
        List<CrewFieldAudit> audits = new LinkedList<>();
        Employee maker = modifiedCrew.getEnteredBy();
        CrewFieldStatus fs = modifiedCrew.getFieldStatus();
        Employee enteredBy = modifiedCrew.getEnteredBy();
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
                        } else if (val.getClass().equals(Boolean.class)) {
                            Boolean value = (Boolean) val;
                            crewFieldAudit.setFieldValue((value ? "YES" : "NO"));
                        } else if (val.getClass().equals(Integer.class)) {
                            Integer value = (Integer) val;
                            crewFieldAudit.setFieldValue(String.valueOf(value));
                        } else if (val.getClass().equals(Double.class)) {
                            Double value = (Double) val;
                            crewFieldAudit.setFieldValue(String.valueOf(value));
                        } else if (val.getClass().equals(LocalDate.class)) {
                            LocalDate value = (LocalDate) val;
                            crewFieldAudit.setFieldValue(value.toString());
                        }

                        crewFieldAudit.setCrewId(crewId);
                        crewFieldAudit.setFieldName(field.getFieldName());
                        crewFieldAudit.setEnteredBy(enteredBy.getEmpId());
                        crewFieldAudit.setEnteredDateTime(LocalDateTime.now());
                        audits.add(crewFieldAudit);

                        setterMethod.invoke(fs, new FieldStatus(maker.getEmpId(), now, null, null));

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
