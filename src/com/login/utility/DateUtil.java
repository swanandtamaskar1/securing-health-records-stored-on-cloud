package com.login.utility;

public class DateUtil {

	public static java.sql.Date convertCurrentUtilDateTimetoSqlDate() {
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		return sqlDate;
	}
}
