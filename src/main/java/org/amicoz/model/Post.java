package org.amicoz.model;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Date;
/**
 * @author Girish
 *
 */
@Entity
@Table(name="Post")
public class Post {
	
	@Id @GeneratedValue
	@Column(name="Post_Id")
	private int postID;
	
	@Column(name="User_Id")
	private int userID;
	
	@Column(name="Post_Text")
	private String postText;
		
	@Column(name="Like_Count")
	private int likeCount;
	
	@Column(name="Dislike_Count")
	private int dislikeCount;
	
	@Column(name="Comment_Count")
	private int commentCount;
	
	@Column(name="Post_Visibility", nullable = false)
	private String postVisibility;
	
	@Column(name="Group_Id", nullable = true)
	private String groupId;
	
	@Column(name="Created_Date", nullable = false)
	private Date createdDate;
	
	@Column(name="Created_By", nullable = false)
	private String createdBy;
	
	@Column(name="Last_Updated_Date", nullable = false)
	private Date lastUpdatedDate;
	
	@Column(name="Last_Updated_By", nullable = false)
	private String lastUpdatedBy;

	/**
	 * @return the postID
	 */
	public int getPostID() {
		return postID;
	}

	/**
	 * @param postID the postID to set
	 */
	public void setPostID(int postID) {
		this.postID = postID;
	}

	/**
	 * @return the userID
	 */
	public int getUserID() {
		return userID;
	}

	/**
	 * @param userID the userID to set
	 */
	public void setUserID(int userID) {
		this.userID = userID;
	}

	/**
	 * @return the postText
	 */
	public String getPostText() {
		return postText;
	}

	/**
	 * @param postText the postText to set
	 */
	public void setPostText(String postText) {
		this.postText = postText;
	}


	/**
	 * @return the likeCount
	 */
	public int getLikeCount() {
		return likeCount;
	}

	/**
	 * @param likeCount the likeCount to set
	 */
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	/**
	 * @return the dislikeCount
	 */
	public int getDislikeCount() {
		return dislikeCount;
	}

	/**
	 * @param dislikeCount the dislikeCount to set
	 */
	public void setDislikeCount(int dislikeCount) {
		this.dislikeCount = dislikeCount;
	}

	/**
	 * @return the commentCount
	 */
	public int getCommentCount() {
		return commentCount;
	}

	/**
	 * @param commentCount the commentCount to set
	 */
	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	/**
	 * @return the postVisibility
	 */
	public String getPostVisibility() {
		return postVisibility;
	}

	/**
	 * @param postVisibility the postVisibility to set
	 */
	public void setPostVisibility(String postVisibility) {
		this.postVisibility = postVisibility;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the lastUpdatedDate
	 */
	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	/**
	 * @param lastUpdatedDate the lastUpdatedDate to set
	 */
	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	/**
	 * @return the lastUpdatedBy
	 */
	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	/**
	 * @param lastUpdatedBy the lastUpdatedBy to set
	 */
	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

}