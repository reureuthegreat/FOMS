package com.Menu;

import java.util.ArrayList;

import com.FoodItem.FoodItem;
import com.FoodItem.FoodItemOperator;

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
        FoodItemOperator manager = new FoodItemOperator();
        manager.updateInfo(foodItem);
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

