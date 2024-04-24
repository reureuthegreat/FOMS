package com;

import java.util.ArrayList;
import java.util.HashMap;

import com.Branch.BranchSystem;
import com.Cart.Cart;
import com.Cart.CartManager;
import com.Cart.ICartManager;
import com.FoodItem.FoodItem;
import com.Menu.ICustomerMenu;

import com.Menu.MenuOperator;
import com.Order.Order;

public class CustomerOrderingSystem {
	public CustomerOrderingSystem(){}
	public void customerorderingsystem(){
	
		BranchSystem branchSystem = new BranchSystem(); 
		branchSystem.Branch_Menu_Management();
			
		ArrayList<FoodItem> customer_menu = branchSystem.Get_Customer_Menu();
		ICustomerMenu menu_operator = new MenuOperator();
		menu_operator.Display_Customer_Menu(customer_menu);
		
		
		Cart cart = new Cart();
		ICartManager cartManager = new CartManager();
		
		HashMap<FoodItem, Integer> items = cartManager.shopping(customer_menu);
		if (items == null) {
			//return back to the menu???
		}
		
		
		//1. First ask user for dine in options? COMPLETE THIS---
		System.out.println("Dine in or Takeaway?");
		Boolean dine_in = true;
		//2. Payment successful or not? COMPLETE THIS--- 
		
		
		/*Assume:
		- dine in = true
		- payment is done/successful
		*/

		
		Order order1 = new Order(items, dine_in);
		Order order2 = new Order(items, dine_in);
		Order order3 = new Order(items, dine_in);
		
		branchSystem.addOrder(order1);
		branchSystem.addOrder(order2);
		branchSystem.addOrder(order3);
		
		branchSystem.Display_Order();
		branchSystem.Process_Order();
		branchSystem.View_New_Order();
		
	}
	
}
