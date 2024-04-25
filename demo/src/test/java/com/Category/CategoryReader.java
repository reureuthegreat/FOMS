package com.Category;
import java.util.Scanner;

/**
 * Reads and validates input for a category from the user.
 */
public class CategoryReader implements ICategoryReader {

    /**
     * Reads a category input from the user and validates it.
     *
     * @return A Category enum representing the valid category input.
     */
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

    /**
     * Checks if the input string is a valid category.
     *
     * @param input The input string to validate.
     * @return True if the input is a valid category, false otherwise.
     */
    private boolean isValidCategory(String input) {
        for (Category category : Category.values()) {
            if (category.name().equalsIgnoreCase(input)) {
                return true;
            }
        }
        return false;
    }
}