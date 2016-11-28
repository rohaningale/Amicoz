package org.amicoz.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.CascadeType;
import javax.persistence.Column;


@Entity
@Table(name="User")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="User_Id")
	private int userID;
	@Column(name="Primary_Email_Id", nullable=false)
	private String primaryEmailId;
	@Column(name="Secondary_Email_Id", nullable=true)
	private String secondaryEmailId;
	@Column(name="Password", nullable = false)
	private String password;
	@Column(name="Secret_Question_Id",nullable = false)
	//@JoinColumn(name="Question_Id")
	private String secretQuestion;
	@Column(name="Answer")
	private String secretQuestionAnswer;
	@Column(name="Created_By", nullable=false)
	private String createdBy;
	@Column(name="Creation_Date", nullable=false)
	private Date  CreationDate;
	@Column(name="Last_Updated_By", nullable=false)
	private String updatedBy;
	@Column(name="Last_Update_Date", nullable=false)
	private Date UpdateDate;
	public int getRecoveryBit() {
		return recoveryBit;
	}
	public void setRecoveryBit(int recoveryBit) {
		this.recoveryBit = recoveryBit;
	}
	@Column(name="Recovery_Bit")
	private int recoveryBit;
	
	
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getPrimaryEmailId() {
		return primaryEmailId;
	}
	public void setPrimaryEmailId(String primaryEmailId) {
		this.primaryEmailId = primaryEmailId;
	}
	public String getSecondaryEmailId() {
		return secondaryEmailId;
	}
	public void setSecondaryEmailId(String secondaryEmailId) {
		this.secondaryEmailId = secondaryEmailId;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getSecretQuestion() {
		return secretQuestion;
	}
	public void setSecretQuestion(String secretQuestion) {
		this.secretQuestion = secretQuestion;
	}
	public String getSecretQuestionAnswer() {
		return secretQuestionAnswer;
	}
	public void setSecretQuestionAnswer(String secretQuestionAnswer) {
		this.secretQuestionAnswer = secretQuestionAnswer;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreationDate() {
		return CreationDate;
	}
	public void setCreationDate(Date creationDate) {
		CreationDate = creationDate;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public Date getUpdateDate() {
		return UpdateDate;
	}
	public void setUpdateDate(Date updateDate) {
		UpdateDate = updateDate;
	}
	
}