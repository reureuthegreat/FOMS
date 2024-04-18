package com.Accounts;
import java.util.Scanner;



public class ManagerAccount extends StaffAccount {
	ManagerAccount(){
	}

	ManagerAccount(String ID, String name, int age, String gender, String branch){
        super(ID,name,age,gender,branch);
    }

	public void ManageOrder(/*Order order*/) {
		Scanner sc = new Scanner(System.in);
		System.out.println("---------Order Management-----------");
		System.out.println("1. View Order");
		System.out.println("2. Process Order");
		System.out.println("3. Display New Order");
		System.out.println("------------------------------------");

		int choice = sc.nextInt();
        switch (choice) {
            case 1:
                //Order.viewOrder
                break;
            case 2:
                //Order.viewOrder
                break;
            case 3:
                //Order.displayNewOrder
                break;
            default:
                System.out.println("Invalid choice! Input Choice again: ");
				choice = sc.nextInt();

        }
        sc.close();
    }
	public Branch getBranch(BranchManagement branchManagement){
		String BranchName = this.getBranchName();
		return branchManagement.getBranchByName(BranchName);
	}

	public void displayStaffList(BranchManagement branchManagement) {
		Branch branch = this.getBranch(branchManagement);
    	if (branch != null) {
        	branch.displayStaffList();
    	} else {
        	System.out.println("No branch information available.");
    	}
	}

	public void MenuManagement(){

	}
}