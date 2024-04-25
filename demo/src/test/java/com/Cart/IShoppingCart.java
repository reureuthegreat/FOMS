package com.Cart;



import java.util.ArrayList;
import java.util.HashMap;

import com.FoodItem.FoodItem;


/**
 * Interface representing a shopping cart.
 */
public interface IShoppingCart {

	/**
	 * Creates a shopping cart based on a customer's menu of FoodItems.
	 *
	 * @param customerMenu An ArrayList of FoodItem objects representing the customer's menu.
	 * @return A HashMap representing the shopping cart with FoodItems and their quantities.
	 */
	HashMap<FoodItem, Integer> shopping(ArrayList<FoodItem> customerMenu);
}
