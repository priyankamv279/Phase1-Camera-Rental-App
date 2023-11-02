package com.cameraRental.project;

class User {
	public double walletBalance;

	public User() {
		this.walletBalance = 0.0;
	}

	public double getWalletBalance() {
		return walletBalance;
	}

	public void addBalance(double amount) {
		walletBalance += amount;
	}

	public boolean deductBalance(double amount) {
		if (walletBalance >= amount) {
			walletBalance -= amount;
			return true;
		}
		return false;
	}
}
