package com.intuitbrains.service.crew;

import com.intuitbrains.model.crew.Crew;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;

@Service
public class CrewService {
    @Autowired
    private CrewExcelService crewExcelService;

    public Crew uploadCrewData(FileInputStream file) throws IOException {
        return crewExcelService.upload(file);
    }
}
