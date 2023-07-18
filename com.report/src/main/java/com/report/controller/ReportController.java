package com.report.controller;

import com.report.dao.StudentRepo;
import com.report.entities.Student;
import com.report.service.ReportGenerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ReportController {



    
	
    @Autowired
    private ReportGenerationService reportGenerationService;

    @GetMapping("/")
    public String showIndexPage() {
        return "index"; // This will render index.html using Thymeleaf
    }

    

    @GetMapping("/generatereport")
    public String redirectToGenerateReportPage() {
        // Perform any necessary logic and data handling here
        return "generate_report"; // This will render generate_report.html using Thymeleaf
    }
    
    
    

    
    
    @GetMapping(value = "/generate-report", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> generateReport(@RequestParam String year, @RequestParam String branch) {
        byte[] reportBytes = reportGenerationService.generateReport(year, branch);

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=report.pdf");

        return ResponseEntity.ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(reportBytes);
    }
}