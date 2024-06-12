package com.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.login.pojo.PatientMaster;
import com.login.utility.MyConnection;

public class PatientMasterDaoImpl implements PatientMasterInterface {

	Connection conn = null;

	public boolean save(PatientMaster PatientMaster) {

		try {

			conn = MyConnection.getConnectionObj();
			PreparedStatement ps = conn.prepareStatement(
					"insert into patient_master(FIRST_NAME,LAST_NAME,CITY,STATE,PINCODE,CONTACT_NO,EMAIL,AGE,WEIGHT,HEIGHT,BLOOD_GROUP,USER_ID) values (?,?,?,?,?,?,?,?,?,?,?,?)");

			ps.setString(1, PatientMaster.getFirst_name());
			ps.setString(2, PatientMaster.getLast_name());
			ps.setString(3, PatientMaster.getCity());
			ps.setString(4, PatientMaster.getState());
			ps.setString(5, PatientMaster.getPincode());
			ps.setString(6, PatientMaster.getContact_no());
			ps.setString(7, PatientMaster.getEmail());
			ps.setString(8, PatientMaster.getAge());
			ps.setString(9, PatientMaster.getWeight());
			ps.setString(10, PatientMaster.getHeight());
			ps.setString(11, PatientMaster.getBlood_group());
			ps.setInt(12, PatientMaster.getUSER_ID());
			int no = ps.executeUpdate();
			if (no > 0) {
				return true;
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
		return false;
	}

	public boolean updatePatientMaster(PatientMaster PatientMaster) {
		try {
			conn = MyConnection.getConnectionObj();
			PreparedStatement ps = conn.prepareStatement(
					"update patient_master set FIRST_NAME=?,LAST_NAME=?,CITY=?,STATE=?,PINCODE=?,CONTACT_NO=?,EMAIL=?,AGE=?,WEIGHT=?,HEIGHT=?,BLOOD_GROUP=? where  ID=? ");

			ps.setString(1, PatientMaster.getFirst_name());
			ps.setString(2, PatientMaster.getLast_name());
			ps.setString(3, PatientMaster.getCity());
			ps.setString(4, PatientMaster.getState());
			ps.setString(5, PatientMaster.getPincode());
			ps.setString(6, PatientMaster.getContact_no());
			ps.setString(7, PatientMaster.getEmail());
			ps.setString(8, PatientMaster.getAge());
			ps.setString(9, PatientMaster.getWeight());
			ps.setString(10, PatientMaster.getHeight());
			ps.setString(11, PatientMaster.getBlood_group());
			ps.setInt(12, PatientMaster.getId());
			int no = ps.executeUpdate();
			if (no > 0) {
				return true;
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
		return false;
	}

	public List<PatientMaster> PatientMasterList() {
		try {
			conn = MyConnection.getConnectionObj();
			PreparedStatement ps = conn.prepareStatement("select * from patient_master order by ID desc");
			ResultSet rs = ps.executeQuery();
			List<PatientMaster> PatientMasterList = new ArrayList<PatientMaster>();

			while (rs.next()) {
				PatientMaster PatientMaster = new PatientMaster();
				PatientMaster.setId(rs.getInt("ID"));
				PatientMaster.setUSER_ID(rs.getInt("USER_ID"));
				PatientMaster.setFirst_name(rs.getString("FIRST_NAME"));
				PatientMaster.setLast_name(rs.getString("LAST_NAME"));
				PatientMaster.setCity(rs.getString("CITY"));
				PatientMaster.setState(rs.getString("STATE"));
				PatientMaster.setPincode(rs.getString("PINCODE"));
				PatientMaster.setContact_no(rs.getString("CONTACT_NO"));
				PatientMaster.setEmail(rs.getString("EMAIL"));
				PatientMaster.setAge(rs.getString("AGE"));
				PatientMaster.setWeight(rs.getString("WEIGHT"));
				PatientMaster.setHeight(rs.getString("HEIGHT"));
				PatientMaster.setBlood_group(rs.getString("BLOOD_GROUP"));
				PatientMasterList.add(PatientMaster);
			}
			return PatientMasterList;
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
	public boolean editPatientMaster(PatientMaster PatientMaster) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletePatientMaster(PatientMaster PatientMaster) {
		try {
			conn = MyConnection.getConnectionObj();
			PreparedStatement ps = conn.prepareStatement("delete  from patient_master where id=? ");
			ps.setInt(1, PatientMaster.getId());
			return ps.execute();

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
		return false;
	}

	@Override
	public PatientMaster getElementById(PatientMaster PatientMaster) {
		try {
			conn = MyConnection.getConnectionObj();
			PreparedStatement ps = conn.prepareStatement("select * from patient_master where id= ?");
			ps.setInt(1, PatientMaster.getId());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				PatientMaster.setId(rs.getInt("ID"));
				PatientMaster.setUSER_ID(rs.getInt("USER_ID"));
				PatientMaster.setFirst_name(rs.getString("FIRST_NAME"));
				PatientMaster.setLast_name(rs.getString("LAST_NAME"));
				PatientMaster.setCity(rs.getString("CITY"));
				PatientMaster.setState(rs.getString("STATE"));
				PatientMaster.setPincode(rs.getString("PINCODE"));
				PatientMaster.setContact_no(rs.getString("CONTACT_NO"));
				PatientMaster.setEmail(rs.getString("EMAIL"));
				PatientMaster.setAge(rs.getString("AGE"));
				PatientMaster.setWeight(rs.getString("WEIGHT"));
				PatientMaster.setHeight(rs.getString("HEIGHT"));
				PatientMaster.setBlood_group(rs.getString("BLOOD_GROUP"));
			}
			return PatientMaster;
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
	public PatientMaster getElementByUserId(int userId) {
		try {
			conn = MyConnection.getConnectionObj();
			PreparedStatement ps = conn.prepareStatement("select * from patient_master where USER_ID = ?");
			ps.setInt(1, userId);
			PatientMaster patientMaster = new PatientMaster();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				patientMaster.setId(rs.getInt("ID"));
				patientMaster.setUSER_ID(rs.getInt("USER_ID"));
				patientMaster.setFirst_name(rs.getString("FIRST_NAME"));
				patientMaster.setLast_name(rs.getString("LAST_NAME"));
				patientMaster.setCity(rs.getString("CITY"));
				patientMaster.setState(rs.getString("STATE"));
				patientMaster.setPincode(rs.getString("PINCODE"));
				patientMaster.setContact_no(rs.getString("CONTACT_NO"));
				patientMaster.setEmail(rs.getString("EMAIL"));
				patientMaster.setAge(rs.getString("AGE"));
				patientMaster.setWeight(rs.getString("WEIGHT"));
				patientMaster.setHeight(rs.getString("HEIGHT"));
				patientMaster.setBlood_group(rs.getString("BLOOD_GROUP"));
			}
			return patientMaster;
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