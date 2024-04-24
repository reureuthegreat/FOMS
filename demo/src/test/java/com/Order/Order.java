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
    protected DishStatus status;
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
        this.collection_deadline = LocalTime.now().plusHours(1); // Set collection_deadline to current time + 1 hour
        this.items = items; // Set items
        this.status = DishStatus.NEW; // Set status to NEW
        this.option = option; // Set option
    }
    
    public int get_order_id() {
    	return order_id;
    }
    
    private void Refresh_Dish_Status() {
    	System.out.println(LocalTime.now());
    	System.out.println(collection_deadline);
    	if (status == DishStatus.READY_TO_PICKUP && LocalTime.now().isAfter(collection_deadline)) {
    		status = DishStatus.CANCELLED;
        }
    }
    
 
    public void DisplayOrder() {
    	Refresh_Dish_Status();
    	
        double totalPrice = 0.0; // Initialize total price
        
        System.out.println("+-------------------------------------------+");
        System.out.printf("| %s%-32s |\n", "Order NO.", order_id);
        
        // Combine order_date and order_time into LocalDateTime
        LocalDateTime orderDateTime = LocalDateTime.of(order_date, order_time);
        
        // Format the date and time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = orderDateTime.format(formatter);
        System.out.printf("| %s  %-34s |\n", "Time:", formattedDateTime);
        System.out.printf("| %s  %-32s |\n", "Status:", status);
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

    
    

    
    //check if is a new order
    public boolean IsNewOrder() {
    	return status == DishStatus.NEW;
    }
    
    // Method to process a new order
    public void ProcessNewOrder() {
        status = DishStatus.READY_TO_PICKUP;
        
        System.out.println("Order Status Successfully Updated!");
        DisplayOrder();
        
    }

    // Method to check status
    public void checkStatus() {
    	 Refresh_Dish_Status();
         System.out.println("Status: " + status);
    }
}
