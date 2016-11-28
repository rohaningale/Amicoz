/**
 * 
 */
package org.amicoz.model;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Groups")
public class Groups {
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Group_Id")
	private int groupId;
	
	@Column(name="Admin_User_Id", nullable=false)
	private int adminId;
	
	@Column(name="Group_Name", nullable=false)
	private String groupName;
	
	@Column(name="Is_Chat_Group", nullable=false)
	private boolean isChatGroup;
	
	@Column(name="User_Limit")
	private int userLimit;
	
	@Column(name="Group_members")
	private String userLists;

	@Column(name="Group_Description")
	private String groupDescription;
	
	@Column(name="Creation_Date", nullable=false)
	private Date createdDate;
	
	@Column(name="Created_By", nullable=false)
	private String createdBy;		// user name
	
	@Column(name="Last_Update_Date", nullable=false)
	private Date lastUpdatedDate;
	
	@Column(name="Last_Updated_By", nullable=false)
	private String lastUpdatedBy;	// user name

	@Column(name="Is_Deleted", nullable=false)
	private String isDeleted;
	
	public String isDeleted() {
		return isDeleted;
	}

	public void setDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
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

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public boolean isChatGroup() {
		return isChatGroup;
	}

	public void setChatGroup(boolean isChatGroup) {
		this.isChatGroup = isChatGroup;
	}

	public int getUserLimit() {
		return userLimit;
	}

	public void setUserLimit(int userLimit) {
		this.userLimit = userLimit;
	}

	public String getUserLists() {
		return userLists;
	}

	public void setUserLists(String userLists) {
		this.userLists = userLists;
	}

	public String getGroupDescription() {
		return groupDescription;
	}

	public void setGroupDescription(String groupDescription) {
		this.groupDescription = groupDescription;
	}
	
	
		
}
