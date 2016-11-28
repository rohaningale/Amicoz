package com.in28minutes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

//import com.in28minutes.email.AmicozEmailService;
import com.in28minutes.service.LoginService;


@Controller
@SessionAttributes(value = {"s_emailid","s_fullname", "s_time","s_recovery"})
public class UAMController {

	// set the LoginService - AutoWiring
	@Autowired
	LoginService service;
/*	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String _showLoginPage(ModelMap modelMap) {
		
		if(modelMap.get("s_emailid") == null || modelMap.get("s_emailid").equals("")){
			return "../login_amicoz";
		}
		
		return "index";
		//System.out.println();
	}*/
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage() {
		return "login";
	} 
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String handleLoginRequest(@RequestParam String emailId, @RequestParam String password, ModelMap modelMap) {

		/* check if the username and password combination is present
		 * 
		 *   also check if the recovery option is set to true (1)
		 *   
		 *   if recovery option is set to 1 then make the user to reset the password.
		 *   
		 *   */
		
		//String recovery = "1";
		
		if(modelMap.get("s_recovery") != null &&
				modelMap.get("s_recovery").toString() != ""
				&& modelMap.get("s_recovery").toString() == "1") {
			
			modelMap.addAttribute("s_emailid",emailId);
			
			return "redirect:/password_settings#reset_pass";
		} 
		
		if(!service.validateUser(emailId, password)) {
			modelMap.put("errorMessage", "invalid credentials");
			return "../login_amicoz";
		}
		modelMap.put("s_emailid", emailId );
		modelMap.put("s_fullname", emailId.substring(0,emailId.indexOf("@")));
		
		/*AmicozEmailService.sendNotificationEMail(
				new CustomMessage("amicoz.network@gmail.com", modelMap.get("s_emailid").toString(), 
						"Amicoz Network: Login success", "You just logged in to Amicoz network "
						+ "\n Log in time " +new Date()
						+ "\n Your session is active"));
		*/
		//modelMap.put("name", name);
		//modelMap.put("time", new Date());
		//System.out.println(name);
		//return "welcome";
		
/*		
		String args[] = new String[4];
		args[0] = modelMap.get("s_emailid").toString(); args[1] = "amicoz.network@gmail.com"; 
		args[2] = "Amicoz Network: Login success";
		args[3] = "You just logged in to Amicoz network "
						+ "\n Log in time " +new Date()
						+ "\n Your session is active";
		CrunchifyEmailTest.main(args);*/
		
		
		return "profile";
		//return "forward:/index";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(ModelMap modelMap){
		/*AmicozEmailService.sendNotificationEMail(
				new CustomMessage("amicoz.network@gmail.com", modelMap.get("s_emailid").toString(), 
						"Amicoz Network: Logout success", "You just logged out from Amicoz network."
						+ "\n Logout time " +new Date()));*/
		System.out.println(modelMap.get("s_emailid"));
		modelMap.put("s_emailid", "");
		return "../login_amicoz";
	}
	
