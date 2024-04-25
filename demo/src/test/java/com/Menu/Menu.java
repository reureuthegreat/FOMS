package com.Menu;

import java.util.ArrayList;
import java.util.Scanner;

import com.FoodItem.FoodItem;
import com.FoodItem.FoodItemOperator;
import com.FoodItem.IFoodItemOperator;

/**
 * Represents a menu containing FoodItems.
 */
public class Menu{

    protected ArrayList<FoodItem> menu;
    protected ArrayList<FoodItem> customer_menu;

    /**
     * Constructs a new Menu object with empty menu and customer_menu lists.
     */
    public Menu() {
        this.menu = new ArrayList<FoodItem>();
        this.customer_menu = new ArrayList<FoodItem>();
    }

    /**
     * Adds a FoodItem to the menu.
     *
     * @param FoodItem The FoodItem to be added to the menu.
     */
    protected void addItem(FoodItem FoodItem) {
        menu.add(FoodItem);
        Refresh_CustomerMenu();
    }

    /**
     * Removes a FoodItem from the menu.
     *
     * @param foodItem The FoodItem to be removed from the menu.
     */
    protected void removeItem(FoodItem foodItem) {
        menu.remove(foodItem);
        Refresh_CustomerMenu();
    }

    /**
     * Updates a FoodItem in the menu by allowing the user to modify its price, description, category, or availability.
     *
     * @param foodItem The FoodItem to be updated.
     */
    protected void updateItem(FoodItem foodItem) {

        IFoodItemOperator foodItemOperator = new FoodItemOperator();

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
                    foodItemOperator.modifyPrice(foodItem);
                    foodItem.display();
                    break;
                }
                case 2: {
                    foodItemOperator.modifyDescription(foodItem);
                    foodItem.display();
                    break;
                }
                case 3: {
                    foodItemOperator.modifyCategory(foodItem);
                    foodItem.display();
                    break;
                }
                case 4:{
                    foodItemOperator.modifyAvailability(foodItem);
                    foodItem.display();
                    break;
                }
            }
        }while(choice <=4 && choice >=1);

        Refresh_CustomerMenu();
    }


    /**
     * Retrieves the menu containing FoodItems.
     *
     * @return The ArrayList of FoodItems representing the menu.
     */
    public ArrayList<FoodItem> getMenu() {
        return menu;
    }

    /**
     * Retrieves the customer menu containing available FoodItems.
     *
     * @return The ArrayList of FoodItems representing the customer menu.
     */
    public ArrayList<FoodItem> getCustomerMenu() {
        return customer_menu;
    }

    /**
     * Refreshes the customer menu by updating it with available FoodItems from the main menu.
     * Only FoodItems with availability set to true are included in the customer menu.
     */
    public void Refresh_CustomerMenu(){
        ArrayList<FoodItem> availableItems = new ArrayList<FoodItem>();
        for (FoodItem item : this.menu) {
            if (item.getAvailability()) {
                availableItems.add(item);
            }
        }
        this.customer_menu = availableItems;
    }

    /**
     * Sets the main menu of FoodItems.
     *
     * @param menu The ArrayList of FoodItems representing the main menu to be set.
     */
    public void setMenu(ArrayList<FoodItem> menu) {
        this.menu = menu;
    }

    /**
     * Sets the customer menu of FoodItems.
     *
     * @param customer_menu The ArrayList of FoodItems representing the customer menu to be set.
     */
    public void setCustomer_menu(ArrayList<FoodItem> customer_menu) {
        this.customer_menu = customer_menu;
    }
}
