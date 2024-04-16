package com.Accounts;
import java.util.Scanner;

public class StaffAccount extends Account {

	private Account staff;
    private String branch;

    StaffAccount(){}

    StaffAccount(String ID, String name, int age, String gender, String branch){
        super(ID,name,age,gender);
        this.branch = branch;
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
                System.out.println("Invalid choice! Input choice again:");
                choice = sc.nextInt();
        }
        sc.close();
    }

    public void setBranch(String branch){
        this.branch = branch;
    }

    public String getBranchName(){
        return this.branch;
    }
}