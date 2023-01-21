package com.skilldistillery.foodtruck.entities;

public class FoodTruck {

	private static int nextTruckId;
	
	private int id;
	private String name;
	private String foodType;
	
	//constructor
	//auto-assign id using static variable owned by FoodTruck class
	public FoodTruck() {
		id=nextTruckId++;
	}
	
	//setters
	public void setName(String name) {
		this.name = name;
	}
	
	public void setfoodType(String foodType) {
		this.foodType = foodType;
	}
	
	//getters
	public String getName() {
		return name;
	}
	
	public String getFoodType() {
		return foodType;
	}
	
	public int getId() {
		return id;
	}
	
	
	//override object string method (good practice)
	@Override
	public String toString() {
		return "not implemented yet";
	}
}
