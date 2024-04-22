package com.Accounts;
import java.util.Scanner;
import java.util.NoSuchElementException;


public class ManageBranchApp{
    public ManageBranchApp(){}
    Scanner sc = new Scanner(System.in);
    int choice;
    public void managebranchapp(BranchManagement branchManagement){
        do{
            System.out.println("===========================.\n"+
            "Please select what you would like to do.\n"+
            "1. Open Branch\n"+
            "2. Close Branch\n"+
            "3. Back\n"+
            "===========================");
            try {
                choice = sc.nextInt();
                sc.nextLine(); // Consume newline character
            } catch (NoSuchElementException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                sc.nextLine(); // Consume invalid input
                continue; // Restart the loop
            }
        switch(choice){
            case 1:
                if(branchManagement.AddBranch()){
                    System.out.println("New branch opened.");
                }else{
                    System.out.println("Failed to open branch. Try again.");
                }
                break;
            case 2:
                if(branchManagement.RemoveBranch()){
                    System.out.println("Branch closed successfully.");
                }
                else{
                    System.out.println("Failed to close branch.. Try again.");
                }
                break;
            case 3:
                break;
            default:
                System.out.println("Please choose either 1,2 or 3");
                sc.nextLine();
                choice = sc.nextInt();
                break;
        }
        }while(choice != 3);
    }
}