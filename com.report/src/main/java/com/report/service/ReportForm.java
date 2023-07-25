package com.report.service;

public class ReportForm {

	private String year;
    private String branch;
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
	public ReportForm(String year, String branch) {
		super();
		this.year = year;
		this.branch = branch;
	}
	public ReportForm() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
