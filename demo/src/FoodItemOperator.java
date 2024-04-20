package FoodItem;

import java.util.Scanner;

import Category.Category;
import Category.CategoryReader;
import Category.ICategoryReader;

public class FoodItemOperator implements IFoodItemOperator{
	
	public static FoodItem createFoodItem() {
		Scanner scanner = new Scanner(System.in);

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
		if (avail == 1)
			availability = true;
		
		return new FoodItem(name,price,description,category,availability);
	}
	
	public void modifyPrice(FoodItem foodItem) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Current Price: " + foodItem.getPrice());
        System.out.println("Enter new Price: ");
        double newPrice = scanner.nextDouble();
        foodItem.setPrice(newPrice);
    }

    public void modifyDescription(FoodItem foodItem) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Current Description: " + foodItem.getDescription());
        System.out.println("Enter new Description: ");
        String newDescription = scanner.next();
        foodItem.setDescription(newDescription);
    }

    public void modifyCategory(FoodItem foodItem) {
        System.out.println("Current Category: " + foodItem.getCategory());
        ICategoryReader categoryReader = new CategoryReader();
        Category newCategory = categoryReader.readinCategory();
        foodItem.setCategory(newCategory);
        System.out.println("Updated Category: " + foodItem.getCategory());
    }
    
    public void modifyAvailability(FoodItem foodItem) {
		
		boolean availability = foodItem.getAvailability();
		availability = !availability;
		System.out.println("Now, the item is: " + (availability ? "Available" : "Not Available"));
		foodItem.setAvailability(availability);
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
