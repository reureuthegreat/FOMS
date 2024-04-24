package com.Cart;



import java.util.ArrayList;
import java.util.HashMap;

import com.FoodItem.FoodItem;



public interface ICartManager {
	
	HashMap<FoodItem, Integer> shopping(ArrayList<FoodItem> customerMenu);
}
