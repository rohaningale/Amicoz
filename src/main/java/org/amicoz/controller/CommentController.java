package org.amicoz.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.amicoz.dao.CommentsDAO;
import org.amicoz.ui.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(value = {"s_emailid","s_userid","s_fullname","s_groupid","s_imgsrc"})

public class CommentController {

	@Autowired
	CommentsDAO commentsDao;
	
	@RequestMapping(value="/commentSave", method = RequestMethod.POST)
	public void saveComment(@ModelAttribute("Comment")Comment comments, HttpServletResponse response, ModelMap modelMap) throws IOException{
		System.out.println("In CommentSave");
		PrintWriter out = response.getWriter();
		comments.setDislikeCount(0);
		comments.setLikeCount(0);
		commentsDao.saveComment(comments);
//		if(commentsDao.saveComment(comments)){
//			out.println(1);
//		}
//		else{
//			out.println(0);
//		}
		if(7 > 6){
			out.println(1);
		}
		else{
			out.println(0);
		}
	}
}