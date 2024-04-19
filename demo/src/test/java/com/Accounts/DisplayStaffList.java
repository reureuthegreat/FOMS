package com.Accounts;

import java.util.Scanner;

public class DisplayStaffList {
    public DisplayStaffList(){}
    int choice;
    Scanner sc = new Scanner(System.in);
    
    public void displaystafflist(){ //TODO
        System.out.println("Please choose which filter you would like to display staff list:");
		System.out.println("1. Branch");
		System.out.println("2. Role");
		System.out.println("3. Gender");
		System.out.println("4. Age");
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		switch(choice){
			case 1:
				//Role
				break;
			case 2:
				//Gender
				break;
			case 3:
				//Age
			default:
				System.out.println("Invalid Choice.");
		}
		sc.close();
    }

    public void displaystafflist(String BranchName){
        System.out.println("Staff List by brnch......"); // TODO
    }
}
