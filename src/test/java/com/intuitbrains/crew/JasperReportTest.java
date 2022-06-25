package com.intuitbrains.crew;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRSaver;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class JasperReportTest {

    @Test
    public void createOfferLetter() throws JRException {
        File jasperFile = new File("E:\\dev\\shipping_erp\\src\\main\\resources\\static\\jasper\\offer_letter.jasper");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("crewName", "Rohan P Tiwari");
        parameters.put("rank", "Chief");
        parameters.put("agreedWages", "15000.00");
        parameters.put("vesselName", "EXMAR - DKASKLAK S");
        parameters.put("contractPeriod", "6 +/-1");
        parameters.put("bankName", "HDFC");
        parameters.put("accountNUmber", "00321392348");
        parameters.put("beneficiaryName", "Rohan Pradeep Tiwari");

        final JRBeanCollectionDataSource data = new JRBeanCollectionDataSource(new ArrayList<>());
//        final JasperReport report = new JasperReport(jasperFile);



        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperFile.getPath(), parameters, new JREmptyDataSource());
        JRPdfExporter exporter = new JRPdfExporter();

        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(
                new SimpleOutputStreamExporterOutput("offer_letter.pdf"));
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


    }

}
