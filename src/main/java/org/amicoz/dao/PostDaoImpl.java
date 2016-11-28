package org.amicoz.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.amicoz.model.Post;
import org.amicoz.model.UserInfo;
import org.amicoz.ui.model.Posts;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class PostDaoImpl implements PostDAO{

	@Autowired
	SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	@Override
	@Transactional
	public Boolean addPost(Posts post) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try{
			session.save(getDBBeanForUIBean(post));
			return true;
		}catch(HibernateException he){
			he.printStackTrace();
			return false;
		}finally{
			session.close();
		}
	}
	
	

	@Override
	@Transactional
	public ArrayList<String> getProfileInformation(int _userId) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		ArrayList<String> retVal = new ArrayList<String>();
		try{
			
			Query query = session.createQuery("from UserInfo where userId = :userID");
			
			query.setParameter("userID", _userId);
			
			
			List<UserInfo> list =  query.list();
			
			if(list != null){
				
				if(list.get(0).getFirstName() != null)
					retVal.add(list.get(0).getFirstName());
				
				if(list.get(0).getLastName() != null)
					retVal.add(list.get(0).getLastName());
				
				
				if(list.get(0).getDateOfBirth() != null)
					retVal.add("Born on "+list.get(0).getDateOfBirth().toString());
				
				if(list.get(0).getBio() != null)
					retVal.add(list.get(0).getBio());
				
				if(list.get(0).getCity() != null && !list.get(0).getCity().trim().equals(""))
					retVal.add("Lives in "+list.get(0).getCity());
				
				if(list.get(0).getState() != null)
					retVal.add(list.get(0).getState());
				
				if(list.get(0).getCountry() != null)
					retVal.add(list.get(0).getCountry());
				
				if(list.get(0).getSchool() != null && !list.get(0).getSchool().trim().equals("") )
					retVal.add("Studies at "+list.get(0).getSchool());
				
				if(list.get(0).getProfileVisibility() != null && !list.get(0).getProfileVisibility().trim().equals("")){
					
					switch(list.get(0).getProfileVisibility()) {
					case "Y":
					case "y":
						retVal.add("Privacy: Public");
						break;
					case "F":
					case "f":
						retVal.add("Privacy: Friends");
						break;
					case "P":
					case "p":
						retVal.add("Privacy: Private");
						break;
					}
					
				}
					
				return retVal;
			}
			return null;
		}catch(HibernateException e){
			e.printStackTrace();
			return null;
		}
		finally{
			session.close();
		}
			
	}

	@Override
	@Transactional
	public ArrayList<Posts> getPostsOfUser(int _userId) {
		// TODO Auto-generated method stub
		
		Session session = sessionFactory.openSession();
		ArrayList<Posts> retVal;
		try {
			
			//Query query = session.createSQLQuery("select * from Post where User_Id = ? and Group_Id is not null");
			Query query = session.createQuery("from Post where User_Id = ? and Group_Id is null");
			query.setParameter(0, _userId);
			List<Post> userPosts = query.list();
			System.out.println("# of user posts : "+userPosts.size());
			query = session.createQuery("from UserInfo where userId = :userId");
			query.setParameter("userId", _userId);																																											
			UserInfo uInfo = (UserInfo) query.uniqueResult();
			
			if(userPosts != null && userPosts.size() > 0) {
				String username = uInfo.getFirstName() + " " + uInfo.getLastName();
				Posts uiUserPost = new Posts();
				
				retVal = new ArrayList<Posts>();
				/*for(Post p : userPosts) {*/
				for(int j=0;j<userPosts.size();j++) {
					//System.out.println("Text : "+p.getPostText());
					uiUserPost = new Posts();
					Post p = (Post) userPosts.get(j);
					uiUserPost.setCommentCount(p.getCommentCount());
					uiUserPost.setDislikeCount(p.getDislikeCount());
					uiUserPost.setGroupId(p.getGroupId());
					uiUserPost.setLikeCount(p.getLikeCount());
					uiUserPost.setPostID(p.getPostID());
					uiUserPost.setPostText(p.getPostText());
					uiUserPost.setPostVisibility(p.getPostVisibility());
					uiUserPost.setTime(p.getCreatedDate());
					uiUserPost.setUserID(p.getUserID());
					uiUserPost.setUserName(username);
					uiUserPost.setProfilePicURL(uInfo.getProfilePictureURL());
					//System.out.println(uiUserPost.getPostText());
					retVal.add(uiUserPost);
					System.out.println(retVal.get(j).getPostText());
				}
				System.out.println(retVal);
				//System.out.println(((Posts)retVal.get(0)).getUserName());
				return retVal;
			}
			return null;
		} catch (HibernateException e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
		
	}

	
	public Post getDBBeanForUIBean(Posts post){
		Post posts = new Post();
		posts.setPostID(post.getPostID());
		posts.setUserID(post.getUserID());
		posts.setPostText(post.getPostText());
		posts.setLikeCount(post.getLikeCount());
		posts.setDislikeCount(post.getDislikeCount());
		posts.setGroupId(post.getGroupId());
		posts.setCommentCount(post.getCommentCount());
		posts.setPostVisibility(post.getPostVisibility());
		posts.setCreatedBy("ADMIN");
		Date date = new Date();
		posts.setCreatedDate(date);
		posts.setLastUpdatedBy("ADMIN");
		posts.setLastUpdatedDate(date);
		return posts;
	}

	/*public List<Posts> getFriendsPost(int userId){
		Session session = sessionFactory.openSession();
		try{
			Query query = session.createQuery("from Post where User_Id=?");
			query.setParameter(0, userId);
			List<Post> post = query.list();
			
			List<Posts> posts = new ArrayList<Posts>();
			for(int i=0; i<post.size(); i++){
				Posts p = new Posts();
				p.setCommentCount(post.get(i).getCommentCount());
				p.setComments(post.get(i).);
				p.setDislikeCount(dislikeCount);
				p.setGroupId(groupId);
				p.setLikeCount(likeCount);
				p.setPostID(postID);
				p.setPostText(postText);
				p.setPostVisibility(postVisibility);
				p.setProfilePicURL(profilePicURL);
				p.setTime(time);
				p.setUserID(userID);
				p.setUserName(userName);
			}
			
			return posts;
		}catch(HibernateException he){
			he.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}*/
	
	public List<Posts> getFriendsPost(int userId){
		Session session = sessionFactory.openSession();
		try{
			List<Posts> postsUI = new ArrayList<Posts>();
			Query query = session.createQuery("from Post where User_Id=?");
			query.setParameter(0, userId);
			List<Post> posts = query.list();
			if(posts==null)
				return null;
			for(Post post: posts){
				postsUI.add(getUIBeanForDBBean(post));
			}
			return postsUI;
		}catch(HibernateException he){
			he.printStackTrace();
			return null;
		}finally{
			session.close();
		}
	}
	
	public Posts getUIBeanForDBBean(Post posts){
		Posts post = new Posts();
		post.setPostID(posts.getPostID());
		post.setUserID(posts.getUserID());
		post.setPostText(posts.getPostText());
		post.setLikeCount(posts.getLikeCount());
		post.setDislikeCount(posts.getDislikeCount());
		post.setGroupId(posts.getGroupId());
		post.setCommentCount(posts.getCommentCount());
		post.setPostVisibility(posts.getPostVisibility());
		
		return post;
	}
	

}