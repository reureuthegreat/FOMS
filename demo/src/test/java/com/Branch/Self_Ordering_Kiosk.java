package com.Branch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import com.Cart.IShoppingCart;
import com.Cart.ShoppingCart;
import com.FoodItem.FoodItem;
import com.Menu.ICustomerMenu;
import com.Menu.MenuOperator;
import com.Order.Order;

public class Self_Ordering_Kiosk {
	private boolean get_dine_in_option() {
		Scanner sc = new Scanner(System.in);

		System.out.println("+----------------+       +---------------+");
		System.out.println("|  0: Takeaway   |       |  1: Dine-in   |");
		System.out.println("+----------------+       +---------------+");

		int option = sc.nextInt();

		if (option == 0) {
			System.out.println("You chose Takeaway...");
			sc.close();
			return false;

		} else if (option == 1) {
			System.out.println("You chose Dine-in...");
			sc.close();
			return true;

		} else {
			System.out.println("Invalid option. Assuming you Dine-in... LOL");
			sc.close();
			return true;
		}
	}

	public boolean ordering(BranchSystem branchSystem) {

		/*
		 *  Settings
		 */

		// 1. Get the Branch Menu & Set up the MenuOperator to display the menu
		ArrayList<FoodItem> customer_menu = branchSystem.Get_Customer_Menu();
		ICustomerMenu menu_operator = new MenuOperator();

		// 2. Set up the Shopping Cart
		IShoppingCart shopping_cart = new ShoppingCart();

		/*
		 *  Ordering
		 */

		// 1. Display Menu to Customer
		menu_operator.Display_Customer_Menu(customer_menu);

		// 2. Wait for the customer to view the menu:
		System.out.println("");
		System.out.println("");
		for (int i = 5; i >= 1; i--) {
			System.out.println("A ShoppingCart will be ready in " + i + " seconds");
			try {
				Thread.sleep(1000); // Sleep for 1 second (1000 milliseconds)
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("A ShoppingCart is ready!");

		// 3. Based on the Branch Menu, customer pick the items using a shopping cart
		//    & "items" stores the FoodItem that customer orders

		HashMap<FoodItem, Integer> items = shopping_cart.shopping(customer_menu);
		if (items == null) {
			return false;
		}

		// 4. Ask customer the dine in options
		System.out.println("Dine in or Takeaway?");
		Boolean dine_in = get_dine_in_option();

		// 5. Generate an Order based on the items and the dine in option selected
		Order temp_order = new Order(items, dine_in);

		// 6. PAYMENT HERE
		PaymentApp PA = new PaymentApp();
		PA.paymentapp(temp_order.calculatePrice());

		// 7. Print out the Receipt
		temp_order.DisplayOrder();

		// 8. Send the order to the branch system
		branchSystem.addOrder(temp_order);

		return true;
	}
}