package com.Menu;

import java.util.ArrayList;

import com.FoodItem.FoodItem;

/**
 * Represents an interface for displaying a customer menu.
 */
public interface ICustomerMenu {

    /**
     * Displays the customer menu using the provided list of FoodItems.
     *
     * @param customer_menu The ArrayList of FoodItems representing the customer menu.
     */
    void Display_Customer_Menu(ArrayList<FoodItem> customer_menu);
}
