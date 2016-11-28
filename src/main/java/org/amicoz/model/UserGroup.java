/**
 * 
 */
package org.amicoz.model;

import java.io.Serializable;






import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;


/**
 * @author iamkarandikar
 *
 */
@Embeddable
public
class UserGroup implements Serializable{
	
	@Column(name="User_Id")
	private int userId;
	
	@Column(name="Group_Id")
	private int groupId;

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the group
	 *//*
	public Groups getGroup() {
		return group;
	}

	*//**
	 * @param group the group to set
	 *//*
	public void setGroup(Groups group) {
		this.group = group;
	}
*/
	/**
	 * @return the groupId
	 */
	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	


}

