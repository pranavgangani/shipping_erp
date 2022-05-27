package com.intuitbrains.crew;

import com.intuitbrains.dao.common.CrewDocumentRepository;
import com.intuitbrains.dao.common.DocumentTypeRepository;
import com.intuitbrains.dao.common.FlagRepository;
import com.intuitbrains.dao.crew.CrewRepository;
import com.intuitbrains.main.CrewManagementApplication;
import com.intuitbrains.model.common.document.*;
import com.intuitbrains.model.crew.CrewDocument;
import com.intuitbrains.model.common.document.category.DocumentType;
import com.intuitbrains.model.crew.*;
import com.intuitbrains.service.crew.CrewExcelService;
import com.intuitbrains.service.crew.CrewService;
import com.intuitbrains.util.DateTimeUtil;
import com.intuitbrains.util.StringUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddressList;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFDataValidationHelper;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = CrewManagementApplication.class)
@AutoConfigureMockMvc
class ExcelReadTest {
    @Autowired
    private CrewDocumentRepository documentDao;
    @Autowired
    private DocumentTypeRepository docTypeDao;
    @Autowired
    private CrewRepository crewDao;
    @Autowired
    private FlagRepository flagDao;
    @Autowired
    private CrewService crewService;

    @Test
    public void readFromExcel() {
        try {
            FileInputStream file = new FileInputStream("D:\\shipping_erp\\Pranav.xlsx");
            crewService.uploadCrewData("IND001",file);
        } catch (IOException e) {
            e.printStackTrace();
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


    @Test
    public void generateExcelTemplateForNewRecruit() {
        //some data
        String[] deckDeptRanks = Rank.getDeckDeptList().stream().map(Rank::getName).collect(Collectors.toList()).toArray(new String[Rank.getDeckDeptList().size()]);
        String[] engineDeptRanks = Rank.getEngineDeptList().stream().map(Rank::getName).collect(Collectors.toList()).toArray(new String[Rank.getEngineDeptList().size()]);
        String[] galleyDeptRanks = Rank.getGalleyDeptList().stream().map(Rank::getName).collect(Collectors.toList()).toArray(new String[Rank.getGalleyDeptList().size()]);

        Workbook wb = new XSSFWorkbook();

        //hidden sheet for list values
        XSSFSheet sheet = (XSSFSheet) wb.createSheet("Sheet 1");

        int rowNum = 0;
        Row rankSelectRow = sheet.createRow(rowNum++);
        Cell cell = rankSelectRow.createCell(0);
        cell.setCellValue("Applied for Rank");

        DataValidation dataValidation = null;
        DataValidationConstraint constraint = null;
        DataValidationHelper validationHelper = null;

        validationHelper = new XSSFDataValidationHelper(sheet);
        CellRangeAddressList addressList = new CellRangeAddressList(1, 1, 0, 0);
        constraint = validationHelper.createExplicitListConstraint(deckDeptRanks);
        dataValidation = validationHelper.createValidation(constraint, addressList);
        dataValidation.setSuppressDropDownArrow(true);
        sheet.addValidationData(dataValidation);

        //Finally, let's write the content to a “temp.xlsx” file in the current directory and close the workbook:
        File currDir = new File(".");
        String path = currDir.getAbsolutePath();
        String fileLocation = path.substring(0, path.length() - 1) + "temp.xlsx";

        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(fileLocation);
            wb.write(outputStream);
            wb.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
