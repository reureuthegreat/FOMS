package com.BranchPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.Order.Order;

/**
 * The Order_Collection_Site class manages the display of orders and the collection process
 * at a branch's order collection site.
 */
public class Order_Collection_Site {
	 // Function to get order ID from the list
    /**
     * Retrieves the order ID from the specified list at the given index.
     *
     * @param orderList The list of orders to retrieve the ID from.
     * @param index     The index of the order to retrieve.
     * @return The order ID if the index is valid, an empty string otherwise.
     */
    public static String getOrderId(List<Order> orderList, int index) {
        if (index < orderList.size()) {
            return " #" + orderList.get(index).get_order_id();
        } else {
            return "";
        }
    }

    // Function to pad the string to a specified length
    /**
     * Pads the given string to the specified length.
     *
     * @param str    The string to pad.
     * @param length The desired length of the padded string.
     * @return The padded string.
     */
    public static String padTo(String str, int length) {
        return String.format("%-" + length + "s", str);
    }

    /**
     * Displays the orders in different categories: preparing, ready to pick up, completed, and cancelled.
     * Orders are displayed in four vertical columns with boxes around them.
     *
     * @param branchSystem The branch system containing the orders to display.
     */
    public void Display_Orders(BranchSystem branchSystem) {
    	
    	branchSystem.checkUncollectedOrders();
    	
    	ArrayList<Order> new_orders = branchSystem.new_order_list;
    	ArrayList<Order> ready_to_pickup_orders = branchSystem.ready_to_pickup_order_list;
    	ArrayList<Order> completed_orders = branchSystem.completed_order_list;
    	ArrayList<Order> cancelled_orders = branchSystem.cancelled_order_list;
    	
        // Assuming new_order_list, ready_to_pickup_order_list, completed_order_list, cancelled_order_list are defined elsewhere

    	int maxOrders = Math.max(Math.max(new_orders.size(), ready_to_pickup_orders.size()), Math.max(completed_orders.size(), cancelled_orders.size()));

        // Display orders in four vertical columns with boxes around them
        System.out.println("+----------------------+----------------------+----------------------+----------------------+");
        System.out.println("|      Preparing       |  Ready to Pick up    |      Completed       |       Cancelled      |");
        System.out.println("+----------------------+----------------------+----------------------+----------------------+");

        for (int i = 0; i < maxOrders; i++) {
            System.out.print("|");
           
            // Preparing
            System.out.print(padTo(getOrderId(new_orders, i), 22) + "|");
            // Ready to Pick up
            System.out.print(padTo(getOrderId(ready_to_pickup_orders, i), 22) + "|");
            // Completed
            System.out.print(padTo(getOrderId(completed_orders, i), 22) + "|");
            // Cancelled
            System.out.print(padTo(getOrderId(cancelled_orders, i), 22) + "|");
            System.out.println();
        }

        System.out.println("+----------------------+----------------------+----------------------+----------------------+");
    }

    /**
     * Collects an order for pickup based on the user's input of the order ID.
     *
     * @param branchSystem The branch system containing the orders.
     */
    public void collect_order(BranchSystem branchSystem) {
    	System.out.println("Order # for Collection? ");
    	Scanner scanner = new Scanner(System.in);
    	int orderid = scanner.nextInt();
    	branchSystem.collectOrder(orderid);
    }
    
    
}
