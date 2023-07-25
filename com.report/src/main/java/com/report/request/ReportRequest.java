package com.report.request;

public class ReportRequest {
    private String year;
    private String branch;
   

    public ReportRequest() {
    }

    public ReportRequest(String year, String branch) {
        this.year = year;
        this.branch = branch;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    
}
