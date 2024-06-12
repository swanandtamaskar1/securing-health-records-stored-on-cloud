package com.login.pojo;

import java.sql.Date;

public class PatientHistory {

	private int id;
	private int patient_id;
	private String symptoms;
	private String prescription;
	private int prescribedByDoctor;
	private String prescribedByName;
	private Date prescribedDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public String getPrescription() {
		return prescription;
	}

	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}

	public int getPrescribedByDoctor() {
		return prescribedByDoctor;
	}

	public void setPrescribedByDoctor(int prescribedByDoctor) {
		this.prescribedByDoctor = prescribedByDoctor;
	}

	public String getPrescribedByName() {
		return prescribedByName;
	}

	public void setPrescribedByName(String prescribedByName) {
		this.prescribedByName = prescribedByName;
	}

	public Date getPrescribedDate() {
		return prescribedDate;
	}

	public void setPrescribedDate(Date prescribedDate) {
		this.prescribedDate = prescribedDate;
	}

}
