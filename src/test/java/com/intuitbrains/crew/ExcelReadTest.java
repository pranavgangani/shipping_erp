package com.intuitbrains.crew;

import com.intuitbrains.dao.common.CrewDocumentRepository;
import com.intuitbrains.dao.common.DocumentTypeRepository;
import com.intuitbrains.model.common.document.*;
import com.intuitbrains.model.common.document.category.Document;
import com.intuitbrains.model.common.document.category.DocumentType;
import com.intuitbrains.model.crew.Crew;
import com.intuitbrains.util.DateTimeUtil;
import com.intuitbrains.util.StringUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class ExcelReadTest {
    @Autowired
    private CrewDocumentRepository documentDao;
    @Autowired
    private DocumentTypeRepository docTypeDao;

    @Test
    public void readFromExcel() {
        final String fileLocation = "";
        try {
            List<Document> documents = new ArrayList<>();
            FileInputStream file = new FileInputStream(new File("D:\\Projects\\New_Hires.xls"));
            Workbook workbook = new HSSFWorkbook(file);
            Crew crew = new Crew();
            //Next, let's retrieve the first sheet of the file and iterate through each row:
            Sheet sheet = workbook.getSheetAt(0);
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
            crew.setfName(sheet.getRow(fNameCell.getRow()).getCell(fNameCell.getCol()).getRichStringCellValue().getString());
            crew.setmName(sheet.getRow(mNameCell.getRow()).getCell(mNameCell.getCol()).getRichStringCellValue().getString());
            crew.setlName(sheet.getRow(lNameCell.getRow()).getCell(lNameCell.getCol()).getRichStringCellValue().getString());
            crew.setNationality(sheet.getRow(nationalityCell.getRow()).getCell(nationalityCell.getCol()).getRichStringCellValue().getString());
            Date dob = sheet.getRow(dateOfBirthCell.getRow()).getCell(dateOfBirthCell.getCol()).getDateCellValue();
            crew.setDob(DateTimeUtil.convertToLocalDate(dob));

            //Vacancy details
            String postAppliedFor = sheet.getRow(postAppliedForCell.getRow()).getCell(postAppliedForCell.getCol()).getRichStringCellValue().getString();
            boolean isLowerRank = StringUtil.parseBoolean(sheet.getRow(isLowerRankCell.getRow()).getCell(isLowerRankCell.getCol()).getRichStringCellValue().getString());
            Date dateAvailableFrom = sheet.getRow(dateAvailableCell.getRow()).getCell(dateAvailableCell.getCol()).getDateCellValue();

            List<Document> mandatoryDocList = documentDao.findAll();

            //Passport & Visa
            populatePassportVisa(sheet, mandatoryDocList, documents);

            //CDC
            populateCDC(sheet, mandatoryDocList, documents);

            //Licence
            populateLicence(sheet, mandatoryDocList, documents);


            crew.setExistingDocuments(documents);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void populatePassportVisa(Sheet sheet, List<Document> mandatoryDocList, List<Document> crewDocsToPopulate) {
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
            LocalDateTime doi = DateTimeUtil.convertToLocalDateTime(doiVal);
            LocalDateTime doe = DateTimeUtil.convertToLocalDateTime(doeVal);
            String docTypeStr = sheet.getRow(docTypeCell.getRow()).getCell(docTypeCell.getCol()).getRichStringCellValue().getString();
            String placeOfIssue = sheet.getRow(poICell.getRow()).getCell(poICell.getCol()).getRichStringCellValue().getString();
            String docNum = sheet.getRow(numCell.getRow()).getCell(numCell.getCol()).getRichStringCellValue().getString();

            if (docTypeStr.equalsIgnoreCase("Passport")) {
                DocumentType dt = docTypeDao.findByName("Indian Passport");
                for (Document doc : mandatoryDocList) {
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
                        break;
                    }
                }
            } else if (docTypeStr.equalsIgnoreCase("US Visa C1/D")) {
                DocumentType dt = docTypeDao.findByName("US C1/D");
                for (Document doc : mandatoryDocList) {
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
                for (Document doc : mandatoryDocList) {
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
                for (Document doc : mandatoryDocList) {
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

    private void populateCDC(Sheet sheet, List<Document> mandatoryDocList, List<Document> crewDocsToPopulate) {
        //CDC
        for (int i = 40; i <= 45; i++) {
            CellReference docTypeCell = new CellReference("B" + i);
            CellReference numCell = new CellReference("E" + i);
            CellReference doICell = new CellReference("H" + i);
            CellReference poICell = new CellReference("L" + i);
            CellReference doECell = new CellReference("O" + i);
            CellReference remarksCell = new CellReference("R" + i);
            String docTypeStr = sheet.getRow(docTypeCell.getRow()).getCell(docTypeCell.getCol()).getRichStringCellValue().getString();

            Date doiVal = sheet.getRow(doICell.getRow()).getCell(doICell.getCol()).getDateCellValue();
            Date doeVal = sheet.getRow(doECell.getRow()).getCell(doECell.getCol()).getDateCellValue();
            LocalDateTime doi = DateTimeUtil.convertToLocalDateTime(doiVal);
            LocalDateTime doe = DateTimeUtil.convertToLocalDateTime(doeVal);
            String placeOfIssue = sheet.getRow(poICell.getRow()).getCell(poICell.getCol()).getRichStringCellValue().getString();
            String docNum = sheet.getRow(numCell.getRow()).getCell(numCell.getCol()).getRichStringCellValue().getString();
            String remarks = sheet.getRow(remarksCell.getRow()).getCell(remarksCell.getCol()).getRichStringCellValue().getString();

            if (docTypeStr.equalsIgnoreCase("Indian")) {
                DocumentType dt = docTypeDao.findByName("Indian CDC");
                for (Document doc : mandatoryDocList) {
                    if (doc.getDocName().equalsIgnoreCase(dt.getName()) && doc.getFlagCode().equalsIgnoreCase(dt.getFlagCode())) {
                        NationalID cdc = (NationalID) doc;
                        cdc.setDateOfExpiry(doe);
                        cdc.setDocNumber(docNum);
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
                for (Document doc : mandatoryDocList) {
                    if (doc.getDocName().equalsIgnoreCase(dt.getName()) && doc.getFlagCode().equalsIgnoreCase(dt.getFlagCode())) {
                        NationalID cdc = (NationalID) doc;
                        cdc.setDateOfExpiry(doe);
                        cdc.setDocNumber(docNum);
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
                for (Document doc : mandatoryDocList) {
                    if (doc.getDocName().equalsIgnoreCase(dt.getName()) && doc.getFlagCode().equalsIgnoreCase(dt.getFlagCode())) {
                        NationalID cdc = (NationalID) doc;
                        cdc.setDateOfExpiry(doe);
                        cdc.setDocNumber(docNum);
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
                for (Document doc : mandatoryDocList) {
                    if (doc.getDocName().equalsIgnoreCase(dt.getName()) && doc.getFlagCode().equalsIgnoreCase(dt.getFlagCode())) {
                        NationalID cdc = (NationalID) doc;
                        cdc.setDateOfExpiry(doe);
                        cdc.setDocNumber(docNum);
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
                for (Document doc : mandatoryDocList) {
                    if (doc.getDocName().equalsIgnoreCase(dt.getName()) && doc.getFlagCode().equalsIgnoreCase(dt.getFlagCode())) {
                        NationalID cdc = (NationalID) doc;
                        cdc.setDateOfExpiry(doe);
                        cdc.setDocNumber(docNum);
                        cdc.setDateOfIssue(doi);
                        cdc.setDateOfExpiry(doe);
                        cdc.setPlaceOfIssue(placeOfIssue);
                        cdc.setRemarks(remarks);
                        crewDocsToPopulate.add(cdc);
                        break;
                    }
                }
            } else if (docTypeStr.equalsIgnoreCase("Yellow Fever")) {
                DocumentType dt = docTypeDao.findByName("Yellow Fever");
                for (Document doc : mandatoryDocList) {
                    if (doc.getDocName().equalsIgnoreCase(dt.getName()) && doc.getFlagCode().equalsIgnoreCase(dt.getFlagCode())) {
                        Certificate cert = (Certificate) doc;
                        cert.setDateOfExpiry(doe);
                        cert.setDocNumber(docNum);
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

    private void populateLicence(Sheet sheet, List<Document> mandatoryDocList, List<Document> crewDocsToPopulate) {
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
            LocalDateTime doi = DateTimeUtil.convertToLocalDateTime(doiVal);
            LocalDateTime doe = DateTimeUtil.convertToLocalDateTime(doeVal);
            String placeOfIssue = sheet.getRow(poICell.getRow()).getCell(poICell.getCol()).getRichStringCellValue().getString();
            String docNum = sheet.getRow(numCell.getRow()).getCell(numCell.getCol()).getRichStringCellValue().getString();
            String grade = sheet.getRow(gradeCell.getRow()).getCell(gradeCell.getCol()).getRichStringCellValue().getString();

            if (docTypeStr.equalsIgnoreCase("Indian")) {
                DocumentType dt = docTypeDao.findByName("Indian License");
                for (Document doc : mandatoryDocList) {
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
                for (Document doc : mandatoryDocList) {
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
                for (Document doc : mandatoryDocList) {
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
                DocumentType dt = docTypeDao.findByName("UK License");
                for (Document doc : mandatoryDocList) {
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

    @Test
    public void writeToExcel() {
        //First, we will create and style a header row that contains “Name” and “Age” cells:
        Workbook workbook = new XSSFWorkbook();

        Sheet sheet = workbook.createSheet("Persons");
        sheet.setColumnWidth(0, 6000);
        sheet.setColumnWidth(1, 4000);

        Row header = sheet.createRow(0);

        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        XSSFFont font = ((XSSFWorkbook) workbook).createFont();
        font.setFontName("Arial");
        font.setFontHeightInPoints((short) 16);
        font.setBold(true);
        headerStyle.setFont(font);

        Cell headerCell = header.createCell(0);
        headerCell.setCellValue("Name");
        headerCell.setCellStyle(headerStyle);

        headerCell = header.createCell(1);
        headerCell.setCellValue("Age");
        headerCell.setCellStyle(headerStyle);

        //Next, let's write the content of the table with a different style:

        CellStyle style = workbook.createCellStyle();
        style.setWrapText(true);

        Row row = sheet.createRow(2);
        Cell cell = row.createCell(0);
        cell.setCellValue("John Smith");
        cell.setCellStyle(style);

        cell = row.createCell(1);
        cell.setCellValue(20);
        cell.setCellStyle(style);

        //Finally, let's write the content to a “temp.xlsx” file in the current directory and close the workbook:
        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        String fileLocation = path.substring(0, path.length() - 1) + "temp.xlsx";

        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(fileLocation);
            workbook.write(outputStream);
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
