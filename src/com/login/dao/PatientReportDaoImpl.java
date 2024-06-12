package com.login.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.login.pojo.PatientReport;
import com.login.utility.MyConnection;

public class PatientReportDaoImpl implements PatientReportIntf {
	Connection conn;

	@Override
	public void addReport(PatientReport patientReport) {

		try {

			conn = MyConnection.getConnectionObj();
			PreparedStatement ps = conn.prepareStatement(
					"insert into patient_report(patient_id,report_name,report_date,report) values (?,?,?,?)");

			ps.setInt(1, patientReport.getPatient_id());
			ps.setString(2, patientReport.getReportFileName());
			ps.setDate(3, patientReport.getReportDate());
			ps.setString(4, patientReport.getReport());

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
	public void deleteReport(int reportId) {
		try {
			conn = MyConnection.getConnectionObj();
			PreparedStatement ps = conn.prepareStatement("delete  from patient_report where id=? ");
			ps.setInt(1, reportId);
			ps.execute();

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

	}

	@Override
	public Integer getLastAddedReportId(int patientId) {
		try {
			conn = MyConnection.getConnectionObj();
			PreparedStatement ps = conn
					.prepareStatement("select max(id) as id from patient_report where patient_id = ?");
			ps.setInt(1, patientId);

			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {

				return rs.getInt("id");

			}
			return null;
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

	@Override
	public List<PatientReport> getAllReportByPatientId(int patientId) {
		try {
			conn = MyConnection.getConnectionObj();
			PreparedStatement ps = conn.prepareStatement("select * from patient_report where patient_id = ?");
			ps.setInt(1, patientId);
			List<PatientReport> patientReports = new ArrayList<PatientReport>();

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				PatientReport patientReport = new PatientReport();
				patientReport.setId(rs.getInt("id"));
				patientReport.setReportFileName(rs.getString("report_name"));
				patientReport.setPatient_id(patientId);
				patientReport.setReportDate(rs.getDate("report_date"));
				patientReport.setReport(rs.getString("report"));
				patientReports.add(patientReport);
			}
			return patientReports;
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

	@Override
	public PatientReport getReportById(int reportId) {
		try {
			conn = MyConnection.getConnectionObj();
			PreparedStatement ps = conn.prepareStatement("select * from patient_report where id = ?");
			ps.setInt(1, reportId);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				PatientReport patientReport = new PatientReport();
				patientReport.setId(rs.getInt("id"));
				patientReport.setReportFileName(rs.getString("report_name"));
				patientReport.setPatient_id(rs.getInt("patient_id"));
				patientReport.setReportDate(rs.getDate("report_date"));
				patientReport.setReport(rs.getString("report"));
				return patientReport;
			}

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
