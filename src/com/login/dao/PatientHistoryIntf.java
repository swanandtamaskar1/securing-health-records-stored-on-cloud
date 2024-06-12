package com.login.dao;

import java.util.List;

import com.login.pojo.PatientHistory;

public interface PatientHistoryIntf {

	public void savePatientHistory(PatientHistory patientHistory);

	public List<PatientHistory> getAllbyPatientId(int id);

}
