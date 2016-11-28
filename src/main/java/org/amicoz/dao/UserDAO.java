package org.amicoz.dao;

import java.util.ArrayList;
import java.util.List;

import org.amicoz.model.Post;
import org.amicoz.ui.model.GeneralSettingsInfoImpl;
import org.amicoz.ui.model.Group;
import org.amicoz.ui.model.PasswordResetSettingsInfoImpl;
import org.amicoz.ui.model.Posts;
import org.amicoz.ui.model.PrivacySettingsInfoImpl;
import org.amicoz.ui.model.RegistrationInfo;
import org.amicoz.ui.model.SearchResults;
import org.amicoz.ui.model.UserDetails;

public interface UserDAO {

	public Integer checkLogin(String userName, String password);
	
	public int addUser(RegistrationInfo registrationInfo);
	
	public ArrayList<String> getSecurityQueAndAnswer(String emailId, boolean alternate);
	
	public void updateRecoveryBitAndPassword(int userId, int recoveryBit, String encryptPassword);

	public ArrayList<String> getSettingsData(int userId);
	
	public boolean saveGeneralSettings(GeneralSettingsInfoImpl generalSettings, int userId);
	
	public boolean savePrivacySettings(PrivacySettingsInfoImpl privacySettings, int userId);
	
	public boolean savePasswordResetSettings(String username, PasswordResetSettingsInfoImpl passwordResetSettings, int userId);
	
	public boolean saveProfilePictureSettings(ProfilePictureSettingsImpl profilePictureSettings, int userId);

	public String getUserFullname(int _userId);
	
	public ArrayList<SearchResults> search(String keyword);

	public String getProfilePicURL(int _userId);
	
	public List<Group> displayGroups(int userID);
	
	public List<UserDetails> suggestFriends(int userID);
	
	public List<UserDetails> showPendingFriends(int userId);
	
	public List<UserDetails> showFriends(int userId);
	
	
}