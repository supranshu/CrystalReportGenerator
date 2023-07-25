package com.report.service;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.report.dao.StudentRepo;
import com.report.entities.Student;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
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
    
   

 // ...

 public byte[] generateReport(String year, String branch) {
     try {
         
         List<Student> students = getStudentsByYearAndBranch(year, branch);
         JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(students);

         
         InputStream reportTemplate = getClass().getResourceAsStream("/students.jrxml");
         JasperReport jasperReport = JasperCompileManager.compileReport(reportTemplate);

         
         JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);

         ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
         JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);

         return outputStream.toByteArray();
     } catch (JRException e) {
         e.printStackTrace();
        
         return null;
     } catch (Exception e) {
         e.printStackTrace();
         
         return null;
     }
 }


}
