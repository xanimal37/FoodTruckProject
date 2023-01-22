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

		// pass scanner to app object on creatinon
		FoodTruckApp app = new FoodTruckApp();
		// this will start the main program loop
		app.launch(scanner);
		// this will run afer the main program loop
		// closes the scanner
		scanner.close();
	}

	// method within FoodTruckApp class that launches the app
	private void launch(Scanner input) {
		//instantiate the fleet!!
		fleet = new FoodTruck[5];
	
		// this runs before the loop starts
		System.out.println("== Welcome to Food Truck App ===");

		// this is the main program loop
		mainMenuLoop(input);

		// this runs when the loop ends
		System.out.println("== Bye! Hope you had some good food! ==");
	}

	private void mainMenuLoop(Scanner input) {
		boolean keepGoing = true;
		while (keepGoing) {
			System.out.println("Would you like to add food trucks? (Y or QUIT)");
			String choice = input.nextLine();
			//make all caps so it's easier to write switch cases
			choice = choice.toUpperCase();			
			switch(choice) {
			case "Y":
				addFoodTruck(input);
				break;
			case "QUIT":
				keepGoing = false;
				break;
			default:
				System.out.println("Please enter a valid option (Y or QUIT)");
				break;
			}
		}
	}
	
	private void addFoodTruck(Scanner input) {
		System.out.println("Please enter the truck name:");
		String newName = input.nextLine();
		
		//exit if user enters quit or QUIT
		if(newName.equals("QUIT") || newName.equals("quit")) {
			return;
		}
		
		System.out.println("Please enter the truck food type:");
		String newFoodType = input.nextLine();
		System.out.println("Please enter the truck rating:");
		int newRating = input.nextInt();
		//clear scanner
		input.nextLine();
		
		System.out.println("You entered Name: " + newName + " FoodType: " + newFoodType + " Rating: "+ newRating);
		System.out.println("Is this correct? (Y/N)");
		//check if user really wants to enter this truck
		String isCorrect = input.nextLine();
		//make all UPPERCASE to make switch simpler
		isCorrect = isCorrect.toUpperCase();
		
		//switch - either add the truck or go back into main loop
		switch(isCorrect) {
		case "N":
			//start this method again
			addFoodTruck(input);
			break;
		case "Y":
			FoodTruck newTruck = new FoodTruck();
			newTruck.setName(newName);
			newTruck.setfoodType(newFoodType);
			newTruck.setRating(newRating);
			//add to fleet
			fleet[numTrucks]=newTruck;
			//fleet size tracker
			numTrucks++;
			addFoodTruck(input);
			break;
		default:
			break;
		}
		
		
	}

}
