package com.kannanrameshrk.dto;

public class Branch {
	private int id;
	private String name;
	private String address;
	private String phoneNumber;
	
	
	public Branch(String shopName, String shopAddress, String phoneNumber) {
		this.name=shopName;
		this.address=shopAddress;
		this.phoneNumber = phoneNumber;
	}
	public Branch() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
}
