package com.intuitbrains.service.common;

import com.intuitbrains.model.common.document.CheckList;
import com.intuitbrains.model.common.document.Contract;
import com.intuitbrains.model.common.document.Declaration;
import com.intuitbrains.model.common.document.category.Document;
import com.intuitbrains.model.common.document.category.DocumentCategory;
import com.intuitbrains.model.crew.Crew;
import com.intuitbrains.model.crew.contract.CrewContract;
import com.intuitbrains.model.crew.NextOfKin;
import com.intuitbrains.model.vessel.Vessel;
import com.intuitbrains.util.ListUtil;
import org.apache.poi.xwpf.usermodel.*;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.util.LinkedList;
import java.util.List;

public class ContractDocumentGenerator {
    public static String logo = "logo-leaf.png";
    public static String output = "contract.docx";

    private Crew crew;
    private Vessel vessel;
    private CrewContract contract;
    private List<Document> contractDocuments;

    public ContractDocumentGenerator(Crew crew, Vessel vessel, CrewContract contract) {
        this.crew = crew;
        this.vessel = vessel;
        this.contract = contract;
        contractDocuments = contract.getDocuments();
        if (contractDocuments == null) {
            contractDocuments = new LinkedList<>();
        }
    }

    public void generate() throws Exception {
        generateContrat();
        generateCheckList();// Can capture from <CrewDocuments>
        generateSeafarerBriefing();
        generateDocsHandedOver();
        generateAlcoholDrugsDeclaration();
        generateDeclarationAgainstUseOfObjectionableMaterials();
        generateNextKinDeclaration(); // Can capture values from <NextOfKin>
        generateSignOnDeclaration();
        generateSignOnHealthDeclaration();
        generateSignOnPerformanceGoals();
        generateTravelHistorySelfDeclaration();
        contract.setDocuments(contractDocuments);
    }

    private static void setRun(XWPFRun run, String fontFamily, int fontSize, String colorRGB, String text, boolean bold,
                               boolean addBreak) {
        run.setFontFamily(fontFamily);
        run.setFontSize(fontSize);
        run.setColor(colorRGB);
        run.setText(text);
        run.setBold(bold);
        if (addBreak)
            run.addBreak();
    }

