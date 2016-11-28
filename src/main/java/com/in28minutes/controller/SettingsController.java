package com.in28minutes.controller;

//@Controller
//@SessionAttributes(names={"s_fullname","s_emailid"})
public class SettingsController {/*

	@RequestMapping(value="/profile_settings", method=RequestMethod.GET)
	public String viewSettings(ModelMap modelMap) {
		System.out.println("Settings "+modelMap.get("s_emailid"));
		
		
		 * This should call the GeneralSettingsImpl.showSettings
		 * 
		 
		
	
		return "forward:/gen_settings";
		
		//return "settings";
	}
	
	
	@RequestMapping(value="/gen_settings", method=RequestMethod.GET)
	public String showGenSettings(ModelMap modelMap){
		 Get the settings from the database and load the settings page 
		
		System.out.println("Forwarded to gen_settings");
		//modelMap.addAttribute("fname", modelMap.get("s_s_fullname"));
		modelMap.addAttribute("fname", modelMap.get("s_fullname"));
		modelMap.addAttribute("lname", "lastname");
		modelMap.addAttribute("sec_email", modelMap.get("s_emailid"));
		modelMap.addAttribute("dob", new SimpleDateFormat("MM/dd/yyyy").format(new Date()));
		modelMap.addAttribute("phonenum", "82");
		String gender = "Female";
		if(gender.equalsIgnoreCase("Male")){
			modelMap.addAttribute("male", "selected");
			modelMap.addAttribute("female", "");
		}else {
			modelMap.addAttribute("male", "");
			modelMap.addAttribute("female", "selected");
		}
		//modelMap.addAttribute("gender", "Female");
		//modelMap.addAttribute("abc", "selected");
		modelMap.addAttribute("bio", "This is your bio!!!");
		modelMap.addAttribute("wholename", modelMap.get("s_fullname"));
		//modelMap.addAttribute("fname", modelMap.get("s_fullname"));
		//modelMap.addAttribute("lname", "lastname");
		//modelMap.addAttribute("email", modelMap.get("s_emailid"));
		
		return "forward:/privacy_settings";
	}
	
	
	@RequestMapping(value="/gen_settings", method=RequestMethod.POST)
	public @ResponseBody String saveGenSettings(@RequestParam String fname, ModelMap modelMap){
		 Get the settings from the jsp page and reload the settings page 
		System.out.println("Saving info as "+fname);
		//modelMap.addAttribute("message_color", "green");
		//modelMap.addAttribute("message", "Successfully updated!");
		//return "../settings";
		return "1";
	}
	
	
	
	/privacy_settings
	/password_settings
	/profile_pic_settings
	
	
	@RequestMapping(value="/privacy_settings", method=RequestMethod.GET)
	public String showPrivacySettings(ModelMap modelMap) {
		System.out.println("Forwarded to privacy_settings");
		
		String privacy = "public";		// get the data from the database and assign the privacy
		//modelMap.addAttribute("Settings", "Change your privacy settings here.");
	
		if(privacy.equalsIgnoreCase("private")) {
			modelMap.addAttribute("pri", "selected");
			modelMap.addAttribute("pub", "");
		} else {
			modelMap.addAttribute("pub", "selected");
			modelMap.addAttribute("pri", "");
		}

		//modelMap.addAttribute("pri","selected");
		//modelMap.addAttribute
		return "forward:/password_settings";
	}
	
	@RequestMapping(value="/password_settings", method=RequestMethod.GET)
	public String showPasswordSettings(ModelMap modelMap) {
		System.out.println("Forwarded to password_settings");
		 Nothing to do on get request for password settings 
		return "forward:/profile_pic_settings";
	}
	
	@RequestMapping(value="/profile_pic_settings", method=RequestMethod.GET)
	public String showProfilePicSettings(ModelMap modelMap) {
		System.out.println("Forwarded to profile_pic_settings");
		
		String imageSrc = "profilePics/"+modelMap.get("s_emailid")+".jpg";
		modelMap.addAttribute("img_src",imageSrc);
		return "/settings";
	}

	@RequestMapping(value="/profile_pic_settings", method=RequestMethod.POST)
	public @ResponseBody String saveProfilePicSettings(ModelMap map) {
		
		
		return "1";
	}
*/}
