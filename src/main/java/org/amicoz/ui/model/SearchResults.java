package org.amicoz.ui.model;

public class SearchResults {

	private int userId;
	
	private String emailId;
	
	private String fullname;

	private String city;
	
	private String profilePicUrl;


	
	public SearchResults(int userId, String emailId, String fullname, String city, String profilePicUrl) {
		super();
		this.userId = userId;
		this.emailId = emailId;
		this.fullname = fullname;
		this.city = city;
		this.profilePicUrl = profilePicUrl;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getProfilePicUrl() {
		return profilePicUrl;
	}

	public void setProfilePicUrl(String profilePicUrl) {
		this.profilePicUrl = profilePicUrl;
	}
	
	
	
	
}
