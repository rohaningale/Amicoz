package com.in28minutes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(value = {"s_emailid","s_fullname"})
public class CommonController {

	
	
	
	
	@RequestMapping(value="/index")
	public String showIndexPage(){
		return "index";
	}
	
	@RequestMapping(value="/trial", method= RequestMethod.POST)
	public String trial(@RequestParam String emailId, @RequestParam String password, ModelMap model){
		System.out.println(emailId);
/*		if(emailId.equals("")){
			model.addAttribute("user",emailId+"..");
			model.addAttribute("pass",password+"..");
			model.addAttribute("errorMessage","Reeneter");
			model.addAttribute("color", "red");
		}else{
			model.addAttribute("errorMessage","success");
			model.addAttribute("color", "green");
		}*/
		
		return "/login";
	}
	
	@RequestMapping(value="/validate", method= RequestMethod.POST, consumes = "application/json")
	public @ResponseBody String validate(@RequestParam String EMAIL, ModelMap model){
		System.out.println("in validate");
		if(EMAIL.equals("")){
			return "0";
		}
		return "1";
		
	}
	
}

