package com.login.dao;

import java.util.List;

import com.login.pojo.PatientReport;

public interface PatientReportIntf {

	public void addReport(PatientReport patientReport);

	public void deleteReport(int reportId);

	public List<PatientReport> getAllReportByPatientId(int patientId);

	public PatientReport getReportById(int reportId);

	public Integer getLastAddedReportId(int patientId);
}
