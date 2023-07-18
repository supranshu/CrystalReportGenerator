package com.report.request;

public class ReportRequest {
    private String year;
    private String branch;
    // Add more attributes as per your report criteria

    // Constructors, getters, and setters

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

    // Add more getters and setters for additional attributes, if any
}
