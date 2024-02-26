package com.kannanrameshrk.user;

import java.util.List;

import com.kannanrameshrk.dto.Branch;
import com.kannanrameshrk.dto.Medicine;
import com.kannanrameshrk.dto.Purchase;
import com.kannanrameshrk.dto.User;
import com.kannanrameshrk.repository.Repository;

class UserViewModel {
	private UserView userView;
	
	public UserViewModel(UserView userView) {
		this.userView = userView;
	}

	public List<Branch> getData() {
		return Repository.getInstance().getBranchData();
	}

	public List<String> getGategoryData() {
		return Repository.getInstance().getGategoryData();
	}

	public int saveUserToDatabase(User user) {
		return Repository.getInstance().addUser(user);
	}

	public double getMedicinePrice(int medicineId) {
		return Repository.getInstance().getMedicinePrice(medicineId);
	}

	public boolean savePurchaseData(Purchase purchase) {
		return Repository.getInstance().savePurchasedata(purchase) ;
	}

	public List<Purchase> userOrderData(String phoneNumber) {
		return Repository.getInstance().userOrderData(phoneNumber);
	}
}
