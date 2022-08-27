package comm.skilldistillery.foodtruck.app;

import java.util.Scanner;

import comm.skilldistillery.foodtruck.entities.FoodTruck;

public class FoodTruckApp {

	Scanner kb = new Scanner(System.in);

	int MAX_TRUCKS = 5;
	FoodTruck[] truckFleet = new FoodTruck[MAX_TRUCKS];

	public static void main(String[] args) {
		System.out.println("Hello! Welcome to the customized Food Truck Application!");
		System.out.println();

		FoodTruckApp trucks = new FoodTruckApp();
		trucks.createTrucks();
	}

	public void createTrucks() {
		for (int truckID = 0; truckID < truckFleet.length; truckID++) {
			System.out.println(
					"Please Enter a Food Truck Name (Note: type \"quit\" here to stop entry or enter less than 5): ");
			String name = kb.nextLine();

			if (name.equalsIgnoreCase("quit")) {
				break;
			}

			System.out.println("Please Enter this Food Truck's type of Cuisine: ");
			String foodType = kb.nextLine();

			System.out.println("Please enter this Food Truck's rating (1-5): ");
			int rating = kb.nextInt();
			kb.nextLine();
			// absorb the extra line that populated
			// when the user returns their response 
			//to  first prompt

		FoodTruck truck = new FoodTruck(name,foodType,rating);
		truckFleet[truckID] = truck;

		}
		while (true) {
			displayMenu();
			System.out.println();
		}

	}

	public void displayTrucks() {
		// display the array of food trucks that was created
		// in for loop createTrucks() method
		for (FoodTruck foodTruck : truckFleet) {
			if (foodTruck != (null)) {
				System.out.println(foodTruck.toString());
			}
		}

	}

	public void displayMenu() {
		System.out.println("1. List all food trucks in the area");
		System.out.println("2. See the average rating of food trucks");
		System.out.println("3. Display the highest-rated food truck");
		System.out.println("4. Quit the program");
		int choice = kb.nextInt();

		switch (choice) {

		case 1:
			displayTrucks();
			break;
		case 2:
			calculateAverage();
			break;
		case 3:
			highestRated();
			break;
		case 4:
			System.out.println("Exiting the Program, Goodbye.");
			System.exit(0);

		}

	}

	public void calculateAverage() {
		int ratingTotal = 0;
		int count = 0;

		for (int i = 0; i < truckFleet.length; i++) {
			FoodTruck foodTruck = truckFleet[i];
			if (foodTruck != null) {
				ratingTotal += foodTruck.getTruckRating();
				count++;
			}
		}

		double average = (double) ratingTotal / count;

		System.out.println("The average rating of all your trucks is: " + average);
	}

	public void highestRated() {
		FoodTruck prior = truckFleet[0];

		FoodTruck highest = truckFleet[0];

		for (int i = 0; i < truckFleet.length; i++) {
			FoodTruck foodTruck = truckFleet[i];
			if (foodTruck != null) {
				if (prior.getTruckRating() > (truckFleet[i].getTruckRating())) {
					prior = truckFleet[i];
				}
				if (highest.getTruckRating() < truckFleet[i].getTruckRating()) {
					highest = truckFleet[i];
				}

			}
		}
		System.out.println("The highest rated truck is: " + highest);

	}
}