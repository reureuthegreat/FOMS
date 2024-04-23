package com.Accounts;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ManageStaffApp {
    public ManageStaffApp(){}
    Scanner sc = new Scanner(System.in);
    int choice;
    public void managestaffapp(StaffAccManagement staffAccManagement){
        boolean isValidInput = false;
        do {
            try {
                System.out.println("===========================.\n" +
                        "Please select what you would like to do.\n" +
                        "1. Create Staff Account\n" +
                        "2. Delete Staff Account\n" +
                        "3. Edit Staff Account Details\n" +
                        "4. Back\n" +
                        "===========================");
                choice = sc.nextInt();
                isValidInput = true;
                switch (choice) {
                    case 1:
                        if(staffAccManagement.addAcc()){
                            System.out.println("New Staff Account created.");
                        }else{
                            System.out.println("Failed to create Account. Try again.");
                        }
                        break;
                    case 2:
                        if(staffAccManagement.removeAcc()){
                            System.out.println("Staff Account deleted successfully.");
                        }
                        else{
                            System.out.println("Failed to delete Account. Try again.");
                        }
                        break;
                    case 3:
                        staffAccManagement.editAcc();
                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("Please choose either 1, 2, 3, or 4.");
                        isValidInput = false;
                        break;
                }
            } catch (InputMismatchException ex) {
                System.out.println("Invalid input. Please enter a valid choice.");
                sc.nextLine(); // Clear the input buffer
                isValidInput = false;
            }
        } while (!isValidInput || choice != 4);
    }
}