	/*@RequestMapping(value="/forgot_password_1", method = RequestMethod.GET)
	public String handleForgotPassword_1_GET(ModelMap modelMap) {
		
		return "forgot_password_1";
	}
	
	@RequestMapping(value="/forgot_password_1", method = RequestMethod.POST)
	public String handleForgotPassword_1_POST(@RequestParam String emailId, ModelMap modelMap) {
		
		
		String email = "anandk10@gmail.com"; // get email id frm database
		
		
		if(emailId.equals(email)) {
			 signifies that the a user with the provided email address exists. 
			 Setting the user id in the session to recognize which user is trying to retrieve the password
			//modelMap.addAttribute("s_emailid",email);
			
			System.out.println("UserInfoEntity is requesting to get new password");
			
			 Get the security question from the database for the corresponding email id 
			 set the userid in the hidden label element 
			String secQuestion = "What is the name of your first car?";
			modelMap.put("userId", "123");
			modelMap.put("emailId", email);
			System.out.println(modelMap.get("userId")+","+modelMap.get("emailId"));
			modelMap.put("security_question",secQuestion);
			return "forgot_password_2";
		}
		System.out.println("hello");
		modelMap.addAttribute("message","<b>Sorry, UserInfoEntity with such alternate email id doesn't exists ! </b>");
		modelMap.addAttribute("color","red");
		return "forgot_password_1";
		
	}
	*/
	@RequestMapping(value="/forgot_password_get", method = RequestMethod.GET)
	public String handleForgotPassword_2_GET(@RequestParam String answer, ModelMap modelMap) {
		/* Get the corresponding security question */
		
		/* retrieve the security question of the corresponding user id */
		System.out.println("forgot password 2 get");
		return "forgot_password_2";
	}
	
/*	@RequestMapping(value="/forgot_password_2", method = RequestMethod.POST)
	public String handleForgotPassword_2_POST(@RequestParam String emailId, @RequestParam String security_question, @RequestParam String answer, ModelMap modelMap) {
		 Get the corresponding security question 
		
		 retrieve the security question and the answer of the corresponding user id 
		//String sec_question = modelMap.get("security_question").toString();
		System.out.println(security_question);
		System.out.println(answer);
		
		if(!answer.trim().equalsIgnoreCase("")) {
			
			 Check the provided answer is correct 
			String actualAnswer = "answer";
			if(answer.equalsIgnoreCase(actualAnswer)) {
				
				int rand = new Random().nextInt(Integer.MAX_VALUE);
				String dummyPassword = String.valueOf(rand);
				System.out.println("Dummy generated password : "+dummyPassword);
				
				 make this insertion in the db after encrypting it.
				 * and mark the flag for recovery as true  
				 * 
				
				String encryptPassword = PasswordEncryptionService_old.MD5(dummyPassword);
				modelMap.addAttribute("s_recovery", "1");
				System.out.println(encryptPassword);
				
				int flag = 1;

				 db.insert(encryptPassword,1,userId)  
				
				String args[] = new String[4];
				args[0] = emailId; args[1] = "amicoz.network@gmail.com"; 
				args[2] = "Amicoz Network: Request for forgot username";
				args[3] = "Login with your alternate email id "
						+ "and put the following dummy password at the time of login "+dummyPassword;
				
				
				//CrunchifyEmailTest.main(args);
				
				return "../login_amicoz";
			}
			
			
		}
		

		return "forgot_password_2";
	}
*/	
	
	/*
	
	
	@RequestMapping(value="/forgot_username_1", method = RequestMethod.GET)
	public String handleForgotUsername_1_GET( ModelMap modelMap) {
		 return the forgot_username_1 page 
		return "forgot_username_1";
	}
	
	@RequestMapping(value="/forgot_username_1", method = RequestMethod.POST)
	public String handleForgotUsername_1_POST(@RequestParam String emailId, ModelMap modelMap) {
		  Check whether the provided alternate email id is present in the database 
		String email = "anandk10@gmail.com";
		System.out.println("Reseting");
		if(emailId.equals(email)) {
			 This alternate email id is present 
			 * Set a dummy password in the database table and show it
			 * 
			int rand = new Random().nextInt(Integer.MAX_VALUE);
			String dummyPassword = String.valueOf(rand);
			System.out.println("Dummy generated password : "+dummyPassword);
			AmicozEmailService.sendNotificationEMail(
					new CustomMessage("amicoz.network@gmail.com", email, 
							"Amicoz Network: Request for forgot username", 
							"Put the following dummy password at the time of login "+dummyPassword));
			String args[] = new String[4];
			args[0] = email; args[1] = "amicoz.network@gmail.com"; 
			args[2] = "Amicoz Network: Request for forgot username";
			args[3] = "Login with your alternate email id "
					+ "and put the following dummy password at the time of login "+dummyPassword;
			
			
			CrunchifyEmailTest.main(args);
		}
		return "../login_amicoz";
	}
	*/
/*	@RequestMapping(value="/forgot_username_2", method = RequestMethod.GET)
	public String handleForgotUsername_2_GET(ModelMap modelMap) {
		return "forgot_username";
	}
	
	@RequestMapping(value="/forgot_username_2", method = RequestMethod.POST)
	public String handleForgotUsername_2_POST(ModelMap modelMap) {
		return "forgot_username";
	}*/

}
