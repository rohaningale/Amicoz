package org.amicoz.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.amicoz.dao.UserDAO;
import org.amicoz.security.PasswordEncryptionService;
import org.amicoz.ui.model.Group;
import org.amicoz.ui.model.LoginInfo;
import org.amicoz.ui.model.RegistrationInfo;
import org.amicoz.ui.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.google.gson.Gson;
import com.in28minutes.security.PasswordEncryptionService_old;

import crunchify.com.tutorials.CrunchifyEmailTest;

@Controller
@SessionAttributes(value = { "s_emailid", "s_userid", "s_fullname", "s_groupid", "s_imgsrc" })
public class LoginController {
	/*
	 * @Autowired LoginService service;
	 */

	@Autowired
	UserDAO userDao;

	@RequestMapping(value = "/login_amicoz", method = RequestMethod.GET)
	public String _showLoginPage(ModelMap modelMap) {

/*		if (modelMap.get("s_userid") == null || modelMap.get("s_userid").equals("")) {
			return "../login_amicoz";
		}*/
		
		if(modelMap.get("s_userid").equals("invalid")) {
			return "../login_amicoz";
		}
		modelMap.addAttribute("s_imgsrc",
				userDao.getProfilePicURL(Integer.parseInt(modelMap.get("s_userid").toString())));
		return "profile";
		// System.out.println();
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String _showLoginPage_1(ModelMap modelMap) {

		if (modelMap.get("s_userid") == null || modelMap.get("s_userid").equals("")) {
			return "../login_amicoz";
		}
		modelMap.addAttribute("s_imgsrc",
				userDao.getProfilePicURL(Integer.parseInt(modelMap.get("s_userid").toString())));
		// return "index";
		// return "redirect:/profile?userid="+modelMap.get("s_userid");
		// return "index";
		return "redirect:/frontPage";

		// System.out.println();
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String _showLoginPage_2(ModelMap modelMap) {

		if (modelMap.get("s_emailid") == null || modelMap.get("s_emailid").equals("")) {
			return "../login_amicoz";
		}
		modelMap.addAttribute("s_imgsrc",
				userDao.getProfilePicURL(Integer.parseInt(modelMap.get("s_userid").toString())));
		// return "index";
		return "redirect:/index";
		// System.out.println();
	}

	/*
	 * @RequestMapping(value = "/login_amicoz", method = RequestMethod.GET)
	 * public String showLoginPage() { return "forward:/"; }
	 */

	/*
	 * @RequestMapping(method = RequestMethod.GET) public ModelAndView login(){
	 * ModelAndView loginModel = new ModelAndView("login"); User user = new
	 * User(); loginModel.addObject(user); return loginModel; }
	 */

	/*
	 * @RequestMapping(value = "/login", method = RequestMethod.POST) public
	 * ModelAndView checkLogin(BindingResult result, ModelAndView loginModel){
	 * 
	 * User user = (User)loginModel.getModel().get("login");
	 * 
	 * }
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("RegistrationInfo") RegistrationInfo registrationInfo, ModelMap model) {
		/*
		 * UserDAO userRegistration = new UserDaoImpl(); ModelAndView mv = new
		 * ModelAndView(""); if(userRegistration.addUser(registrationInfo))
		 * mv.addObject("message", "Entry successful"); else
		 * mv.addObject("message","Error in entry"); return mv;
		 */
		System.out.println(
				"Email ID-->" + registrationInfo.getEmailId() + " Password-->" + registrationInfo.getPassword());
		if (userDao.addUser(registrationInfo) == 1)
			return "../login_amicoz";
		else if (userDao.addUser(registrationInfo) == 0) {
			model.addAttribute("firstname", registrationInfo.getFirstname());
			model.addAttribute("lastname", registrationInfo.getLastname());
			model.addAttribute("emailId", registrationInfo.getEmailId());
			model.addAttribute("password", registrationInfo.getPassword());
			if (registrationInfo.getSecretAnswer() != null)
				model.addAttribute("secretAnswer", registrationInfo.getSecretAnswer());
			if (registrationInfo.getSecondaryEmail() != null)
				model.addAttribute("secondaryEmail", registrationInfo.getSecondaryEmail());
			model.addAttribute("erroralert", "Account already exists!!!");
			return "../register";
		} else {
			return "/error";
		}
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerUser(ModelMap modelMap) {
		return "../register";
	}

	@RequestMapping(value = "/login_amicoz", method = RequestMethod.POST)
	public @ResponseBody String validate(@ModelAttribute("LoginInfo") LoginInfo loginInfo, ModelMap modelMap) throws IOException {
		// System.out.println("In controller function validate!!!
		// username"+loginInfo.getUsername()+"password"+loginInfo.getPassword());
		loginInfo.setPassword(PasswordEncryptionService.MD5(loginInfo.getPassword()));
		System.out.println(loginInfo.getPassword());
		int _userId;
		if ((_userId = userDao.checkLogin(loginInfo.getUsername(), loginInfo.getPassword())) != Integer.MIN_VALUE) {

			modelMap.put("s_fullname", userDao.getUserFullname(_userId));

			modelMap.put("s_emailid", loginInfo.getUsername());
			// fetch fullname from database
			// modelMap.put("s_fullname",
			// loginInfo.getUsername().substring(0,loginInfo.getUsername().indexOf("@")));
			modelMap.put("s_userid", _userId);
			modelMap.addAttribute("s_imgsrc", userDao.getProfilePicURL(_userId));
			return "1";
			//return "forward:/frontPage";
			// return "index";
			// return "forward:/groupcreate";
		}
		modelMap.put("errorMessage", "invalid credentials");
		//return "../login_amicoz";
		return "0";
	}

	@RequestMapping(value = "/logout")
	public String logout(ModelMap modelMap) {
		modelMap.addAttribute("s_userid", "invalid");
		modelMap.addAttribute("s_emailid", "invalid");
		modelMap.addAttribute("s_imgsrc", "invalid");
		modelMap.addAttribute("s_groupid", "invalid");
		modelMap.addAttribute("s_fullname", "invalid");
		return "../login_amicoz";
	}

	@RequestMapping(value = "/forgot_password_1", method = RequestMethod.GET)
	public String handleForgotPassword_1_GET(ModelMap modelMap) {

		return "/forgot_password_1";
	}

	@RequestMapping(value = "/forgot_password_1", method = RequestMethod.POST)
	public String handleForgotPassword_1_POST(@RequestParam String emailId, ModelMap modelMap) {
		// String email = "anandk10@gmail.com";
		ArrayList<String> retVal = userDao.getSecurityQueAndAnswer(emailId, false);

		if (retVal != null) {
			System.out.println("User " + retVal.get(0) + " is requesting to get new password");
			modelMap.addAttribute("security_question", "<b>" + retVal.get(1) + "</b>");
			modelMap.addAttribute("emailId", emailId);
			modelMap.addAttribute("userId", retVal.get(0));
			return "forgot_password_2";
		}

		System.out.println("hello");
		modelMap.addAttribute("message", "<b>Sorry, User with such alternate email id doesn't exists ! </b>");
		modelMap.addAttribute("color", "red");
		return "forgot_password_1";

	}

	@RequestMapping(value = "/forgot_password_2", method = RequestMethod.POST)
	public String handleForgotPassword_2_POST(@RequestParam String emailId, @RequestParam String userId,
			@RequestParam String security_question, @RequestParam String answer, ModelMap modelMap) {
		/* Get the corresponding security question */

		/*
		 * retrieve the security question and the answer of the corresponding
		 * user id
		 */
		// String sec_question = modelMap.get("security_question").toString();
		// System.out.println(security_question);
		answer = answer.trim();
		// System.out.println(answer);

		if (!answer.equalsIgnoreCase("")) {

			/* Check the provided answer is correct */

			/* String actualAnswer = "answer"; */
			System.out.println(emailId);
			ArrayList<String> retVal = userDao.getSecurityQueAndAnswer(emailId, false);

			if (retVal == null)
				return "forgot_password_2";

			System.out.println("retVal " + retVal);
			System.out.println("size " + retVal.size());
			System.out.println("actual answer " + retVal.get(2));
			System.out.println("supplie answer: " + answer);
			if (answer.equalsIgnoreCase(retVal.get(2))) {
				int rand = new Random().nextInt(Integer.MAX_VALUE);
				String dummyPassword = String.valueOf(rand);
				System.out.println("Dummy generated password : " + dummyPassword);

				String encryptPassword = PasswordEncryptionService_old.MD5(dummyPassword);
				System.out.println(encryptPassword);
				modelMap.addAttribute("s_recovery", "1");
				System.out.println("User id : " + userId);
				userDao.updateRecoveryBitAndPassword(Integer.parseInt(userId), 1, encryptPassword);

				String args[] = new String[4];
				args[0] = emailId;
				args[1] = "amicoz.network@gmail.com";
				args[2] = "Amicoz Network: Request for password recovery.";
				args[3] = "Login with your primary email id " + "and put the following password at the time of login "
						+ dummyPassword + ". "
						+ "Please make sure to reset the password by going to Settings > Reset Password section.";
				CrunchifyEmailTest.main(args);

				return "../login_amicoz";
			}
		}

		return "forgot_password_2";
	}

	@RequestMapping(value = "/forgot_username_1", method = RequestMethod.GET)
	public String handleForgotUsername_1_GET(ModelMap modelMap) {
		return "forgot_username_1";
	}

	@RequestMapping(value = "/forgot_username_1", method = RequestMethod.POST)
	public String handleForgotUsername_1_POST(@RequestParam String emailId, ModelMap modelMap) {
		// String email = "anandk10@gmail.com";
		System.out.println("Reseting");
		System.out.println("for " + emailId);
		ArrayList<String> retVal = userDao.getSecurityQueAndAnswer(emailId, true);

		System.out.println(retVal);
		if (retVal != null) {

			modelMap.put("security_question", retVal.get(1));
			modelMap.put("userId", retVal.get(0));
			modelMap.put("emailId", emailId);
			return "forgot_username_2";
		}

		// if(emailId.equals(email)) {
		/*
		 * This alternate email id is present Set a dummy password in the
		 * database table and show it
		 * 
		 * int rand = new Random().nextInt(Integer.MAX_VALUE); String
		 * dummyPassword = String.valueOf(rand); System.out.println(
		 * "Dummy generated password : "+dummyPassword);
		 * AmicozEmailService.sendNotificationEMail( new
		 * CustomMessage("amicoz.network@gmail.com", email,
		 * "Amicoz Network: Request for forgot username",
		 * "Put the following dummy password at the time of login "
		 * +dummyPassword));
		 */
		/*
		 * String args[] = new String[4]; args[0] = email; args[1] =
		 * "amicoz.network@gmail.com"; args[2] =
		 * "Amicoz Network: Request for forgot username"; args[3] =
		 * "Login with your alternate email id " +
		 * "and put the following dummy password at the time of login "
		 * +dummyPassword;
		 * 
		 * 
		 * CrunchifyEmailTest.main(args);
		 */
		// }
		return "forgot_username_1";
	}

	@RequestMapping(value = "/forgot_username_2", method = RequestMethod.GET)
	public String handleForgotUsername_2_GET(ModelMap modelMap) {
		return "/forgot_username";
	}

	@RequestMapping(value = "/forgot_username_2", method = RequestMethod.POST)
	public String handleForgotUsername_2_POST(@RequestParam String security_question, @RequestParam String userId,
			@RequestParam String emailId, @RequestParam String answer, ModelMap modelMap) {

		answer = answer.trim();
		// System.out.println(answer);

		if (!answer.equalsIgnoreCase("")) {

			/* Check the provided answer is correct */

			/* String actualAnswer = "answer"; */
			System.out.println(emailId);
			ArrayList<String> retVal = userDao.getSecurityQueAndAnswer(emailId, true);

			if (retVal == null)
				return "forgot_password_2";

			if (answer.equalsIgnoreCase(retVal.get(2))) {
				int rand = new Random().nextInt(Integer.MAX_VALUE);
				String dummyPassword = String.valueOf(rand);
				System.out.println("Dummy generated password : " + dummyPassword);

				String encryptPassword = PasswordEncryptionService_old.MD5(dummyPassword);
				System.out.println(encryptPassword);
				modelMap.addAttribute("s_recovery", "1");
				System.out.println("User id : " + userId);
				userDao.updateRecoveryBitAndPassword(Integer.parseInt(userId), 1, encryptPassword);

				String args[] = new String[4];
				args[0] = emailId;
				args[1] = "amicoz.network@gmail.com";
				args[2] = "Amicoz Network: Request for password recovery.";
				args[3] = "Login with your primary email id (" + retVal.get(3)
						+ "), and put the following password at the time of login " + dummyPassword + ". "
						+ "Please make sure to reset the password by going to Settings > Reset Password section.";
				CrunchifyEmailTest.main(args);

				return "../login_amicoz";
			}

			return "/forgot_username_2";

		}

		return "/forgot_username_2";
	}

	@RequestMapping(value = "/indexDtls", method = RequestMethod.POST)
	public String loadIndexPage(ModelMap modelmap) {
		System.out.println("Inside loadIndexPage()");

		System.out.println(modelmap.get("s_userid"));
		// List<Group> groupList = new ArrayList<Group>();

		int userID = (int) modelmap.get("s_userid");
		List<Group> groupList = userDao.displayGroups(userID);
		System.out.println("group list size : " + groupList.size());
		List<UserDetails> friendSuggestionList = userDao.suggestFriends(userID);
		List<UserDetails> pendingReqFromFriendsList = userDao.showPendingFriends(userID);
		List<UserDetails> friendsList = userDao.showFriends(userID);
		Gson g = new Gson();
		String groupListJSON = g.toJson(groupList);
		String friendSuggestionJSON = g.toJson(friendSuggestionList);
		// System.out.println(friendSuggestionJSON);
		String pendingReqFromFriendsListJSON = g.toJson(pendingReqFromFriendsList);
		// System.out.println(pendingReqFromFriendsListJSON);
		String friendsListJSON = g.toJson(friendsList);
		modelmap.addAttribute("groups", groupListJSON);
		modelmap.addAttribute("friendSuggestion", friendSuggestionJSON);
		modelmap.addAttribute("pendingReqFromFriends", pendingReqFromFriendsListJSON);
		modelmap.addAttribute("friends", friendsListJSON);
		return "index";
	}

	@RequestMapping(value = "/indexDtls", method = RequestMethod.GET)
	public String loadIndexPage_GET(ModelMap modelmap) {
		System.out.println("Inside loadIndexPage()");

		System.out.println(modelmap.get("s_userid"));
		// List<Group> groupList = new ArrayList<Group>();

		int userID = (int) modelmap.get("s_userid");
		List<Group> groupList = userDao.displayGroups(userID);
		System.out.println("group list size : " + groupList.size());
		List<UserDetails> friendSuggestionList = userDao.suggestFriends(userID);
		List<UserDetails> pendingReqFromFriendsList = userDao.showPendingFriends(userID);
		List<UserDetails> friendsList = userDao.showFriends(userID);
		Gson g = new Gson();
		String groupListJSON = g.toJson(groupList);
		String friendSuggestionJSON = g.toJson(friendSuggestionList);
		// System.out.println(friendSuggestionJSON);
		String pendingReqFromFriendsListJSON = g.toJson(pendingReqFromFriendsList);
		// System.out.println(pendingReqFromFriendsListJSON);
		String friendsListJSON = g.toJson(friendsList);
		modelmap.addAttribute("groups", groupListJSON);
		modelmap.addAttribute("friendSuggestion", friendSuggestionJSON);
		modelmap.addAttribute("pendingReqFromFriends", pendingReqFromFriendsListJSON);
		modelmap.addAttribute("friends", friendsListJSON);
		return "index";
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String showIndexPage_GET(ModelMap modelMap) {

/*		if (modelMap.get("s_userid") == null || modelMap.get("s_userid").equals("")) {
			return "../login_amicoz";
		}*/
		
		if(modelMap.get("s_userid").equals("invalid")) {
			return "../login_amicoz";
		}
		return "redirect:/frontPage";
		
/*		modelMap.addAttribute("s_imgsrc",
				userDao.getProfilePicURL(Integer.parseInt(modelMap.get("s_userid").toString())));

		System.out.println("Inside loadIndexPage()");

		System.out.println(modelMap.get("s_userid"));
		// List<Group> groupList = new ArrayList<Group>();

		int userID = (int) modelMap.get("s_userid");
		List<Group> groupList = userDao.displayGroups(userID);
		System.out.println("group list size : " + groupList.size());
		List<UserDetails> friendSuggestionList = userDao.suggestFriends(userID);
		List<UserDetails> pendingReqFromFriendsList = userDao.showPendingFriends(userID);
		List<UserDetails> friendsList = userDao.showFriends(userID);
		Gson g = new Gson();
		String groupListJSON = g.toJson(groupList);
		String friendSuggestionJSON = g.toJson(friendSuggestionList);
		// System.out.println(friendSuggestionJSON);
		System.out.println("group list json " + groupListJSON);
		String pendingReqFromFriendsListJSON = g.toJson(pendingReqFromFriendsList);
		// System.out.println(pendingReqFromFriendsListJSON);
		String friendsListJSON = g.toJson(friendsList);
		modelMap.addAttribute("groups", groupListJSON);
		modelMap.addAttribute("friendSuggestion", friendSuggestionJSON);
		modelMap.addAttribute("pendingReqFromFriends", pendingReqFromFriendsListJSON);
		modelMap.addAttribute("friends", friendsListJSON);

		return "index";*/
	}

	/*
	 * @RequestMapping(value="/forgot_password_2", method = RequestMethod.GET)
	 * public String handleForgotPassword_2_GET(@RequestParam String answer,
	 * ModelMap modelMap) {
	 * 
	 * return "/forgot_password_2"; }
	 */
	/*
	 * @RequestMapping(value="/forgot_password_2", method = RequestMethod.POST)
	 * public String handleForgotPassword_2_POST(@RequestParam String answer,
	 * ModelMap modelMap) { Get the corresponding security question
	 * 
	 * retrieve the security question of the corresponding user id
	 * 
	 * return "/forgot_password_2"; }
	 * 
	 * 
	 * @RequestMapping(value="/forgot_username_1", method = RequestMethod.GET)
	 * public String handleForgotUsername_1_GET( ModelMap modelMap) { return the
	 * forgot_username_1 page return "/forgot_username_1"; }
	 * 
	 * @RequestMapping(value="/forgot_username_1", method = RequestMethod.POST)
	 * public String handleForgotUsername_1_POST(@RequestParam String emailId,
	 * ModelMap modelMap) { Check whether the provided alternate email id is
	 * present in the database String email = "anandk10@gmail.com";
	 * System.out.println("Reseting"); if(emailId.equals(email)) { This
	 * alternate email id is present Set a dummy password in the database table
	 * and show it
	 * 
	 * int rand = new Random().nextInt(Integer.MAX_VALUE); String dummyPassword
	 * = String.valueOf(rand); System.out.println("Dummy generated password : "
	 * +dummyPassword); Emailer.sendMessage(new CustomMessage(email,
	 * "Please login with this dummy password and reset the password."));
	 * 
	 * 
	 * 
	 * 
	 * } return "/login"; }
	 */

	/*
	 * @ModelAttribute public LoginInfo getLoginInfo(@RequestParam String
	 * username, @RequestParam String password){
	 * loginInfo.setUsername(username); loginInfo.setPassword(password); return
	 * loginInfo; }
	 */
}