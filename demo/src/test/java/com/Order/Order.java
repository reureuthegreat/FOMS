package com.Order;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.HashMap;

import com.FoodItem.FoodItem;


/**
 * Represents an order made by a customer.
 */
public class Order {
    private static int lastOrderId = 0;
    protected int order_id;
    protected LocalDate order_date;
    protected LocalTime order_time;
    protected LocalTime collection_deadline;
    protected HashMap<FoodItem, Integer> items;
    protected Boolean option;

    /**
     * Constructs an Order object with the specified items and option.
     *
     * @param items   A HashMap containing FoodItem objects as keys and their corresponding quantities as values.
     * @param option  A Boolean value representing the order type (true for DINE_IN, false for TAKEAWAY).
     *
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

    /**
     * Retrieves the order ID.
     *
     * @return The order ID.
     */
    public int get_order_id() {
        return order_id;
    }

    /**
     * Checks if the current time is beyond the collection deadline for the order.
     *
     * @return true if the current time is after the collection deadline, false otherwise.
     */
    public boolean beyond_collection_deadline() {
        return LocalTime.now().isAfter(collection_deadline);
    }

    /**
     * Displays the order details including order ID, date and time, items, quantities, and total price.
     */
    public void DisplayOrder() {

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

            System.out.printf("| - %-20s   %-16d |\n", itemName.substring(0, Math.min(itemName.length(), 20)), quantity);
        }
        System.out.println("|                                           |");
        System.out.printf("| %s  %-33s |\n", "Total:", "$" + calculatePrice());
        System.out.println("+-------------------------------------------+");
    }

    /**
     * Calculates the total price of the order based on the item prices and quantities.
     *
     * @return The total price of the order.
     */

    public double calculatePrice(){
        double totalPrice = 0;
        for (FoodItem item : items.keySet()) {
            int quantity = items.get(item); // Get quantity of the item

            totalPrice += item.getPrice() * quantity; // Add item price to total price
        }
        return totalPrice;
    }
}