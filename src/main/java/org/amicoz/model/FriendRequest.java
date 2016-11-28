package org.amicoz.model;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Column;



import java.io.Serializable;
import java.util.Date;





@Entity
@Table(name="Friend_Request")
public class FriendRequest {

	@EmbeddedId
	private SenderReceiver senderReciever;
	
	
	@Column(name="Created_Date", nullable = false)
	private Date createdDate;
	
	@Column(name="Created_By", nullable = false)
	private String createdBy;
	
	@Column(name="Last_Updated_Date", nullable = false)
	private Date lastUpdatedDate;
	
	@Column(name="Last_Updated_By", nullable = false)
	private String lastUpdatedBy;

	
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

	/**
	 * @return the senderReceiver
	 */
	public SenderReceiver getSenderReceiver() {
		return senderReciever;
	}

	/**
	 * @param senderReceiver the senderReceiver to set
	 */
	public void setSenderReceiver(SenderReceiver senderReceiver) {
		this.senderReciever = senderReceiver;
	}
	
}

