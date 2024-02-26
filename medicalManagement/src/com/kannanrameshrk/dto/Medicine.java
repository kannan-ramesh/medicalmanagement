package com.kannanrameshrk.dto;

public class Medicine {
	private int id;
	private String name;
	private String category;
	private double price;
	private int quentity;
	private int branchId;
	
	
	public Medicine(String medichineName, String category, double medichinePrice, int quentity, int branchId) {
		this.name=medichineName;
		this.category=category;
		this.price=medichinePrice;
		this.quentity=quentity;
		this.branchId=branchId;
	}
	public Medicine() {
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuentity() {
		return quentity;
	}
	public void setQuentity(int quentity) {
		this.quentity = quentity;
	}
	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	
	
}
