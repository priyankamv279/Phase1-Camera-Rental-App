package com.cameraRental.project;

import java.util.*;

public class Option2_3 {

	static List<Camera> rentlist = new ArrayList<>();
	// all the cameras list
	static {

		rentlist.add(new Camera(1, "canon", "DSLR-D7500", 200.0, "Available"));
		rentlist.add(new Camera(2, "Sony", "DSLR12", 1400.0, "Available"));
		rentlist.add(new Camera(3, "Samsung", "SM123", 500.0, "Available"));
		rentlist.add(new Camera(4, "Sony", "SONY1234", 200.0, "Rented"));
		rentlist.add(new Camera(5, "Some", "Another", 123.0, "Available"));
		rentlist.add(new Camera(6, "Nikon", "N123", 200.0, "Available"));

	}

	public static void rentCamera(User user) {

		Scanner scanner = new Scanner(System.in);
		viewAvailableCameras(); // Display only available cameras

		try {
			System.out.print("Enter the camera ID you want to rent: ");
			int cameraId = scanner.nextInt();

			Camera selectedCamera = null;
			for (Camera camera : rentlist) {
				if (camera.getId() == cameraId && camera.getStatus().equals("Available")) {
					selectedCamera = camera;
					break;
				}
			}

			System.out.println("Wallet Balance: " + user.getWalletBalance()); 

			if (selectedCamera != null) {
				double rentalAmount = selectedCamera.getrentalAmount();
				System.out.println("Rent Amount: " + rentalAmount);

				if (user.getWalletBalance() >= rentalAmount) {
					user.deductBalance(rentalAmount);
					System.out.println("You rented " + selectedCamera.getBrand() + " " + selectedCamera.getModel() +
							" for INR " + rentalAmount + " per day.");
					System.out.println("New Wallet Balance: " + user.getWalletBalance()); 

					//show the avaliable cameras after renting
					System.out.println("\nUpdated List of Available Cameras after Renting:\n");
					selectedCamera.status ="Rented";
					System.out.println("=========================================================================================");
					System.out.println(String.format("%-18s%-18s%-18s%-18s%-15s", "Camera ID", "Brand", "Model", "Price (Per Day)", "Status"));
					System.out.println("=========================================================================================");
					rentlist.sort(Comparator.comparingInt(Camera::getId));
					for (Camera camera : rentlist) {
						if (camera.getStatus().equals("Available")) {
							System.out.println(camera);
						}
					} }else {
						System.out.println("Insufficient balance in your wallet to rent this camera.");
					}
			} else { 
				System.out.println("Camera with ID " + cameraId + " not found in the available list.");
			}
		} catch (InputMismatchException e) {
			System.out.println("Invalid input. Please enter a valid camera number.");
		}


	}

	// displaying only the avaliable options to rent
	public static void viewAvailableCameras() {

		if (rentlist.isEmpty()) {
			System.out.println("No Data Present at This Moment.");
			return;
		}

		System.out.println("List of Available Cameras:");
		System.out.println("=========================================================================================");
		System.out.println(String.format("%-18s%-18s%-18s%-18s%-15s", "Camera ID", "Brand", "Model", "Price (Per Day)", "Status"));
		System.out.println("=========================================================================================");
		for (Camera camera : rentlist) {
			if (camera.getStatus().equals("Available")) {
				System.out.println(camera);
			}
		}
	}

	// view all the cameras
	public static void viewAllCameras() {

		if (rentlist.isEmpty()== false) {

			System.out.println("List of All Cameras:");
			System.out.println("=========================================================================================");
			System.out.println(String.format("%-18s%-18s%-18s%-18s%-15s", "Camera ID", "Brand", "Model", "Price (Per Day)", "Status"));
			System.out.println("=========================================================================================");

			rentlist.sort(Comparator.comparingInt(Camera::getId));

			for (Camera camera : rentlist) {
				System.out.println(camera);
			}

		}
		else { System.out.println("no data present");
		}
	}

}