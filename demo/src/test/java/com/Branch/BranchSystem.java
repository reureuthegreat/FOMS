package com.Branch;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.FoodItem.FoodItem;
import com.Menu.ICustomerMenu;
import com.Menu.IManagerMenu;
import com.Menu.Menu;
import com.Menu.MenuOperator;
import com.Order.Order;

public class BranchSystem{
	protected Menu menu;
	protected ArrayList<Order> new_order_list; 
	protected ArrayList<Order> ready_to_pickup_order_list; 
	protected ArrayList<Order> cancelled_order_list; 
	protected ArrayList<Order> completed_order_list; 
	
		
	public BranchSystem() {
		this.menu = new Menu();
		this.new_order_list = new ArrayList<Order>();
		this.ready_to_pickup_order_list = new ArrayList<Order>();
		this.cancelled_order_list = new ArrayList<Order>();
		this.completed_order_list = new ArrayList<Order>();
				
	}
	
	/*
	 *  Menu Related 
	 */
	
	//For Customer Only
	public ArrayList<FoodItem> Get_Customer_Menu() {
		return menu.getCustomerMenu();
	}
	
	//For Manager Only
	public void Branch_Menu_Management() {
		IManagerMenu menu_operator = new MenuOperator();
		int choice;
        Scanner scanner = new Scanner(System.in);
        do{
        	System.out.println("");
        	System.out.println("");
        	System.out.println("");
        	System.out.println("");
        	
        	System.out.println("+-----------------------------------+");
        	System.out.println("| Updating Menu.....                |");
        	System.out.println("+-----------------------------------+");
        	System.out.println("| 1. Add FoodItem                   |");
        	System.out.println("| 2. Remove FoodItem                |");
        	System.out.println("| 3. Update FoodItem                |");
        	System.out.println("| 4. Display Current Menu           |");
        	System.out.println("| Enter other numbers to quit.      |");
        	System.out.println("+-----------------------------------+");

        	
        	System.out.println("Enter Choice:");
        	choice = scanner.nextInt();
        	switch (choice) {
        		
				case 1: {
					menu_operator.Add_FoodItems(menu);
					break;
				}
				case 2: {
					menu_operator.Remove_FoodItems(menu);
					break;
				}
				case 3: {
					menu_operator.Update_FoodItems(menu);
					break;
				}
				case 4: {
					menu_operator.Display_Manager_Menu(menu);
					break;
				}
			}
    
        	System.out.println("");
        	System.out.println("");
        	System.out.println("");
        	System.out.println("");
        	
        }while(choice <=4 && choice >=1);
	}

	
	/*
	 *  Order Related
	 */
	
	//customer perspective
	
	public void addOrder(Order order) {
		new_order_list.add(order);
	}
	
	
 
    public void collectOrder(int orderId) {
        for (Order order : ready_to_pickup_order_list) {
            if (order.get_order_id() == orderId) {
                ready_to_pickup_order_list.remove(order);
                completed_order_list.add(order); 
                System.out.println("Order #" + orderId + " collected successfully.");
                return;
            }
        }
        System.out.println("Order #" + orderId + " is not ready for collection.");
    }
    
    
    //staff's perspective
    
    public void View_New_Order() {
        System.out.println("New Orders:");
        for (Order order : new_order_list) {
            order.DisplayOrder();
        }
    }
	
	public void Process_Order() {
        View_New_Order(); // Display new orders before processing

        // Process new orders
        Scanner scanner = new Scanner(System.in);
        int orderNumber;
        boolean validInput;
        do {
            System.out.print("Enter the order number to process (0 to cancel): ");
            orderNumber = scanner.nextInt();

            if (orderNumber == 0) {
                System.out.println("Order processing cancelled.");
                return;
            }

            validInput = false;
            for (Order order : new_order_list) {
                if (order.get_order_id() == orderNumber) {
                    // Change order status to "Ready to Pick up"
                    ready_to_pickup_order_list.add(order);
                    new_order_list.remove(order);
                    validInput = true;
                    System.out.println("Order processed successfully.");
                    break;
                }
            }

            if (!validInput) {
                System.out.println("Invalid order number or order already processed. Please try again.");
            }
        } while (!validInput);
    }


	public void checkUncollectedOrders() {
	    Iterator<Order> iterator = ready_to_pickup_order_list.iterator();
	    while (iterator.hasNext()) {
	        Order order = iterator.next();
	        if (order.beyond_collection_deadline()) {
	            iterator.remove(); // Remove from ready_to_pickup_order_list
	            cancelled_order_list.add(order); // Add to cancelled_order_list
	            System.out.println("Order ID " + order.get_order_id() + " has been cancelled due to non-collection.");
	        }
	    }
	}

   
    
}
