package com.in28minutes.ui.model;

public class GeneralSettingsInfoImpl implements SettingsInfo {

	private String firstName;
	private String lastName;
	private String emailId;
	private String dob;
	private String phoneNum;
	private String gender;
	private String bioInfo;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBioInfo() {
		return bioInfo;
	}
	public void setBioInfo(String bioInfo) {
		this.bioInfo = bioInfo;
	}
	
	
	
}
