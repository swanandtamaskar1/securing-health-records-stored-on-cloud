package com.login.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {

	static Connection conn = null;

	public static Connection getConnectionObj() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			System.out.println("Driver Loaded...");

			String url = "jdbc:mysql://localhost:3306/deduplication";
			String user = "root";
			String password = "happino2024";
			conn = DriverManager.getConnection(url, user, password);

			System.out.println("Connection Established...");

			return conn;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public static void CloseConnection() {
		try {
			conn.close();
			conn = null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
