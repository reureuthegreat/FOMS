package com.BranchPackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import com.FoodItem.FoodItem;
import com.Menu.IManagerMenu;
import com.Menu.Menu;
import com.Menu.MenuOperator;
import com.Order.Order;

/**
 * The BranchSystem class represents the system of a branch, including menu management and order processing.
 */
public class BranchSystem{

	protected Menu menu;
	protected ArrayList<Order> new_order_list;
	protected ArrayList<Order> ready_to_pickup_order_list;
	protected ArrayList<Order> cancelled_order_list;
	protected ArrayList<Order> completed_order_list;

	/**
	 * Constructs a new BranchSystem with default menu and order lists.
	 */
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
	/**
	 * Retrieves the customer menu from the branch system.
	 *
	 * @return The customer menu as an ArrayList of FoodItem objects.
	 */
	public ArrayList<FoodItem> Get_Customer_Menu() {
		return menu.getCustomerMenu();
	}

	//For Manager Only
	/**
	 * Manages the branch's menu by allowing a manager to add, remove, update food items,
	 * and display the current menu.
	 */
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

	/**
	 * Adds an order to the list of new orders.
	 *
	 * @param order The order to be added.
	 */
	public void addOrder(Order order) {
		new_order_list.add(order);
	}

	/**
	 * Collects an order based on its ID, moving it from the ready to pick up list to the completed order list.
	 * Prints a message indicating the success or failure of the collection process.
	 *
	 * @param orderId The ID of the order to be collected.
	 */
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

	/**
	 * Displays the new orders by iterating through the new order list and calling DisplayOrder on each order.
	 */
	public void View_New_Order() {
		System.out.println("New Orders:");
		for (Order order : new_order_list) {
			order.DisplayOrder();
		}
	}

	/**
	 * Processes new orders by displaying them, prompting the user to select an order for processing,
	 * and changing the order status to "Ready to Pick up" upon successful processing.
	 * Prints messages to inform the user about the process and handles input validation.
	 */
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

	/**
	 * Checks for uncollected orders beyond their collection deadline in the ready to pick up order list.
	 * If an order is beyond the deadline, it is removed from the ready to pick up list and added to the
	 * cancelled order list. Prints a message for each cancelled order.
	 */
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

	/**
	 * Retrieves the current menu associated with this branch system.
	 *
	 * @return The current menu.
	 */
	public Menu getMenu() {
		return menu;
	}

	/**
	 * Sets the menu for this branch system.
	 *
	 * @param menu The menu to be set.
	 */
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
}