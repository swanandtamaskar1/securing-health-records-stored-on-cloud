package com.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import com.login.pojo.PatientHistory;

import com.login.utility.MyConnection;

public class PatientHistoryDaoImpl implements PatientHistoryIntf {
	Connection conn;

	@Override
	public void savePatientHistory(PatientHistory patientHistory) {

		try {

			conn = MyConnection.getConnectionObj();
			PreparedStatement ps = conn.prepareStatement(
					"insert into patient_history(patient_id,symptoms,prescription,prescribed_by_doctor,prescribed_by_name,prescribed_date) values (?,?,?,?,?,?)");

			ps.setInt(1, patientHistory.getPatient_id());
			ps.setString(2, patientHistory.getSymptoms());
			ps.setString(3, patientHistory.getPrescription());
			ps.setInt(4, patientHistory.getPrescribedByDoctor());
			ps.setString(5, patientHistory.getPrescribedByName());
			ps.setDate(6, patientHistory.getPrescribedDate());
			int no = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return;

	}

	@Override
	public List<PatientHistory> getAllbyPatientId(int patientId) {
		try {
			conn = MyConnection.getConnectionObj();
			PreparedStatement ps = conn.prepareStatement("select * from patient_history where patient_id =? ");
			ps.setInt(1, patientId);
			ResultSet rs = ps.executeQuery();
			List<PatientHistory> patientHistorylist = new ArrayList<PatientHistory>();

			while (rs.next()) {
				PatientHistory patientHistory = new PatientHistory();
				patientHistory.setId(rs.getInt("patient_id"));
				patientHistory.setPrescription(rs.getString("prescription"));
				patientHistory.setSymptoms(rs.getString("symptoms"));
				patientHistory.setPrescribedByName(rs.getString("prescribed_by_name"));
				patientHistory.setPatient_id(patientId);
				patientHistory.setPrescribedByDoctor(rs.getInt("prescribed_by_doctor"));
				patientHistory.setPrescribedDate(rs.getDate("prescribed_date"));
				patientHistorylist.add(patientHistory);
			}
			return patientHistorylist;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;

	}

}
