//This structure heavily copies from the MAdLibs app we had to modify 
//for one of the evening labs

package com.skilldistillery.foodtruck.app;

import java.util.Scanner;
import com.skilldistillery.foodtruck.entities.FoodTruck;

public class FoodTruckApp {

	// fleet of FoodTrucks
	private FoodTruck[] fleet;

	// track number of trucks in fleet
	int numTrucks = 0;

	public static void main(String[] args) {

		// Instantiate a scanner to use for all input
		Scanner scanner = new Scanner(System.in);

		// pass scanner to app object on creation
		FoodTruckApp app = new FoodTruckApp();
		// this will start the main program loop
		app.launch(scanner);
		// this will run after the main program loop
		// closes the scanner
		scanner.close();
	}

	// method within FoodTruckApp class that launches the app
	private void launch(Scanner input) {
		// instantiate the fleet!!
		fleet = new FoodTruck[5];

		// this runs before the loop starts
		System.out.println("==============================================");
		System.out.println("========= Welcome to Food Truck App ==========");
		System.out.println("==============================================");

		// this is the main program loop
		mainMenuLoop(input);

		// this runs when the loop ends
		System.out.println("== Bye! Hope you had some good food! ==");
	}

	private void mainMenuLoop(Scanner input) {
		boolean keepGoing = true;
		while (keepGoing) {
			// different menu items depending on numTrucks;
			if (numTrucks == 0) {
				System.out.println("==============================================");
				System.out.println("Would you like to add food trucks? (Y or QUIT)");
				System.out.println("==============================================");
			} else {
				System.out.println("==============================================");
				System.out.println("Would you like to add food trucks? (Y or QUIT)");
				System.out.println("(D)isplay all Food Trucks");
				System.out.println("View (A)verage rating");
				System.out.println("See the (H)ighest rated Food Truck --");
				System.out.println("==============================================");
			}

			String choice = input.nextLine();
			// make all caps so it's easier to write switch cases
			choice = choice.toUpperCase();
			switch (choice) {
			case "Y":
				addFoodTruck(input);
				// if addFoodtruck exists after entering trucks
				displayFleet();
				break;
			case "D":
				// the user could accidentally enter these choices even if they aren't offered
				// so test that numTrucks is >0 and if so do nothing
				if (numTrucks > 0) {
					displayFleet();
				}
				break;
			case "A":
				if (numTrucks > 0) {
					showAverageRating();
				}
				break;
			case "H":
				if (numTrucks > 0) {
					showHighestRated();
				}
				break;
			case "QUIT":
				keepGoing = false;
				break;
			default:
				System.out.println("Please enter a valid option!");
				break;
			}
		}
	}

	private void addFoodTruck(Scanner input) {
		// first, check that a truck can be added
		// exit method is fleet is full
		if (numTrucks >= 5) {
			System.out.println("All trucks have been entered.");
			return;
		}

		System.out.println("Please enter the truck name:");
		String newName = input.nextLine();

		// exit method if user enters quit or QUIT
		if (newName.equals("QUIT") || newName.equals("quit")) {
			return;
		}

		System.out.println("Please enter the truck food type:");
		String newFoodType = input.nextLine();
		System.out.println("Please enter the truck rating (1 - 10):");
		int newRating = input.nextInt();
		// clear scanner
		input.nextLine();

		System.out.println("You entered Name: " + newName + " FoodType: " + newFoodType + " Rating: " + newRating);
		System.out.println("Is this correct? (Y/N)");
		// check if user really wants to enter this truck
		String isCorrect = input.nextLine();
		// make all UPPERCASE to make switch simpler
		isCorrect = isCorrect.toUpperCase();

		// switch - either add the truck or go back into main loop
		switch (isCorrect) {
		case "N":
			// start this method again
			addFoodTruck(input);
			break;
		case "Y":
			FoodTruck newTruck = new FoodTruck();
			newTruck.setName(newName);
			newTruck.setfoodType(newFoodType);
			newTruck.setRating(newRating);
			// add to fleet
			fleet[numTrucks] = newTruck;
			// fleet size tracker
			numTrucks++;
			addFoodTruck(input);
			break;
		default:
			break;
		}

	}

	// method shows all trucks in fleet with their data
	private void displayFleet() {
		// header
		System.out.println("==============================================");
		System.out.println("===== Name ==== ID ==== Type ==== Rating =====");
		System.out.println("==============================================");

		for (FoodTruck truck : fleet) {
			if (truck != null) {
				System.out.println(truck);
			}
		}
	}

	// method shows the truck with the highest rating
	private void showHighestRated() {

		FoodTruck highestRated = fleet[0];

		for (FoodTruck truck : fleet) {
			if (truck != null) {
				if (truck.getRating() > highestRated.getRating()) {
					highestRated = truck;
				}
			}
		}
		// header
		System.out.println("==============================================");
		System.out.println("=========      HIGHEST RATED      ============");
		System.out.println("===== Name ==== ID ==== Type ==== Rating =====");
		System.out.println("==============================================");
		System.out.println(highestRated);
	}

	// method to tell the user the average truck rating
	private void showAverageRating() {

		int total = 0;
		double avgRating = 0;

		for (FoodTruck truck : fleet) {
			if (truck != null) {
				total += truck.getRating();
			}
		}

		avgRating = total / numTrucks;
		System.out.println("========================================================");
		System.out.println("The average truck rating is " + avgRating + " out of 10.");
		System.out.println("========================================================");
	}

}
