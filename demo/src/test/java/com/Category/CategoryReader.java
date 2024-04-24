package com.Category;
import java.util.Scanner;

public class CategoryReader implements ICategoryReader {
    @Override
    public Category readinCategory() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim().toUpperCase();

        if (isValidCategory(input)) {
            return Category.valueOf(input);
        } else {
            System.out.println("Invalid category. Please enter one of: Burger, Drink, SideDish, SetMeal");
            return readinCategory(); // Recursive call if input is invalid
        }
    }

    private boolean isValidCategory(String input) {
        for (Category category : Category.values()) {
            if (category.name().equalsIgnoreCase(input)) {
                return true;
            }
        }
        return false;
    }
}