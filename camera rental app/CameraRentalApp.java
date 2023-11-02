package com.cameraRental.project;

import java.util.*;


public class CameraRentalApp {
	private static List<Camera> cameraList = new ArrayList<>();
	private static User user = new User();

	//setting the login credentials
	private static final String USERNAME = "admin";
	private static final String PASSWORD = "admin123";

	/* main menu selection*/

	public static boolean authenticateUser(String username, String password) {
		return username.equals(USERNAME) && password.equals(PASSWORD);
	}

	public static void displayWelcomeScreen() {
		System.out.println("WELCOME TO CAMERA RENTAL APP");
	}

	public static void displayloginpage() {
		System.out.println("\nPLEASE LOGIN TO CONTINUE\n");
	}

	public static void displaymessage() {
		System.out.println("Successfully Logged In");
	}

	// main menu display
	static int displayMainMenu() {
		System.out.println("\nMain Menu:");
		System.out.println("1. MY Cameras");
		System.out.println("2. Rent a Camera");
		System.out.println("3. View all Cameras");
		System.out.println("4. Manage Wallet");
		System.out.println("5. Close Application");
		System.out.print("Enter your choice: ");
		Scanner scanner = new Scanner(System.in);
		return scanner.nextInt();
	}



}

