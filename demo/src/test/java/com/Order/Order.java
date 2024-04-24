package com.Order;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.HashMap;

import com.FoodItem.FoodItem;


public class Order {
	private static int lastOrderId = 0;
    protected int order_id;
    protected LocalDate order_date;
    protected LocalTime order_time;
    protected LocalTime collection_deadline;
    protected HashMap<FoodItem, Integer> items;
    protected Boolean option;

    /*
     * DINE_IN = True 
     * TAKEAWAY = False
     */

    // Constructor
    public Order(HashMap<FoodItem, Integer> items, Boolean option) {
    	lastOrderId++;  // Increment lastOrderId
        this.order_id = lastOrderId;
        this.order_date = LocalDate.now(); // Set order_date to the current date
        this.order_time = LocalTime.now(); // Set order_time to the current time
        this.collection_deadline = LocalTime.now().plusHours(1); // Set collection_deadline to order creation time + 1 hour
        this.items = items; // Set items
        this.option = option; // Set option
    }
    
    public int get_order_id() {
    	return order_id;
    }
    
    public boolean beyond_collection_deadline() {
    	return LocalTime.now().isAfter(collection_deadline);
    }
    
    public void DisplayOrder() {
    	
    	
        double totalPrice = 0.0; // Initialize total price
        
        System.out.println("+-------------------------------------------+");
        System.out.printf("| %s%-32s |\n", "Order NO.", order_id);
        
        // Combine order_date and order_time into LocalDateTime
        LocalDateTime orderDateTime = LocalDateTime.of(order_date, order_time);
        
        // Format the date and time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = orderDateTime.format(formatter);
        System.out.printf("| %s  %-34s |\n", "Time:", formattedDateTime);
        System.out.println("+-------------------------------------------+");
        System.out.println("| Item Name:               Quantity:        |");
        for (FoodItem item : items.keySet()) {
            String itemName = item.getName();
            int quantity = items.get(item); // Get quantity of the item
            
            totalPrice += item.getPrice() * quantity; // Add item price to total price
            System.out.printf("| - %-20s   %-16d |\n", itemName.substring(0, Math.min(itemName.length(), 20)), quantity);
        }
        System.out.println("|                                           |");
        System.out.printf("| %s  %-33s |\n", "Total:", "$" + totalPrice);
        System.out.println("+-------------------------------------------+");
    }

    
   
}
