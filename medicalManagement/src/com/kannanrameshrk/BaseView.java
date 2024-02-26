package com.kannanrameshrk;

import java.util.List;
import java.util.Scanner;

import com.kannanrameshrk.dto.Branch;
import com.kannanrameshrk.dto.Purchase;
import com.kannanrameshrk.medical.MedicalView;
import com.kannanrameshrk.user.UserView;

public class BaseView {
	public void adminStart(Scanner input) {
		final String userName = "kannanramesh";
		final String password = "15410198";
		MedicalView medicalView = new MedicalView();

		System.out.println("Enter UserName:");
		String uName = input.next();
		System.out.println("Enter Your Password:");
		String pass = input.next();

		if (userName.equals(uName) && password.equals(pass)) {
			boolean loop = true;
			do {
				System.out.println(" 1.Add Medical Branch");
				System.out.println(" 2.Add Medicines");
				System.out.println(" 3.Order Details");
				System.out.println(" 4.exit");

				System.out.println();

				System.out.println("Enter your Choice:");
				System.out.println("******************");
				int choice = input.nextInt();
				input.nextLine();
				switch (choice) {
				case 1: {
					System.out.println("\t\t Medical Branch");
					System.out.println("\t\t****************");
					medicalView.regShop(input);
					break;
				}
				case 2: {
					System.out.println("\t\tAdd Mediciens");
					System.out.println("\t\t****************");
					medicalView.addMedicine(input);
					break;
				}
				case 3: {
					System.out.println("\t\tOrder Details");
					System.out.println("\t\t****************");
					medicalView.getPurchaseData();
					break;
				}
				case 4: {
					loop = false;
					System.out.println("Exit Application...");
					break;
				}
				default: {
					System.out.println("Invalid choice..");
					break;
				}
				}
			} while (loop);
		} else {
			System.out.println("Invalid UserName Password..");
			return;
		}
	}

	public void userStart(Scanner input) {
		UserView userView = new UserView();
		boolean loop = true;
		do {
			System.out.println(" 1.View Branchs");
			System.out.println(" 2.Catagory Medichine");
			System.out.println(" 3.Order Medichine");
			System.out.println(" 4.Order Details");
			System.out.println(" 5.exit");

			System.out.println();

			System.out.println("Enter your Choice:");
			System.out.println("******************");
			int choice = input.nextInt();
			input.nextLine();

			switch (choice) {
			case 1: {
				System.out.println("\t\t Medical Branch");
				System.out.println("\t\t****************");
				userView.showBranch();
				break;
			}
			case 2: {
				System.out.println("\t\tCatagory Medechine");
				System.out.println("\t\t****************");
				userView.showMedichineCategory();
				break;
			}
			case 3: {
				System.out.println("\t\tOrder Medechine");
				System.out.println("\t\t****************");
				userView.orderMedichine(input);
				break;
			}
			case 4: {
				System.out.println("\t\tOrder details");
				System.out.println("\t\t****************");
				userView.userOrderData(input);
				break;
			}
			case 5: {
				loop = false;
				System.out.println("Exit Application...");
				break;
			}
			default: {
				System.out.println("Invalid choice..");
				break;
			}
			}
		} while (loop);
	}

	public void viewBranch(List<Branch> data) {
		System.out.println("Branch Id" + "    " + "Branch Name" + "    " + "Address" + "   " + "PhoneNumber");
		System.out.println("-------------------------------------------------------------------------");
		for (Branch val : data) {
			System.out.printf("%-11d%-14s%-18s%-12s%n", val.getId(), val.getName(), val.getAddress(),
					val.getPhoneNumber());
		}
		System.out.println("-------------------------------------------------------------------------");
	}

	public void viewPurchaseData(List<Purchase> purchaseData) {
		System.out.println("Purchase Details:");
		System.out.println("-----------------------------------------------------------------------------------------------------------------------");
		System.out.printf("%-20s %-10s %-10s %-20s %-20s %-15s %-20s %-20s %-20s%n", "Date", "Quantity", "Price",
				"User Name", "User Address", "User Phone", "Medicine Name", "Medicine Category", "Branch Name");
		System.out.println("----------------------------------------------------------------------------------------------------------------------");

		for (Purchase purchase : purchaseData) {
			System.out.printf("%-20s %-10d %-10.2f %-20s %-20s %-15s %-20s %-20s %-20s%n", purchase.getDateTime(),
					purchase.getQuantity(), purchase.getTotalPrice(), purchase.getUser().getUserName(),
					purchase.getUser().getAddress(), purchase.getUser().getPhoneNumber(),
					purchase.getMedicine().getName(), purchase.getMedicine().getCategory(),
					purchase.getBranch().getName());
		}
		System.out.println("---------------------------------------------------------------------------------------------------------------------");
	}
}