package org.amicoz.ui.model;

import org.amicoz.security.PasswordEncryptionService;

public class PasswordResetSettingsInfoImpl {

	private String currentPassword, newPassword;
	
	public String getCurrentPassword() {
		return currentPassword;
	}

	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = PasswordEncryptionService.MD5(currentPassword);
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = PasswordEncryptionService.MD5(newPassword);
	}

	private String confirmPassword;


	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		
		this.confirmPassword = PasswordEncryptionService.MD5(confirmPassword);
	}
	
	
	
	
}
