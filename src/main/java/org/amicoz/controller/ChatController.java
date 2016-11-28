package org.amicoz.controller;

import org.amicoz.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(value = {"s_emailid","s_userid","s_fullname","s_groupid","s_imgsrc"})
public class ChatController {
	
	@Autowired
	UserDAO userDao;
	
	@RequestMapping(value="/chat", method=RequestMethod.GET)
	public String viewChatPage(ModelMap modelMap){
		modelMap.addAttribute("s_imgsrc", userDao.getProfilePicURL(Integer.parseInt(modelMap.get("s_userid").toString())));
		//modelMap.addAttribute("fromid",modelMap.get("s_userid"));
		return "chat";
	}
	
	
}
