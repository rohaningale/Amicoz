/**
 * 
 */
package org.amicoz.model;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Column;


/**
 * @author Girish
 *
 */

@Entity
public class Likes {

	@EmbeddedId
	private UserLikes userLikes;
	
	@Column(name="Like_Type")
	private String likeType;
	
	@Column(name="Like_On")
	private String likeOn;
	
	@Column(name="Created_Date", nullable=false)
	private Date createdDate;
	
	@Column(name="Created_By", nullable=false)
	private String createdBy;
	
	@Column(name="Last_Updated_Date", nullable=false)
	private Date lastUpdatedDate;
	
	@Column(name="Last_Updated_By", nullable=false)
	private String lastUpdatedBy;

	

	/**
	 * @return the likeType
	 */
	public String getLikeType() {
		return likeType;
	}

	/**
	 * @param likeType the likeType to set
	 */
	public void setLikeType(String likeType) {
		this.likeType = likeType;
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
	 * @return the likeOn
	 */
	public String getLikeOn() {
		return likeOn;
	}

	/**
	 * @param likeOn the likeOn to set
	 */
	public void setLikeOn(String likeOn) {
		this.likeOn = likeOn;
	}

	/**
	 * @return the userLikes
	 */
	public UserLikes getUserLikes() {
		return userLikes;
	}

	/**
	 * @param userLikes the userLikes to set
	 */
	public void setUserLikes(UserLikes userLikes) {
		this.userLikes = userLikes;
	}
	
}