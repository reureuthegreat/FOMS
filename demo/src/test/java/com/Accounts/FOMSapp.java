package com.Accounts;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FOMSapp {
    public static void main(String[] args) {
        System.out.println("Welcome to KFC");
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
                    break;
                case 2:
                    StaffApp sA = new StaffApp();
                    sA.staffapp(); // Calls the Staff Application interface
                    break;
                case 3:
                    break;
                default:
					System.out.println("Please Enter 1,2 or 3");
					break;
            }
        }while(choice!=3);
        sc.close();
    }
}
