package com.in28minutes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.in28minutes.security.PasswordEncryptionService_old;

@Controller
@SessionAttributes(value= {"fname","lname","email","password"})
public class RegisterController {

	/*@Autowired
	//PasswordEncryptionService_old encryptService = new PasswordEncryptionService_old();
	
	@RequestMapping(value = "/register")
	public String register() {
		return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@ModelAttribute("RegistrationInfo") RegistrationInfo register, ModelMap modelMap) {
		
		
		 * Do the data entries
		 * 
		 * 
		
		return "register";
	}*/
	
	@RequestMapping(value = "/register2")
	public String register2(@RequestParam String firstname,
			@RequestParam String lastname,
			@RequestParam String email,
			@RequestParam String password) {
		
		/*byte[] salt;
		byte[] encryptedPass;
		try {
			salt = encryptService.generateSalt();
			encryptedPass = encryptService.getEncryptedPassword(password, salt);
			System.out.println(new String(encryptedPass));
			System.out.println(new String(salt));
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		System.out.println(PasswordEncryptionService_old.MD5(password));
		
		
		//System.out.println("Entered details are : "+firstname+","+lastname+","+email+","+password);
		
		return "../register2";
	}
	
	
	
}
