package com.fileFuntions;

import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.xml.bind.DatatypeConverter;

public class EncryptionDecryptionAES {
	static Cipher cipher;

	public static SecretKey generateSymmetricKey(String key) throws Exception {
		SecretKey skey = null;
		try {
			byte[] knumb = key.getBytes();

			KeyGenerator kgen = KeyGenerator.getInstance("AES");
			SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
			sr.setSeed(knumb);
			kgen.init(128, sr);
			skey = kgen.generateKey();

			return skey;

		} catch (Exception e) {
			return skey;
		}
	}

	public static String encrypt(String plainText, String key) throws Exception {
		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
		keyGenerator.init(128);
		SecretKey secretKey = EncryptionDecryptionAES.generateSymmetricKey(key);
		cipher = Cipher.getInstance("AES");
		byte[] plainTextByte = plainText.getBytes();
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		byte[] encryptedByte = cipher.doFinal(plainTextByte);

		// Base64.Encoder encoder = Base64.getEncoder();
		String encryptedText = DatatypeConverter.printBase64Binary(encryptedByte);
		System.out.println("encryptedText---------" + encryptedText);
		return encryptedText;
	}

	public static String decrypt(String encryptedText, String key) throws Exception {

		KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
		keyGenerator.init(128);
		SecretKey secretKey = EncryptionDecryptionAES.generateSymmetricKey(key);
		cipher = Cipher.getInstance("AES");
		// Base64.Decoder decoder = Base64.getDecoder();
		byte[] encryptedTextByte = DatatypeConverter.parseBase64Binary(encryptedText);
		System.out.println("encryptedTextByte" + encryptedTextByte);
		cipher.init(Cipher.DECRYPT_MODE, secretKey);
		byte[] decryptedByte = cipher.doFinal(encryptedTextByte);
		String decryptedText = new String(decryptedByte);
		System.out.println("encryptedText---------" + decryptedText);
		return decryptedText;
	}

}