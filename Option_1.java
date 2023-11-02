package com.cameraRental.project;

import java.util.*;

public class Option_1 {

	// mycameras sub option 1
	private static void addCamera(){
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.print("ENTER THE CAMERA Brand: ");
			String brand = scanner.nextLine();
			System.out.print("ENTER THE MODEL: ");
			String model = scanner.nextLine();
			System.out.print("ENTER THE PER DAY PRICE(INR): ");
			double rentalAmount = scanner.nextDouble();
			scanner.nextLine(); // Consume the newline character

			// Auto-increment the ID
			int id = Option2_3.rentlist.size() + 1;
			// Set the status to "Available"
			String status = "Available";

			Camera newCamera = new Camera(id, brand, model, rentalAmount, status);
			Option2_3.rentlist.add(newCamera);

			System.out.println("YOUR CAMERA HAS BEEN SUCCESSFULLY ADDED TO THE LIST.\n");
		} catch (InputMismatchException e) {
			System.out.println("Invalid input. Please enter a valid entry.");
		}
	}


	// mycameras sub option 2
	private static void removeCamera() {
		Option2_3.viewAllCameras();
		System.out.print("ENTER THE CAMERA ID TO REMOVE: ");
		Scanner scanner = new Scanner(System.in);
		int cameraId = scanner.nextInt();

		Camera cameraToRemove = null;
		for (Camera camera : Option2_3.rentlist ) {
			if (camera.getId() == cameraId ) {
				cameraToRemove = camera;
				break;
			}
		}

		if (cameraToRemove != null) {
			Option2_3.rentlist.remove(cameraToRemove);
			System.out.println("CAMERA SUCCESSFULLY REMOVED.\n");
		} else {
			System.out.println("Camera with ID " + cameraId + " not found in your list.");
		}
	}

	// mycameras sub option 3
	private static void viewMyCameras() {
		System.out.println("The following details show the mylist of cameras:\n");

		if (Option2_3.rentlist.isEmpty()) {
			System.out.println("No cameras in your list.");
			return;
		}

		System.out.println("=========================================================================================");
		System.out.println(String.format("%-18s%-18s%-18s%-18s%-15s", "Camera ID", "Brand", "Model", "Price (Per Day)", "Status"));
		System.out.println("=========================================================================================");

		Option2_3.rentlist.sort(Comparator.comparingInt(Camera::getId));

		for (Camera camera : Option2_3.rentlist) {
			if (camera.getStatus().equals("Rented")) {
				System.out.println(camera);
			}
		}

	}

	// option_1 main menu 
	public static void MyCameras() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("\nMy Cameras Menu:");
			System.out.println("1. ADD");
			System.out.println("2. REMOVE");
			System.out.println("3. VIEW MY CAMERAS");
			System.out.println("4. GO TO PREVIOUS MENU");
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			try {
				switch (choice) {
				case 1:
					addCamera();
					break;
				case 2:
					removeCamera();
					break;
				case 3:
					viewMyCameras();
					break;
				case 4:
					return;
				default:
					System.out.println("Invalid choice. Please try again.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter a valid number.");
				scanner.nextLine(); 
			}
		}
	}
}
