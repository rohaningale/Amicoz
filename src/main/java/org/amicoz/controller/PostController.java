package org.amicoz.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.amicoz.dao.PostDAO;
import org.amicoz.ui.model.Posts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(value = {"s_emailid","s_userid","s_fullname","s_groupid","s_imgsrc"})
public class PostController {

	@Autowired
	PostDAO postDao;
	
	@RequestMapping(value="/postSave", method = RequestMethod.POST)
	public void savePost(@ModelAttribute("Post")Posts posts, HttpServletResponse response, ModelMap modelMap) throws IOException{
		System.out.println("In save post");
		PrintWriter out = response.getWriter();
		posts.setUserID(Integer.parseInt(modelMap.get("s_userid").toString()));
		posts.setCommentCount(0);
		posts.setLikeCount(0);
		//posts.setCommentCount(0);
		posts.setComments(null);
		
		if(modelMap.get("s_groupid") != null)
			posts.setGroupId(modelMap.get("s_groupid").toString());
		else
			posts.setGroupId(null);
		
		posts.setPostVisibility("Y");
		//set current profile pic url
		posts.setProfilePicURL(posts.getProfilePicURL());
		System.out.println("trying to save.");
		if(postDao.addPost(posts)){
			System.out.println("success");
			out.println(1);
		}else{
			out.println(0);
		}
	}
	
}