    private void generateContrat() {
        final String fileName = "1_Contract.docx";
        try (FileOutputStream out = new FileOutputStream(fileName)) {
            XWPFDocument document = new XWPFDocument();


            XWPFParagraph title = document.createParagraph();
            title.setAlignment(ParagraphAlignment.CENTER);
            setRun(title.createRun(), "Calibre LIght", 12, "2b5079", "(CONTRACT OF MARITIME EMPLOYMENT)", false, false);

            // Creating Table
            XWPFTable tab = document.createTable();
            XWPFTableRow row = tab.getRow(0); // 1st row
            row.addNewTableCell();
//--------------------------------
            row = tab.createRow(); // 2nd Row
            XWPFParagraph paragraph = row.getCell(0).addParagraph();
            setRun(paragraph.createRun(), "Calibre LIght", 10, "2b5079", "(Name & registered address of the employer)",
                    true, false);
            row.getCell(1).setText("SAAR, Maritime Corporation, Regd. Address: Kerala, INDIA.");

            row = tab.createRow(); // 3rd Row
            paragraph = row.getCell(0).addParagraph();
            setRun(paragraph.createRun(), "Calibre LIght", 10, "2b5079", "(Full name & address of Seafarer)", true,
                    false);
            row.getCell(1).setText("Rohan P Tiwari\n\n211 Renuka Soc.,Rd.22, Kisan Nagar, Wagle Estate, Thane, INDIA");
//--------------------------------
            row = tab.createRow(); // 4rd Row
            paragraph = row.getCell(0).addParagraph();
            setRun(paragraph.createRun(), "Calibre LIght", 10, "2b5079", "(Date of Birth)", true, false);
            row.getCell(0).setText("20-Nov-1985");

            paragraph = row.getCell(1).addParagraph();
            setRun(paragraph.createRun(), "Calibre LIght", 10, "2b5079", "(Place of Birth)", true, false);
            row.getCell(1).setText("Mumbai");
//--------------------------------
            row = tab.createRow(); // 5th Row
            paragraph = row.getCell(0).addParagraph();
            setRun(paragraph.createRun(), "Calibre LIght", 10, "2b5079", "(Nationality)", true, false);
            row.getCell(0).setText("India");

            paragraph = row.getCell(1).addParagraph();
            setRun(paragraph.createRun(), "Calibre LIght", 10, "2b5079", "(Passport/Expiry)", true, false);
            row.getCell(1).setText("Z324324/18-Dec-2022");
//--------------------------------
            row = tab.createRow(); // 6th Row
            paragraph = row.getCell(0).addParagraph();
            setRun(paragraph.createRun(), "Calibre LIght", 10, "2b5079", "(Vessel)", true, false);
            row.getCell(0).setText(vessel.getVesselName());

            paragraph = row.getCell(1).addParagraph();
            setRun(paragraph.createRun(), "Calibre LIght", 10, "2b5079", "(Home Port)", true, false);
            row.getCell(1).setText("Thuishaven");
//--------------------------------
            row = tab.createRow(); // 6th Row
            paragraph = row.getCell(0).addParagraph();
            setRun(paragraph.createRun(), "Calibre LIght", 10, "2b5079", "(IMO Number)", true, false);
            row.getCell(0).setText("Chattogram");

            paragraph = row.getCell(1).addParagraph();
            setRun(paragraph.createRun(), "Calibre LIght", 10, "2b5079", "(Seaman Book)", true, false);
            row.getCell(1).setText("CH 52205");
//--------------------------------
            row = tab.createRow(); // 6th Row
            paragraph = row.getCell(0).addParagraph();
            setRun(paragraph.createRun(), "Calibre LIght", 10, "2b5079", "(Rank)", true, false);
            row.getCell(0).setText(crew.getRank().getName());

            paragraph = row.getCell(1).addParagraph();
            setRun(paragraph.createRun(), "Calibre LIght", 10, "2b5079", "(Next of Kin)", true, false);
            row.getCell(1).setText("Vrushali Tiwari - 211 Renuka SOc., Kisan Nagar, Wagle Estate, 400604.");
//--------------------------------
            row = tab.createRow(); // 3rd Row
            paragraph = row.getCell(0).addParagraph();
            setRun(paragraph.createRun(), "Calibre LIght", 10, "2b5079", "(Monthly wages)", true, false);
            row.getCell(1).setText("$ 15000");
//--------------------------------
            row = tab.createRow(); // th Row
            paragraph = row.getCell(0).addParagraph();
            setRun(paragraph.createRun(), "Calibre LIght", 10, "2b5079", "(Date Begin)", true, false);
            row.getCell(1).setText("02-Jun-2021");

            row = tab.createRow(); // th Row
            paragraph = row.getCell(0).addParagraph();
            setRun(paragraph.createRun(), "Calibre LIght", 10, "2b5079", "(Signature of Seafarer)", true, false);
            paragraph = row.getCell(1).addParagraph();
            setRun(paragraph.createRun(), "Calibre LIght", 10, "2b5079", "(Signature of Employer)", true, false);
//--------------------------------
            row = tab.createRow(); // th Row
            paragraph = row.getCell(0).addParagraph();
            setRun(paragraph.createRun(), "Calibre LIght", 10, "2b5079", "(Signature of Crew Manager)", true, false);
            paragraph = row.getCell(1).addParagraph();
            setRun(paragraph.createRun(), "Calibre LIght", 10, "2b5079", "(Signature of Ship Owner)", true, false);

            document.write(out);

            // Save file to contract documents
            Contract contract = new Contract();
            contract.setDocumentCategory(DocumentCategory.EMPLOYMENT);
            contract.setFileTitle(fileName);
            contract.setFile(new Binary(BsonBinarySubType.BINARY, Files.readAllBytes(new File(fileName).toPath())));
            contractDocuments.add(contract);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void generateCheckList() {
        final String fileName = "2_Checklist.docx";
        try (FileOutputStream out = new FileOutputStream(fileName)) {
            XWPFDocument document = new XWPFDocument();

            // Creating Table
            XWPFTable tab = document.createTable();
            XWPFTableRow row = tab.getRow(0); // First row
            // Columns
            row.getCell(0).setText("Sl. No.");
            row.addNewTableCell().setText("Name");
            row.addNewTableCell().setText("Email");
            row = tab.createRow(); // Second Row
            row.getCell(0).setText("1.");
            row.getCell(1).setText("Irfan");
            row.getCell(2).setText("irfan@gmail.com");
            row = tab.createRow(); // Third Row
            row.getCell(0).setText("2.");
            row.getCell(1).setText("Mohan");
            row.getCell(2).setText("mohan@gmail.com");
            document.write(out);

            // Save file to contract documents
            CheckList checkList = new CheckList();
            checkList.setDocumentCategory(DocumentCategory.EMPLOYMENT);
            checkList.setFileTitle(fileName);
            checkList.setFile(new Binary(BsonBinarySubType.BINARY, Files.readAllBytes(new File(fileName).toPath())));
            contractDocuments.add(checkList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void generateSeafarerBriefing() {
        final String fileName = "3_Seafarer_Briefing.docx";
        try (FileOutputStream out = new FileOutputStream(fileName)) {
            XWPFDocument document = new XWPFDocument();

            // Creating Table
            XWPFTable tab = document.createTable();
            XWPFTableRow row = tab.getRow(0); // First row
            // Columns
            row.getCell(0).setText("Sl. No.");
            row.addNewTableCell().setText("Name");
            row.addNewTableCell().setText("Email");
            row = tab.createRow(); // Second Row
            row.getCell(0).setText("1.");
            row.getCell(1).setText("Irfan");
            row.getCell(2).setText("irfan@gmail.com");
            row = tab.createRow(); // Third Row
            row.getCell(0).setText("2.");
            row.getCell(1).setText("Mohan");
            row.getCell(2).setText("mohan@gmail.com");
            document.write(out);

            // Save file to contract documents
            CheckList checkList = new CheckList();
            checkList.setDocumentCategory(DocumentCategory.EMPLOYMENT);
            checkList.setFileTitle(fileName);
            checkList.setFile(new Binary(BsonBinarySubType.BINARY, Files.readAllBytes(new File(fileName).toPath())));
            contractDocuments.add(checkList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void generateDocsHandedOver() {
        final String fileName = "4_Docs_Handed_Over.docx";
        try (FileOutputStream out = new FileOutputStream(fileName)) {
            XWPFDocument document = new XWPFDocument();

            // Creating Table
            XWPFTable tab = document.createTable();
            XWPFTableRow row = tab.getRow(0); // First row
            // Columns
            row.getCell(0).setText("Sl. No.");
            row.addNewTableCell().setText("Name");
            row.addNewTableCell().setText("Email");
            row = tab.createRow(); // Second Row
            row.getCell(0).setText("1.");
            row.getCell(1).setText("Irfan");
            row.getCell(2).setText("irfan@gmail.com");
            row = tab.createRow(); // Third Row
            row.getCell(0).setText("2.");
            row.getCell(1).setText("Mohan");
            row.getCell(2).setText("mohan@gmail.com");
            document.write(out);

            // Save file to contract documents
            CheckList checkList = new CheckList();
            checkList.setDocumentCategory(DocumentCategory.EMPLOYMENT);
            checkList.setFileTitle(fileName);
            checkList.setFile(new Binary(BsonBinarySubType.BINARY, Files.readAllBytes(new File(fileName).toPath())));
            contractDocuments.add(checkList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void generateAlcoholDrugsDeclaration() {
        final String fileName = "5_Alcohol_Drugs_Declaration.docx";
        try (FileOutputStream out = new FileOutputStream(fileName)) {
            XWPFDocument document = new XWPFDocument();

            // Creating Table
            XWPFTable tab = document.createTable();
            XWPFTableRow row = tab.getRow(0); // First row
            // Columns
            row.getCell(0).setText("Sl. No.");
            row.addNewTableCell().setText("Name");
            row.addNewTableCell().setText("Email");
            row = tab.createRow(); // Second Row
            row.getCell(0).setText("1.");
            row.getCell(1).setText("Irfan");
            row.getCell(2).setText("irfan@gmail.com");
            row = tab.createRow(); // Third Row
            row.getCell(0).setText("2.");
            row.getCell(1).setText("Mohan");
            row.getCell(2).setText("mohan@gmail.com");
            document.write(out);

            // Save file to contract documents
            Declaration declaration = new Declaration();
            declaration.setDocumentCategory(DocumentCategory.EMPLOYMENT);
            declaration.setFileTitle(fileName);
            declaration.setFile(new Binary(BsonBinarySubType.BINARY, Files.readAllBytes(new File(fileName).toPath())));
            contractDocuments.add(declaration);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void generateDeclarationAgainstUseOfObjectionableMaterials() {
        final String fileName = "6_Declaration_Against_Use_of_Objectionable_Materials.docx";
        try (FileOutputStream out = new FileOutputStream(fileName)) {
            XWPFDocument document = new XWPFDocument();

            // Creating Table
            XWPFTable tab = document.createTable();
            XWPFTableRow row = tab.getRow(0); // First row
            // Columns
            row.getCell(0).setText("Sl. No.");
            row.addNewTableCell().setText("Name");
            row.addNewTableCell().setText("Email");
            row = tab.createRow(); // Second Row
            row.getCell(0).setText("1.");
            row.getCell(1).setText("Irfan");
            row.getCell(2).setText("irfan@gmail.com");
            row = tab.createRow(); // Third Row
            row.getCell(0).setText("2.");
            row.getCell(1).setText("Mohan");
            row.getCell(2).setText("mohan@gmail.com");
            document.write(out);

            // Save file to contract documents
            Declaration declaration = new Declaration();
            declaration.setDocumentCategory(DocumentCategory.EMPLOYMENT);
            declaration.setFileTitle(fileName);
            declaration.setFile(new Binary(BsonBinarySubType.BINARY, Files.readAllBytes(new File(fileName).toPath())));
            contractDocuments.add(declaration);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void generateNextKinDeclaration() {

        List<NextOfKin> noks = crew.getNextOfKins();

        final String fileName = "7_Next_Kin_Declaration.docx";
        try (FileOutputStream out = new FileOutputStream(fileName)) {
            XWPFDocument document = new XWPFDocument();

            // Creating Table
            XWPFTable tab = document.createTable();
            XWPFTableRow row = tab.getRow(0); // First row
            // Columns
            row.getCell(0).setText("Sl. No.");
            row.addNewTableCell().setText("Name");
            row.addNewTableCell().setText("DOB");
            row.addNewTableCell().setText("Gender");
            row.addNewTableCell().setText("Relation");
            row.addNewTableCell().setText("Address");
            row.addNewTableCell().setText("% Of Amount");

            if (ListUtil.isNotEmpty(noks)) {
                int i = 1;
                for (NextOfKin nok : noks) {
                    row = tab.createRow(); // New Row
                    row.getCell(0).setText(i + ".");
                    row.getCell(1).setText(nok.getNomineeName());
                    row.getCell(2).setText(nok.getDateOfBirth());
                    row.getCell(3).setText(nok.getGender());
                    row.getCell(4).setText(nok.getRelationType());
                    row.getCell(5).setText(nok.getAddress());
                    row.getCell(6).setText(String.valueOf(nok.getPerOfAmount()));
                }
            }

            document.write(out);

            // Save file to contract documents
            Declaration declaration = new Declaration();
            declaration.setDocumentCategory(DocumentCategory.EMPLOYMENT);
            declaration.setFileTitle(fileName);
            declaration.setFile(new Binary(BsonBinarySubType.BINARY, Files.readAllBytes(new File(fileName).toPath())));
            contractDocuments.add(declaration);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void generateSignOnDeclaration() {
        final String fileName = "8_Sign_On_Declaration.docx";
        try (FileOutputStream out = new FileOutputStream(fileName)) {
            XWPFDocument document = new XWPFDocument();

            // Creating Table
            XWPFTable tab = document.createTable();
            XWPFTableRow row = tab.getRow(0); // First row
            // Columns
            row.getCell(0).setText("Sl. No.");
            row.addNewTableCell().setText("Name");
            row.addNewTableCell().setText("Email");
            row = tab.createRow(); // Second Row
            row.getCell(0).setText("1.");
            row.getCell(1).setText("Irfan");
            row.getCell(2).setText("irfan@gmail.com");
            row = tab.createRow(); // Third Row
            row.getCell(0).setText("2.");
            row.getCell(1).setText("Mohan");
            row.getCell(2).setText("mohan@gmail.com");
            document.write(out);

            // Save file to contract documents
            Declaration declaration = new Declaration();
            declaration.setDocumentCategory(DocumentCategory.EMPLOYMENT);
            declaration.setFileTitle(fileName);
            declaration.setFile(new Binary(BsonBinarySubType.BINARY, Files.readAllBytes(new File(fileName).toPath())));
            contractDocuments.add(declaration);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void generateSignOnHealthDeclaration() {
        final String fileName = "9_Sign_On_Health_Declaration.docx";
        try (FileOutputStream out = new FileOutputStream(fileName)) {
            XWPFDocument document = new XWPFDocument();

            // Creating Table
            XWPFTable tab = document.createTable();
            XWPFTableRow row = tab.getRow(0); // First row
            // Columns
            row.getCell(0).setText("Sl. No.");
            row.addNewTableCell().setText("Name");
            row.addNewTableCell().setText("Email");
            row = tab.createRow(); // Second Row
            row.getCell(0).setText("1.");
            row.getCell(1).setText("Irfan");
            row.getCell(2).setText("irfan@gmail.com");
            row = tab.createRow(); // Third Row
            row.getCell(0).setText("2.");
            row.getCell(1).setText("Mohan");
            row.getCell(2).setText("mohan@gmail.com");
            document.write(out);

            // Save file to contract documents
            Declaration declaration = new Declaration();
            declaration.setDocumentCategory(DocumentCategory.EMPLOYMENT);
            declaration.setFileTitle(fileName);
            declaration.setFile(new Binary(BsonBinarySubType.BINARY, Files.readAllBytes(new File(fileName).toPath())));
            contractDocuments.add(declaration);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void generateSignOnPerformanceGoals() {
        final String fileName = "10_Sign_On_Performance_Goals.docx";
        try (FileOutputStream out = new FileOutputStream(fileName)) {
            XWPFDocument document = new XWPFDocument();

            // Creating Table
            XWPFTable tab = document.createTable();
            XWPFTableRow row = tab.getRow(0); // First row
            // Columns
            row.getCell(0).setText("Sl. No.");
            row.addNewTableCell().setText("Name");
            row.addNewTableCell().setText("Email");
            row = tab.createRow(); // Second Row
            row.getCell(0).setText("1.");
            row.getCell(1).setText("Irfan");
            row.getCell(2).setText("irfan@gmail.com");
            row = tab.createRow(); // Third Row
            row.getCell(0).setText("2.");
            row.getCell(1).setText("Mohan");
            row.getCell(2).setText("mohan@gmail.com");
            document.write(out);

            // Save file to contract documents
            Declaration declaration = new Declaration();
            declaration.setDocumentCategory(DocumentCategory.EMPLOYMENT);
            declaration.setFileTitle(fileName);
            declaration.setFile(new Binary(BsonBinarySubType.BINARY, Files.readAllBytes(new File(fileName).toPath())));
            contractDocuments.add(declaration);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void generateTravelHistorySelfDeclaration() {
        final String fileName = "11_Travel_History_Self_Declaration.docx";
        try (FileOutputStream out = new FileOutputStream(fileName)) {
            XWPFDocument document = new XWPFDocument();
            // Creating Table
            XWPFTable tab = document.createTable();
            XWPFTableRow row = tab.getRow(0); // First row
            // Columns
            row.getCell(0).setText("Sl. No.");
            row.addNewTableCell().setText("Name");
            row.addNewTableCell().setText("Email");
            row = tab.createRow(); // Second Row
            row.getCell(0).setText("1.");
            row.getCell(1).setText("Irfan");
            row.getCell(2).setText("irfan@gmail.com");
            row = tab.createRow(); // Third Row
            row.getCell(0).setText("2.");
            row.getCell(1).setText("Mohan");
            row.getCell(2).setText("mohan@gmail.com");
            document.write(out);

            // Save file to contract documents
            Declaration declaration = new Declaration();
            declaration.setDocumentCategory(DocumentCategory.EMPLOYMENT);
            declaration.setFileTitle(fileName);
            declaration.setFile(new Binary(BsonBinarySubType.BINARY, Files.readAllBytes(new File(fileName).toPath())));
            contractDocuments.add(declaration);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
