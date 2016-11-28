package org.amicoz.ui.model;

public class PrivacySettingsInfoImpl implements SettingsInfo {

	private String privacy;

	public String getPrivacy() {
		return privacy;
	}

	public void setPrivacy(String privacy) {
		
		if(privacy.equalsIgnoreCase("public"))
			this.privacy = "Y";
		else if(privacy.equalsIgnoreCase("private"))
			this.privacy = "P";
		else if(privacy.equalsIgnoreCase("Friends"))
			this.privacy = "F";
	}
	
	
	
}
