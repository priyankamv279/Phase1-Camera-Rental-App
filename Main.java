package com.cameraRental.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		CameraRentalApp object = new CameraRentalApp();
		User user = new User();
		List<Camera> rentlist = new ArrayList<>();

		// display page
		Scanner scanner = new Scanner(System.in);
		object.displayWelcomeScreen();
		object.displayloginpage();
		System.out.println("Developed by ------> Priyanka M V\n");
		
		// Authentication
		System.out.print("Enter your username: ");
		String username = scanner.nextLine();
		System.out.print("Enter your password: ");
		String password = scanner.nextLine();

		Option_1 opt1 = new Option_1(); 
		Option2_3 obj = new Option2_3();
		Option_4 opt4 = new Option_4();

		if (object.authenticateUser(username, password)) {
			object.displaymessage();

			while (true) {
				int choice = object.displayMainMenu();
				switch (choice) {
				case 1:
					opt1.MyCameras ();
					break;
				case 2:
					obj.rentCamera(user);
					break;
				case 3:
					obj.viewAllCameras();
					break;
				case 4:
					opt4.manageWallet(user);
					break;

				case 5:
					System.out.println("* Closed the App *");
					return;

				default:
					System.out.println("Invalid choice. Please try again.");
				}
			}
		} else {
			System.out.println("Authentication failed. Please enter valid credentials.");
		}
	}

}
