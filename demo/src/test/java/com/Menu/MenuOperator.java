package com.Menu;

import java.util.ArrayList;
import java.util.Scanner;

import com.FoodItem.FoodItem;
import com.FoodItem.FoodItemOperator;

/**
 * MenuOperator class.
 * Implements both customer and manager menu operations.
 */
public class MenuOperator implements ICustomerMenu,IManagerMenu{

	/**
	 * Displays the menu for managers.
	 *
	 * @param menu The Menu object representing the manager's menu.
	 */
	@Override
	public void Display_Manager_Menu(Menu menu) {
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");

		ArrayList<FoodItem> menu_items = menu.getMenu();
		System.out.println("+------------------------------------------+");
		System.out.println("|             A Deep Dried Menu            |");
		System.out.printf("| Total Items: %-27s |\n", menu_items.size());
		System.out.println("+------------------------------------------+");
		for (int i = 1;i<=menu_items.size();i++) {
			System.out.println("+------------------------------------------+");
			System.out.printf("|Item #%-35s |\n",i);
			menu_items.get(i-1).display();
			System.out.println();
		}
	}

	/**
	 * Displays the menu for customers.
	 *
	 * @param customer_menu The ArrayList of FoodItems representing the customer menu.
	 */
	@Override
	public void Display_Customer_Menu(ArrayList<FoodItem> customer_menu) {
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");

		System.out.println("+------------------------------------------+");
		System.out.println("|             A Deep Dried Menu            |");
		System.out.println("+------------------------------------------+");
		for (int i = 1;i<=customer_menu.size();i++) {
			System.out.println("+------------------------------------------+");
			System.out.printf("|Item #%-35s |\n",i);
			customer_menu.get(i-1).display();
		}

	}

	//check for duplicated/existing names in the menu
	/**
	 * Checks for duplicated or existing names in the menu.
	 *
	 * @param name The name to be checked for duplicates.
	 * @param menu The ArrayList of FoodItem objects representing the menu.
	 * @return true if the name does not exist in the menu, false otherwise.
	 */
	private boolean check_duplicates(String name,ArrayList<FoodItem> menu) {
		for (FoodItem foodItem:menu) {
			if (foodItem.getName().equals(name))
				return false;
		}
		return true;
	}

	/**
	 * Adds a new FoodItem to the menu if its name does not already exist.
	 *
	 * @param menu The Menu object to which the FoodItem will be added.
	 */
	@Override
	public void Add_FoodItems(Menu menu) {
		FoodItem foodItem = FoodItemOperator.createFoodItem();
		//check if name already exists
		if (check_duplicates(foodItem.getName(),menu.getMenu())) {
			menu.addItem(foodItem);
		}
		else {
			System.out.println("Error! Name already exists!");
		}
	}

	/**
	 * Removes a FoodItem from the menu based on user input of the item's index.
	 *
	 * @param menu The Menu object from which the FoodItem will be removed.
	 */
	@Override
	public void Remove_FoodItems(Menu menu) {

		Scanner scanner = new Scanner(System.in);
		int index;

		ArrayList<FoodItem> menu_items = menu.getMenu();

		if (menu_items.size() == 0) {
			System.out.println("No items to remove. Menu is empty.");
			return;
		}

		Display_Manager_Menu(menu);

		do {
			System.out.println("Enter the Index of removing item:" + "1 ~ " + menu_items.size());
			index = scanner.nextInt();
			if (index < 1 || index > menu_items.size()) {
				System.out.println("Index must be between 1 and "+menu_items.size() + ". Try again.");
			}
		} while (index < 1 || index > menu_items.size());

		FoodItem foodItem = menu_items.get(index - 1);
		menu.removeItem(foodItem);

	}

	/**
	 * Updates a FoodItem in the menu based on user input of the item's ordering number.
	 *
	 * @param menu The Menu object containing the FoodItem to be updated.
	 */
	@Override
	public void Update_FoodItems(Menu menu) {
		Scanner scanner = new Scanner(System.in);
		int index;

		ArrayList<FoodItem> menu_items = menu.getMenu();

		if (menu_items.size() == 0) {
			System.out.println("No items to update. Menu is empty.");
			return;
		}

		Display_Manager_Menu(menu);
		System.out.println("");
		System.out.println("");

		do {
			System.out.println("Enter the ordering number of the item to update:" + "1 ~ " + menu_items.size());
			index = scanner.nextInt();
			if (index < 1 || index > menu_items.size()) {
				System.out.println("Ordering number must be between 1 and "+menu_items.size() + ". Try again.");
			}
		} while (index < 1 || index > menu_items.size());

		FoodItem foodItem = menu_items.get(index - 1);
		menu.updateItem(foodItem);
	}


}