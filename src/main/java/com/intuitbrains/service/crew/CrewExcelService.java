package com.intuitbrains.service.crew;

import com.intuitbrains.common.Flag;
import com.intuitbrains.dao.common.CrewDocumentRepository;
import com.intuitbrains.dao.common.DocumentTypeRepository;
import com.intuitbrains.dao.common.FlagRepository;
import com.intuitbrains.dao.crew.CrewRepository;
import com.intuitbrains.model.common.Address;
import com.intuitbrains.model.common.DurationType;
import com.intuitbrains.model.common.document.*;
import com.intuitbrains.model.common.document.category.EducationDocument;
import com.intuitbrains.model.crew.CrewDocument;
import com.intuitbrains.model.common.document.category.DocumentType;
import com.intuitbrains.model.crew.*;
import com.intuitbrains.model.vessel.VesselSubType;
import com.intuitbrains.util.DateTimeUtil;
import com.intuitbrains.util.ParamUtil;
import com.intuitbrains.util.StringUtil;
import com.thoughtworks.qdox.model.expression.Add;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
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

    public Crew readFromExcel(FileInputStream file) {
        Crew crew = new Crew();
        read(file, crew);
        return crew;
    }


    private Crew read(FileInputStream file, Crew crew) {
        try {
            List<CrewDocument> documents = new ArrayList<>();
            Workbook workbook = new XSSFWorkbook(file);
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
            CellReference nearAirportCell = new CellReference("D29");

            CellReference presentAddLine1Cell = new CellReference("B25");
            CellReference presentAddLine2Cell = new CellReference("B26");
            CellReference presentAddLine3Cell = new CellReference("B27");
            CellReference presentAddPinCodeCell = new CellReference("H27");
            CellReference presentAddTelCell = new CellReference("D28");
            CellReference howCometoKnowCell = new CellReference("J31");

            String nationality = sheet1.getRow(nationalityCell.getRow()).getCell(nationalityCell.getCol()).getRichStringCellValue().getString();
            String placeOfBirth = sheet1.getRow(placeOfBirthCell.getRow()).getCell(placeOfBirthCell.getCol()).getRichStringCellValue().getString();
            String nearAirport = sheet1.getRow(nearAirportCell.getRow()).getCell(nearAirportCell.getCol()).getRichStringCellValue().getString();

            Address permAddress = new Address();
            String line = sheet1.getRow(permAddLine1Cell.getRow()).getCell(permAddLine1Cell.getCol()).getRichStringCellValue().getString();
            line+=sheet1.getRow(permAddLine2Cell.getRow()).getCell(permAddLine2Cell.getCol()).getRichStringCellValue().getString();
            line+=sheet1.getRow(permAddLine3Cell.getRow()).getCell(permAddLine3Cell.getCol()).getRichStringCellValue().getString();
            permAddress.setPostalCode((int)(sheet1.getRow(permAddPinCodeCell.getRow()).getCell(permAddPinCodeCell.getCol()).getNumericCellValue()));
            permAddress.setMob1(sheet1.getRow(permAddTelCell.getRow()).getCell(permAddTelCell.getCol()).getRichStringCellValue().getString());
            permAddress.setAddress(line);

            Address presentAddress = new Address();
            line = sheet1.getRow(presentAddLine1Cell.getRow()).getCell(presentAddLine1Cell.getCol()).getRichStringCellValue().getString();
            line+=sheet1.getRow(presentAddLine2Cell.getRow()).getCell(presentAddLine2Cell.getCol()).getRichStringCellValue().getString();
            line+=sheet1.getRow(presentAddLine3Cell.getRow()).getCell(presentAddLine3Cell.getCol()).getRichStringCellValue().getString();
            permAddress.setPostalCode((int)(sheet1.getRow(presentAddPinCodeCell.getRow()).getCell(presentAddPinCodeCell.getCol()).getNumericCellValue()));
            presentAddress.setMob1(sheet1.getRow(presentAddTelCell.getRow()).getCell(presentAddTelCell.getCol()).getRichStringCellValue().getString());
            presentAddress.setAddress(line);

            crew.setPermAddress(permAddress);
            crew.setPresentAddress(presentAddress);
            crew.setReference(sheet1.getRow(howCometoKnowCell.getRow()).getCell(howCometoKnowCell.getCol()).getRichStringCellValue().getString());

            //Crew details
            crew.setFirstName(sheet1.getRow(fNameCell.getRow()).getCell(fNameCell.getCol()).getRichStringCellValue().getString());
            crew.setMiddleName(sheet1.getRow(mNameCell.getRow()).getCell(mNameCell.getCol()).getRichStringCellValue().getString());
            crew.setLastName(sheet1.getRow(lNameCell.getRow()).getCell(lNameCell.getCol()).getRichStringCellValue().getString());
            //crew.setNationality(sheet1.getRow(nationalityCell.getRow()).getCell(nationalityCell.getCol()).getRichStringCellValue().getString());
            Date dob = sheet1.getRow(dateOfBirthCell.getRow()).getCell(dateOfBirthCell.getCol()).getDateCellValue();
            crew.setDob(DateTimeUtil.convertToLocalDate(dob));

            //Vacancy details
            String postAppliedFor = sheet1.getRow(postAppliedForCell.getRow()).getCell(postAppliedForCell.getCol()).getRichStringCellValue().getString();
            boolean isLowerRank = StringUtil.parseBoolean(sheet1.getRow(isLowerRankCell.getRow()).getCell(isLowerRankCell.getCol()).getRichStringCellValue().getString());
            Date dateAvailableFrom = sheet1.getRow(dateAvailableCell.getRow()).getCell(dateAvailableCell.getCol()).getDateCellValue();


            //Get Documents
            //List<CrewDocument> mandatoryDocList = documentDao.findAll();;
            crew.setAvailableFromDate(DateTimeUtil.convertToLocalDate(dateAvailableFrom));
            crew.setAcceptLowerRank(isLowerRank);
            crew.setRank(Rank.createFromDesc(postAppliedFor));

            //Passport & Visa
            populatePassportVisa(sheet1, crew, documents);
            //CDC
            populateCDC(sheet1, crew, documents);
            //Licence
            populateLicence(sheet1, crew, documents);
            //NoK
            populateNextOfKin(sheet1, crew, documents);
            //Education & Apprentice
            populateTraining(sheet2, crew, documents);
            //Education & Apprentice
            populateEducationHistory(sheet2, crew, documents);
            //Medical History
            populateMedicalHistory(sheet2, crew);
            //Employment
            populateEmploymentHistory(sheet3, crew, documents);

            //Set docs
            crew.setExistingDocuments(documents);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return crew;
    }

    private void populateTraining(Sheet sheet, Crew crew, List<CrewDocument> crewDocsToPopulate) {

        //10+2
        for (int i = 2; i <= 38; i++) {
            CellReference courseNameCell = new CellReference("A" + i);

            String courseName = sheet.getRow(courseNameCell.getRow()).getCell(courseNameCell.getCol()).getRichStringCellValue().getString();

            if (StringUtil.isNotEmpty(courseName)) {
                courseName = courseName.substring(courseName.lastIndexOf("(") + 1, courseName.lastIndexOf(")"));
                DocumentType dt = docTypeDao.getByShortName(courseName);

                if (dt != null) {
                    CellReference docNumberCell = new CellReference("D" + i);
                    CellReference doICell = new CellReference("F" + i);
                    CellReference doeCell = new CellReference("G" + i);
                    CellReference nameOfInstCell = new CellReference("H" + i);
                    CellReference durationDaysCell = new CellReference("I" + i);
                    CellReference placeOfInstCell = new CellReference("J" + i);

                    MerchantNavyCertificate cert = new MerchantNavyCertificate();
                    cert.setDocType(dt);
                    cert.setDocNumber(sheet.getRow(docNumberCell.getRow()).getCell(docNumberCell.getCol()).getRichStringCellValue().getString());
                    cert.setDateOfIssue(DateTimeUtil.convertToLocalDate(sheet.getRow(doICell.getRow()).getCell(doICell.getCol()).getDateCellValue()));
                    cert.setDateOfExpiry(DateTimeUtil.convertToLocalDate(sheet.getRow(doeCell.getRow()).getCell(doeCell.getCol()).getDateCellValue()));
                    cert.setInstituteName(sheet.getRow(nameOfInstCell.getRow()).getCell(nameOfInstCell.getCol()).getRichStringCellValue().getString());
                    cert.setDurationType(DurationType.DAYS);
                    cert.setValidity((int) sheet.getRow(durationDaysCell.getRow()).getCell(durationDaysCell.getCol()).getNumericCellValue());
                    cert.setInstituteAddress(sheet.getRow(placeOfInstCell.getRow()).getCell(placeOfInstCell.getCol()).getRichStringCellValue().getString());
                    crewDocsToPopulate.add(cert);
                }
            }
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
        CellReference endangerCell = new CellReference("H64");
        CellReference drugCell = new CellReference("H65");
        CellReference malariaCell = new CellReference("E67");
        CellReference diabetesCell = new CellReference("J67");
        CellReference epilepsyCell = new CellReference("E68");
        CellReference nervousCell = new CellReference("J68");

        crew.setHasMalaria(StringUtil.parseBoolean(sheet.getRow(malariaCell.getRow()).getCell(malariaCell.getCol()).getRichStringCellValue().getString()));
        crew.setSufferingFromDiseaseThatEndangersLife(StringUtil.parseBoolean(sheet.getRow(endangerCell.getRow()).getCell(endangerCell.getCol()).getRichStringCellValue().getString()));
        crew.setHasDiabetes(StringUtil.parseBoolean(sheet.getRow(diabetesCell.getRow()).getCell(diabetesCell.getCol()).getRichStringCellValue().getString()));
        crew.setDrugAlcoholAddict(StringUtil.parseBoolean(sheet.getRow(drugCell.getRow()).getCell(drugCell.getCol()).getRichStringCellValue().getString()));
        crew.setHasEpilepsy(StringUtil.parseBoolean(sheet.getRow(epilepsyCell.getRow()).getCell(epilepsyCell.getCol()).getRichStringCellValue().getString()));
        crew.setHasNervousDisability(StringUtil.parseBoolean(sheet.getRow(nervousCell.getRow()).getCell(nervousCell.getCol()).getRichStringCellValue().getString()));
    }

    private void populateEducationHistory(Sheet sheet, Crew crew, List<CrewDocument> crewDocsToPopulate) {
        List<Education> education = new ArrayList<>();

        //10+2
        for (int i = 47; i <= 48; i++) {
            CellReference instituteNameCell = new CellReference("A" + i);
            String instituteName = sheet.getRow(instituteNameCell.getRow()).getCell(instituteNameCell.getCol()).getRichStringCellValue().getString();

            if (StringUtil.isNotEmpty(instituteName)) {
                CellReference startDateCell = new CellReference("F" + i);
                CellReference endDateCell = new CellReference("G" + i);
                CellReference degreeNameCell = new CellReference("H" + i);
                String courseName = sheet.getRow(degreeNameCell.getRow()).getCell(degreeNameCell.getCol()).getRichStringCellValue().getString();
                DocumentType dt = docTypeDao.getByShortName(courseName);
                if (dt != null) {
                    Education edu = new Education();
                    edu.setInstituteName(instituteName);
                    edu.setStartDate(DateTimeUtil.convertToLocalDate(sheet.getRow(startDateCell.getRow()).getCell(startDateCell.getCol()).getDateCellValue()));
                    edu.setEndDate(DateTimeUtil.convertToLocalDate(sheet.getRow(endDateCell.getRow()).getCell(endDateCell.getCol()).getDateCellValue()));
                    edu.setEducationName(sheet.getRow(degreeNameCell.getRow()).getCell(degreeNameCell.getCol()).getRichStringCellValue().getString());
                    education.add(edu);

                    Certificate cert = new Certificate();
                    cert.setInstituteName(edu.getInstituteName());
                    cert.setStartDate(edu.getStartDate());
                    cert.setEndDate(edu.getEndDate());
                    cert.setDocType(dt);

                    crewDocsToPopulate.add(cert);
                }
            }
        }
        //Pre-Sea Training/Apprentice
        for (int i = 52; i <= 53; i++) {
            CellReference instituteNameCell = new CellReference("A" + i);
            String instituteName = sheet.getRow(instituteNameCell.getRow()).getCell(instituteNameCell.getCol()).getRichStringCellValue().getString();

            if (StringUtil.isNotEmpty(instituteName)) {
                CellReference startDateCell = new CellReference("F" + i);
                CellReference endDateCell = new CellReference("G" + i);
                CellReference degreeNameCell = new CellReference("H" + i);
                String courseName = sheet.getRow(degreeNameCell.getRow()).getCell(degreeNameCell.getCol()).getRichStringCellValue().getString();
                DocumentType dt = docTypeDao.getByShortName(courseName);
                if (dt != null) {
                    Education edu = new Education();
                    edu.setInstituteName(instituteName);
                    edu.setStartDate(DateTimeUtil.convertToLocalDate(sheet.getRow(startDateCell.getRow()).getCell(startDateCell.getCol()).getDateCellValue()));
                    edu.setEndDate(DateTimeUtil.convertToLocalDate(sheet.getRow(endDateCell.getRow()).getCell(endDateCell.getCol()).getDateCellValue()));
                    edu.setEducationName(sheet.getRow(degreeNameCell.getRow()).getCell(degreeNameCell.getCol()).getRichStringCellValue().getString());
                    education.add(edu);

                    Certificate cert = new Certificate();
                    cert.setInstituteName(edu.getInstituteName());
                    cert.setStartDate(edu.getStartDate());
                    cert.setEndDate(edu.getEndDate());
                    cert.setDocType(dt);
                    crewDocsToPopulate.add(cert);
                }
            }
        }
        crew.setEducationHistory(education);
    }

    private void populateEmploymentHistory(Sheet sheet, Crew crew, List<CrewDocument> crewDocsToPopulate) {
        List<Experience> employment = new LinkedList<>();

        for (int i = 4; i <= 48; i++) {
            CellReference empNameCell = new CellReference("B" + i);
            String empName = sheet.getRow(empNameCell.getRow()).getCell(empNameCell.getCol()).getRichStringCellValue().getString();
            if (StringUtil.isNotEmpty(empName)) {
                CellReference vesselNameCell = new CellReference("C" + i);
                CellReference rankCell = new CellReference("D" + i);
                CellReference flagCell = new CellReference("E" + i);
                String flagCode = StringUtil.trim(sheet.getRow(flagCell.getRow()).getCell(flagCell.getCol()).getRichStringCellValue().getString());
                flagCode = flagCode.substring(flagCode.lastIndexOf("(") + 1, flagCode.lastIndexOf(")"));
                //Flag flag = flagDao.getByCode(flagCode);
                CellReference vesselTypeCell = new CellReference("F" + i);
                String vesselType = StringUtil.trim(sheet.getRow(vesselTypeCell.getRow()).getCell(vesselTypeCell.getCol()).getRichStringCellValue().getString());
                VesselSubType subType = VesselSubType.createFromDesc(vesselType);

                CellReference startDateCell = new CellReference("L" + i);
                CellReference endDateCell = new CellReference("M" + i);
                CellReference signOffReasonCell = new CellReference("O" + i);

                Experience emp = new Experience();
                emp.setEmployerName(sheet.getRow(empNameCell.getRow()).getCell(empNameCell.getCol()).getRichStringCellValue().getString());
                emp.setVesselName(sheet.getRow(vesselNameCell.getRow()).getCell(vesselNameCell.getCol()).getRichStringCellValue().getString());
                emp.setFlagCode(flagCode);
                emp.setVesselSubType(subType);
                emp.setLastRank(Rank.createFromDesc(sheet.getRow(rankCell.getRow()).getCell(rankCell.getCol()).getRichStringCellValue().getString()));
                emp.setStartDate(DateTimeUtil.convertToLocalDate(sheet.getRow(startDateCell.getRow()).getCell(startDateCell.getCol()).getDateCellValue()));
                emp.setEndDate(DateTimeUtil.convertToLocalDate(sheet.getRow(endDateCell.getRow()).getCell(endDateCell.getCol()).getDateCellValue()));
                String signOffReason = sheet.getRow(signOffReasonCell.getRow()).getCell(signOffReasonCell.getCol()).getRichStringCellValue().getString();
                if (StringUtil.isNotEmpty(signOffReason)) {
                    emp.setReasonForSingOff(Experience.ReasonForSingOff.createFromDesc(sheet.getRow(signOffReasonCell.getRow()).getCell(signOffReasonCell.getCol()).getRichStringCellValue().getString()));
                }
                employment.add(emp);

              /*  ExperienceLetter cert = new ExperienceLetter();
                cert.setDocType(DocumentType.);
                cert.setStartDate(edu.getStartDate());
                cert.setEndDate(edu.getEndDate());
                cert.setDocType(dt);
                crewDocsToPopulate.add(cert);*/
            }

        }
        crew.setEmploymentHistory(employment);
    }

    private void populatePassportVisa(Sheet sheet, Crew crew, List<CrewDocument> crewDocsToPopulate) {
        for (int i = 34; i <= 37; i++) {
            CellReference docTypeCell = new CellReference("B" + i);

            String docTypeStr = sheet.getRow(docTypeCell.getRow()).getCell(docTypeCell.getCol()).getRichStringCellValue().getString();
            if (StringUtil.isNotEmpty(docTypeStr)) {
                CellReference numCell = new CellReference("E" + i);
                String docNum = sheet.getRow(numCell.getRow()).getCell(numCell.getCol()).getRichStringCellValue().getString();

                if (StringUtil.isNotEmpty(docNum)) {
                    CellReference doICell = new CellReference("H" + i);
                    CellReference poICell = new CellReference("L" + i);
                    CellReference doECell = new CellReference("O" + i);
                    CellReference blankCell = new CellReference("R" + i);
                    CellReference ecnrCell = new CellReference("T" + i);

                    Date doiVal = sheet.getRow(doICell.getRow()).getCell(doICell.getCol()).getDateCellValue();
                    Date doeVal = sheet.getRow(doECell.getRow()).getCell(doECell.getCol()).getDateCellValue();
                    LocalDate doi = doiVal != null ? DateTimeUtil.convertToLocalDate(doiVal) : null;
                    LocalDate doe = doeVal != null ? DateTimeUtil.convertToLocalDate(doeVal) : null;
                    String placeOfIssue = sheet.getRow(poICell.getRow()).getCell(poICell.getCol()).getRichStringCellValue().getString();

                    if (docTypeStr.equalsIgnoreCase("Passport")) {
                        DocumentType dt = docTypeDao.findByName("Indian Passport");
                        Passport passport = new Passport();
                        passport.setDocType(dt);
                        passport.setDateOfExpiry(doe);
                        passport.setDocNumber(docNum);
                        passport.setDateOfIssue(doi);
                        passport.setDateOfExpiry(doe);
                        passport.setPlaceOfIssue(placeOfIssue);
                        passport.setRequiredECNR(StringUtil.parseBoolean(sheet.getRow(ecnrCell.getRow()).getCell(ecnrCell.getCol()).getRichStringCellValue().getString()));
                        passport.setBlankPages((int) sheet.getRow(blankCell.getRow()).getCell(blankCell.getCol()).getNumericCellValue());
                        crewDocsToPopulate.add(passport);
                        crew.setPassportNumber(docNum);
                    } else if (docTypeStr.equalsIgnoreCase("US Visa C1/D")) {
                        DocumentType dt = docTypeDao.findByName("US C1/D");
                        Visa visa = new Visa();
                        visa.setDocType(dt);
                        visa.setDocNumber(docNum);
                        visa.setDateOfIssue(doi);
                        visa.setDateOfExpiry(doe);
                        visa.setPlaceOfIssue(placeOfIssue);
                        crewDocsToPopulate.add(visa);
                    } else if (docTypeStr.equalsIgnoreCase("US Visa B1/B2")) {
                        DocumentType dt = docTypeDao.findByName("US B1/B2");
                        Visa visa = new Visa();
                        visa.setDocType(dt);
                        visa.setDocNumber(docNum);
                        visa.setDateOfIssue(doi);
                        visa.setDateOfExpiry(doe);
                        visa.setPlaceOfIssue(placeOfIssue);
                        crewDocsToPopulate.add(visa);
                    } else if (docTypeStr.equalsIgnoreCase("Australian MCV")) {
                        DocumentType dt = docTypeDao.findByName("Australian MCV");
                        Visa visa = new Visa();
                        visa.setDocType(dt);
                        visa.setDocNumber(docNum);
                        visa.setDateOfIssue(doi);
                        visa.setDateOfExpiry(doe);
                        visa.setPlaceOfIssue(placeOfIssue);
                        crewDocsToPopulate.add(visa);
                    }
                }
            }

        }
    }

    private void populateCDC(Sheet sheet, Crew crew, List<CrewDocument> crewDocsToPopulate) {
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
            } else {
                System.out.println("Cell is empty");
            }
            String docNum = sheet.getRow(numCell.getRow()).getCell(numCell.getCol()).getRichStringCellValue().getString();

            String docTypeStr = sheet.getRow(docTypeCell.getRow()).getCell(docTypeCell.getCol()).getRichStringCellValue().getString();

            Date doiVal = sheet.getRow(doICell.getRow()).getCell(doICell.getCol()).getDateCellValue();
            Date doeVal = sheet.getRow(doECell.getRow()).getCell(doECell.getCol()).getDateCellValue();
            LocalDate doi = doiVal != null ? DateTimeUtil.convertToLocalDate(doiVal) : null;
            LocalDate doe = doeVal != null ? DateTimeUtil.convertToLocalDate(doeVal) : null;
            String placeOfIssue = sheet.getRow(poICell.getRow()).getCell(poICell.getCol()).getRichStringCellValue().getString();

            String remarks = sheet.getRow(remarksCell.getRow()).getCell(remarksCell.getCol()).getRichStringCellValue().getString();

            if (docTypeStr.equalsIgnoreCase("Indian")) {
                DocumentType dt = docTypeDao.findByName("Indian CDC");
                CDC cdc = new CDC();
                cdc.setDateOfExpiry(doe);
                cdc.setDocType(dt);
                cdc.setDocNumber(docNum);
                cdc.setDateOfIssue(doi);
                cdc.setDateOfExpiry(doe);
                cdc.setPlaceOfIssue(placeOfIssue);
                cdc.setRemarks(remarks);
                crew.setIndianCDCNumber(docNum);
                crewDocsToPopulate.add(cdc);
            } else if (docTypeStr.equalsIgnoreCase("Liberian")) {
                DocumentType dt = docTypeDao.findByName("Liberian CDC");
                CDC cdc = new CDC();
                cdc.setDateOfExpiry(doe);
                cdc.setDocType(dt);
                cdc.setDocNumber(docNum);
                cdc.setDateOfIssue(doi);
                cdc.setDateOfExpiry(doe);
                cdc.setPlaceOfIssue(placeOfIssue);
                cdc.setRemarks(remarks);
                crewDocsToPopulate.add(cdc);
            } else if (docTypeStr.equalsIgnoreCase("Panama")) {
                DocumentType dt = docTypeDao.findByName("Panama CDC");
                CDC cdc = new CDC();
                cdc.setDocType(dt);
                cdc.setDateOfExpiry(doe);
                cdc.setDocNumber(docNum);
                cdc.setDateOfIssue(doi);
                cdc.setDateOfExpiry(doe);
                cdc.setPlaceOfIssue(placeOfIssue);
                cdc.setRemarks(remarks);
                crewDocsToPopulate.add(cdc);
            } else if (docTypeStr.equalsIgnoreCase("Others")) {
                DocumentType dt = docTypeDao.findByName("Other CDC");
                CDC cdc = new CDC();
                cdc.setDocType(dt);
                cdc.setDateOfExpiry(doe);
                cdc.setDocNumber(docNum);
                cdc.setDateOfIssue(doi);
                cdc.setDateOfExpiry(doe);
                cdc.setPlaceOfIssue(placeOfIssue);
                cdc.setRemarks(remarks);
                crewDocsToPopulate.add(cdc);
            } else if (docTypeStr.equalsIgnoreCase("INDOS")) {
                DocumentType dt = docTypeDao.findByName("INDOS");
                CDC cdc = new CDC();
                cdc.setDocType(dt);
                cdc.setDateOfExpiry(doe);
                cdc.setDocNumber(docNum);
                cdc.setDateOfIssue(doi);
                cdc.setDateOfExpiry(doe);
                cdc.setPlaceOfIssue(placeOfIssue);
                cdc.setRemarks(remarks);
                crewDocsToPopulate.add(cdc);
                crew.setIndosNumber(String.valueOf(docNum));
            } else if (docTypeStr.equalsIgnoreCase("Yellow Fever")) {
                DocumentType dt = docTypeDao.findByName("Yellow Fever");
                YellowFever cert = new YellowFever();
                cert.setDocType(dt);
                cert.setDateOfExpiry(doe);
                cert.setDocNumber(docNum);
                cert.setDateOfIssue(doi);
                cert.setDateOfExpiry(doe);
                cert.setPlaceOfIssue(placeOfIssue);
                cert.setRemarks(remarks);
                crewDocsToPopulate.add(cert);
            }
        }
    }

    private void populateNextOfKin(Sheet sheet, Crew crew, List<CrewDocument> crewDocsToPopulate) {
        CellReference civilStatusCell = new CellReference("D55");
        CellReference nokNameCell = new CellReference("D56");
        CellReference nokAddressCell = new CellReference("D57");
        CellReference nokRelationCell = new CellReference("O56");
        CellReference nokPinCodeCell = new CellReference("Q58");
        CellReference nokContactCell = new CellReference("N59");

        crew.setMaritalStatus(sheet.getRow(civilStatusCell.getRow()).getCell(civilStatusCell.getCol()).getRichStringCellValue().getString());
        String nokAddress = sheet.getRow(nokAddressCell.getRow()).getCell(nokAddressCell.getCol()).getRichStringCellValue().getString();
        //String nokPinCode = sheet.getRow(nokPinCodeCell.getRow()).getCell(nokPinCodeCell.getCol()).getRichStringCellValue().getString();
        String nokContact = sheet.getRow(nokContactCell.getRow()).getCell(nokContactCell.getCol()).getRichStringCellValue().getString();

        //NoK list
        List<NextOfKin> noks = new ArrayList<>();
        for (int i = 62; i <= 65; i++) {
            CellReference nameCell = new CellReference("C" + i);
            CellReference relationTypeCell = new CellReference("E" + i);
            CellReference dobCell = new CellReference("F" + i);
            CellReference passportCell = new CellReference("H" + i);
            CellReference doICell = new CellReference("K" + i);
            CellReference poICell = new CellReference("M" + i);
            CellReference doECell = new CellReference("O" + i);
            CellReference ecnrCell = new CellReference("Q" + i);
            CellReference hasUSVisaCell = new CellReference("S" + i);

            String name = sheet.getRow(nameCell.getRow()).getCell(nameCell.getCol()).getRichStringCellValue().getString();

            if (StringUtil.isNotEmpty(name)) {
                Date dobVal = sheet.getRow(dobCell.getRow()).getCell(dobCell.getCol()).getDateCellValue();
                Date doiVal = sheet.getRow(doICell.getRow()).getCell(doICell.getCol()).getDateCellValue();
                Date doeVal = sheet.getRow(doECell.getRow()).getCell(doECell.getCol()).getDateCellValue();
                String placeOfIssue = sheet.getRow(poICell.getRow()).getCell(poICell.getCol()).getRichStringCellValue().getString();
                String passportNum = sheet.getRow(passportCell.getRow()).getCell(passportCell.getCol()).getRichStringCellValue().getString();
                String relationTypeName = sheet.getRow(relationTypeCell.getRow()).getCell(relationTypeCell.getCol()).getRichStringCellValue().getString();
                boolean isECNR = StringUtil.parseBoolean(sheet.getRow(ecnrCell.getRow()).getCell(ecnrCell.getCol()).getRichStringCellValue().getString());
                boolean hasUSVisa = StringUtil.parseBoolean(sheet.getRow(hasUSVisaCell.getRow()).getCell(hasUSVisaCell.getCol()).getRichStringCellValue().getString());
                LocalDate dob = DateTimeUtil.convertToLocalDate(dobVal);
                LocalDate doi = DateTimeUtil.convertToLocalDate(doiVal);
                LocalDate doe = DateTimeUtil.convertToLocalDate(doeVal);

                NextOfKin nok = new NextOfKin();
                nok.setRelationType(relationTypeName);
                nok.setNomineeName(name);
                nok.setDateOfBirth(dob);
                nok.setAddress(nokAddress);
                nok.setHasUSVisa(hasUSVisa);

                Passport nokPassport = new Passport();
                nokPassport.setDocNumber(passportNum);
                nokPassport.setGivenName(name);
                nokPassport.setRequiredECNR(isECNR);
                nokPassport.setDateOfExpiry(doe);
                nokPassport.setAddress(nokAddress);
                nokPassport.setDateOfIssue(doi);
                nokPassport.setPlaceOfIssue(placeOfIssue);
                nok.setPassport(nokPassport);

                noks.add(nok);
            }
        }
        crew.setNextOfKins(noks);
    }

    private void populateLicence(Sheet sheet, Crew crew, List<CrewDocument> crewDocsToPopulate) {

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
            LocalDate doi = doiVal != null ? DateTimeUtil.convertToLocalDate(doiVal) : null;
            LocalDate doe = doeVal != null ? DateTimeUtil.convertToLocalDate(doeVal) : null;
            String placeOfIssue = sheet.getRow(poICell.getRow()).getCell(poICell.getCol()).getRichStringCellValue().getString();
            String docNum = String.valueOf(sheet.getRow(numCell.getRow()).getCell(numCell.getCol()).getNumericCellValue());
            String grade = sheet.getRow(gradeCell.getRow()).getCell(gradeCell.getCol()).getRichStringCellValue().getString();

            if (docTypeStr.equalsIgnoreCase("Indian")) {
                DocumentType dt = docTypeDao.findByName("Indian License");
                License lic = new License();
                lic.setDocType(dt);
                lic.setDateOfExpiry(doe);
                lic.setDocNumber(docNum);
                lic.setDateOfIssue(doi);
                lic.setDateOfExpiry(doe);
                lic.setPlaceOfIssue(placeOfIssue);
                lic.setGrade(grade);
                crewDocsToPopulate.add(lic);
            } else if (docTypeStr.equalsIgnoreCase("Liberian")) {
                DocumentType dt = docTypeDao.findByName("Liberian License");
                License lic = new License();
                lic.setDocType(dt);
                lic.setDateOfExpiry(doe);
                lic.setDocNumber(docNum);
                lic.setDateOfIssue(doi);
                lic.setDateOfExpiry(doe);
                lic.setPlaceOfIssue(placeOfIssue);
                lic.setGrade(grade);
                crewDocsToPopulate.add(lic);
            } else if (docTypeStr.equalsIgnoreCase("Panama")) {
                DocumentType dt = docTypeDao.findByName("Panama License");
                License lic = new License();
                lic.setDocType(dt);
                lic.setDateOfExpiry(doe);
                lic.setDocNumber(docNum);
                lic.setDateOfIssue(doi);
                lic.setDateOfExpiry(doe);
                lic.setPlaceOfIssue(placeOfIssue);
                lic.setGrade(grade);
                crewDocsToPopulate.add(lic);
            } else if (docTypeStr.equalsIgnoreCase("UK")) {
                DocumentType dt = docTypeDao.findByName("UK License");
                License lic = new License();
                lic.setDocType(dt);
                lic.setDateOfExpiry(doe);
                lic.setDocNumber(docNum);
                lic.setDateOfIssue(doi);
                lic.setDateOfExpiry(doe);
                lic.setPlaceOfIssue(placeOfIssue);
                lic.setGrade(grade);
                crewDocsToPopulate.add(lic);
            } else if (docTypeStr.equalsIgnoreCase("Singapore")) {
                DocumentType dt = docTypeDao.findByName("Singapore License");
                License lic = new License();
                lic.setDocType(dt);
                lic.setDateOfExpiry(doe);
                lic.setDocNumber(docNum);
                lic.setDateOfIssue(doi);
                lic.setDateOfExpiry(doe);
                lic.setPlaceOfIssue(placeOfIssue);
                lic.setGrade(grade);
                crewDocsToPopulate.add(lic);
            } else if (docTypeStr.equalsIgnoreCase("Others")) {
                DocumentType dt = docTypeDao.findByName("Other License");
                License lic = new License();
                lic.setDocType(dt);
                lic.setDateOfExpiry(doe);
                lic.setDocNumber(docNum);
                lic.setDateOfIssue(doi);
                lic.setDateOfExpiry(doe);
                lic.setPlaceOfIssue(placeOfIssue);
                lic.setGrade(grade);
                crewDocsToPopulate.add(lic);
            }
        }
    }
}
