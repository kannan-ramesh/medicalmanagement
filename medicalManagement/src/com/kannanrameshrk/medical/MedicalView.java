package com.kannanrameshrk.medical;

import java.util.List;
import java.util.Scanner;

import com.kannanrameshrk.BaseView;
import com.kannanrameshrk.dto.Branch;
import com.kannanrameshrk.dto.Medicine;
import com.kannanrameshrk.dto.Purchase;
import com.kannanrameshrk.user.UserView;

public class MedicalView {
	private MedicalViewModel medicalViewModel;
	
	public MedicalView() {
		medicalViewModel = new MedicalViewModel(this);
	}

	public void regShop(Scanner input) {
		System.out.println("Enter Medical Shop Name:");
		String shopName=input.nextLine();
		System.out.println("Enter Medical Shop address:");
		String shopAddress=input.nextLine();
		System.out.println("Enter Phone Number:");
		String phoneNumber = input.next();
		
		Branch branch = new Branch(shopName,shopAddress,phoneNumber);
		medicalViewModel.validate(branch);
		}

	public void showErr(String errMessage) {
		System.out.println(errMessage);
	}

	public void onSuccess(String successMessage) {
		System.out.println(successMessage);
	}

	public void addMedicine(Scanner input) {
		UserView userView=new UserView();
		userView.showBranch();

		System.out.println("Enter Medichine Name:");
		String medichineName=input.nextLine();
		System.out.println("Enter Medichine Category:");
		String gategory=input.nextLine();
		System.out.println("Enter Medichine Price:(10-n)");
		double medichinePrice=input.nextDouble();
		System.out.println("Enter Quentiry:(1-n)");
		int quentity=input.nextInt();
		System.out.println("Enter Branch Id:");
		int branchId=input.nextInt();
		Medicine mede=new Medicine(medichineName, gategory,medichinePrice,quentity,branchId);
		medicalViewModel.addMedichine(mede);
	}

	public void getPurchaseData() {
		List<Purchase> purchaseData=medicalViewModel.getPurchaseData();
		
		if(purchaseData.size()==0) {
			System.out.println("No Data found");
		}else {
			BaseView baseView = new BaseView();
			baseView.viewPurchaseData(purchaseData);
		}
	}
}
