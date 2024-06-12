package com.login.pojo;

import java.sql.Date;

public class PatientMaster {

	private int ID;
	private int USER_ID;
	private String FIRST_NAME;
	private String LAST_NAME;
	private String CITY;
	private String STATE;
	private String PINCODE;
	private String CONTACT_NO;
	private String EMAIL;
	private String AGE;
	private String WEIGHT;
	private String HEIGHT;
	private String BLOOD_GROUP;

	public int getUSER_ID() {
		return USER_ID;
	}

	public void setUSER_ID(int uSER_ID) {
		USER_ID = uSER_ID;
	}

	public int getId() {
		return ID;
	}

	public void setId(int ID) {
		this.ID = ID;
	}

	public String getFirst_name() {
		return FIRST_NAME;
	}

	public void setFirst_name(String FIRST_NAME) {
		this.FIRST_NAME = FIRST_NAME;
	}

	public String getLast_name() {
		return LAST_NAME;
	}

	public void setLast_name(String LAST_NAME) {
		this.LAST_NAME = LAST_NAME;
	}

	public String getCity() {
		return CITY;
	}

	public void setCity(String CITY) {
		this.CITY = CITY;
	}

	public String getState() {
		return STATE;
	}

	public void setState(String STATE) {
		this.STATE = STATE;
	}

	public String getPincode() {
		return PINCODE;
	}

	public void setPincode(String PINCODE) {
		this.PINCODE = PINCODE;
	}

	public String getContact_no() {
		return CONTACT_NO;
	}

	public void setContact_no(String CONTACT_NO) {
		this.CONTACT_NO = CONTACT_NO;
	}

	public String getEmail() {
		return EMAIL;
	}

	public void setEmail(String EMAIL) {
		this.EMAIL = EMAIL;
	}

	public String getAge() {
		return AGE;
	}

	public void setAge(String AGE) {
		this.AGE = AGE;
	}

	public String getWeight() {
		return WEIGHT;
	}

	public void setWeight(String WEIGHT) {
		this.WEIGHT = WEIGHT;
	}

	public String getHeight() {
		return HEIGHT;
	}

	public void setHeight(String HEIGHT) {
		this.HEIGHT = HEIGHT;
	}

	public String getBlood_group() {
		return BLOOD_GROUP;
	}

	public void setBlood_group(String BLOOD_GROUP) {
		this.BLOOD_GROUP = BLOOD_GROUP;
	}

}