package org.amicoz.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SenderReceiver implements Serializable
{
	
	@Column(name="Sender_Id")
	private String senderID;
	
	@Column(name="Receiver_Id")
	private String receiverID;
	
	/**
	 * @return the senderID
	 */
	public String getSenderID() {
		return senderID;
	}

	/**
	 * @param senderID the senderID to set
	 */
	public void setSenderID(String senderID) {
		this.senderID = senderID;
	}

	/**
	 * @return the receiverID
	 */
	public String getReceiverID() {
		return receiverID;
	}

	/**
	 * @param receiverID the receiverID to set
	 */
	public void setReceiverID(String receiverID) {
		this.receiverID = receiverID;
	}
	
	public boolean equals(SenderReceiver sr)
	{
		if(this.getSenderID() == sr.senderID && this.getReceiverID() == sr.getReceiverID()){
			return true;
		}
		return false;
	}

}
