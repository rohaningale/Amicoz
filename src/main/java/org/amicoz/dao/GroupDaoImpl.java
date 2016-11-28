package org.amicoz.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.amicoz.ui.model.Comment;
import org.amicoz.ui.model.Friends;
import org.amicoz.ui.model.Group;
import org.amicoz.ui.model.GroupSearchResults;
import org.amicoz.ui.model.Posts;
import org.amicoz.ui.model.UserDetails;
import org.amicoz.model.Comments;
import org.amicoz.model.Groups;
import org.amicoz.model.Post;
import org.amicoz.model.User;
import org.amicoz.model.UserGroup;
import org.amicoz.model.UserGroups;
import org.amicoz.model.UserInfo;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class GroupDaoImpl implements GroupDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/*@Override
	public List<UserDetails> createGroup(int userId) {
		// TODO Auto-generated method stub
		
		List<UserDetails> friendsDetails = new ArrayList<UserDetails>();
		List<FriendsDB> friendsDb = getFriends(userId);
		UserInfo userInfo;
		for(FriendsDB friend : friendsDb){
			if(friend.getUserID1()==userId){
				userInfo = getUserDetails(friend.getUserID2());
			}else{
				userInfo = getUserDetails(friend.getUserID1());
			}
			friendsDetails.add(getUIBeanForUserDetails(userInfo));
		}
		return friendsDetails;
	}*/
	
	public int getUserIdForName(String userName){
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from User where Primary_Email_Id = ?");
		query.setParameter(0, userName);
		List<User> user = query.list();
		return user.get(0).getUserID();
	}
	
	public UserInfo getUserDetails(int userId){
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("from UserInfo where User_Id = ?");
		query.setParameter(0, userId);
		List<UserInfo> userInfo = query.list();
		return userInfo.get(0);
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
			Query query = session.createQuery("from Friends where User_Id1 = ? OR User_Id2 = ?");
			query.setParameter(0, userId);
			List<Friends> friends = query.list();
			return friends;
		}catch(HibernateException he){
			he.printStackTrace();
			return null;
		}finally{
			session.close();
		}
		
	}
	
	public Boolean saveGroupInfo(Group group){
		
		Groups groups = new Groups();
		groups.setAdminId(group.getGroupAdminId());
		groups.setGroupName(group.getGroupName());
		groups.setGroupDescription(group.getGroupDescription());
		groups.setChatGroup(false);
		groups.setCreatedBy("ADMIN");
		Date date = new Date();
		groups.setCreatedDate(date);
		groups.setLastUpdatedBy("ADMIN");
		groups.setLastUpdatedDate(date);
		groups.setDeleted("N");
		//ArrayList<Integer> userIds = new ArrayList<Integer>();
		//for(int i=0; i<group.getUserDetails().length; i++){
		//	userIds.add(group.getUserDetails()[i].getUserId());
		//}
		//userIds.toString();
		/*String[] users = group.getUserDetails().split(", ");
		ArrayList<Integer> userIds = new ArrayList<Integer>();
		for(int i=0; i<users.length;i++){
			System.out.println("User->"+users[i]);
			userIds.add(Integer.parseInt(users[i]));
		}*/
		
		groups.setUserLists(group.getUserDetails().substring(0, group.getUserDetails().length()-2));
		Session session = sessionFactory.openSession();
		try{
			
			session.save(groups);
			System.out.println("group data saved.");
			return true;
		}catch(HibernateException he){
			he.printStackTrace();
			System.out.println("Error while saving group data!!!");
			return false;
		}finally{
			session.close();
		}
		
	}
	
	public Group getGroupInfo(int groupId){
		Session session = sessionFactory.openSession();
		try{
			Query query = session.createQuery("from Groups where Group_Id = ?");
			query.setParameter(0, groupId);
			List<Groups> groupInfo = query.list();
			return getUIBeanForGroups(groupInfo.get(0));
		}catch(HibernateException he){
			he.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}
	
	public int getGroupId(){
		Session session = sessionFactory.openSession();
		try{
			Query query = session.createSQLQuery("Select max(Group_Id) from Groups");
			List<Object[]> groupInfo = query.list();
			if(groupInfo!=null){
				System.out.println("executed.");
				Iterator iterator = groupInfo.iterator();
				while (iterator.hasNext()) {
				    //Object[] row = iterator.next();
					 
					Integer row = (Integer) iterator.next();
					
					//Object[] row = (Object[])iterator.next();
				    if(row!=null)
				    	return (Integer)row;
				    else
				    	return -1;
				}
			}
			return -1;
		}catch(HibernateException he){
			he.printStackTrace();
			return 0;
		}finally{
			session.close();
		}
	}
	
	public Group getGroupInfo(Date creationDate){
		Session session = sessionFactory.openSession();
		try{
			Query query = session.createQuery("from Groups where Creation_Date = ?");
			query.setParameter(0, creationDate);
			List<Groups> groupInfo = query.list();
			return getUIBeanForGroups(groupInfo.get(0));
		}catch(HibernateException he){
			he.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}
	
	private Group getUIBeanForGroups(Groups group){
		Group groupUIBean = new Group();
		groupUIBean.setGroupId(group.getGroupId());
		groupUIBean.setGroupName(group.getGroupName());
		groupUIBean.setGroupAdminId(group.getAdminId());
		groupUIBean.setGroupDescription(group.getGroupDescription());
		groupUIBean.setUserDetails(group.getUserLists());
		groupUIBean.setPosts(getGroupPosts(group.getGroupId()));
		return groupUIBean;
	}
	
	private ArrayList<Posts> getGroupPosts(int groupId){
		Session session = sessionFactory.openSession();
		try{
			Query query = session.createQuery("from Post where Group_Id = ?");
			query.setParameter(0, groupId);
			List<Post> posts = query.list();
			ArrayList<Posts> postUI = new ArrayList<Posts>();
			for(Post post: posts){
				postUI.add(getUIBeanForPost(post));
			}
			return postUI;
		}catch(HibernateException he){
			he.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}
	
	private Posts getUIBeanForPost(Post post){
		
		Posts uiPost = new Posts();
		uiPost.setPostID(post.getPostID());
		uiPost.setPostText(post.getPostText());
		uiPost.setCommentCount(post.getCommentCount());
		uiPost.setLikeCount(post.getLikeCount());
		uiPost.setPostVisibility(post.getPostVisibility());
		uiPost.setDislikeCount(post.getDislikeCount());
		uiPost.setUserID(post.getUserID());
		uiPost.setTime(post.getCreatedDate());
		uiPost.setComments(getPostComments(post));
		UserInfo userInfo = getUserDetails(post.getUserID()); 
		uiPost.setUserName(userInfo.getFirstName()+" "+userInfo.getLastName());
		uiPost.setProfilePicURL(userInfo.getProfilePictureURL());
		return uiPost;
	}
	
	private ArrayList<Comment>getPostComments(Post post){
		Session session = sessionFactory.openSession();
		try{
			Query query = session.createQuery("from Comments where Post_Id = ?");
			query.setParameter(0, post.getPostID());
			ArrayList<Comment> commentsUI = new ArrayList<Comment>();
			List<Comments> comments = query.list();
			for(Comments comment : comments){
				commentsUI.add(getCommentUIBean(comment));
			}
			return commentsUI;
		}catch(HibernateException he){
			he.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}
	
	private Comment getCommentUIBean(Comments comment){
		Comment commentUI = new Comment();
		commentUI.setCommentId(comment.getCommentId());
		commentUI.setPostId(comment.getPostId());
		commentUI.setUserId(comment.getUserId());
		commentUI.setLikeCount(comment.getLikeCount());
		commentUI.setDislikeCount(comment.getDislikeCount());
		commentUI.setTimeStamp(comment.getCreatedDate());
		commentUI.setComment(comment.getComment());
		UserInfo userInfo = getUserDetails(comment.getUserId()); 
		commentUI.setUserName(userInfo.getFirstName()+" "+userInfo.getLastName());
		commentUI.setProfilePicURL(userInfo.getProfilePictureURL());
		return commentUI;
	}
	
	@Transactional
	public Boolean insertUserGroupMapping(Group group){
		String[] userIds = group.getUserDetails().substring(0, group.getUserDetails().length()-2).split(", ");
		Session session = sessionFactory.openSession();
		try{
			UserGroups userGroups = new UserGroups();
			for(String userId: userIds){
				
				String sql = "INSERT INTO USER_GROUPS " +
						" VALUES(?,?,?,?,?,?)";
				Query query = session.createSQLQuery(sql);
				query.setParameter(0, Integer.parseInt(userId));
				query.setParameter(1, group.getGroupId());
				Date date = new Date();
				query.setParameter(2, "ADMIN");
				query.setParameter(3, date);
				query.setParameter(4, "ADMIN");
				query.setParameter(5, date);
				
				int updatedRows = query.executeUpdate();
				System.out.println("inserted "+updatedRows);
				
				/*UserGroup userGroup = new UserGroup();
				userGroup.setUserId(Integer.parseInt(userId));
				userGroup.setGroupId(group.getGroupId());
				userGroups.setCreatedBy("ADMIN");
				Date date = new Date();
				userGroups.setCreatedDate(date);
				userGroups.setLastUpdatedBy("ADMIN");
				userGroups.setLastUpdatedDate(date);
				userGroups.setUserGroup(userGroup);*/
				//session.save(userGroup);
				//session.save(userGroups);
				
				System.out.println("saved user groups data");
			}
			return true;
		}catch(HibernateException he){
			he.printStackTrace();
			return false;
		}finally{
			session.close();
		}
		
	}

	@Override
	public GroupSearchResults searchGroups(String groups) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.openSession();
		
		try{
			Query query = session.createSQLQuery("SELECT ");
			
		} catch(HibernateException e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
		
		return null;
	}

}