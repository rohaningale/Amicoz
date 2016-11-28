package org.amicoz.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_search_v")
public class SearchView {
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public void setPrimary_Email_Id(String primary_Email_Id) {
		Primary_Email_Id = primary_Email_Id;
	}
	public void setFull_Name(String full_Name) {
		Full_Name = full_Name;
	}
	public void setCity(String city) {
		City = city;
	}
	public void setFIRST_NAME(String fIRST_NAME) {
		FIRST_NAME = fIRST_NAME;
	}
	public void setLAST_NAME(String lAST_NAME) {
		LAST_NAME = lAST_NAME;
	}
	@Id
	int user_id;
	String Primary_Email_Id;
	String Full_Name;
	String City;
	String FIRST_NAME;
	String LAST_NAME;
	public int getUser_id() {
		return user_id;
	}
	public String getPrimary_Email_Id() {
		return Primary_Email_Id;
	}
	public String getFull_Name() {
		return Full_Name;
	}
	public String getCity() {
		return City;
	}
	public String getFIRST_NAME() {
		return FIRST_NAME;
	}
	public String getLAST_NAME() {
		return LAST_NAME;
	}
	
	
}
