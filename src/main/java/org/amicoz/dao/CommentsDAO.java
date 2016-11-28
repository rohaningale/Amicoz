package org.amicoz.dao;

import java.util.ArrayList;

import org.amicoz.model.Post;
import org.amicoz.ui.model.Comment;
import org.amicoz.ui.model.Posts;

public interface CommentsDAO {

	public Boolean saveComment(Comment comment);
	public ArrayList<Comment>getPostComments(Posts post);
	//public ArrayList<Comment>getPostComments(Post post);
}