package org.amicoz.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.amicoz.model.FriendRequest;
import org.amicoz.model.Friends;
import org.amicoz.model.SenderReceiver;
import org.amicoz.model.UserInfo;
import org.amicoz.ui.model.UserDetails;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FriendDaoImpl implements FriendDAO {

	@Autowired
	private SessionFactory sessionFactory;

	
	
	
	private boolean checkRequest(int senderId, int receiverId) {
		
		Session session = sessionFactory.openSession();
		try{
			
			String sql = "from FriendRequest where Receiver_Id = ? and Sender_Id = ?";
			Query query = session.createQuery(sql);
			query.setParameter(0, receiverId);
			query.setParameter(1, senderId);
			List list = query.list();
			
			if(list.size()>0){
				return true;
			}
			
			query.setParameter(0, senderId);
			query.setParameter(1, receiverId);
			list=query.list();
			
			if(list.size()>0){
				return true;
			}
			
		}catch(HibernateException e) {
			e.printStackTrace();
			return false;
		} finally {
			session.close();
		}
		
		
		return false;
	}
	
	
	
	
	@Transactional
	public int addFriend(String toUser, int fromUser)
	{
		FriendRequest friendRequest = new FriendRequest();
		SenderReceiver senderReceiver = new SenderReceiver();
		String from = String.valueOf(fromUser);
		senderReceiver.setSenderID(from);
		senderReceiver.setReceiverID(toUser);
		
		//check if request is already sent by toUser
		boolean result = checkRequest(fromUser, Integer.parseInt(toUser));
		if(result){
			return -1;
		}
		
		friendRequest.setCreatedBy(from);
		friendRequest.setCreatedDate(new Date());
		friendRequest.setLastUpdatedBy(from);
		friendRequest.setLastUpdatedDate(new Date());
		friendRequest.setSenderReceiver(senderReceiver);
		Session session = sessionFactory.getCurrentSession();
		
		try{
		session.save(friendRequest);
		}catch(HibernateException e)
		{
			System.out.println("Exception in FriendDaoImpl: method: addFriend()");
			e.printStackTrace();
			return -1;
		}
		
		return 0;
	}

	
	@Transactional
	public int confirmFriend(String fromUser,int userId)
	{
		String receiverID = String.valueOf(userId);
		Friends friends = new Friends();
		SenderReceiver senderReceiver = new SenderReceiver();
		senderReceiver.setSenderID(fromUser);
		senderReceiver.setReceiverID(receiverID);
		friends.setCreatedBy("1");
		friends.setCreatedDate(new Date());
		friends.setLastUpdatedBy("1");
		friends.setLastUpdatedDate(new Date());
		friends.setSenderReceiver(senderReceiver);
		friends.setIsBlocked("N");
		Session session = sessionFactory.getCurrentSession();
		
		try
		{
			Query q = session.createQuery("delete from FriendRequest "
					+ "where sender_id = :fromUser "
					+ " and receiver_id = :receiverID"
					);
			q.setString("fromUser", fromUser);
			q.setString("receiverID", receiverID);
			q.executeUpdate();
			
			q.setString("fromUser", receiverID);
			q.setString("receiverID", fromUser);
			q.executeUpdate();
			session.save(friends);
		}catch(HibernateException e)
		{
			System.out.println("Exception in FriendDaoImpl: method: confirmFriend()");
			e.printStackTrace();
			return -1;
		}
		
		return 0;
	}
	
	@Transactional
	public int cancelFriendRequest(int toUser, int fromUser)
	{
//		String currentUserID = "tk";
		
		Session session = sessionFactory.getCurrentSession();
		
		try
		{
			Query q = session.createQuery("delete from FriendRequest "
					+ "where sender_id = :fromUser "
					+ " and receiver_id = :receiverID"
					);
			q.setParameter("fromUser", toUser);
			q.setParameter("receiverID", fromUser);
			q.executeUpdate();
			
			q.setParameter("fromUser", fromUser);
			q.setParameter("receiverID", toUser);
			q.executeUpdate();
			
		}catch(HibernateException e)
		{
			System.out.println("Exception in FriendDaoImpl: method: cancelFriendRequest()");
			e.printStackTrace();
			return -1;
		}
		
		return 0;
	}
	
	@Transactional
	public int removeFriend(int toUser, int fromUser)
	{
		//String currentUserID = "tk";
		
		Session session = sessionFactory.getCurrentSession();
		
		try
		{
			Query q = session.createQuery("delete from Friends "
					+ "where sender_id = :fromUser "
					+ " and receiver_id = :receiverID"
					);
			q.setParameter("fromUser", toUser);
			q.setParameter("receiverID", fromUser);
			q.executeUpdate();
			
			q.setParameter("fromUser", toUser);
			q.setParameter("receiverID", toUser);
			q.executeUpdate();
			
		}catch(HibernateException e)
		{
			System.out.println("Exception in FriendDaoImpl: method: confirmFriend()");
			e.printStackTrace();
			return -1;
		}
		
		return 0;
	}
	
	@Transactional
	public int updateBlockedStatus(int toUser,int currentUser, char blockStatus)
	{
		//String currentUserID = "tk";
		
		Session session = sessionFactory.getCurrentSession();
		
		try
		{
			Query q = session.createQuery("update Friends set Blocked = :blockStatus "
					+ "where sender_id = :fromUser "
					+ " and receiver_id = :receiverID"
					);
			q.setParameter("blockStatus", blockStatus);
			q.setParameter("fromUser", toUser);
			q.setParameter("receiverID", currentUser);
			q.executeUpdate();
			
			q.setParameter("blockStatus", blockStatus);
			q.setParameter("fromUser", currentUser);
			q.setParameter("receiverID", toUser);
			q.executeUpdate();
			
		}catch(HibernateException e)
		{
			System.out.println("Exception in FriendDaoImpl: method: updateBlockedStatus()");
			e.printStackTrace();
			return -1;
		}
		
		return 0;
	}
	/**
	 * @return the sessionFactory
	 */
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	/**
	 * @param sessionFactory the sessionFactory to set
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	public String testForFriends(int senderId, int receiverId) {
		
		String status = "";
		
		Session session = sessionFactory.openSession();
		
		
		try{
			String sql = "SELECT SENDER_ID AS ID FROM FRIENDS WHERE SENDER_ID = ? AND RECEIVER_ID = ? "
					+ "UNION SELECT RECEIVER_ID AS ID FROM FRIENDS WHERE RECEIVER_ID = ? AND SENDER_ID = ?";
			Query query = session.createSQLQuery(sql);
			query.setParameter(0, senderId);
			query.setParameter(1, receiverId);
			query.setParameter(2, senderId);
			query.setParameter(3, receiverId);
			List<Object[]> l = query.list();
			if(l!=null && l.size()==1) 
				return "Remove Friend";
					
			
			sql = "SELECT SENDER_ID AS ID FROM FRIEND_REQUEST WHERE SENDER_ID = ? AND RECEIVER_ID = ?";
			query = session.createSQLQuery(sql);
			query.setParameter(0, senderId);
			query.setParameter(1, receiverId);
			l = query.list();
			if(l!=null && l.size()==1)
				return "Cancel Request";
			
			sql = "SELECT RECEIVER_ID AS ID FROM FRIEND_REQUEST WHERE RECEIVER_ID = ? AND SENDER_ID = ?";
			query = session.createSQLQuery(sql);
			query.setParameter(0, senderId);
			query.setParameter(1, receiverId);
			l = query.list();
			if(l!=null && l.size()==1)
				return "Confirm Friend";
			
			
			return "Add Friend";
			
			
					
			
		} catch (HibernateException e) {
			e.printStackTrace();
			
			return "Add Friend";
		} finally {
			session.close();
			
		}
		
	}
	
	public List<UserDetails> getFriendsDetails(int userId) {
		// TODO Auto-generated method stub
		
		List<UserDetails> friendsDetails = new ArrayList<UserDetails>();
		List<Friends> friendsDb = getFriends(userId);
		UserInfo userInfo;
		for(Friends friend : friendsDb){
			if(Integer.parseInt(friend.getSenderReceiver().getSenderID())==userId){
				userInfo = getUserInfo(Integer.parseInt(friend.getSenderReceiver().getReceiverID()));
			}else{
				userInfo = getUserInfo(Integer.parseInt(friend.getSenderReceiver().getSenderID()));
			}
			friendsDetails.add(getUIBeanForUserDetails(userInfo));
		}
		return friendsDetails;
	}
	
	public UserDetails getUIBeanForUserDetails(UserInfo userInfo){
		
		UserDetails userDetails = new UserDetails();
		userDetails.setFirstName(userInfo.getFirstName());
		userDetails.setLastName(userInfo.getLastName());
		userDetails.setUserId(userInfo.getUserId());
		return userDetails;
	}
	
	@Transactional
	private List<Friends> getFriends(int userId){
		
		Session session = sessionFactory.openSession();
		try{
			Query query = session.createQuery("from Friends where Sender_Id = ? OR Receiver_Id = ?");
			query.setParameter(0, userId);
			query.setParameter(1, userId);
			List<Friends> friends = query.list();
			return friends;
		}catch(HibernateException he){
			he.printStackTrace();
			return null;
		}finally{
			session.close();
		}
		
	}
	
	public UserInfo getUserInfo(int userId){
		Session session = sessionFactory.openSession();
		try{
			Query query = session.createQuery("from UserInfo where User_Id = ?");
			query.setParameter(0, userId);
			List<UserInfo> userInfo = query.list();
			return userInfo.get(0);
		}catch(HibernateException he){
			he.printStackTrace();
			return null;
		}finally{
			session.close();
		}
		
	}
	
	public UserDetails getUserDetails(int userId){
		UserInfo userInfo = getUserInfo(userId);
		UserDetails userDetails = new UserDetails();
		userDetails.setUserId(userInfo.getUserId());
		userDetails.setFirstName(userInfo.getFirstName());
		userDetails.setLastName(userInfo.getLastName());
		userDetails.setProfilePicUrl(userInfo.getProfilePictureURL());
		return userDetails;
	}
	
}
