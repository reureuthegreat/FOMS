package com.Accounts;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.Branch.Branch;
import com.Branch.BranchSystem;
import com.FoodItem.FoodItem;
import com.Menu.Menu;

/**
 * The main class representing the Fast Food Ordering Menu System (FOMS) application.
 */
public class FOMSapp {

    /**
     * The main method to start the FOMS application.
     *
     * @param args The command-line arguments.
     * @throws IOException If an I/O error occurs.
     */
    public static void main(String[] args) throws IOException {
        Database DB = new Database(); // creates new Database object
        StaffAccManagement staffaccmanagement = new StaffAccManagement(); // creates new staffaccmanagement object
        BranchManagement branchManagement = new BranchManagement(); // creates new branchmanagement object
        try {
            ArrayList<Account> AL = DB.readAccounts("/Users/cheokerinos/IdeaProjects/FastFoodOrdering/src/main/java/com/Accounts/Staff.txt");
            staffaccmanagement.setAccList(AL); // reads in Database of Accounts
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        try {
            ArrayList<Branch> ALB = DB.readBranch("/Users/cheokerinos/IdeaProjects/FastFoodOrdering/src/main/java/com/Accounts/Branch.txt");
            branchManagement.setBranchList(ALB); //reads in Database of branchs
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        try {
                Branch br= branchManagement.getBranchByName("NTU"); // reads in Database for NTUMENU
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
            Branch br= branchManagement.getBranchByName("JP"); // reads in Database for JPMENU
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
            Branch br= branchManagement.getBranchByName("JE"); // reads in Database for JE Menu
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
			System.out.println("Please enter number of your selection: "); // selection for user.
            try{
		        choice = sc.nextInt();
			}
			catch (InputMismatchException ex) {
				System.out.println("numbers only");
				sc.nextLine();
		        choice = sc.nextInt();		 
			}
            switch(choice){
                case 1: // goes to Customer User Interface
                    sc.nextLine();
                    CustomerOrderingSystem COS = new CustomerOrderingSystem();
                    COS.COS(branchManagement);
                    break;
                case 2: // goes to Staffs User interface.
                    StaffApp sA = new StaffApp();
                    sA.staffapp(staffaccmanagement,branchManagement); // Calls the Staff Application interface
                    break;
                case 3: // Saves all the changes made in current run into Database.
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
