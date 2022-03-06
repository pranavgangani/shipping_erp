package com.shipping.service.common;

import com.shipping.dao.crew.CrewContractRepository;
import com.shipping.dao.crew.CrewRepository;
import com.shipping.dao.vessel.VesselRepository;
import com.shipping.model.crew.Crew;
import com.shipping.model.crew.CrewContract;
import com.shipping.model.vessel.Vessel;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ContractDocumentGenerator {
    @Autowired
    private CrewRepository crewDao;
    @Autowired
    private VesselRepository vesselDao;
    @Autowired
    private CrewContractRepository crewContractDao;

    public static String logo = "logo-leaf.png";
    public static String output = "contract.docx";

    public void generate(Crew crew, Vessel vessel, CrewContract contract) throws Exception {
        XWPFDocument document = new XWPFDocument();

        XWPFParagraph title = document.createParagraph();
        title.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun titleRun = title.createRun();
        titleRun.setText("(CONTRACT OF MARITIME EMPLOYMENT)");
        titleRun.setColor("009933");
        titleRun.setBold(true);
        titleRun.setFontFamily("Courier");
        titleRun.setFontSize(20);

        XWPFParagraph subTitle = document.createParagraph();
        subTitle.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun subTitleRun = subTitle.createRun();
        subTitleRun.setText("(Name & registered address of the employer)");
        subTitleRun.setColor("00CC44");
        subTitleRun.setFontFamily("Courier");
        subTitleRun.setFontSize(16);
        subTitleRun.setTextPosition(20);
        subTitleRun.setUnderline(UnderlinePatterns.DOT_DOT_DASH);

        XWPFParagraph subTitle2 = document.createParagraph();
        subTitle2.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun subTitleRun2 = subTitle.createRun();
        subTitleRun2.setText("(Full name & address of Seafarer)");
        subTitleRun2.setColor("00CC44");
        subTitleRun2.setFontFamily("Courier");
        subTitleRun2.setFontSize(16);
        subTitleRun2.setTextPosition(20);
        subTitleRun2.setUnderline(UnderlinePatterns.DOT_DOT_DASH);

        XWPFParagraph image = document.createParagraph();
        image.setAlignment(ParagraphAlignment.CENTER);
        XWPFRun imageRun = image.createRun();
        imageRun.setTextPosition(20);
        Path imagePath = Paths.get(ClassLoader.getSystemResource(logo).toURI());
        imageRun.addPicture(Files.newInputStream(imagePath), XWPFDocument.PICTURE_TYPE_PNG, imagePath.getFileName().toString(), Units.toEMU(50), Units.toEMU(50));

        XWPFParagraph sectionTitle = document.createParagraph();
        XWPFRun sectionTRun = sectionTitle.createRun();
        sectionTRun.setText("What makes a good API?");
        sectionTRun.setColor("00CC44");
        sectionTRun.setBold(true);
        sectionTRun.setFontFamily("Courier");

        XWPFParagraph para1 = document.createParagraph();
        para1.setAlignment(ParagraphAlignment.BOTH);
        String string1 = "Text1";
        XWPFRun para1Run = para1.createRun();
        para1Run.setText(string1);

        XWPFParagraph para2 = document.createParagraph();
        para2.setAlignment(ParagraphAlignment.RIGHT);
        String string2 = "Text1";
        XWPFRun para2Run = para2.createRun();
        para2Run.setText(string2);
        para2Run.setItalic(true);

        XWPFParagraph para3 = document.createParagraph();
        para3.setAlignment(ParagraphAlignment.LEFT);
        String string3 = "Text1";
        XWPFRun para3Run = para3.createRun();
        para3Run.setText(string3);

        output = contract.getId() + "_" + output;
        FileOutputStream out = new FileOutputStream(output);
        document.write(out);
        out.close();
        document.close();
    }

}
