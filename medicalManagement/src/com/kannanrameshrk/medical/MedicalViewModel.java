package com.kannanrameshrk.medical;

import java.util.List;

import com.kannanrameshrk.Validations;
import com.kannanrameshrk.dto.Branch;
import com.kannanrameshrk.dto.Medicine;
import com.kannanrameshrk.dto.Purchase;
import com.kannanrameshrk.repository.Repository;

class MedicalViewModel {
	private MedicalView medicalView;
	Validations validation=new Validations();
	
	public MedicalViewModel(MedicalView medicalView) {
		this.medicalView = medicalView;
	}

	public void validate(Branch branch) {
		boolean branchName =validation.validateName(branch.getName());
		boolean address = validation.validateAddress(branch.getAddress());
		boolean phoneNumber = validation.validatePhoneNumber(branch.getPhoneNumber());
		
		if(branchName && address && phoneNumber) {
			boolean success=Repository.getInstance().registerBranch(branch);
			if(success) {
				medicalView.onSuccess("Branch Added Successfully");
			}else {
				medicalView.showErr("Branch not added...");
			}
		}else {
			medicalView.showErr("Please check Your Input");
		}
	}

	public void addMedichine(Medicine mede) {
		boolean name=validation.validateName(mede.getName());
		boolean category=validation.validateName(mede.getCategory());
		boolean price=validation.validatePrice(mede.getPrice());
		boolean quantity=validation.validateQuantity(mede.getQuentity());
		
		if(name==false) {
			medicalView.showErr("Please Check medichine Name..");
		}
		if(category==false) {
			medicalView.showErr("please check category..");
		}
		if(price==false) {
			medicalView.showErr("please check price...");
		}
		if(quantity==false) {
			medicalView.showErr("please enter non-negative number(1-500)");
		}
		
		if(name && category && price && quantity) {
			boolean success=Repository.getInstance().registerMedichine(mede);
			if(success) {
				medicalView.onSuccess("Medechine Added Successfully");
			}else {
				medicalView.showErr("Medechine not added...");
			}
		}else {
			medicalView.showErr("please check your input...");
		}
	}

	public List<Purchase> getPurchaseData() {
		return Repository.getInstance().getPurchaseData();
	}
}
