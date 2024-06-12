package com.login.dao;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.mail.Session;
import javax.servlet.http.HttpSession;

import org.bouncycastle.asn1.ocsp.Request;

import com.login.pojo.Login;
import com.login.utility.MyConnection;

public class RegistrationImpl implements RegistrationInterface {

	@Override
	public boolean signup(Login l) {
		// TODO Auto-generated method stub
		Connection conn = null;

		try {
			conn = MyConnection.getConnectionObj();
			PreparedStatement pstm = conn.prepareStatement(
					"insert into login_info(USERNAME,EMAIL_ID,STATE,CITY,PINCODE,PASSWORD,ADDRESS,role,status)values(?,?,?,?,?,?,?,?,?)");
			pstm.setString(1, l.getUsername());
			pstm.setString(2, l.getEMAIL_ID());
			pstm.setString(3, l.getSTATE());
			pstm.setString(4, l.getCITY());
			pstm.setInt(5, l.getPINCODE());
			pstm.setString(6, l.getPassword());
			pstm.setString(7, l.getADDRESS());
			pstm.setString(8, l.getRole());

			pstm.setString(9, "active");

			pstm.executeUpdate(); // important

			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Login login(Login userLogin) {
		// TODO Auto-generated method stub
		Connection conn = null;

		try {

			conn = MyConnection.getConnectionObj();
			PreparedStatement ps = conn
					.prepareStatement("select * from login_info where EMAIL_ID=? and PASSWORD=? and role=?");
			ps.setString(1, userLogin.getEMAIL_ID());
			ps.setString(2, userLogin.getPassword());
			ps.setString(3, userLogin.getRole());
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Login login = new Login();
				login.setUsername(rs.getString("USERNAME"));
				login.setId(rs.getLong("USER_ID"));
				login.setEMAIL_ID(userLogin.getEMAIL_ID());
				login.setRole(rs.getString("role"));
				login.setStatus(rs.getString("status"));
				return login;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public String getEmailId(String username) {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = MyConnection.getConnectionObj();
			PreparedStatement ps = conn.prepareStatement("select * from login_info where USERNAME=?");
			ps.setString(1, username);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				String mailId = rs.getString("EMAIL_ID");
				return mailId;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "";
	}

	@Override
	public List<Login> getAllNewUersListForApproval(String role) {
		Connection conn = null;

		List<Login> requestList = new ArrayList<Login>();
		try {
			conn = MyConnection.getConnectionObj();
			PreparedStatement ps = conn.prepareStatement("select * from login_info where status='inactive' and role=?");
			ps.setString(1, role);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Login login = new Login();
				login.setId(rs.getLong("USER_ID"));
				login.setUsername(rs.getString("username"));
				login.setADDRESS(rs.getString("ADDRESS"));
				requestList.add(login);
			}
			return requestList;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean updateApprovalStatus(long id, String status) {

		try {
			Connection conn = null;
			conn = MyConnection.getConnectionObj();
			PreparedStatement ps = conn.prepareStatement("update login_info set status=? where USER_ID=?");
			ps.setString(1, status);
			ps.setLong(2, id);
			ps.executeUpdate();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public List<Login> getBlockedList(String role) {
		Connection conn = null;

		List<Login> requestList = new ArrayList<Login>();
		try {
			conn = MyConnection.getConnectionObj();
			PreparedStatement ps = conn.prepareStatement("select * from login_info where status='blocked' and role=?");
			ps.setString(1, role);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Login login = new Login();
				login.setId(rs.getLong("USER_ID"));
				login.setUsername(rs.getString("username"));
				login.setADDRESS(rs.getString("ADDRESS"));
				requestList.add(login);
			}
			return requestList;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean updateBlockUserStatus(long id, String status) {
		try

		{

			Connection conn = null;
			conn = MyConnection.getConnectionObj();
			/* mac address */
			InetAddress ip = InetAddress.getLocalHost();
			System.out.println("Current IP address : " + ip.getHostAddress());
			NetworkInterface network = NetworkInterface.getByInetAddress(ip);
			byte[] mac = network.getHardwareAddress();
			System.out.println("Current MAC address : " + network.getHardwareAddress());
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < mac.length; i++) {
				sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
			}
			System.out.println("------------------------" + sb.toString());

			PreparedStatement ps = conn.prepareStatement("update login_info set status=? where USER_ID=?");
			ps.setString(1, "inactive");
			ps.setLong(2, id);
			ps.executeUpdate();
			PreparedStatement ps1 = conn.prepareStatement("insert into macaddress_master (system_mac) values(?)");
			ps1.setString(1, sb.toString());
			ps1.executeUpdate();

			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public List<Login> getAllDoctors() {
		Connection conn = null;

		List<Login> doctorList = new ArrayList<Login>();
		try {
			conn = MyConnection.getConnectionObj();
			PreparedStatement ps = conn.prepareStatement("select * from login_info where status='active' and role=?");
			ps.setString(1, "Doctor");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Login login = new Login();
				login.setUsername(rs.getString("USERNAME"));
				login.setCITY(rs.getString("CITY"));
				login.setSTATE(rs.getString("STATE"));
				login.setEMAIL_ID(rs.getString("EMAIL_ID"));
				login.setId(rs.getLong("USER_ID"));
				login.setRole(rs.getString("role"));
				login.setStatus(rs.getString("status"));
				doctorList.add(login);
			}
			return doctorList;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
