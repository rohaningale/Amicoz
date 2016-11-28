package org.amicoz.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserLikes implements Serializable
{
	@Column(name="User_Id")
	private int userID;
	
	
	@Column(name="Liked_Id")
	private int likedID;
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
	 * @return the postID
	 */

	/**
	 * @return the likedID
	 */
	public int getLikedID() {
		return likedID;
	}

	/**
	 * @param likedID the likedID to set
	 */
	public void setLikedID(int likedID) {
		this.likedID = likedID;
	}
}