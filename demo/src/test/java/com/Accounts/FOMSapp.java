package com.Accounts;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.Branch.Branch;
import com.Branch.BranchSystem;
import com.FoodItem.FoodItem;
import com.Menu.Menu;

public class FOMSapp {
    public static void main(String[] args) throws IOException {
        Database DB = new Database();
        StaffAccManagement staffaccmanagement = new StaffAccManagement();
        BranchManagement branchManagement = new BranchManagement();
        try {
            ArrayList<Account> AL = DB.readAccounts("/Users/cheokerinos/IdeaProjects/FastFoodOrdering/src/main/java/com/Accounts/Staff.txt");
            staffaccmanagement.setAccList(AL);
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        try {
            ArrayList<Branch> ALB = DB.readBranch("/Users/cheokerinos/IdeaProjects/FastFoodOrdering/src/main/java/com/Accounts/Branch.txt");
            branchManagement.setBranchList(ALB);
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        try {
                Branch br= branchManagement.getBranchByName("NTU");
                ArrayList<FoodItem> ALF = DB.readMenu("/Users/cheokerinos/IdeaProjects/FastFoodOrdering/src/main/java/com/Accounts/NTUMENU.txt");
                BranchSystem bs = br.getBranchSystem();
                Menu menu = new Menu();
                menu.setMenu(ALF);
                menu.setCustomer_menu(ALF);
                bs.setMenu(menu);
            }
        catch(IOException e) {
            e.printStackTrace();
        }
        try {
            Branch br= branchManagement.getBranchByName("JP");
            ArrayList<FoodItem> ALF = DB.readMenu("/Users/cheokerinos/IdeaProjects/FastFoodOrdering/src/main/java/com/Accounts/JPMENU.txt");
            BranchSystem bs = br.getBranchSystem();
            Menu menu = new Menu();
            menu.setMenu(ALF);
            menu.setCustomer_menu(ALF);
            bs.setMenu(menu);
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        try {
            Branch br= branchManagement.getBranchByName("JE");
            ArrayList<FoodItem> ALF = DB.readMenu("/Users/cheokerinos/IdeaProjects/FastFoodOrdering/src/main/java/com/Accounts/JEMENU.txt");
            BranchSystem bs = br.getBranchSystem();
            Menu menu = new Menu();
            menu.setMenu(ALF);
            menu.setCustomer_menu(ALF);
            bs.setMenu(menu);
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        System.out.println("Welcome to KFC!");
        System.out.println(" .----------------.  .----------------.  .----------------. \n" +
                "| .--------------. || .--------------. || .--------------. |\n" +
                "| |  ___  ____   | || |  _________   | || |     ______   | |\n" +
                "| | |_  ||_  _|  | || | |_   ___  |  | || |   .' ___  |  | |\n" +
                "| |   | |_/ /    | || |   | |_  \\_|  | || |  / .'   \\_|  | |\n" +
                "| |   |  __'.    | || |   |  _|      | || |  | |         | |\n" +
                "| |  _| |  \\ \\_  | || |  _| |_       | || |  \\ `.___.'\\  | |\n" +
                "| | |____||____| | || | |_____|      | || |   `._____.'  | |\n" +
                "| |              | || |              | || |              | |\n" +
                "| '--------------' || '--------------' || '--------------' |\n" +
                " '----------------'  '----------------'  '----------------' ");
        System.out.println("");
        Scanner sc = new Scanner(System.in);
        int choice;
        do{
            System.out.println(
				"=================KFC FastFood Ordering Menu System=================\n"+
				"1. Customer\n"+
				"2. Staff\n"+
				"3. Shut down\n"+
				"======================================================================\n");
			System.out.println("Please enter number of your selection: ");
            try{
		        choice = sc.nextInt();
			}
			catch (InputMismatchException ex) {
				System.out.println("numbers only");
				sc.nextLine();
		        choice = sc.nextInt();		 
			}
            switch(choice){
                case 1:
                    sc.nextLine();
                    CustomerOrderingSystem COS = new CustomerOrderingSystem();
                    COS.COS(branchManagement);
                    break;
                case 2:
                    StaffApp sA = new StaffApp();
                    sA.staffapp(staffaccmanagement,branchManagement); // Calls the Staff Application interface
                    break;
                case 3:
                    try {
                        String filename = "/Users/cheokerinos/IdeaProjects/FastFoodOrdering/src/main/java/com/Accounts/Staff.txt";
                        DB.saveAccounts(filename, staffaccmanagement.getStaffAccounts());
                    }catch(IOException e){
                        e.printStackTrace();
                    }
                    try {
                        String filename = "/Users/cheokerinos/IdeaProjects/FastFoodOrdering/src/main/java/com/Accounts/Branch.txt";
                        DB.saveBranchs(filename, BranchManagement.getBranchList());
                    }catch(IOException e){
                        e.printStackTrace();
                    }
                    try {
                        Branch branch = branchManagement.getBranchByName("NTU");
                        BranchSystem BS = branch.getBranchSystem();
                        Menu menu = BS.getMenu();
                        String filename = "/Users/cheokerinos/IdeaProjects/FastFoodOrdering/src/main/java/com/Accounts/NTUMENU.txt";
                        DB.saveMenu(filename,menu.getMenu());
                    }catch(IOException e){
                        e.printStackTrace();
                    }
                    try {
                        Branch branch = branchManagement.getBranchByName("JP");
                        BranchSystem BS = branch.getBranchSystem();
                        Menu menu = BS.getMenu();
                        String filename = "/Users/cheokerinos/IdeaProjects/FastFoodOrdering/src/main/java/com/Accounts/JPMENU.txt";
                        DB.saveMenu(filename,menu.getMenu());
                    }catch(IOException e){
                        e.printStackTrace();
                    }
                    try {
                        Branch branch = branchManagement.getBranchByName("JE");
                        BranchSystem BS = branch.getBranchSystem();
                        Menu menu = BS.getMenu();
                        String filename = "/Users/cheokerinos/IdeaProjects/FastFoodOrdering/src/main/java/com/Accounts/JEMENU.txt";
                        DB.saveMenu(filename,menu.getMenu());
                    }catch(IOException e){
                        e.printStackTrace();
                    }
                    break;
                default:
					System.out.println("Please Enter 1,2 or 3");
					break;
            }
        }while(choice!=3);

        sc.close();
    }
}
