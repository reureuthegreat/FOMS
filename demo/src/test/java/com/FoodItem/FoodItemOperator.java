package com.FoodItem;

import java.util.Scanner;

import com.Category.Category;
import com.Category.CategoryReader;
import com.Category.ICategoryReader;

/**
 * Provides operations to create and modify FoodItems.
 */
public class FoodItemOperator implements IFoodItemOperator{

	/**
	 * Creates a new FoodItem based on user input.
	 *
	 * @return The newly created FoodItem object, or null if creation fails.
	 */
	public static FoodItem createFoodItem() {
		Scanner scanner = new Scanner(System.in);

		try{
			System.out.println("Enter new FoodItem name:");
			String name = scanner.next();

			System.out.println("Enter the new FoodItem category (Burger, Drink, SideDish, SetMeal):");
			ICategoryReader categoryReader = new CategoryReader();
			Category category = categoryReader.readinCategory();

			System.out.println("Enter new FoodItem price:");
			double price = scanner.nextDouble();

			System.out.println("Enter new FoodItem description:");
			String description = scanner.next();

			boolean availability = false;
			System.out.println("Enter Availability:");
			System.out.println("1: Available");
			System.out.println("0: Not Available");

			int avail = scanner.nextInt();
			if (avail == 1) {
				availability = true;
			} else if (avail != 0) {
				throw new IllegalArgumentException("Invalid input for availability. Please enter 1 for Available or 0 for Not Available.");
			}
			scanner.nextLine();
			System.out.println("Enter the Branch this FoodItem is for:");
			String Loc = scanner.nextLine();

			return new FoodItem(name,price,description,category,availability,Loc);

		}catch (Exception e) {
			System.out.println("Error creating FoodItem: " + e.getMessage());
			return null; // Return null to indicate that FoodItem creation failed
		}
	}

	/**
	 * Modifies the price of a FoodItem.
	 *
	 * @param foodItem The FoodItem whose price will be modified.
	 */
	@Override
	public void modifyPrice(FoodItem foodItem) {

		Scanner scanner = new Scanner(System.in);
		try{
			System.out.println("Current Price: " + foodItem.getPrice());
			System.out.println("Enter new Price: ");
			double newPrice = scanner.nextDouble();
			foodItem.setPrice(newPrice);
		}catch(Exception e){
			System.out.println("Error in modifying price " + e.getMessage());
		}
	}

	/**
	 * Modifies the description of a FoodItem.
	 *
	 * @param foodItem The FoodItem whose description will be modified.
	 */
	@Override
	public void modifyDescription(FoodItem foodItem) {

		try{
			Scanner scanner = new Scanner(System.in);
			System.out.println("Current Description: " + foodItem.getDescription());
			System.out.println("Enter new Description: ");
			String newDescription = scanner.next();
			foodItem.setDescription(newDescription);
		}catch(Exception e){
			System.out.println("Error in modifying description " + e.getMessage());
		}
	}

	/**
	 * Modifies the category of a FoodItem.
	 *
	 * @param foodItem The FoodItem whose category will be modified.
	 */

	@Override
	public void modifyCategory(FoodItem foodItem) {

		try{
			System.out.println("Current Category: " + foodItem.getCategory());
			ICategoryReader categoryReader = new CategoryReader();
			Category newCategory = categoryReader.readinCategory();
			foodItem.setCategory(newCategory);
			System.out.println("Updated Category: " + foodItem.getCategory());
		}catch(Exception e){
			System.out.println("Error in modifying category " + e.getMessage());
		}
	}

	/**
	 * Modifies the availability status of a FoodItem.
	 *
	 * @param foodItem The FoodItem whose availability status will be modified.
	 */
	@Override
	public void modifyAvailability(FoodItem foodItem) {

		try{
			boolean availability = foodItem.getAvailability();
			availability = !availability;
			System.out.println("Now, the item is: " + (availability ? "Available" : "Not Available"));
			foodItem.setAvailability(availability);
		}catch(Exception e){
			System.out.println("Error in modifying category " + e.getMessage());
		}
	}



}