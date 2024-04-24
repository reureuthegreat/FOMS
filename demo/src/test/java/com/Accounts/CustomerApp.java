package com.Accounts;

import com.Branch.Branch;
import com.Branch.BranchSystem;
import com.FoodItem.FoodItem;
import com.Menu.ICustomerMenu;
import com.Menu.MenuOperator;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerApp {
    public CustomerApp(){}
    Scanner sc = new Scanner(System.in);

    public void customerapp(BranchManagement branchManagement){
            System.out.println("Please enter number of your Branch name: ");
            String name = sc.nextLine();
            Branch branch = branchManagement.getBranchByName(name);
            do {
                if (branch == null) {
                    System.out.println("Branch does not exist!");
                    name = sc.nextLine();
                }
            }while(branch==null);
            BranchSystem BS = branch.getBranchSystem();
            ArrayList<FoodItem> customer_menu = BS.Get_Customer_Menu();
            ICustomerMenu menu_operator = new MenuOperator();
            menu_operator.Display_Customer_Menu(customer_menu);
    }
}
