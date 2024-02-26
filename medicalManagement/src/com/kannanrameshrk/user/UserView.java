package com.kannanrameshrk.user;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import com.kannanrameshrk.BaseView;
import com.kannanrameshrk.Validations;
import com.kannanrameshrk.dto.Branch;
import com.kannanrameshrk.dto.Purchase;
import com.kannanrameshrk.dto.User;

public class UserView {
	private UserViewModel userViewModel;
	BaseView baseView = new BaseView();

	public UserView() {
		userViewModel = new UserViewModel(this);
	}

	public void showBranch() {
		List<Branch> data = userViewModel.getData();

		if (data.size() == 0) {
			System.out.println("No Data Found..");
		} else {
			baseView.viewBranch(data);
		}
	}

	public void showMedichineCategory() {
		List<String> categoryData = userViewModel.getGategoryData();

		if (categoryData.size() == 0) {
			System.out.println("No Data Found..");
		} else {
			int i = 0;
			System.out.println("SLNo   Categorys");
			System.out.println("--------------------");

			for (String val : categoryData) {
				System.out.println(++i + "      " + val);
			}
			System.out.println("--------------------");
		}

	}

	public void orderMedichine(Scanner input) {
		System.out.println("Please enter your details:");

		System.out.print("Name: ");
		String userName = input.nextLine();
		System.out.print("Address: ");
		String address = input.nextLine();
		System.out.print("Phone Number: ");
		String phoneNumber = input.nextLine();
		System.out.print("Branch ID: ");
		int branchId = input.nextInt();
		input.nextLine();

		User user = new User(userName, address, phoneNumber, branchId);

		int userId = userViewModel.saveUserToDatabase(user);
		System.out.println("Your user Id is:" + userId);
		System.out.println("Please enter the medicine details:");
		System.out.print("Medicine ID: ");
		int medicineId = input.nextInt();
		System.out.print("Quantity: ");
		int quantity = input.nextInt();

		double price = userViewModel.getMedicinePrice(medicineId);
		if (price == -1) {
			System.out.println("Medicine Not found..");
		}

		double totalPrice = price * quantity;
		LocalDateTime dateTime = LocalDateTime.now();

		Purchase purchase = new Purchase(userId, medicineId, dateTime, quantity, totalPrice, branchId);
		boolean success = userViewModel.savePurchaseData(purchase);

		if (success) {
			System.out.println("Purchase successful!");
		} else {
			System.out.println("Purchase unsuccessful!");
		}
	}

	public void userOrderData(Scanner input) {
		System.out.println("Enter your phoneNumber:");
		String phoneNumber=input.next();
		
		Validations val=new Validations();
		boolean success=val.validatePhoneNumber(phoneNumber);
		
		if(success) {
			List<Purchase> userPurchaseData=userViewModel.userOrderData(phoneNumber);
			baseView.viewPurchaseData(userPurchaseData);
		}else {
			System.out.println("Invalid PhoneNumber:");
			userOrderData(input);
		}
	}
}