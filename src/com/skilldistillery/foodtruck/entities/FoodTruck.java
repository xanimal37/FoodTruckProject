package com.skilldistillery.foodtruck.entities;

public class FoodTruck {

	private static int nextTruckId;
	private String name;
	private String foodType;
	private int rating;
	//user does not set this
	private int id;
	
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
	
	public void setRating(int rating) {
		this.rating = rating;
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
	
	public int getRating() {
		return rating;
	}
	
	//override object string method (good practice)
	@Override
	public String toString() {
		return "== " + getName() + " == " + getId() + " == " + getFoodType() + " == " + getRating() + " == ";
	}
}
