package com.kannanrameshrk;

public class Validations {

	public boolean validateName(String name) {
		if(name.length()>=3 && name.length()<=50) {
			return true;
		}
		return false;
	}

	public boolean validateAddress(String address) {
		if(address.length()>3 && address.length()<=100) {
			return true;
		}
		return false;
	}

	public boolean validatePhoneNumber(String phoneNumber) {
		if(phoneNumber.matches("^\\d{10}$")) {
			return true;
		}
		return false;
	}

	public boolean validatePrice(double price) {
		if(price>=10) {
			return true;
		}
		return false;
	}

	public boolean validateQuantity(int quentity) {
		if(quentity>0 && quentity<=500) {
			return true;
		}
		return false;
	}
}
