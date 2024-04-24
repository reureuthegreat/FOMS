package com.Cart;



import java.util.ArrayList;
import java.util.HashMap;

import com.FoodItem.FoodItem;



public interface IShoppingCart {
	
	HashMap<FoodItem, Integer> shopping(ArrayList<FoodItem> customerMenu);
}
