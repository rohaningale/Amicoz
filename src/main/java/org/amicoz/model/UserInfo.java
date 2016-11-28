package org.amicoz.model;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//user id fname lname contact dob gender profilpic city state country school profilevisibility
@Entity
@Table(name="User_Info")
public class UserInfo {
	@Column(name="User_Id")
	@Id
	private int userId;
	@Column(name="First_Name", nullable=false)
	private String firstName;
	@Column(name="Last_Name")
	private String lastName;
	@Column(name="Contact_Number")
	private String contactNumber;
	@Temporal(TemporalType.DATE)
	@Column(name="Date_Of_Birth")
	private Date dateOfBirth;
	@Column(name="Bio")
	private String Bio;
	@Column(name="Gender")
	private String gender;
	@Column(name="ProfilePic_URL")
	private String profilePictureUrl;
	public String getBio() {
		return Bio;
	}
	public void setBio(String bio) {
		Bio = bio;
	}
	@Column(name="City")
	private String city;
	@Column(name="State")
	private String state;
	@Column(name="Country")
	private String country;
	@Column(name="School")
	private String school;
	@Column(name="Profile_Visibility")
	private String profileVisibility;

	@Column(name="Created_By", nullable=false)
	private String createdBy;
	@Column(name="Created_Date", nullable=false)
	private Date  CreationDate;
	@Column(name="Last_Updated_By", nullable=false)
	private String updatedBy;
	@Column(name="Last_Updated_Date", nullable=false)
	private Date UpdateDate;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
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
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getProfilePictureURL() {
		return profilePictureUrl;
	}
	public void setProfilePictureURL(String profilePictureURL) {
		this.profilePictureUrl = profilePictureURL;
	}
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
	public String getProfileVisibility() {
		return profileVisibility;
	}
	public void setProfileVisibility(String profileVisibility) {
		this.profileVisibility = profileVisibility;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreationDate() {
		return CreationDate;
	}
	public void setCreationDate(Date creationDate) {
		CreationDate = creationDate;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Date getUpdateDate() {
		return UpdateDate;
	}
	public void setUpdateDate(Date updateDate) {
		UpdateDate = updateDate;
	}

}