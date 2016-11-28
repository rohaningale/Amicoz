/**
 * 
 */
package org.amicoz.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="User_Groups")
public class UserGroups {
	@EmbeddedId
	private UserGroup userGroup;

	@Column(name="Updated_Date", nullable=false)
	private Date lastUpdatedDate;
	
	@Column(name="Last_Updated_By", nullable=false)
	private String lastUpdatedBy;	// user id from UserInfo
	
	@Column(name="Created_Date", nullable=false)
	private Date createdDate;
	
	@Column(name="Created_By", nullable=false)
	private String createdBy;		// user id from UserInfo
	
	public UserGroup getUserGroup() {
		return userGroup;
	}

	public void setUserGroup(UserGroup userGroup) {
		this.userGroup = userGroup;
	}

	
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

}
