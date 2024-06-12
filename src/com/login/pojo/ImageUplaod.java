package com.login.pojo;

import java.sql.Date;

public class ImageUplaod {

	private long file_id;

	private String PATH;
	private String USERNAME;
	private String Type;
	private int fileSize;

	private Date DATE;

	public Date getDATE() {
		return DATE;
	}

	public void setDATE(Date dATE) {
		DATE = dATE;
	}

	private String TIME;
	private String ACTION;
	private String FILE_NAME;
	private String IP_ADDRESS;

	public int getFileSize() {
		return fileSize;
	}

	public void setFileSize(int fileSize) {
		this.fileSize = fileSize;
	}

	public String getTIME() {
		return TIME;
	}

	public void setTIME(String tIME) {
		TIME = tIME;
	}

	public String getACTION() {
		return ACTION;
	}

	public void setACTION(String aCTION) {
		ACTION = aCTION;
	}

	public String getFILE_NAME() {
		return FILE_NAME;
	}

	public void setFILE_NAME(String fILE_NAME) {
		FILE_NAME = fILE_NAME;
	}

	public String getIP_ADDRESS() {
		return IP_ADDRESS;
	}

	public void setIP_ADDRESS(String iP_ADDRESS) {
		IP_ADDRESS = iP_ADDRESS;
	}

	public String getUSERNAME() {
		return USERNAME;
	}

	public void setUSERNAME(String uSERNAME) {
		USERNAME = uSERNAME;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getPATH() {
		return PATH;
	}

	public void setPATH(String pATH) {
		PATH = pATH;
	}

	public long getFile_id() {
		return file_id;
	}

	public void setFile_id(long fileId) {
		file_id = fileId;
	}

}
