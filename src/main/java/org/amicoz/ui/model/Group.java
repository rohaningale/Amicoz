package org.amicoz.ui.model;

import java.util.ArrayList;

public class Group {
	
	private int groupId;
	private String groupName;
	private String groupDescription;
	private int groupAdminId;
	//private ArrayList<UserDetails> userDetails;
	private String userDetails;
	private ArrayList<Posts> posts;
	
	public int getGroupId() {
		return groupId;
	}
	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}
	public String getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(String userDetails) {
		this.userDetails = userDetails;
	}
	public String getGroupName() {
		return groupName;
	}
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	public String getGroupDescription() {
		return groupDescription;
	}
	public void setGroupDescription(String groupDescription) {
		this.groupDescription = groupDescription;
	}
	public int getGroupAdminId() {
		return groupAdminId;
	}
	public void setGroupAdminId(int groupAdminId) {
		this.groupAdminId = groupAdminId;
	}
	public ArrayList<Posts> getPosts() {
		return posts;
	}
	public void setPosts(ArrayList<Posts> posts) {
		this.posts = posts;
	}
	
	/*public ArrayList<UserDetails> getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(ArrayList<UserDetails> userDetails) {
		this.userDetails = userDetails;
	}*/
}