package Branch;

import java.util.ArrayList;
import java.util.Scanner;

import FoodItem.FoodItem;
import Menu.ICustomerMenu;
import Menu.IManagerMenu;
import Menu.Menu;
import Menu.MenuOperator;
import Order.Order;

public class BranchSystem implements ICustomerBranchApp,IStaffBranchApp,IManagerBranchApp{
	protected Menu menu;
	protected ArrayList<Order> order_list; 
	
		
	public BranchSystem() {
		this.menu = new Menu();
		this.order_list = new ArrayList<Order>();
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
	
	public void addOrder(Order order) {
		order_list.add(order);
	}
	
	public void Display_Order() {
		for (Order order : order_list) {
			order.DisplayOrder();
		}
		
	}

	
	public void Process_Order() {	
		View_New_Order(); // Display new orders before processing

	    // Ask the user which order to process
	    Scanner scanner = new Scanner(System.in);
	    int orderNumber;
	    boolean validInput = false;
	    
	    do {
	        System.out.print("Enter the order number to process (0 to cancel): ");
	        orderNumber = scanner.nextInt();

	        // Check if the input is 0 (to cancel)
	        if (orderNumber == 0) {
	            System.out.println("Order processing cancelled.");
	            return;
	        }

	        // Find the order with the specified order number
	        for (Order order : order_list) {
	            if (order.get_order_id() == orderNumber && order.IsNewOrder()) {
	                // Process the new order
	                order.ProcessNewOrder();
	                return; // Exit the loop after processing the order
	            }
	        }

	        // If the order with the specified number is not found
	        System.out.println("Invalid order number or order already processed. Please try again.");
	    } while (!validInput);
		
	}


	public void View_New_Order() {
		for (Order order : order_list) {
			if (order.IsNewOrder())
				order.DisplayOrder();
		}
		
	}

}
