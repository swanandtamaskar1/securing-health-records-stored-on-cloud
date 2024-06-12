package com.login.utility;

import java.util.Date;
import java.util.Properties;
import java.util.Random;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import javax.mail.*;

public class EmailUtility {

	public static String sendEmail(String emailId) {
		String userpassword = getRandomPassword(8);
		final String SMTP_SERVER = "smtp.gmail.com";
		final String PASSWORD = "hxzi ravc zkkr mdbx";// password
		final String USERNAME = "swanandtamaskar2";
		final String EMAIL_FROM = "swanandtamaskar2@gmail.com";
		final String EMAIL_SUBJECT = "Login Details";
		final String EMAIL_TEXT = "Do not share the following information with anyone!"+"\nYour username is: " + emailId + "\nPassword: " + userpassword;

		Properties prop = new Properties();
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", SMTP_SERVER);
		prop.put("mail.smtp.port", "587");

		Session session = Session.getInstance(prop, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(USERNAME, PASSWORD);
			}
		});

		try {
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(EMAIL_FROM));
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailId, false));
			msg.setSubject(EMAIL_SUBJECT);
			msg.setText(EMAIL_TEXT);
			msg.setSentDate(new Date());

			Transport.send(msg);

			return userpassword;
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String sendOtp(String emailId) {
		
		String otp = getOTP(8);
		final String SMTP_SERVER = "smtp.gmail.com";
		final String PASSWORD = "hxzi ravc zkkr mdbx";// password
		final String USERNAME = "swanandtamaskar2";
		final String EMAIL_FROM = "swanandtamaskar2@gmail.com";
		final String EMAIL_SUBJECT = "OTP to download report";
		final String EMAIL_TEXT = "Please verify with OTP to download the report."+"\nYour one time password is: " + otp;

		Properties prop = new Properties();
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", SMTP_SERVER);
		prop.put("mail.smtp.port", "587");

		Session session = Session.getInstance(prop, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(USERNAME, PASSWORD);
			}
		});

		try {
			Message msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(EMAIL_FROM));
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailId, false));
			msg.setSubject(EMAIL_SUBJECT);
			msg.setText(EMAIL_TEXT);
			msg.setSentDate(new Date());

			Transport.send(msg);

			return otp;
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return null;
	}

	static String getOTP(int len) {

		String numbers = "0123456789";

		String values = numbers;

		Random rndm_method = new Random();

		char[] password = new char[len];

		for (int i = 0; i < len; i++) {

			password[i] = values.charAt(rndm_method.nextInt(values.length()));

		}
		return String.valueOf(password);
	}

	static String getRandomPassword(int len) {

		String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String Small_chars = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";

		String values = Capital_chars + Small_chars + numbers;

		Random rndm_method = new Random();

		char[] password = new char[len];

		for (int i = 0; i < len; i++) {

			password[i] = values.charAt(rndm_method.nextInt(values.length()));

		}
		return String.valueOf(password);
	}
}
