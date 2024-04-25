package com.Branch;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.Order.Order;

public class Order_Collection_Site {
    /*
     * Utility Functions for Display_Orders
     */

	 // Function to get order ID from the list
    private String getOrderId(List<Order> orderList, int index) {
        if (index < orderList.size()) {
            return " #" + orderList.get(index).get_order_id();
        } else {
            return "";
        }
    }

    // Function to pad the string to a specified length
    private String padTo(String str, int length) {
        return String.format("%-" + length + "s", str);
    }
    


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
    

    
    public void collect_order(BranchSystem branchSystem) {
    	System.out.println("Order # for Collection? ");
    	Scanner scanner = new Scanner(System.in);
    	int orderid = scanner.nextInt();
    	branchSystem.collectOrder(orderid);
    }
    
    
}
