package Cart;

import java.util.HashMap;
import java.util.Map;


import FoodItem.FoodItem;

public class Cart {
    protected HashMap<FoodItem, Integer> items;

    public Cart() {
        this.items = new HashMap<>();
    }

    
    public void addItem(FoodItem item, int quantity) {
    	
        if (items.containsKey(item)) {
            // Item already exists, add the quantity to the existing quantity
            int currentQuantity = items.get(item);
            items.put(item, currentQuantity + quantity);
            return;
        }
        
        items.put(item, quantity);
    }

    
    public void removeItem(FoodItem item) {
        items.remove(item);
    }

    
    public void updateQuantity(FoodItem item, int quantity) {
        if (items.containsKey(item)) {
            items.put(item, quantity);
        }
    }

    // Display the items in the cart
    public void displayCart() {
        if (items.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }
        System.out.println("+----------------------------------------------------------------+");
        System.out.printf("| %-30s | %-9s | %-17s |\n", "Food Name", "Quantity", "Subtotal");
        System.out.println("+----------------------------------------------------------------+");
        double totalCartPrice = 0;
        for (Map.Entry<FoodItem, Integer> entry : items.entrySet()) {
            FoodItem item = entry.getKey();
            int quantity = entry.getValue();
            double totalPrice = item.getPrice() * quantity;
            totalCartPrice += totalPrice;
            System.out.printf("| %-30s | %-9d | $%-16.2f |\n", item.getName(), quantity, totalPrice);
        }
        System.out.println("+----------------------------------------------------------------+");
        System.out.printf("| %-42s | $%-16.2f |\n", "Total: $", totalCartPrice);
        System.out.println("+----------------------------------------------------------------+");
    }

    

   
}
