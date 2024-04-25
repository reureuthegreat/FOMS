package com.Menu;

import java.util.ArrayList;
import java.util.Scanner;

import com.FoodItem.FoodItem;
import com.FoodItem.FoodItemOperator;
import com.FoodItem.IFoodItemOperator;

public class Menu{

    protected ArrayList<FoodItem> menu;
    protected ArrayList<FoodItem> customer_menu;

    public Menu() {
        this.menu = new ArrayList<FoodItem>();
        this.customer_menu = new ArrayList<FoodItem>();
    }

    protected void addItem(FoodItem FoodItem) {
        menu.add(FoodItem);
        Refresh_CustomerMenu();
    }

    protected void removeItem(FoodItem foodItem) {
        menu.remove(foodItem);
        Refresh_CustomerMenu();
    }

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

    public ArrayList<FoodItem> getMenu() {
        return menu;
    }


    public ArrayList<FoodItem> getCustomerMenu() {
        return customer_menu;
    }

    public void Refresh_CustomerMenu(){
        ArrayList<FoodItem> availableItems = new ArrayList<FoodItem>();
        for (FoodItem item : this.menu) {
            if (item.getAvailability()) {
                availableItems.add(item);
            }
        }
        this.customer_menu = availableItems;
    }

    public void setMenu(ArrayList<FoodItem> menu) {
        this.menu = menu;
    }

    public void setCustomer_menu(ArrayList<FoodItem> customer_menu) {
        this.customer_menu = customer_menu;
    }
}
