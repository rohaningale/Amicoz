package org.amicoz.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.amicoz.model.Comments;
import org.amicoz.model.Post;
import org.amicoz.model.UserInfo;
import org.amicoz.ui.model.Comment;
import org.amicoz.ui.model.Posts;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class CommentsDaoImpl implements CommentsDAO{
	SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public Boolean saveComment(Comment comment) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.openSession();
		try{
			Comments commentsDB = getCommentDBBean(comment);
			session.save(commentsDB);
			return true;
		}catch(HibernateException he){
			he.printStackTrace();
			return false;
		}finally{
			session.close();
		}
	}
	
	public ArrayList<Comment>getPostComments(Posts post){
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
			//UserInfo userInfo = getUserDetails(comment.getUserId()); 
			//commentUI.setUserName(userInfo.getFirstName()+" "+userInfo.getLastName());
			//commentUI.setProfilePicURL(userInfo.getProfilePictureURL());
			return commentUI;
		}
		
		
	private Comments getCommentDBBean(Comment comment){
		Comments commentDB = new Comments();
		commentDB.setPostId(comment.getPostId());
		commentDB.setUserId(comment.getUserId());
		commentDB.setLikeCount(comment.getLikeCount());
		commentDB.setDislikeCount(comment.getDislikeCount());
		Date date = new Date();
		commentDB.setCreatedBy("ADMIN");
		commentDB.setCreatedDate(date);
		commentDB.setLastUpdatedDate(date);
		commentDB.setUpdatedBy("ADMIN");
		return commentDB;
	}
}