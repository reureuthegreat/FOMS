import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import Branch.Branch;
import Branch.BranchManagement;
import Branch.BranchSystem;
import Branch.Self_Ordering_Kiosk;
import Cart.IShoppingCart;
import Cart.ShoppingCart;
import FoodItem.FoodItem;
import Menu.ICustomerMenu;

import Menu.MenuOperator;
import Order.Order;

public class CustomerOrderingSystem {
	
	
	public static void main(String[] args) {
		BranchManagement branchManagement = new BranchManagement();
		
		
		branchManagement.AddBranch();
		//branchManagement.AddBranch();
		
		Scanner scanner = new Scanner(System.in);
		
		Branch branch;
		
		int counter = 1;
		System.out.println("Which Burger Queen would you like to go to?");
		for (Branch br : branchManagement.getBranchList()) {
			System.out.println(counter + ":" + br.getBranchName());
			counter++;
		}
		
        do {
        	String name = scanner.nextLine();
            branch = branchManagement.getBranchByName(name);
            if (branch == null) {
                System.out.println("Branch does not exist!");
                name = scanner.nextLine();
            }
        }while(branch==null);
		
        
        /*
         *  Setting
         */

        //1. Connect to branchSystem
        BranchSystem branchSystem = branch.branchSystem;
        /*TEMP - TESTING ONLY*/ branchSystem.Branch_Menu_Management();
        
       
        while (true) {
        	System.out.println("");
        	System.out.println("");
        	System.out.println("");
        	System.out.println("");
        	
	        System.out.println("Welcome to Kentucky Fried Children @" + branch.getBranchName() + "!");
	        System.out.println("+--------------------------------------+");
	        System.out.println("| I'm NOT lovin it...                  |");
	        System.out.println("|                                      |");
	        System.out.println("| Go to:                               |");
	        System.out.println("|  1. Self-Ordering Kiosk              |");
	        System.out.println("|  2. Order Collection Site            |");
	        System.out.println("+--------------------------------------+");

       
	        System.out.print("Enter your choice (1 or 2): ");
	        int choice = scanner.nextInt();
	
	        // Process user's choice
	        switch (choice) {
	            case 1:
	                System.out.println("Going to Self-Ordering Kiosk...");
	                branch.kiosk_machine.ordering(branchSystem);
	                break;
	            case 2:
	                System.out.println("Going to Order Collection Site...");
	                branch.collection_Site.Display_Orders(branchSystem);
	                
	                System.out.println("Collect Order now?");
	                System.out.println("+-----------+");
	                System.out.println("|  1. Yes   |");
	                System.out.println("|  2. No    |");
	                System.out.println("+-----------+");
	                
	                choice = scanner.nextInt();
	                
	                if (choice == 1)
	                	branch.collection_Site.collect_order(branchSystem);
	                break;
	            default:
	                System.out.println("Fun fact: KFC tastes better than BURGER QUEEN...");
	                break;
	        }
	     }
		/*
		
		
		//Staff 
		branchSystem.Display_Order();
		branchSystem.Process_Order();
		branchSystem.View_New_Order();
		*/
	}
	
}
