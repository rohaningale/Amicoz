package org.amicoz.controller;

import java.util.ArrayList;

import org.amicoz.dao.CommentsDAO;
import org.amicoz.dao.FriendDAO;
import org.amicoz.dao.PostDAO;
import org.amicoz.dao.UserDAO;
import org.amicoz.ui.model.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.google.gson.Gson;

@Controller
@SessionAttributes(value = {"s_emailid","s_userid","s_fullname","s_groupid","s_imgsrc"})
public class ProfileController {
	  
	@Autowired
	UserDAO userDao;
	
	@Autowired
	PostDAO postDao;
	
	@Autowired
	FriendDAO friendDao;
	
	@Autowired
	CommentsDAO commentDao;
	
	
	@RequestMapping(value="/profile", method = RequestMethod.GET)
	public String showProfilePage(@RequestParam("userid") int _userid, ModelMap modelMap) {
		
		if(modelMap.get("s_userid") == null || modelMap.get("s_userid").equals("")){
			return "../login_amicoz";
		}
		int _currUserId = 0;		// the user who has logged in 
									// _userid : if of the person of who's profile is being visited
		if(_userid == Integer.parseInt(modelMap.get("s_userid").toString())) {
			modelMap.addAttribute("friend_status", "");
			modelMap.addAttribute("hidden_friend_button","hidden");
			_currUserId = _userid;
		} else {
			_currUserId = Integer.parseInt(modelMap.get("s_userid").toString());
		}
		System.out.println("Current user id: "+_currUserId);
		
		//System.out.println("from profile "+modelMap.get("s_emailid"));
		

		//modelMap.addAttribute("friend_status", "+Add this person.");
		
		/* Load the profile information for the user. */
		
		
		
		modelMap.addAttribute("s_imgsrc", userDao.getProfilePicURL(_currUserId));
		modelMap.addAttribute("profile_picture", userDao.getProfilePicURL(_userid));
		modelMap.addAttribute("profileUserId", _userid);
		//System.out.println(modelMap.get("s_imgsrc"));
		
		// 1) fetch profile information
		ArrayList<String> profileInfo= postDao.getProfileInformation(_userid);
		String privacy = profileInfo.get(profileInfo.size()-1);
		int loadPostsFlag = -1;		// -1 indicated don't load posts
		
		if(_currUserId != _userid) {
			String testFriend = friendDao.testForFriends(_currUserId, _userid);
			System.out.println("test returned : "+testFriend);
			System.out.println("privacy : "+privacy);
			switch(testFriend){
			case "Add Friend":
				// not connected
				if(privacy.equals("Y"))
					loadPostsFlag = 0;	// 0 indicates load posts
				
				break;
			case "Remove Friend":
				// connected	
				if(!privacy.equals("P"))
					loadPostsFlag = 0;
			case "Cancel Request":
				// in friend_request state
			case "Confirm Friend":
				if(privacy.equals("Y"))
					loadPostsFlag = 0;
				break;
			}
			modelMap.addAttribute("friend_status", testFriend);
			modelMap.addAttribute("to_userid",_userid);
		} else {
			System.out.println("You are on your own profile.");
			loadPostsFlag = 1;		// the user is visiting his own profile
			
		}
		
	
		String information="";
/*		information = "[";
		int i;
		for(i=0; i<profileInfo.size()-1; i++) {
			information += profileInfo.get(i)+",\n";
		}
		information += profileInfo.get(i)+"]";*/
	
		Gson gson = new Gson();
		information = gson.toJson(profileInfo);
		
		System.out.println("Info about user : "+information);
		if(loadPostsFlag != -1) {
			// load posts
			
			ArrayList<Posts> postsInfo = postDao.getPostsOfUser(_userid);
			System.out.println(postsInfo);
			if(postsInfo == null || postsInfo.size() ==0 ) {
				System.out.println("Post information not present.");
				return "profile";
			}
			
			
			//System.out.println("[");
			//information += "[";
			int j=0;
			for(int i=0;i<postsInfo.size();i++) {
				postsInfo.get(i).setComments(commentDao.getPostComments(postsInfo.get(i)));
				//information += ((Posts)postsInfo.get(i)).getPostText()+",";
				
				//System.out.println(((Posts)postsInfo.get(i)).getPostText()+",");
			}
			//Sx`System.out.println(((Posts)postsInfo.get(i)).getPostText());
			Gson g = new Gson();
			
			String posts = g.toJson(postsInfo);
			System.out.println(posts);
			modelMap.addAttribute("groupPosts",posts);
			//information += "]"; 
			
		} 
		
/*		
		if((_currUserId != _userid) && (profileInfo==null || privacy.equals("P"))) {
			modelMap.addAttribute("profile_information", "If you are seeing this, may be the user is in Private mode.");
			return "profile";
		} else {
			information = "[";
			int i;
			for(i=0; i<profileInfo.size()-1; i++) {
				information += profileInfo.get(i)+",\n";
			}
			information += profileInfo.get(i)+"]";
		}*/
		modelMap.addAttribute("profile_information",information);
		
		return "profile";
	}
	
	
}
