package com.fileFuntions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;

import com.login.dao.SplitFilesImpl;
import com.login.dao.SplitFilesInterface;
import com.login.pojo.ImageUplaod;
import com.project.task.AmazonUpload;
import com.project.task.Constants;

public class SplittFile {

	private static Scanner scanner;

	public static void splitFile(String absoluteFilePath, String FILE_NAME, String uname, long file_id)
			throws Exception {

		String previousData = "0";
		String path = "";
		int nChunks = 1;
		File file = new File(absoluteFilePath + File.separator + FILE_NAME);
		BufferedReader reader = new BufferedReader(new FileReader(file));

		String actualTxt_name = FILE_NAME.substring(0, FILE_NAME.lastIndexOf("."));

		int lines = 0;

		while (reader.readLine() != null)
			lines++;

		reader.close();

		int RemaingLineNo = 0;
		int remainingLines = lines % 5;
		if (remainingLines > 0) {
			RemaingLineNo = lines - remainingLines + 1;
		}

		String last[] = new String[5];

		scanner = new Scanner(file);
		int count = 0;
		int currentLineNo = 0;
		String tokens = "";
		while (scanner.hasNext()) {
			currentLineNo++;
			tokens = scanner.nextLine();

			last[count] = tokens;
			System.out.println("currentLineNo" + currentLineNo);
			System.out.println("RemaingLineNo" + RemaingLineNo);
			System.out.println("count" + count);
			if (remainingLines > 0 && currentLineNo == RemaingLineNo) {
				for (int i = 0; i <= remainingLines; i++) {

					while (scanner.hasNext()) {
						tokens = scanner.nextLine();
						last[++count] = tokens;
					}
				}

				String bufferData = "";
				for (int i = 0; i < remainingLines; i++) {
					if (last[i] != "") {
						bufferData = bufferData + last[i] + "\r\n";
					}
				}

				Integer bucketNo = getRandomBucket();
				path = absoluteFilePath + File.separator + Constants.bucketbasename + bucketNo;
				String splitFileName = actualTxt_name + "" + Integer.toString(nChunks - 1) + ".txt";
				String newFileName = path + File.separator + splitFileName;

				FileOutputStream filePart = new FileOutputStream(new File(newFileName));
				String encryptedData = EncryptionDecryptionAES.encrypt(bufferData, previousData);
				previousData = bufferData;
				byte[] bytepart = encryptedData.getBytes();
				SplitFilesInterface saveSplitFilesInterface = new SplitFilesImpl();
				ImageUplaod imageUplaod = new ImageUplaod();
				imageUplaod.setPATH(Constants.bucketbasename + bucketNo + "/" + splitFileName);
				imageUplaod.setUSERNAME(uname);
				imageUplaod.setFile_id(file_id);
				saveSplitFilesInterface.saveSplitFiles(imageUplaod);
				filePart.write(bytepart);
				filePart.flush();
				filePart.close();

				AmazonUpload.uploadons3bucket(Constants.bucketbasename + bucketNo, 
						newFileName, splitFileName);
				new File(newFileName).delete();
				nChunks++;

			} else if (count == 4) {

				String bufferData = "";

				for (int i = 0; i < 5; i++) {
					bufferData = bufferData + last[i] + "\r\n";
				}
				Integer bucketNo = getRandomBucket();
				path = absoluteFilePath + File.separator + Constants.bucketbasename + bucketNo;
				String splitFileName = actualTxt_name + "" + Integer.toString(nChunks - 1) + ".txt";
				String newFileName = path + File.separator + splitFileName;

				FileOutputStream filePart = new FileOutputStream(new File(newFileName));

				String encryptedData = EncryptionDecryptionAES.encrypt(bufferData, previousData);
				previousData = bufferData;

				byte[] bytepart = encryptedData.getBytes();

				SplitFilesInterface saveSplitFilesInterface = new SplitFilesImpl();
				ImageUplaod imageUplaod = new ImageUplaod();
				imageUplaod.setPATH(Constants.bucketbasename + bucketNo + "/" + splitFileName);
				imageUplaod.setUSERNAME(uname);
				imageUplaod.setFile_id(file_id);
				saveSplitFilesInterface.saveSplitFiles(imageUplaod);

				filePart.write(bytepart);
				filePart.flush();
				filePart.close();

				AmazonUpload.uploadons3bucket(Constants.bucketbasename + bucketNo, 
						newFileName, splitFileName);
				new File(newFileName).delete();
				nChunks++;

				for (int i = 0; i < 5; i++)
					last[i] = "";
				count = 0;
			}
			else {
				count++;
			}
		}
		reader.close();
	}

	public static int getRandomBucket() {
		int rnd = new Random().nextInt(3) + 1;
		return rnd;
	}
}
