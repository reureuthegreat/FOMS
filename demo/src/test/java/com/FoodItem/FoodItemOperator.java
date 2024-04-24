package com.FoodItem;

import java.util.Scanner;

import com.Category.Category;
import com.Category.CategoryReader;
import com.Category.ICategoryReader;

public class FoodItemOperator implements IFoodItemOperator{
	
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
		
		return new FoodItem(name,price,description,category,availability);
		}catch (Exception e) {
			System.out.println("Error creating FoodItem: " + e.getMessage());
			return null; // Return null to indicate that FoodItem creation failed
		} finally {
		}
	}
	
	public void modifyPrice(FoodItem foodItem) {
        Scanner scanner = new Scanner(System.in);
		try{
        System.out.println("Current Price: " + foodItem.getPrice());
        System.out.println("Enter new Price: ");
        double newPrice = scanner.nextDouble();
        foodItem.setPrice(newPrice);
		}catch(Exception e){
			System.out.println("Error in modifying price " + e.getMessage());
		}finally{
		}
    }

    public void modifyDescription(FoodItem foodItem) {
		try{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Current Description: " + foodItem.getDescription());
        System.out.println("Enter new Description: ");
        String newDescription = scanner.next();
        foodItem.setDescription(newDescription);
		}catch(Exception e){
			System.out.println("Error in modifying description " + e.getMessage());
		}finally{
		}
    }

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
    

    
    public void updateInfo(FoodItem foodItem) {
		int choice;
        Scanner scanner = new Scanner(System.in);
        
        do{
        	System.out.println("+-----------------------------------+");
        	System.out.println("| Updating MenuItems.....           |");
        	System.out.println("+-----------------------------------+");
        	System.out.println("| 1. Update Price                   |");
        	System.out.println("| 2. Update Description             |");
        	System.out.println("| 3. Update Category                |");
        	System.out.println("| 4. Update Availability            |");
        	System.out.println("| Enter other numbers to quit.      |");
        	System.out.println("+-----------------------------------+");
        	System.out.println("");
        	System.out.println("Enter Choice:");
        	choice = scanner.nextInt();
        	System.out.println("");
        	switch (choice) {
				case 1: {
					modifyPrice(foodItem);
					foodItem.display();
					break;
				}
				case 2: {
					modifyDescription(foodItem);
					foodItem.display();
					break;
				}
				case 3: {
					modifyCategory(foodItem);
					foodItem.display();
					break;
				}
				case 4:{
					modifyAvailability(foodItem);
					foodItem.display();
					break;
				}
        	}
        }while(choice <=4 && choice >=1);
	}

	
}
