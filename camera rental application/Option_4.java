package com.cameraRental.project;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Option_4 {

	public static void manageWallet(User user) {

		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("\nWallet Management:");
			System.out.println("1. View Wallet Balance");
			System.out.println("2. Add Money to Wallet");
			System.out.println("3. Return to Main Menu");
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			try {
				switch (choice) {
				case 1:
					System.out.println("Wallet Balance : " + user.getWalletBalance());
					break;
				case 2:
					System.out.print("Enter the amount to deposit (INR): ");
					double depositAmount = scanner.nextDouble();
					user.addBalance(depositAmount);
					System.out.println("Deposit of (INR) " + depositAmount + " successful. New balance: (INR)" + user.getWalletBalance());
					break;
				case 3:
					return; 
				default:
					System.out.println("Invalid choice. Please try again.");
				}
			}
			catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter a valid number.");
				scanner.nextLine();
			}

		}
	}
}


