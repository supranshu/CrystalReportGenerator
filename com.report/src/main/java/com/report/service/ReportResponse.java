package com.report.service;



import java.util.List;

import com.report.entities.Student;

public class ReportResponse {
    private List<Student> students;
    

    public ReportResponse() {
    }

    public ReportResponse(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    
}
