package org.amicoz.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.amicoz.dao.FriendDAO;
import org.amicoz.dao.FriendDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes(value = {"s_emailid","s_userid","s_fullname","s_groupid","s_imgsrc"})
public class FriendController {
	
	@Autowired
	FriendDAO friendDao;
	
	
	@RequestMapping(value="/addFriend", method=RequestMethod.POST)
	public @ResponseBody String addFriend(@RequestParam("user") String toUserName, ModelMap modelmap)
	{
		System.out.println("inside addFriendController");
	    System.out.println(toUserName);
	    System.out.println(modelmap.get("s_userid"));
	    int fromuser = (int) modelmap.get("s_userid");
	    if(friendDao.addFriend(toUserName, fromuser)!=-1){
	    	//modelmap.addAttribute();
	    	System.out.println("success");
	    	return "0";
	    }
	 
	    return "-1";
	}
	
	@RequestMapping(value="/cancelRequest", method=RequestMethod.POST)
	public @ResponseBody String cancelFriendRequest(@RequestParam("user") String toUserName, ModelMap modelmap)
	{
		int from_user = (int) modelmap.get("s_userid");
		
	    if(friendDao.cancelFriendRequest(Integer.parseInt(toUserName),from_user)!=-1){
	    	//modelmap.addAttribute();
	    	System.out.println("success");
	    	return "0";
	    }
	 
	    return "-1";
	}
	
	@RequestMapping(value="/updateBlocked", method=RequestMethod.POST)
	public @ResponseBody String updateBlocked(@RequestParam("user") String fromUserName, @RequestParam("flag") char blockStatus,ModelMap modelmap)
	{
		System.out.println("inside update blocked controller");
	    System.out.println(fromUserName);
	    System.out.println(blockStatus);
	    int current_user = (int)modelmap.get("s_userid");
	    if(friendDao.updateBlockedStatus(Integer.parseInt(fromUserName),current_user,blockStatus)!=-1){
	    	//modelmap.addAttribute();
	    	System.out.println("success");
	    	return "0";
	    }
	 
	    return "-1";
	}
	
	@RequestMapping(value="/confirmFriend", method=RequestMethod.POST)
	public @ResponseBody String confirmFriend(@RequestParam("user") String fromUserName, ModelMap modelmap)
	{
		System.out.println("inside addFriendController");
	    System.out.println(fromUserName);
	    int userId = (int)modelmap.get("s_userid");
	    if(friendDao.confirmFriend(fromUserName,userId)!=-1){
	    	//modelmap.addAttribute();
	    	System.out.println("success");
	    	return "0";
	    }
	 
	    return "-1";
	}
	
	@RequestMapping(value="/removeFriend", method=RequestMethod.POST)
	public @ResponseBody String removeFriend(@RequestParam("user") String toUserName, ModelMap modelmap)
	{
		System.out.println("inside addFriendController");
	    System.out.println(toUserName);
	    
	    int userId = (int)modelmap.get("s_userid");
	    if(friendDao.removeFriend(Integer.parseInt(toUserName),userId)!=-1){
	    	//modelmap.addAttribute();
	    	System.out.println("success");
	    	return "0";
	    }
	 
	    return "-1";
	}
}
	


