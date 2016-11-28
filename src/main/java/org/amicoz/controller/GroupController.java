package org.amicoz.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.amicoz.dao.FriendDAO;
import org.amicoz.dao.GroupDAO;
import org.amicoz.ui.model.Group;
import org.amicoz.ui.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.google.gson.Gson;

@Controller
@SessionAttributes(value = {"s_emailid","s_userid","s_fullname","s_groupid","s_imgsrc"})
public class GroupController {

	@Autowired
	GroupDAO groupDAO;
	
	@Autowired 
	FriendDAO friendDao;
	
	@RequestMapping(value="/groupcreate", method = RequestMethod.GET)
	public String createGroup_GET(ModelMap modelMap){ 
		if (modelMap.get("s_userid") == null || modelMap.get("s_userid").equals("")) {
			return "../login_amicoz";
		}
		System.out.println("In create group--get");
		List<UserDetails> friendsDetails = friendDao.getFriendsDetails(1);
		//List<UserDetails> friendsDetails = new ArrayList<UserDetails>();
		modelMap.addAttribute("friends",friendsDetails);
		return "groupcreate";
		//return "forward:/groupcreate";
		
		
	}
	
	@RequestMapping(value="/groupcreate", method = RequestMethod.POST)
	public void createGroup(@RequestParam("User") String toUser, HttpServletResponse response, ModelMap modelMap) throws IOException{
		System.out.println("\nIn create group!!!");
		//String userEmailId = modelMap.get("email").toString();
		//List<UserDetails> friendsDetails = groupDAO.createGroup(userEmailId);
	//	int userId = Integer.parseInt(modelMap.get("s_userid").toString());
		/*List<UserDetails> friendsDetails = friendDao.getFriendsDetails(1);
		//List<UserDetails> friendsDetails = new ArrayList<UserDetails>();
		UserDetails u1 = new UserDetails();
		u1.setFirstName("abc");
		u1.setLastName("def");
		u1.setUserId(1);
		UserDetails u2 = new UserDetails();
		u2.setFirstName("wer");
		u2.setLastName("qwe");
		u2.setUserId(2);
		friendsDetails.add(u1);
		friendsDetails.add(u2);
		modelMap.addAttribute("friends",friendsDetails);
		return "groupcreate";*/
		PrintWriter out = response.getWriter();
		out.println(1);
	}
	
	@RequestMapping(value="/savegroup", method = RequestMethod.POST)
	public void saveGroup(@ModelAttribute("Group") Group group, 
			HttpServletResponse response, ModelMap modelMap) throws IOException {
		System.out.println("In save group");
		PrintWriter out = response.getWriter();
		//System.out.println(request.getInputStream();
		System.out.println("FirstName: "+group.getGroupName());
		System.out.println("Members: "+group.getGroupDescription());
		System.out.println("before saving group data");
		
		
//		get the group id
		groupDAO.saveGroupInfo(group);
		group.setGroupId(groupDAO.getGroupId());
		System.out.println("new id : "+group.getGroupId());
		groupDAO.insertUserGroupMapping(group);
		System.out.println("after saving group data");
		System.out.println(group.getGroupId());
		modelMap.addAttribute("s_groupid", group.getGroupId());
		System.out.println("sending to group info");
		//System.out.println("FirstName: "+userDetails[0].getFirstName());
		//return "forward:/groupInfo";
		//return "index";
		out.println(1);
		//return "forward:/groupInfo1";
		//return "forward:/groupInfo1";
	}
	
	
	@RequestMapping(value = "/group", method = RequestMethod.GET)
	public String displayGroup_GET(@RequestParam int groupid,ModelMap modelMap) {
		System.out.println("received");
		System.out.println("inside group info GET "+groupid);
		Group group = groupDAO.getGroupInfo(groupid);
		/*
		 * Load the group info. by using the group id in the session attrib.
		 * */
		ArrayList<UserDetails> memberDetails = new ArrayList<UserDetails>();
		String[] userIds = group.getUserDetails().split(", ");
		for(int i=0; i<userIds.length; i++){
			memberDetails.add(friendDao.getUserDetails(Integer.parseInt(userIds[i])));
		}
		Gson gson = new Gson();

		// convert java object to JSON format,
		// and returned as JSON formatted string
		String groupAdmin = gson.toJson(friendDao.getUserDetails(group.getGroupAdminId()));
		String groupId = gson.toJson(group.getGroupId());
		String groupMembers = gson.toJson(memberDetails);
		String groupPosts = gson.toJson(group.getPosts());
		System.out.println("Admin details:"+groupAdmin);
		modelMap.addAttribute("groupName",group.getGroupName());
		modelMap.addAttribute("groupDescription",group.getGroupDescription());
		modelMap.addAttribute("groupAdmin", groupAdmin);
		modelMap.addAttribute("s_groupid", groupId);
		modelMap.addAttribute("groupMembers", groupMembers);
		modelMap.addAttribute("groupPosts", groupPosts);
		
		return "group";
	}
	
	
	@RequestMapping(value = "/group", method = RequestMethod.POST)
	public String displayGroup(ModelMap modelMap)
	{
		//System.out.println("inside display group: controller "+groupId);
		//System.out.println("inside group controller!!! ");
		//Group group = groupDAO.getGroupInfo(1);
		//modelMap.addAttribute("groupName", group.getGroupName());
		//modelMap.addAttribute("groupDescription", group.getGroupDescription());
		//modelMap.addAttribute("Post", group.getPosts());
		return "group";
	}

	@RequestMapping(value="groupInfo", method=RequestMethod.GET)
	public String showGroupInfo_GET(@RequestParam String groupid, ModelMap modelMap) {

		

		return "group";
	}
	
}