package org.amicoz.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.amicoz.dao.ProfilePictureSettingsImpl;
import org.amicoz.dao.UserDAO;
import org.amicoz.ui.model.GeneralSettingsInfoImpl;
import org.amicoz.ui.model.PasswordResetSettingsInfoImpl;
import org.amicoz.ui.model.PrivacySettingsInfoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import crunchify.com.tutorials.CrunchifyEmailTest;

@Controller
@SessionAttributes(names = { "s_emailid", "s_userid", "s_fullname","s_groupid","s_imgsrc" })
public class SettingsController {
	@Autowired
	UserDAO userDao;
	private ArrayList<String> retVal;

	@RequestMapping(value = "/profile_settings", method = RequestMethod.GET)
	public String viewSettings(ModelMap modelMap) {

		if (modelMap.get("s_userid") == null || modelMap.get("s_userid").equals("")) {
			return "../login_amicoz";
		}

		// System.out.println("Settings "+modelMap.get("s_emailid"));
		/*
		 * 
		 * This should call the GeneralSettingsImpl.showSettings
		 * 
		 */
		// modelMap.put("s_fullname", value)
		modelMap.addAttribute("s_imgsrc", userDao.getProfilePicURL(Integer.parseInt(modelMap.get("s_userid").toString())));
		return "forward:/gen_settings";

		// return "settings";
	}

	@RequestMapping(value = "/gen_settings", method = RequestMethod.GET)
	public String showGenSettings(ModelMap modelMap) {
		/* Get the settings from the database and load the settings page */

		if (modelMap.get("s_userid") == null || modelMap.get("s_userid").equals("")) {
			return "../login_amicoz";
		}

		retVal = userDao.getSettingsData(Integer.parseInt(modelMap.get("s_userid").toString()));
		System.out.println(""+retVal.size());
		// System.out.println("Forwarded to gen_settings " +retVal);
		modelMap.addAttribute("sec_email", retVal.get(1));
		modelMap.addAttribute("fname", retVal.get(2));
		modelMap.addAttribute("lname", retVal.get(3));
		modelMap.addAttribute("phonenum", retVal.get(4));
		modelMap.addAttribute("dob", retVal.get(5));// new
													// SimpleDateFormat("MM/dd/yyyy").format(new
													// Date(retVal.get(4))));
		
		modelMap.addAttribute("city", retVal.get(10));
		modelMap.addAttribute("state", retVal.get(11));
		modelMap.addAttribute("country", retVal.get(12));
		modelMap.addAttribute("school", retVal.get(13));
		// System.out.println("School name at UI : "+retVal.get(13)+" rendered
		// as "+modelMap.get("school"));
		//System.out.println(retVal.get(6));
		if (retVal.get(7).equalsIgnoreCase("Male")) {
			modelMap.addAttribute("male", "selected");
			modelMap.addAttribute("female", "");
		} else {
			modelMap.addAttribute("male", "");
			modelMap.addAttribute("female", "selected");
		}

		modelMap.addAttribute("bio", retVal.get(6));

		return "forward:/privacy_settings";
	}

	@RequestMapping(value = "/privacy_settings", method = RequestMethod.POST)
	public @ResponseBody String savePrivacySettingss(
			@ModelAttribute PrivacySettingsInfoImpl privacySettings,
			ModelMap modelMap) {
		if (userDao.savePrivacySettings(privacySettings, Integer.parseInt(modelMap.get("s_userid").toString()))) {
			return "1";
		}
		return "0";
	}

	@RequestMapping(value = "/password_settings", method = RequestMethod.POST)
	public @ResponseBody String savePasswordSettings(@ModelAttribute PasswordResetSettingsInfoImpl passwordSettings,
			ModelMap modelMap) {
		String args[] = new String[4];
		args[0] = modelMap.get("s_emailid").toString();
		args[1] = "amicoz.network@gmail.com";
		args[2] = "Amicoz Network: Password Reset.";
		if (userDao.savePasswordResetSettings(modelMap.get("s_emailid").toString(), passwordSettings,
				Integer.parseInt(modelMap.get("s_userid").toString()))) {

			args[3] = "You recently changed your password. - Amicoz Network";
			CrunchifyEmailTest.main(args);

			return "1";
		}
		String time = " Activity took place on " + new SimpleDateFormat("yyyy-mm-dd hh:mm:ss").format(new Date());

		args[3] = "Password reset initiated. " + time;

		CrunchifyEmailTest.main(args);

		return "0";
	}

