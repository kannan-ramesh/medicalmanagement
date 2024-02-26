package com.kannanrameshrk.dto;

import java.time.LocalDateTime;

public class Purchase {
	  private int id;
	  private int userId;
	  private int medicineId;
      private LocalDateTime dateTime;
      private int quantity;
	  private double totalPrice;
	  private int branchId;
	  private User user;
	  private Branch branch;
	  private Medicine medicine;
	  
	public Purchase(int userId, int medicineId, LocalDateTime dateTime2, int quantity, double totalPrice,
			int branchId) {
		this.userId=userId;
		this.medicineId=medicineId;
		this.dateTime=dateTime2;
		this.quantity=quantity;
		this.totalPrice=totalPrice;
		this.branchId=branchId;
	}
	public Purchase() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getMedicineId() {
		return medicineId;
	}
	public void setMedicineId(int medicineId) {
		this.medicineId = medicineId;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	public Medicine getMedicine() {
		return medicine;
	}
	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}	  
}