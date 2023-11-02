package com.cameraRental.project;


class Camera {

	private int id;
	private String brand;
	private String model;
	private double rentalAmount;  
	public String status;

	public Camera(int id, String brand, String model, double rentalAmount, String status) {
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.rentalAmount = rentalAmount;     
		this.status = status;

	}

	public int getId() {
		return id;
	}

	public String getBrand() {
		return brand;
	}

	public String getModel() {
		return model;
	}

	public double getRentalAmount() {
		return rentalAmount;
	}

	public void setRentalAmount(double rentalAmount) {
		this.rentalAmount = rentalAmount;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getrentalAmount() {
		return rentalAmount;
	}

	public String getStatus() {
		return status;
	}
	

	@Override
	public String toString() {
		return String.format("%-18s%-18s%-18s%-18s%-15s", id, brand, model, rentalAmount, status);
	}

	public void setStatus(String string) {
		// TODO Auto-generated method stub
		this.status = status;
	}
}



