package org.amicoz.dao;

import java.util.ArrayList;
import java.util.List;

import org.amicoz.model.Post;
import org.amicoz.ui.model.Posts;

public interface PostDAO {
	
	public ArrayList<String> getProfileInformation(int _userId);
	public ArrayList<Posts> getPostsOfUser(int _userId); 
	public Boolean addPost(Posts post);
	public List<Posts> getFriendsPost(int userId);
}
