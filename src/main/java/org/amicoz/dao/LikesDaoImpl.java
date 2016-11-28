package org.amicoz.dao;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.amicoz.model.Likes;
import org.amicoz.model.UserLikes;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

public class LikesDaoImpl implements LikesDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional
	public String makeLike(int userid, int postid, String liketype)
	{
		System.out.println("Inside makeLikeDAO");
		Session session = sessionFactory.getCurrentSession();
		try
		{
			Query q;
			
			q=session.createQuery("from Likes where Liked_id = :postID and User_Id = :UserID and Like_Type= :Liketype");
			q.setParameter("postID", postid);
			q.setParameter("UserID", userid);
			q.setParameter("Liketype", liketype);
			
			List l = q.list();
			if(l.size()!=0){
				return "-1";
			}
			
			q=session.createSQLQuery("select liked_id from Likes where Liked_Id = ? and user_id = ?");
			q.setParameter(0, postid);
			q.setParameter(1, userid);
			List list = q.list();
			if(list.size() == 0){	// likes or dislikes first time
			
				Likes likes = new Likes();
				UserLikes userlikes = new UserLikes();
				userlikes.setLikedID(postid);
				userlikes.setUserID(userid);
				
				likes.setUserLikes(userlikes);
				likes.setCreatedBy(String.valueOf(userid));
				likes.setCreatedDate(new Date());
				likes.setLastUpdatedBy(String.valueOf(userid));
				likes.setLikeType(liketype);
				likes.setLikeOn("P");
				likes.setCreatedDate(new Date());
				likes.setCreatedBy(String.valueOf(userid));
				likes.setLastUpdatedDate(new Date());
				likes.setLastUpdatedBy(String.valueOf(userid));
				session.save(likes);
				
				if(liketype.equalsIgnoreCase("L")){
					q = session.createQuery("update Post set like_count = like_count+1 "
						+ "where post_id = :postID "
						);
				}else{
				    q = session.createQuery("update Post set Dislike_count = Dislike_count+1 "
							+ "where post_id = :postID "
							);	
				}
				q.setParameter("postID", postid);
				q.executeUpdate();
			}else		// user is changing his like to dislike or vice versa
			{
				if(liketype.equals("L")){
					// update the counter of likes/dislikes in posts
					q = session.createQuery("update Post set like_count = like_count+1,  Dislike_count = Dislike_count-1 "
							+ "where post_id = :postID "
							);
					q.setParameter("postID", postid);
					q.executeUpdate();
					
				}else{
					// update the counter of likes/dislikes in posts
					q = session.createQuery("update Post set like_count = like_count-1,  Dislike_count = Dislike_count+1 "
							+ "where post_id = :postID "
							);
					q.setParameter("postID", postid);
					q.executeUpdate();
					
				}
				
				
				q = session.createQuery("update Likes set Like_Type = :Liketype "
						+ "where Liked_id = :postID and User_Id = :UserId "
						);
				q.setParameter("Liketype", liketype);
				q.setParameter("postID", postid);
				q.setParameter("UserId", userid);
				q.executeUpdate();
				
			}
	
	}
	catch(HibernateException e)
	{
		e.printStackTrace();
		return "-1";
		/*System.out.println("Inside Data Integrity Exception");
		try
		{
		 Query	q = session.createSQLQuery("update Likes set Like Type = ? where Liked_id = ? and User_id = ?");
		 q.setParameter(0, liketype);
		 q.setParameter(1, postid);
		 q.setParameter(2, userid);
		 q.executeUpdate();
			
		}catch(Exception ex)
		{
			ex.printStackTrace();;
			return "-1";
		}
*/		
	}
	
		return "0";
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
	
}	
   
