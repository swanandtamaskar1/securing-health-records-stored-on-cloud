package com.login.dao;

import java.util.List;

import com.login.pojo.PatientMaster;

public interface PatientMasterInterface {

	public boolean save(PatientMaster PatientMaster);

	public List<PatientMaster> PatientMasterList();

	public boolean updatePatientMaster(PatientMaster PatientMaster);

	public boolean editPatientMaster(PatientMaster PatientMaster);

	public boolean deletePatientMaster(PatientMaster PatientMaster);

	public PatientMaster getElementById(PatientMaster PatientMaster);

	public PatientMaster getElementByUserId(int userId);

}
