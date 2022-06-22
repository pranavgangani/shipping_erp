package com.intuitbrains.service.vessel;

import com.intuitbrains.common.AuditTrail;
import com.intuitbrains.common.Collection;
import com.intuitbrains.dao.common.AuditTrailRepository;
import com.intuitbrains.dao.common.CrewDocumentRepository;
import com.intuitbrains.dao.common.DocumentTypeRepository;
import com.intuitbrains.dao.common.FieldStatus;
import com.intuitbrains.dao.company.EmployeeRepository;
import com.intuitbrains.dao.crew.CrewRepository;
import com.intuitbrains.model.common.document.Contract;
import com.intuitbrains.model.crew.*;
import com.intuitbrains.model.crew.contract.TravelAndAccomodation;
import com.intuitbrains.model.vessel.Vessel;
import com.intuitbrains.service.common.SequenceGeneratorService;
import com.intuitbrains.service.crew.CrewExcelService;
import com.intuitbrains.util.StandardWebParameter;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static com.mongodb.client.model.Filters.*;
import static com.mongodb.client.model.Projections.fields;

@Service
public class VesselService {
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
    private static Bson projections = Projections.include("_id", "vesselSubType", "vesselOwner.ownerName", "vesselType", "vesselName", "enteredBy", "enteredLocalDateTime");

    public Vessel getById(long vesselId) {
        MongoCollection<Vessel> collection = db.getCollection(Collection.VESSEL, Vessel.class);
        Bson filter = eq("_id", vesselId);
        return collection.find(filter).projection(projections).first();
    }


}
