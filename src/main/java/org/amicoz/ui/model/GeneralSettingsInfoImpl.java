package org.amicoz.ui.model;

public class GeneralSettingsInfoImpl implements SettingsInfo {

	
	private String fname;
	private String lname;
	private String email;
	private String dob;
	private String phonenum;
	private String gender;
	private String bio;
    private String city;
    public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	private String state;
    private String country;
    private String school;
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	@Override
	public String toString() {
		return "GeneralSettingsInfoImpl [fname=" + fname + ", lname=" + lname + ", email=" + email + ", dob=" + dob
				+ ", phonenum=" + phonenum + ", gender=" + gender + ", bio=" + bio + ", city=" + city + ", state="
				+ state + ", country=" + country + ", school=" + school + "]";
	}

	
}
