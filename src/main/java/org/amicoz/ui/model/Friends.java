package org.amicoz.ui.model;

public class Friends {

	private int userId1;
	private int userId2;
	private boolean isBlocked;
	
	public int getUserId1() {
		return userId1;
	}
	public void setUserId1(int userId1) {
		this.userId1 = userId1;
	}
	public int getUserId2() {
		return userId2;
	}
	public void setUserId2(int userId2) {
		this.userId2 = userId2;
	}
	public boolean isBlocked() {
		return isBlocked;
	}
	public void setBlocked(boolean isBlocked) {
		this.isBlocked = isBlocked;
	}
}