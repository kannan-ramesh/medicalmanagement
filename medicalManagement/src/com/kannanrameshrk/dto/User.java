package com.kannanrameshrk.dto;

public class User {
	private int userId;
	private String userName;
	private String address;
	private String phoneNumber;
	private int branch_id;
	
	public User(String userName, String address, String phoneNumber, int branchId) {
		this.userName=userName;
		this.address=address;
		this.phoneNumber=phoneNumber;
		this.branch_id=branchId;
	}
	public User() {
		// TODO Auto-generated constructor stub
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getBranch_id() {
		return branch_id;
	}
	public void setBranch_id(int branch_id) {
		this.branch_id = branch_id;
	}
	
	
}
