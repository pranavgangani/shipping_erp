package com.intuitbrains.service.crew;

import com.intuitbrains.dao.common.CrewDocumentRepository;
import com.intuitbrains.dao.common.DocumentTypeRepository;
import com.intuitbrains.dao.common.FlagRepository;
import com.intuitbrains.dao.crew.CrewRepository;
import com.intuitbrains.model.common.document.*;
import com.intuitbrains.model.crew.CrewDocument;
import com.intuitbrains.model.common.document.category.DocumentType;
import com.intuitbrains.model.crew.*;
import com.intuitbrains.util.DateTimeUtil;
import com.intuitbrains.util.StringUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Service
public class CrewExcelService {
    @Autowired
    private CrewDocumentRepository documentDao;
    @Autowired
    private DocumentTypeRepository docTypeDao;
    @Autowired
    private CrewRepository crewDao;
    @Autowired
    private FlagRepository flagDao;

    public Crew upload(FileInputStream file) {
        Crew crew = new Crew();
        readFromExcel(file, crew);
        return crew;
    }


    private void readFromExcel(FileInputStream file, Crew crew) {
        final String fileLocation = "";
        try {
            List<CrewDocument> documents = new ArrayList<>();
            Workbook workbook = new HSSFWorkbook(file);
            //Next, let's retrieve the first sheet of the file and iterate through each row:
            Sheet sheet1 = workbook.getSheetAt(0);
            Sheet sheet2 = workbook.getSheetAt(1);
            Sheet sheet3 = workbook.getSheetAt(2);
            CellReference postAppliedForCell = new CellReference("B15");
            CellReference isLowerRankCell = new CellReference("B18");
            CellReference dateAvailableCell = new CellReference("B21");

            CellReference fNameCell = new CellReference("M14");
            CellReference mNameCell = new CellReference("M15");
            CellReference lNameCell = new CellReference("M16");

            CellReference nationalityCell = new CellReference("M18");
            CellReference dateOfBirthCell = new CellReference("M19");
            CellReference placeOfBirthCell = new CellReference("M20");

            CellReference permAddLine1Cell = new CellReference("B25");
            CellReference permAddLine2Cell = new CellReference("B26");
            CellReference permAddLine3Cell = new CellReference("B27");
            CellReference permAddPinCodeCell = new CellReference("H27");
            CellReference permAddTelCell = new CellReference("D28");
            CellReference permAddNearAirportCell = new CellReference("D29");

            CellReference presentAddLine1Cell = new CellReference("B25");
            CellReference presentAddLine2Cell = new CellReference("B26");
            CellReference presentAddLine3Cell = new CellReference("B27");
            CellReference presentAddPinCodeCell = new CellReference("H27");
            CellReference presentAddTelCell = new CellReference("D28");
            CellReference presentAddNearAirportCell = new CellReference("D29");
            CellReference howCometoKnowCell = new CellReference("J31");

            //Crew details
            crew.setFirstName(sheet1.getRow(fNameCell.getRow()).getCell(fNameCell.getCol()).getRichStringCellValue().getString());
            crew.setMiddleName(sheet1.getRow(mNameCell.getRow()).getCell(mNameCell.getCol()).getRichStringCellValue().getString());
            crew.setLastName(sheet1.getRow(lNameCell.getRow()).getCell(lNameCell.getCol()).getRichStringCellValue().getString());
            crew.setNationality(sheet1.getRow(nationalityCell.getRow()).getCell(nationalityCell.getCol()).getRichStringCellValue().getString());
            Date dob = sheet1.getRow(dateOfBirthCell.getRow()).getCell(dateOfBirthCell.getCol()).getDateCellValue();
            crew.setDob(DateTimeUtil.convertToLocalDate(dob));

            //Vacancy details
            String postAppliedFor = sheet1.getRow(postAppliedForCell.getRow()).getCell(postAppliedForCell.getCol()).getRichStringCellValue().getString();
            boolean isLowerRank = StringUtil.parseBoolean(sheet1.getRow(isLowerRankCell.getRow()).getCell(isLowerRankCell.getCol()).getRichStringCellValue().getString());
            Date dateAvailableFrom = sheet1.getRow(dateAvailableCell.getRow()).getCell(dateAvailableCell.getCol()).getDateCellValue();


            //Get Documents
            List<CrewDocument> mandatoryDocList = documentDao.findAll();
            //Passport & Visa
            populatePassportVisa(sheet1, crew, mandatoryDocList, documents);
            //CDC
            populateCDC(sheet1, crew, mandatoryDocList, documents);
            //Licence
            populateLicence(sheet1, crew, mandatoryDocList, documents);
            //NoK
            populateNextOfKin(sheet1, crew, mandatoryDocList, documents);
            //Courses & Certificates
            populateCoursesAndCertificates(sheet2, crew);
            //Education & Apprentice
            populateEducationHistory(sheet2, crew);
            //Medical History
            populateMedicalHistory(sheet2, crew);
            //Employment
            populateEmploymentHistory(sheet3, crew);

            //Set docs
            crew.setExistingDocuments(documents);

            crewDao.insert(crew);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void populateMedicalHistory(Sheet sheet, Crew crew) {
        CellReference signedOffForMedicalReasonsCell = new CellReference("A57");
        boolean signedOffForMedicalReasons = StringUtil.parseBoolean(sheet.getRow(signedOffForMedicalReasonsCell.getRow()).getCell(signedOffForMedicalReasonsCell.getCol()).getRichStringCellValue().getString());

        crew.setSignedOffForMedicalReasons(signedOffForMedicalReasons);
        List<IllnessAndInjury> illnesses = new ArrayList<>();
        if (signedOffForMedicalReasons) {
            for (int i = 59; i <= 60; i++) {
                CellReference vesselNameCell = new CellReference("A" + i);
                CellReference injuryDescriptionCell = new CellReference("A62");
                CellReference dateOfOccurCell = new CellReference("G" + i);
                IllnessAndInjury ill = new IllnessAndInjury();
                ill.setMedicalType(MedicalType.INJURY);
                ill.setNameOfVessel(sheet.getRow(vesselNameCell.getRow()).getCell(vesselNameCell.getCol()).getRichStringCellValue().getString());
                ill.setDescription(sheet.getRow(injuryDescriptionCell.getRow()).getCell(injuryDescriptionCell.getCol()).getRichStringCellValue().getString());
                ill.setDateOfOccurence(DateTimeUtil.convertToLocalDate(sheet.getRow(dateOfOccurCell.getRow()).getCell(dateOfOccurCell.getCol()).getDateCellValue()));
                illnesses.add(ill);
            }
            crew.setIllnessInjury(illnesses);
        }
        crew.setHasMalaria(false);
        crew.setSufferingFromDiseaseThatEndangersLife(false);
        crew.setDrugAlcoholAddict(false);
        crew.setHasEpilepsy(false);
        crew.setHasNervousDisability(false);
    }

    private void populateEducationHistory(Sheet sheet, Crew crew) {
        List<Education> education = new ArrayList<>();

        //10+2
        for (int i = 47; i <= 48; i++) {
            CellReference instituteNameCell = new CellReference("A" + i);
            CellReference startDateCell = new CellReference("F" + i);
            CellReference endDateCell = new CellReference("G" + i);
            CellReference degreeNameCell = new CellReference("H" + i);

            Education edu = new Education();
            edu.setInstituteName(sheet.getRow(instituteNameCell.getRow()).getCell(instituteNameCell.getCol()).getRichStringCellValue().getString());
            edu.setStartDate(DateTimeUtil.convertToLocalDate(sheet.getRow(startDateCell.getRow()).getCell(startDateCell.getCol()).getDateCellValue()));
            edu.setEndDate(DateTimeUtil.convertToLocalDate(sheet.getRow(endDateCell.getRow()).getCell(endDateCell.getCol()).getDateCellValue()));
            edu.setEducationName(sheet.getRow(degreeNameCell.getRow()).getCell(degreeNameCell.getCol()).getRichStringCellValue().getString());
            education.add(edu);
        }
        //Pre-Sea Training/Apprentice
        for (int i = 52; i <= 53; i++) {
            CellReference instituteNameCell = new CellReference("A" + i);
            CellReference startDateCell = new CellReference("F" + i);
            CellReference endDateCell = new CellReference("G" + i);
            CellReference degreeNameCell = new CellReference("H" + i);

            Education edu = new Education();
            edu.setInstituteName(sheet.getRow(instituteNameCell.getRow()).getCell(instituteNameCell.getCol()).getRichStringCellValue().getString());
            edu.setStartDate(DateTimeUtil.convertToLocalDate(sheet.getRow(startDateCell.getRow()).getCell(startDateCell.getCol()).getDateCellValue()));
            edu.setEndDate(DateTimeUtil.convertToLocalDate(sheet.getRow(endDateCell.getRow()).getCell(endDateCell.getCol()).getDateCellValue()));
            edu.setEducationName(sheet.getRow(degreeNameCell.getRow()).getCell(degreeNameCell.getCol()).getRichStringCellValue().getString());
            education.add(edu);
        }
        crew.setEducationHistory(education);
    }

    private void populateEmploymentHistory(Sheet sheet, Crew crew) {
        List<Experience> employment = new LinkedList<>();

        for (int i = 7; i <= 48; i++) {
            CellReference empNameCell = new CellReference("B" + i);
            CellReference vesselNameCell = new CellReference("C" + i);
            CellReference rankCell = new CellReference("D" + i);
            CellReference flagCell = new CellReference("E" + i);
            CellReference vesselTypeCell = new CellReference("F" + i);

            CellReference startDateCell = new CellReference("L" + i);
            CellReference endDateCell = new CellReference("M" + i);
            CellReference signOffReasonCell = new CellReference("O" + i);

            Experience emp = new Experience();
            emp.setEmployerName(sheet.getRow(empNameCell.getRow()).getCell(empNameCell.getCol()).getRichStringCellValue().getString());
            /*vessel.setVesselName(sheet.getRow(vesselNameCell.getRow()).getCell(vesselNameCell.getCol()).getRichStringCellValue().getString());
            vessel.setFlagCode(flagDao.getByCode(sheet.getRow(flagCell.getRow()).getCell(flagCell.getCol()).getRichStringCellValue().getString()).getCode());
            vessel.setVesselSubType(VesselSubType.createFromDesc(sheet.getRow(vesselTypeCell.getRow()).getCell(vesselTypeCell.getCol()).getRichStringCellValue().getString()));*/
            emp.setLastRank(Rank.createFromDesc(sheet.getRow(rankCell.getRow()).getCell(rankCell.getCol()).getRichStringCellValue().getString()));
            emp.setVesselName(sheet.getRow(vesselNameCell.getRow()).getCell(vesselNameCell.getCol()).getRichStringCellValue().getString());
            emp.setStartDate(DateTimeUtil.convertToLocalDate(sheet.getRow(startDateCell.getRow()).getCell(startDateCell.getCol()).getDateCellValue()));
            emp.setEndDate(DateTimeUtil.convertToLocalDate(sheet.getRow(endDateCell.getRow()).getCell(endDateCell.getCol()).getDateCellValue()));
            emp.setReasonForSingOff(Experience.ReasonForSingOff.createFromDesc(sheet.getRow(signOffReasonCell.getRow()).getCell(signOffReasonCell.getCol()).getRichStringCellValue().getString()));
            employment.add(emp);
        }
        crew.setEmploymentHistory(employment);
    }

    private void populateCoursesAndCertificates(Sheet sheet, Crew crew) {

    }

    private void populatePassportVisa(Sheet sheet, Crew crew, List<CrewDocument> mandatoryDocList, List<CrewDocument> crewDocsToPopulate) {
        for (int i = 34; i <= 37; i++) {
            CellReference docTypeCell = new CellReference("B" + i);
            CellReference numCell = new CellReference("E" + i);
            CellReference doICell = new CellReference("H" + i);
            CellReference poICell = new CellReference("L" + i);
            CellReference doECell = new CellReference("O" + i);
            CellReference blankCell = new CellReference("R" + i);
            CellReference ecnrCell = new CellReference("T" + i);

            Date doiVal = sheet.getRow(doICell.getRow()).getCell(doICell.getCol()).getDateCellValue();
            Date doeVal = sheet.getRow(doECell.getRow()).getCell(doECell.getCol()).getDateCellValue();
            LocalDate doi = DateTimeUtil.convertToLocalDate(doiVal);
            LocalDate doe = DateTimeUtil.convertToLocalDate(doeVal);
            String docTypeStr = sheet.getRow(docTypeCell.getRow()).getCell(docTypeCell.getCol()).getRichStringCellValue().getString();
            String placeOfIssue = sheet.getRow(poICell.getRow()).getCell(poICell.getCol()).getRichStringCellValue().getString();
            String docNum = sheet.getRow(numCell.getRow()).getCell(numCell.getCol()).getRichStringCellValue().getString();

            if (docTypeStr.equalsIgnoreCase("Passport")) {
                DocumentType dt = docTypeDao.findByName("Indian Passport");
                for (CrewDocument doc : mandatoryDocList) {
                    if (doc.getDocName().equalsIgnoreCase(dt.getName()) && doc.getFlagCode().equalsIgnoreCase(dt.getFlagCode())) {
                        Passport passport = (Passport) doc;
                        passport.setDateOfExpiry(doe);
                        passport.setDocNumber(docNum);
                        passport.setDateOfIssue(doi);
                        passport.setDateOfExpiry(doe);
                        passport.setPlaceOfIssue(placeOfIssue);
                        passport.setECNRRequired(StringUtil.parseBoolean(sheet.getRow(ecnrCell.getRow()).getCell(ecnrCell.getCol()).getRichStringCellValue().getString()));
                        passport.setBlankPages((int) sheet.getRow(blankCell.getRow()).getCell(blankCell.getCol()).getNumericCellValue());
                        crewDocsToPopulate.add(passport);
                        crew.setPassportNumber(docNum);
                        break;
                    }
                }
            } else if (docTypeStr.equalsIgnoreCase("US Visa C1/D")) {
                DocumentType dt = docTypeDao.findByName("US C1/D");
                for (CrewDocument doc : mandatoryDocList) {
                    if (doc.getDocName().equalsIgnoreCase(dt.getName()) && doc.getFlagCode().equalsIgnoreCase(dt.getFlagCode())) {
                        Visa visa = (Visa) doc;
                        visa.setDocNumber(docNum);
                        visa.setDateOfIssue(doi);
                        visa.setDateOfExpiry(doe);
                        visa.setPlaceOfIssue(placeOfIssue);
                        crewDocsToPopulate.add(visa);
                        break;
                    }
                }
            } else if (docTypeStr.equalsIgnoreCase("US Visa B1/B2")) {
                DocumentType dt = docTypeDao.findByName("US B1/B2");
                for (CrewDocument doc : mandatoryDocList) {
                    if (doc.getDocName().equalsIgnoreCase(dt.getName()) && doc.getFlagCode().equalsIgnoreCase(dt.getFlagCode())) {
                        Visa visa = (Visa) doc;
                        visa.setDocNumber(docNum);
                        visa.setDateOfIssue(doi);
                        visa.setDateOfExpiry(doe);
                        visa.setPlaceOfIssue(placeOfIssue);
                        crewDocsToPopulate.add(visa);
                        break;
                    }
                }
            } else if (docTypeStr.equalsIgnoreCase("Australian MCV")) {
                DocumentType dt = docTypeDao.findByName("Australian MCV");
                for (CrewDocument doc : mandatoryDocList) {
                    if (doc.getDocName().equalsIgnoreCase(dt.getName()) && doc.getFlagCode().equalsIgnoreCase(dt.getFlagCode())) {
                        Visa visa = (Visa) doc;
                        visa.setDocNumber(docNum);
                        visa.setDateOfIssue(doi);
                        visa.setDateOfExpiry(doe);
                        visa.setPlaceOfIssue(placeOfIssue);
                        crewDocsToPopulate.add(visa);
                        break;
                    }
                }
            }
        }
    }

    private void populateCDC(Sheet sheet, Crew crew, List<CrewDocument> mandatoryDocList, List<CrewDocument> crewDocsToPopulate) {
        //CDC
        for (int i = 40; i <= 45; i++) {
            CellReference docTypeCell = new CellReference("B" + i);
            CellReference numCell = new CellReference("E" + i);
            CellReference doICell = new CellReference("H" + i);
            CellReference poICell = new CellReference("L" + i);
            CellReference doECell = new CellReference("O" + i);
            CellReference remarksCell = new CellReference("R" + i);

            Cell c = sheet.getRow(i).getCell(numCell.getCol());
            if (c != null || c.getCellType() != CellType.BLANK) {
               System.out.println("Cell is not empty");
            }else {
                System.out.println("Cell is empty");
            }
            double docNum = sheet.getRow(numCell.getRow()).getCell(numCell.getCol()).getNumericCellValue();

            String docTypeStr = sheet.getRow(docTypeCell.getRow()).getCell(docTypeCell.getCol()).getRichStringCellValue().getString();

            Date doiVal = sheet.getRow(doICell.getRow()).getCell(doICell.getCol()).getDateCellValue();
            Date doeVal = sheet.getRow(doECell.getRow()).getCell(doECell.getCol()).getDateCellValue();
            LocalDate doi = DateTimeUtil.convertToLocalDate(doiVal);
            LocalDate doe = DateTimeUtil.convertToLocalDate(doeVal);
            String placeOfIssue = sheet.getRow(poICell.getRow()).getCell(poICell.getCol()).getRichStringCellValue().getString();

            String remarks = sheet.getRow(remarksCell.getRow()).getCell(remarksCell.getCol()).getRichStringCellValue().getString();

            if (docTypeStr.equalsIgnoreCase("Indian")) {
                DocumentType dt = docTypeDao.findByName("Indian CDC");
                for (CrewDocument doc : mandatoryDocList) {
                    if (doc.getDocName().equalsIgnoreCase(dt.getName()) && doc.getFlagCode().equalsIgnoreCase(dt.getFlagCode())) {
                        NationalID cdc = (NationalID) doc;
                        cdc.setDateOfExpiry(doe);
                        cdc.setDocNumber(String.valueOf(docNum));
                        cdc.setDateOfIssue(doi);
                        cdc.setDateOfExpiry(doe);
                        cdc.setPlaceOfIssue(placeOfIssue);
                        cdc.setRemarks(remarks);
                        crewDocsToPopulate.add(cdc);
                        break;
                    }
                }
            } else if (docTypeStr.equalsIgnoreCase("Liberian")) {
                DocumentType dt = docTypeDao.findByName("Liberian CDC");
                for (CrewDocument doc : mandatoryDocList) {
                    if (doc.getDocName().equalsIgnoreCase(dt.getName()) && doc.getFlagCode().equalsIgnoreCase(dt.getFlagCode())) {
                        NationalID cdc = (NationalID) doc;
                        cdc.setDateOfExpiry(doe);
                        cdc.setDocNumber(String.valueOf(docNum));
                        cdc.setDateOfIssue(doi);
                        cdc.setDateOfExpiry(doe);
                        cdc.setPlaceOfIssue(placeOfIssue);
                        cdc.setRemarks(remarks);
                        crewDocsToPopulate.add(cdc);
                        break;
                    }
                }
            } else if (docTypeStr.equalsIgnoreCase("Panama")) {
                DocumentType dt = docTypeDao.findByName("Panama CDC");
                for (CrewDocument doc : mandatoryDocList) {
                    if (doc.getDocName().equalsIgnoreCase(dt.getName()) && doc.getFlagCode().equalsIgnoreCase(dt.getFlagCode())) {
                        NationalID cdc = (NationalID) doc;
                        cdc.setDateOfExpiry(doe);
                        cdc.setDocNumber(String.valueOf(docNum));
                        cdc.setDateOfIssue(doi);
                        cdc.setDateOfExpiry(doe);
                        cdc.setPlaceOfIssue(placeOfIssue);
                        cdc.setRemarks(remarks);
                        crewDocsToPopulate.add(cdc);
                        break;
                    }
                }
            } else if (docTypeStr.equalsIgnoreCase("Others")) {
                DocumentType dt = docTypeDao.findByName("Other CDC");
                for (CrewDocument doc : mandatoryDocList) {
                    if (doc.getDocName().equalsIgnoreCase(dt.getName()) && doc.getFlagCode().equalsIgnoreCase(dt.getFlagCode())) {
                        NationalID cdc = (NationalID) doc;
                        cdc.setDateOfExpiry(doe);
                        cdc.setDocNumber(String.valueOf(docNum));
                        cdc.setDateOfIssue(doi);
                        cdc.setDateOfExpiry(doe);
                        cdc.setPlaceOfIssue(placeOfIssue);
                        cdc.setRemarks(remarks);
                        crewDocsToPopulate.add(cdc);
                        break;
                    }
                }
            } else if (docTypeStr.equalsIgnoreCase("INDOS")) {
                DocumentType dt = docTypeDao.findByName("INDOS");
                for (CrewDocument doc : mandatoryDocList) {
                    if (doc.getDocName().equalsIgnoreCase(dt.getName()) && doc.getFlagCode().equalsIgnoreCase(dt.getFlagCode())) {
                        NationalID cdc = (NationalID) doc;
                        cdc.setDateOfExpiry(doe);
                        cdc.setDocNumber(String.valueOf(docNum));
                        cdc.setDateOfIssue(doi);
                        cdc.setDateOfExpiry(doe);
                        cdc.setPlaceOfIssue(placeOfIssue);
                        cdc.setRemarks(remarks);
                        crewDocsToPopulate.add(cdc);
                        crew.setIndosNumber(String.valueOf(docNum));
                        break;
                    }
                }
            } else if (docTypeStr.equalsIgnoreCase("Yellow Fever")) {
                DocumentType dt = docTypeDao.findByName("Yellow Fever");
                for (CrewDocument doc : mandatoryDocList) {
                    if (doc.getDocName().equalsIgnoreCase(dt.getName()) && doc.getFlagCode().equalsIgnoreCase(dt.getFlagCode())) {
                        Certificate cert = (Certificate) doc;
                        cert.setDateOfExpiry(doe);
                        cert.setDocNumber(String.valueOf(docNum));
                        cert.setDateOfIssue(doi);
                        cert.setDateOfExpiry(doe);
                        cert.setPlaceOfIssue(placeOfIssue);
                        cert.setRemarks(remarks);
                        crewDocsToPopulate.add(cert);
                        break;
                    }
                }
            }
        }
    }

    private void populateNextOfKin(Sheet sheet, Crew crew, List<CrewDocument> mandatoryDocList, List<CrewDocument> crewDocsToPopulate) {
        CellReference civilStatusCell = new CellReference("D55");
        CellReference nokNameCell = new CellReference("D56");
        CellReference nokAddressCell = new CellReference("D57");
        CellReference nokRelationCell = new CellReference("O56");
        CellReference nokPinCodeCell = new CellReference("Q58");
        CellReference nokContactCell = new CellReference("N59");

        String civilStatus = sheet.getRow(civilStatusCell.getRow()).getCell(civilStatusCell.getCol()).getRichStringCellValue().getString();
        String nokAddress = sheet.getRow(nokAddressCell.getRow()).getCell(nokAddressCell.getCol()).getRichStringCellValue().getString();
        String nokPinCode = sheet.getRow(nokPinCodeCell.getRow()).getCell(nokPinCodeCell.getCol()).getRichStringCellValue().getString();
        String nokContact = sheet.getRow(nokContactCell.getRow()).getCell(nokContactCell.getCol()).getRichStringCellValue().getString();

        //NoK list
        for (int i = 62; i <= 65; i++) {
            CellReference docTypeCell = new CellReference("B" + i);
            String docTypeStr = sheet.getRow(docTypeCell.getRow()).getCell(docTypeCell.getCol()).getRichStringCellValue().getString();
            CellReference nameCell = new CellReference("B" + i);
            CellReference genderCell = new CellReference("E" + i);
            CellReference dobCell = new CellReference("F" + i);
            CellReference passportCell = new CellReference("H" + i);
            CellReference doICell = new CellReference("K" + i);
            CellReference poICell = new CellReference("M" + i);
            CellReference doECell = new CellReference("O" + i);
            CellReference ecnrCell = new CellReference("Q" + i);
            CellReference hasUSVisaCell = new CellReference("S" + i);

            Date dobVal = sheet.getRow(dobCell.getRow()).getCell(dobCell.getCol()).getDateCellValue();
            Date doiVal = sheet.getRow(doICell.getRow()).getCell(doICell.getCol()).getDateCellValue();
            Date doeVal = sheet.getRow(doECell.getRow()).getCell(doECell.getCol()).getDateCellValue();
            LocalDate dob = DateTimeUtil.convertToLocalDate(dobVal);
            LocalDate doi = DateTimeUtil.convertToLocalDate(doiVal);
            LocalDate doe = DateTimeUtil.convertToLocalDate(doeVal);
            String placeOfIssue = sheet.getRow(poICell.getRow()).getCell(poICell.getCol()).getRichStringCellValue().getString();
            String name = sheet.getRow(nameCell.getRow()).getCell(nameCell.getCol()).getRichStringCellValue().getString();
            String gender = sheet.getRow(genderCell.getRow()).getCell(genderCell.getCol()).getRichStringCellValue().getString();
            String passportNum = sheet.getRow(passportCell.getRow()).getCell(passportCell.getCol()).getRichStringCellValue().getString();
            boolean isECNR = StringUtil.parseBoolean(sheet.getRow(ecnrCell.getRow()).getCell(ecnrCell.getCol()).getRichStringCellValue().getString());
            boolean hasUSVisa = StringUtil.parseBoolean(sheet.getRow(hasUSVisaCell.getRow()).getCell(hasUSVisaCell.getCol()).getRichStringCellValue().getString());

            NextOfKin nok = new NextOfKin();
            NextOfKin.RelationType relationType = null;
            if (docTypeStr.equalsIgnoreCase("Wife")) {
                relationType = NextOfKin.RelationType.WIFE;
            } else if (docTypeStr.startsWith("Child")) {
                if (gender.equalsIgnoreCase("M"))
                    relationType = NextOfKin.RelationType.SON;
                if (gender.equalsIgnoreCase("F"))
                    relationType = NextOfKin.RelationType.DAUGHTER;
            }
            nok.setNomineeName(name);
            nok.setDateOfBirth(dob);
            nok.setRelationType(relationType.getRelationTypeName());
            nok.setAddress(nokAddress);
            nok.setGender(gender);
            nok.setHasUSVisa(hasUSVisa);

            Passport nokPassport = new Passport();
            nokPassport.setDocNumber(passportNum);
            nokPassport.setGivenName(name);
            nokPassport.setECNRRequired(isECNR);
            nokPassport.setDateOfExpiry(doe);
            nokPassport.setAddress(nokAddress);
            nokPassport.setDateOfIssue(doi);
            nokPassport.setPlaceOfIssue(placeOfIssue);
            nok.setPassport(nokPassport);
        }
    }

    private void populateLicence(Sheet sheet, Crew crew, List<CrewDocument> mandatoryDocList, List<CrewDocument> crewDocsToPopulate) {

        //License
        for (int i = 48; i <= 53; i++) {
            CellReference docTypeCell = new CellReference("B" + i);
            CellReference gradeCell = new CellReference("E" + i);
            CellReference numCell = new CellReference("H" + i);
            CellReference doICell = new CellReference("L" + i);
            CellReference poICell = new CellReference("O" + i);
            CellReference doECell = new CellReference("R" + i);

            String docTypeStr = sheet.getRow(docTypeCell.getRow()).getCell(docTypeCell.getCol()).getRichStringCellValue().getString();

            Date doiVal = sheet.getRow(doICell.getRow()).getCell(doICell.getCol()).getDateCellValue();
            Date doeVal = sheet.getRow(doECell.getRow()).getCell(doECell.getCol()).getDateCellValue();
            LocalDate doi = DateTimeUtil.convertToLocalDate(doiVal);
            LocalDate doe = DateTimeUtil.convertToLocalDate(doeVal);
            String placeOfIssue = sheet.getRow(poICell.getRow()).getCell(poICell.getCol()).getRichStringCellValue().getString();
            String docNum = sheet.getRow(numCell.getRow()).getCell(numCell.getCol()).getRichStringCellValue().getString();
            String grade = sheet.getRow(gradeCell.getRow()).getCell(gradeCell.getCol()).getRichStringCellValue().getString();

            if (docTypeStr.equalsIgnoreCase("Indian")) {
                DocumentType dt = docTypeDao.findByName("Indian License");
                for (CrewDocument doc : mandatoryDocList) {
                    if (doc.getDocName().equalsIgnoreCase(dt.getName()) && doc.getFlagCode().equalsIgnoreCase(dt.getFlagCode())) {
                        License lic = (License) doc;
                        lic.setDateOfExpiry(doe);
                        lic.setDocNumber(docNum);
                        lic.setDateOfIssue(doi);
                        lic.setDateOfExpiry(doe);
                        lic.setPlaceOfIssue(placeOfIssue);
                        lic.setGrade(grade);
                        crewDocsToPopulate.add(lic);
                        break;
                    }
                }
            } else if (docTypeStr.equalsIgnoreCase("Liberian")) {
                DocumentType dt = docTypeDao.findByName("Liberian License");
                for (CrewDocument doc : mandatoryDocList) {
                    if (doc.getDocName().equalsIgnoreCase(dt.getName()) && doc.getFlagCode().equalsIgnoreCase(dt.getFlagCode())) {
                        License lic = (License) doc;
                        lic.setDateOfExpiry(doe);
                        lic.setDocNumber(docNum);
                        lic.setDateOfIssue(doi);
                        lic.setDateOfExpiry(doe);
                        lic.setPlaceOfIssue(placeOfIssue);
                        lic.setGrade(grade);
                        crewDocsToPopulate.add(lic);
                        break;
                    }
                }
            } else if (docTypeStr.equalsIgnoreCase("Panama")) {
                DocumentType dt = docTypeDao.findByName("Panama License");
                for (CrewDocument doc : mandatoryDocList) {
                    if (doc.getDocName().equalsIgnoreCase(dt.getName()) && doc.getFlagCode().equalsIgnoreCase(dt.getFlagCode())) {
                        License lic = (License) doc;
                        lic.setDateOfExpiry(doe);
                        lic.setDocNumber(docNum);
                        lic.setDateOfIssue(doi);
                        lic.setDateOfExpiry(doe);
                        lic.setPlaceOfIssue(placeOfIssue);
                        lic.setGrade(grade);
                        crewDocsToPopulate.add(lic);
                        break;
                    }
                }
            } else if (docTypeStr.equalsIgnoreCase("UK")) {
                DocumentType dt = docTypeDao.findByName("UK License");
                for (CrewDocument doc : mandatoryDocList) {
                    if (doc.getDocName().equalsIgnoreCase(dt.getName()) && doc.getFlagCode().equalsIgnoreCase(dt.getFlagCode())) {
                        License lic = (License) doc;
                        lic.setDateOfExpiry(doe);
                        lic.setDocNumber(docNum);
                        lic.setDateOfIssue(doi);
                        lic.setDateOfExpiry(doe);
                        lic.setPlaceOfIssue(placeOfIssue);
                        lic.setGrade(grade);
                        crewDocsToPopulate.add(lic);
                        break;
                    }
                }
            } else if (docTypeStr.equalsIgnoreCase("Singapore")) {
                DocumentType dt = docTypeDao.findByName("Singapore License");
                for (CrewDocument doc : mandatoryDocList) {
                    if (doc.getDocName().equalsIgnoreCase(dt.getName()) && doc.getFlagCode().equalsIgnoreCase(dt.getFlagCode())) {
                        License lic = (License) doc;
                        lic.setDateOfExpiry(doe);
                        lic.setDocNumber(docNum);
                        lic.setDateOfIssue(doi);
                        lic.setDateOfExpiry(doe);
                        lic.setPlaceOfIssue(placeOfIssue);
                        lic.setGrade(grade);
                        crewDocsToPopulate.add(lic);
                        break;
                    }
                }
            } else if (docTypeStr.equalsIgnoreCase("Others")) {
                DocumentType dt = docTypeDao.findByName("Other License");
                for (CrewDocument doc : mandatoryDocList) {
                    if (doc.getDocName().equalsIgnoreCase(dt.getName()) && doc.getFlagCode().equalsIgnoreCase(dt.getFlagCode())) {
                        License lic = (License) doc;
                        lic.setDateOfExpiry(doe);
                        lic.setDocNumber(docNum);
                        lic.setDateOfIssue(doi);
                        lic.setDateOfExpiry(doe);
                        lic.setPlaceOfIssue(placeOfIssue);
                        lic.setGrade(grade);
                        crewDocsToPopulate.add(lic);
                        break;
                    }
                }
            }
        }
    }
}
