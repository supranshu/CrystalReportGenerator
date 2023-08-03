package com.report.service;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.report.dao.StudentRepo;
import com.report.entities.Student;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.List;

@Service
public class ReportGenerationService {

    @Autowired
    private StudentRepo studentRepo;
    private final InputStream reportTemplate = getClass().getResourceAsStream("/students.jrxml");
    
    public List<Student> getStudentsByYearAndBranch(String year, String branch) {
        return studentRepo.findByYearAndBranch(year, branch);
    }
    
    public byte[] generateReport(String year, String branch) {
        try {
            // Load the .jrxml file from the classpath or file system
            JasperReport jasperReport = JasperCompileManager.compileReport(reportTemplate);

            // Fetch data from the database (example: get all students)
            List<Student> students = getStudentsByYearAndBranch(year, branch);
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(students);

            // Fill the report with data
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);

            // Export the report to PDF format (you can use other formats like HTML, Excel, etc.)
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);

            return outputStream.toByteArray();
        } catch (JRException e) {
            e.printStackTrace();
            // Handle the exception as required
            return null;
        }
    }

}
