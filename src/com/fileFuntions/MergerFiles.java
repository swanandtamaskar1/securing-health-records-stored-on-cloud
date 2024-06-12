package com.fileFuntions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import com.login.dao.SplitFilesImpl;
import com.project.task.AmazonUpload;

public class MergerFiles {

	public static String mergedFile(long file_id, String path, String FileName) {

		String mergedFilePath = path + File.separator + "mergedFiles" + File.separator + FileName;
		File folder = new File(path + File.separator + "mergedFiles");

		if (!folder.exists())
			folder.mkdir();

		SplitFilesImpl saveSplitFiles = new SplitFilesImpl();
		List<String> fileList = saveSplitFiles.getAllsplitFiles(file_id);

		File[] files = new File[fileList.size()];
		for (int i = 0; i < fileList.size(); i++) {
			String arr[] = fileList.get(i).split("/");
			String p = "c:\\uploads\\" + arr[0] + "\\" + arr[1];
			AmazonUpload.downloadFileFromS3(p, arr[0], arr[1]);
			files[i] = new File(p);
		}

		try {
			File mergedFile = new File(mergedFilePath);
			mergeFiles(files, mergedFile);

			deleteFiles(files);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mergedFilePath;
	}

	private static void deleteFiles(File[] files) {
		for (File f : files)
			f.delete();

	}

	public static void mergeFiles(File[] files, File mergedFile) throws Exception {

		FileWriter fstream = null;
		BufferedWriter out = null;
		try {
			fstream = new FileWriter(mergedFile, true);
			out = new BufferedWriter(fstream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String aesKey = "0";

		for (File f : files) {

			System.out.println("merging: " + f.getName());
			FileInputStream fis;
			try {
				fis = new FileInputStream(f);
				BufferedReader in = new BufferedReader(new InputStreamReader(fis));

				String aLine;
				while ((aLine = in.readLine()) != null) {
					String decryptedData = EncryptionDecryptionAES.decrypt(aLine, aesKey);
					out.write(decryptedData);
					aesKey = decryptedData;
				}

				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}