	@RequestMapping(value = "/profile_pic_settings", method = RequestMethod.POST)
	public @ResponseBody String saveProfilePicSettings(@ModelAttribute ProfilePictureSettingsImpl profilePicSettings,
			ModelMap modelMap) {
		if (userDao.saveProfilePictureSettings(profilePicSettings,
				Integer.parseInt(modelMap.get("s_userid").toString()))) {
			return "1";
		}
		return "0";
	}

	@RequestMapping(value = "/gen_settings", method = RequestMethod.POST)
	public @ResponseBody String saveGenSettings(@ModelAttribute GeneralSettingsInfoImpl generalSettings,
			ModelMap modelMap) {
		/* Get the settings from the jsp page and reload the settings page */
		// System.out.println("Saving info as "+fname);
		// modelMap.addAttribute("message_color", "green");
		// modelMap.addAttribute("message", "Successfully updated!");
		// return "../settings";

		// System.out.println(generalSettings);

		if (userDao.saveGeneralSettings(generalSettings, Integer.parseInt(modelMap.get("s_userid").toString())))
			return "1";
		return "0";
	}

	/*
	 * /privacy_settings /password_settings /profile_pic_settings
	 * 
	 */
	@RequestMapping(value = "/privacy_settings", method = RequestMethod.GET)
	public String showPrivacySettings(ModelMap modelMap) {
		if (modelMap.get("s_userid") == null || modelMap.get("s_userid").equals("")) {
			return "../login_amicoz";
		}

		System.out.println("Forwarded to privacy_settings");
		String privacy = retVal.get(8);
		System.out.println("DB has "+privacy);
/*		if (privacy == "P") {
			System.out.println("private privacy");
			modelMap.addAttribute("pri", "selected");
			modelMap.addAttribute("pub", "");
			modelMap.addAttribute("fri", "");
		} else if (privacy == "Y") {
			System.out.println("public privacy");
			modelMap.addAttribute("pub", "selected");
			modelMap.addAttribute("pri", "");
			modelMap.addAttribute("fri", "");
		} else {
			System.out.println("friend privacy");
			modelMap.addAttribute("fri", "selected");
			modelMap.addAttribute("pri", "");
			modelMap.addAttribute("pub", "");
		}*/
		
		if(privacy.equals("Y")) {
			System.out.println("Its public");
			modelMap.addAttribute("pub", "selected");
			modelMap.addAttribute("pri", "");
			modelMap.addAttribute("fri", "");
		} else if(privacy.equals("P")) {
			System.out.println("Its private");
			modelMap.addAttribute("pub", "");
			modelMap.addAttribute("pri", "selected");
			modelMap.addAttribute("fri", "");
		} else if(privacy.equals("F")) {
			System.out.println("Its friends");
			modelMap.addAttribute("pub", "");
			modelMap.addAttribute("pri", "");
			modelMap.addAttribute("fri", "selected");
		}
		

		// modelMap.addAttribute("pri","selected");
		// modelMap.addAttribute
		return "forward:/password_settings";
	}

	@RequestMapping(value = "/password_settings", method = RequestMethod.GET)
	public String showPasswordSettings(ModelMap modelMap) {
		if (modelMap.get("s_userid") == null || modelMap.get("s_userid").equals("")) {
			return "../login_amicoz";
		}

		System.out.println("Forwarded to password_settings");
		/* Nothing to do on get request for password settings */
		return "forward:/profile_pic_settings";
	}

	@RequestMapping(value = "/profile_pic_settings", method = RequestMethod.GET)
	public String showProfilePicSettings(ModelMap modelMap) {
		if (modelMap.get("s_userid") == null || modelMap.get("s_userid").equals("")) {
			return "../login_amicoz";
		}

		System.out.println("Forwarded to profile_pic_settings");
		System.out.println(modelMap.get("s_emailid"));
		String imageSrc = "profilePics/" + modelMap.get("s_emailid") + ".jpg";
		modelMap.addAttribute("img_src", userDao.getProfilePicURL(Integer.parseInt(modelMap.get("s_userid").toString())));
		return "/settings";
	}

}
