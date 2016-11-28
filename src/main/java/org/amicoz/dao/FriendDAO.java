package org.amicoz.dao;

import java.util.List;

import org.amicoz.model.UserInfo;
import org.amicoz.ui.model.UserDetails;

public interface FriendDAO {

	
	public int addFriend(String toUser, int fromUser);
	
	public int confirmFriend(String fromUser,int userId);
	public int cancelFriendRequest(int toUser, int fromUser);
	
	public int removeFriend(int toUser, int fromUser);
	
	public int updateBlockedStatus(int toUser, int currentUser, char blockStatus);
	
	public String testForFriends(int senderId, int receiverId);
	
	public List<UserDetails> getFriendsDetails(int userId);
	public UserInfo getUserInfo(int userId);
	public UserDetails getUserDetails(int userId);
}
