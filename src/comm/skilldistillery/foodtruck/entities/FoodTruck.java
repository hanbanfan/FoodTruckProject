package comm.skilldistillery.foodtruck.entities;
public class FoodTruck {
private String truckName;
private String truckFoodType;
private int truckRating;
private static int nextTruckID = 0;
private int uniqueID;

public String getTruckName() {
	return truckName;
}
//User Story #1

public void setTruckName(String truckName) {
	this.truckName = truckName;
}

public String getTruckFoodType() {
	return truckFoodType;
}

public void setTruckFoodType(String truckFoodType) {
	this.truckFoodType = truckFoodType;
}

public int getTruckRating() {
	return truckRating;
}

public void setTruckRating(int truckRating) {
	this.truckRating = truckRating;
}

public static int getNextTruckID() {
	return nextTruckID;
}

public static void setNextTruckID(int nextTruckID) {
	FoodTruck.nextTruckID = nextTruckID;
}

public int getUniqueID() {
	return uniqueID;
}

public void setUniqueID(int uniqueID) {
	this.uniqueID = uniqueID;
}

public FoodTruck(String name, String foodType, int rating) {
	this.truckName = name;
	this.truckFoodType = foodType;
	this.truckRating = rating;
	FoodTruck.nextTruckID++;
	this.uniqueID = nextTruckID;
}


@Override
public String toString() {
	return "Food Truck Unique ID: " + uniqueID + "). Food Truck Name: " + truckName + " / Food Cuisine Type: " 
			+ truckFoodType + " / Food Truck Rating: " + truckRating + ".";
			

}

}