package com.skilldistillery.foodtruck.app;

import java.util.Scanner;
import com.skilldistillery.foodtruck.entities.FoodTruck;

public class FoodTruckApp {

	//fleet of FoodTrucks
	private FoodTruck[] fleet;
	Scanner input;
	//variable to test if we quit the program
	boolean keepGoing;
	//track number of trucks in fleet
	int numTrucks;
	
	public static void main(String[] args) {
		
		FoodTruckApp foodTruckApp = new FoodTruckApp();
		
	}
	
	public FoodTruckApp() {
		
		//instantiate array big enough to hold 5 trucks
		fleet = new FoodTruck[5];
		//Instantiate a scanner to use for all input
		input = new Scanner(System.in);
		keepGoing = true;
		numTrucks=0;
		
	}
	
	//method to get initial user choice (enter truck or quit)
	void chooseOption(Scanner scanner) {
		System.out.println("Would you like to enter a food truck? (Y or QUIT)");
		String appChoice = scanner.nextLine();
		appChoice = appChoice.toUpperCase();
		switch(appChoice) {
		case "Y":
			System.out.println("Not implemented yet");
			break;
		case "QUIT":
			closeApp();
			break;
		default:
			System.out.println("Not implemented yet. need to loop input");
			break;
		}
	}
	
	//method to close app
	void closeApp() {
		System.out.println("Goodbye!");
		System.exit(0);
	}
	
	//method to get foodtruck info
	void getTruckInfo(Scanner scanner) {
		//check for space in fleet
		
		//instantiate a new truck
		FoodTruck newTruck = new FoodTruck();
		System.out.println("Enter the name of the food truck:");
	}

}
