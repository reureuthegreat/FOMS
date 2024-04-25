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
            ArrayList<FoodItem> ALF = DB.readMenu("/Users/cheokerinos/IdeaProjects/FastFoodOrdering/src/main/java/com/Accounts/MENU.txt");
                for(Branch br: BranchManagement.getBranchList()){ // iterates thru all branches
                    ArrayList<FoodItem> branchfoodlist = new ArrayList<>(); // create a temp Arraylist for that branch.
                    for(FoodItem food : ALF){ //iterates thru all the fooditem menus
                        if(food.getLocation().compareTo(br.getBranchName()) == 0){ // check if food location is same as branch.
                            branchfoodlist.add(food);
                        }
                    }
                    BranchSystem bs = br.getBranchSystem(); // once all the food items for that branch has been added. Sets it as the menu for that branch.
                    Menu menu = new Menu();
                    menu.setMenu(branchfoodlist);
                    menu.setCustomer_menu(branchfoodlist);
                    bs.setMenu(menu);
                }
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
                        ArrayList<FoodItem> FoodList = new ArrayList<>(); /*creates a temp ArrayList of Food*/
                        for(Branch branch : BranchManagement.getBranchList()){ //iterates through all the branches.
                            BranchSystem BS = branch.getBranchSystem();
                            Menu menu = BS.getMenu();
                            FoodList.addAll(menu.getMenu()); /*appends all objects in that branch menu food list into the temp ArrayList*/
                        }
                        String filename = "/Users/cheokerinos/IdeaProjects/FastFoodOrdering/src/main/java/com/Accounts/MENU.txt";
                        DB.saveMenu(filename,FoodList); // saves it.
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
