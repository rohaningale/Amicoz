package com.in28minutes.service;

import org.springframework.stereotype.Service;

//new LoginService()
@Service
public class LoginServiceImpl implements LoginService {
	public boolean validateUser(String user, String password) {
		return true;
		//return user.equalsIgnoreCase("in28Minutes") && password.equals("dummy");
	}

}