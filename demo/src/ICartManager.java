package Cart;



import java.util.ArrayList;
import java.util.HashMap;

import FoodItem.FoodItem;



public interface ICartManager {
	
	HashMap<FoodItem, Integer> shopping(ArrayList<FoodItem> customerMenu);
}
