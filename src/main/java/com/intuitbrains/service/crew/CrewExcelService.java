package com.intuitbrains.service.crew;

import com.intuitbrains.dao.common.CrewDocumentRepository;
import com.intuitbrains.dao.common.DocumentTypeRepository;
import com.intuitbrains.model.common.document.category.Document;
import com.intuitbrains.model.crew.Crew;
import com.intuitbrains.util.DateTimeUtil;
import com.intuitbrains.util.StringUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CrewExcelService {
    @Autowired
    private CrewDocumentRepository documentDao;
    @Autowired
    private DocumentTypeRepository docTypeDao;

    public Crew upload(FileInputStream file) {
        Crew crew = new Crew();
        readFromExcel(file, crew);
        return crew;
    }


    private void readFromExcel(FileInputStream file, Crew crew) {
        final String fileLocation = "";
        try {
            List<Document> documents = new ArrayList<>();
            Workbook workbook = new HSSFWorkbook(file);
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


            //Get Documents
            List<Document> mandatoryDocList = documentDao.findAll();
            //Passport & Visa
            //      populatePassportVisa(sheet, mandatoryDocList, documents);
            //CDC
            //       populateCDC(sheet, mandatoryDocList, documents);
            //Licence
            //       populateLicence(sheet, mandatoryDocList, documents);
            //NoK
            //       populateNextOfKin(sheet, mandatoryDocList, documents);
            //Set docs
            crew.setExistingDocuments(documents);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
