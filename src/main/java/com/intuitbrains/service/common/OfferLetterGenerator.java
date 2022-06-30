package com.intuitbrains.service.common;

import com.intuitbrains.dao.crew.ContractRuleRepository;
import com.intuitbrains.model.common.document.CheckList;
import com.intuitbrains.model.common.document.Contract;
import com.intuitbrains.model.common.document.Declaration;
import com.intuitbrains.model.common.document.OfferLetter;
import com.intuitbrains.model.company.compensation.Deduction;
import com.intuitbrains.model.company.compensation.Reimbursement;
import com.intuitbrains.model.company.compensation.Remuneration;
import com.intuitbrains.model.company.compensation.RemunerationType;
import com.intuitbrains.model.crew.*;
import com.intuitbrains.model.crew.contract.CrewContract;
import com.intuitbrains.model.vessel.Vessel;
import com.intuitbrains.util.ListUtil;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;
import org.apache.poi.xwpf.usermodel.*;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class OfferLetterGenerator {
    public static String logo = "logo-leaf.png";
    public static String output = "contract.docx";

    private Crew crew;
    private OfferLetter offerLetter;

    public OfferLetterGenerator(Crew crew, OfferLetter offerLetter) {
        this.crew = crew;
        this.offerLetter = offerLetter;
    }

    public void generate(String tempFilePath) throws JRException, IOException {
        String jasperFilePath = getClass().getResource("/jasper/offer_letter.jasper").getPath();
        jasperFilePath = "E:\\dev\\shipping_erp\\target\\classes\\jasper\\offer_letter.jasper";

        String fileName = crew.getFileNum() + "_offer_letter.pdf";
        String uploadPath = tempFilePath + File.separator + "temp" + File.separator + fileName;
        Map<String, Object> params = new HashMap<>();
        params.put("crewName", crew.getFullName());
        params.put("rank", offerLetter.getAgreedRank().getName());
        params.put("agreedWages", String.valueOf(offerLetter.getAgreedWages()));
        params.put("vesselName", offerLetter.getVesselName());
        params.put("contractPeriod", offerLetter.getContractPeriod().toString());

        List<Bank> banks = crew.getBanks();
        if (ListUtil.isNotEmpty(banks)) {
            Bank bank = (Bank) ListUtil.getFirstItem(banks);
            params.put("bankName", bank.getBankName());
            params.put("accountNumber", bank.getAccountNumber());
            params.put("beneficiaryName", bank.getBeneficiaryName());
        }
        params.put("remunerationDataSource", offerLetter.getRemunerations());
        params.put("reimbursementDataSource", offerLetter.getReimbursements());
        params.put("deductionDataSource", offerLetter.getDeductions());
        //final JRBeanCollectionDataSource data = new JRBeanCollectionDataSource(offerLetter.getRemunerations());

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperFilePath, params, new JREmptyDataSource());
        JRPdfExporter exporter = new JRPdfExporter();
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(
                new SimpleOutputStreamExporterOutput(fileName));
        SimplePdfReportConfiguration reportConfig
                = new SimplePdfReportConfiguration();
        reportConfig.setSizePageToContent(true);
        reportConfig.setForceLineBreakPolicy(false);

        SimplePdfExporterConfiguration exportConfig
                = new SimplePdfExporterConfiguration();
        exportConfig.setMetadataAuthor("intuitbrains");
        exportConfig.setEncrypted(true);
        exportConfig.setAllowedPermissionsHint("PRINTING");

        exporter.setConfiguration(reportConfig);
        exporter.setConfiguration(exportConfig);

        exporter.exportReport();
        JasperExportManager.exportReportToPdfFile(jasperPrint, uploadPath);

        File tmpFile = new File(uploadPath);
        byte[] fileContent = Files.readAllBytes(tmpFile.toPath());

        offerLetter.setFile(new Binary(BsonBinarySubType.BINARY, fileContent));
        offerLetter.setFileTitle(fileName);
        //tmpFile.delete();
    }


}
