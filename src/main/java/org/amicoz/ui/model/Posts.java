package org.amicoz.ui.model;

import java.util.ArrayList;
import java.util.Date;

public class Posts implements Comparable{
	private int postID;
	private int userID;
	private String postText;
	private int likeCount;
	private int dislikeCount;
	private int commentCount;
	private String postVisibility;
	private String groupId;
	private Date time;
	private String userName;
	private String profilePicUrl;
	private ArrayList<Comment> comments;
	
	public int getPostID() {
		return postID;
	}
	public void setPostID(int postID) {
		this.postID = postID;
	}
	public String getProfilePicURL() {
		return profilePicUrl;
	}
	public void setProfilePicURL(String profilePicURL) {
		this.profilePicUrl = profilePicURL;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getPostText() {
		return postText;
	}
	public void setPostText(String postText) {
		this.postText = postText;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	public int getDislikeCount() {
		return dislikeCount;
	}
	public void setDislikeCount(int dislikeCount) {
		this.dislikeCount = dislikeCount;
	}
	public int getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}
	public String getPostVisibility() {
		return postVisibility;
	}
	public void setPostVisibility(String postVisibility) {
		this.postVisibility = postVisibility;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public ArrayList<Comment> getComments() {
		return comments;
	}
	public void setComments(ArrayList<Comment> comments) {
		this.comments = comments;
	}
	@Override
	public int compareTo(Object p) {
		// TODO Auto-generated method stub
		Posts p1 = (Posts)p;
		if(p1.getTime().getTime()> this.getTime().getTime()){
			return 1;
		}else{
			return -1;
		}
	}
}