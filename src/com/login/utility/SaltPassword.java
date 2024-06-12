package com.login.utility;

import java.security.MessageDigest;
import java.security.SecureRandom;

public class SaltPassword {
	static byte[] salt;
	static {
		if (salt == null) {
			salt = getSalt();
		}

	}

	private static String getPassword(String passwordToHash, byte[] salt) {
		String generatedPassword = null;
		try {
			// Create MessageDigest instance for MD5
			MessageDigest md = MessageDigest.getInstance("MD5");
			// Add password bytes to digest
			md.update(salt);
			// Get the hash's bytes
			byte[] bytes = md.digest(passwordToHash.getBytes());
			// This bytes[] has bytes in decimal format;
			// Convert it to hexadecimal format
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++) {
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			// Get complete hashed password in hex format
			generatedPassword = sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return generatedPassword;
	}

	// Add salt
	private static byte[] getSalt() {
		// Always use a SecureRandom generator
		try {
			SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
			// Create array for salt
			byte[] salt = new byte[16];
			// Get a random salt
			sr.generateSeed(10);
			// return salt
			// System.out.println(sr.);
			return sr.generateSeed(10);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public static void main(String[] args) throws Exception {
		String passwordToHash = "1234";

		String securePassword = getPassword(passwordToHash, salt);
		System.out.println(securePassword);

		String regeneratedPassowrdToVerify = getPassword(passwordToHash, salt);
		System.out.println(regeneratedPassowrdToVerify); 
	}
}
