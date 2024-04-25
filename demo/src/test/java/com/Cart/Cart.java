package com.Cart;

import java.util.HashMap;
import java.util.Map;


import com.FoodItem.FoodItem;

/**
 * Represents a shopping cart that stores FoodItem objects along with their quantities.
 */
public class Cart {
    /**
     * Map to store FoodItems along with their quantities in the cart.
     */
    protected HashMap<FoodItem, Integer> items;

    /**
     * Initializes a new instance of the Cart class.
     * Constructs a new Cart object with an empty item list.
     */
    public Cart() {
        this.items = new HashMap<>();
    }

    /**
     * Adds a specified quantity of a FoodItem to the cart.
     * If the FoodItem already exists in the cart, the quantity is updated by adding the specified quantity to the existing quantity.
     * If the FoodItem does not exist in the cart, it is added with the specified quantity.
     *
     * @param item     The FoodItem to add to the cart.
     * @param quantity The quantity of the FoodItem to add.
     */
    public void addItem(FoodItem item, int quantity) {
    	
        if (items.containsKey(item)) {
            // Item already exists, add the quantity to the existing quantity
            int currentQuantity = items.get(item);
            items.put(item, currentQuantity + quantity);
            return;
        }
        
        items.put(item, quantity);
    }

    /**
     * Removes a specified FoodItem from the cart.
     *
     * @param item The FoodItem to remove from the cart.
     */
    public void removeItem(FoodItem item) {
        items.remove(item);
    }

    /**
     * Updates the quantity of a specified FoodItem in the cart.
     * If the FoodItem exists in the cart, its quantity is updated to the specified quantity.
     *
     * @param item     The FoodItem whose quantity needs to be updated.
     * @param quantity The new quantity for the FoodItem.
     */
    public void updateQuantity(FoodItem item, int quantity) {
        if (items.containsKey(item)) {
            items.put(item, quantity);
        }
    }

    // Display the items in the cart
    /**
     * Displays the items in the cart along with their quantities and subtotals.
     * If the cart is empty, it prints a message indicating that the cart is empty.
     */
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
