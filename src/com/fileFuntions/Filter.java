package com.fileFuntions;

import java.io.File;
import java.io.FileInputStream;

public class Filter {
	public String getAllFilesFromFolder1(String bufferData, String path) {

		System.out.println("PATH" + path);
		// Directory path here
		path = path + "\\" + "Folder1";

		String files;
		File folder = new File(path);

		System.out.println("-------------------------------" + folder);

		if (!folder.exists()) {
			boolean status = folder.mkdirs();
		}

		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {

			if (listOfFiles[i].isFile()) {
				files = listOfFiles[i].getName();
				if (files.endsWith(".txt") || files.endsWith(".TXT")) {
					try {

						System.out.println("files.." + files);
						File inputFile = new File(path + "\\" + files);
						// System.out.println("infultFileeeeeeeee"+inputFile);
						FileInputStream inputStream = new FileInputStream(inputFile);
						int fileSize = (int) inputFile.length();
						// byte PART_SIZE =(byte) 127;
						byte[] byteChunkPart = new byte[fileSize];
						int read = inputStream.read(byteChunkPart, 0, fileSize);
						inputStream.close();
						// System.out.println("READDDDDDD"+read);
						// String crrentFileData=byteChunkPart.toString();
						String crrentFileData = new String(byteChunkPart);
						System.out.println("crrentFileData........" + crrentFileData);

						System.out.println("Bufferdata......." + bufferData);
						if (crrentFileData.equalsIgnoreCase(bufferData)) {
							// System.out.println("HIEEEEEEEEEEEEE");
							return "Folder1\\" + files;
						}

					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return null;
	}

	public String getAllFilesFromFolder2(String bufferData, String path) {

		System.out.println("PATH" + path);
		// Directory path here

		path = path + "\\" + "Folder2";
		String files;
		File folder = new File(path);

		if (!folder.exists()) {
			boolean status = folder.mkdirs();
		}

		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {

			if (listOfFiles[i].isFile()) {
				files = listOfFiles[i].getName();
				if (files.endsWith(".txt") || files.endsWith(".TXT")) {
					try {

						System.out.println("files.." + files);
						File inputFile = new File(path + "\\" + files);
						// System.out.println("infultFileeeeeeeee"+inputFile);
						FileInputStream inputStream = new FileInputStream(inputFile);
						int fileSize = (int) inputFile.length();
						// byte PART_SIZE =(byte) 127;
						byte[] byteChunkPart = new byte[fileSize];
						int read = inputStream.read(byteChunkPart, 0, fileSize);
						inputStream.close();
						// System.out.println("READDDDDDD"+read);
						// String crrentFileData=byteChunkPart.toString();
						String crrentFileData = new String(byteChunkPart);
						System.out.println("crrentFileData........" + crrentFileData);

						System.out.println("Bufferdata......." + bufferData);
						if (crrentFileData.equalsIgnoreCase(bufferData)) {
							// System.out.println("HIEEEEEEEEEEEEE");
							return "Folder2\\" + files;
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
		return null;
	}
}
