package com.Accounts;
import java.util.Scanner;

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
		choice = sc.nextInt();
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
                System.out.println("Branch closeded successfully.");
            }
            else{
                System.out.println("Failed to close branch.. Try again.");
            }
            break;
        case 3:
            break;
        default:
            System.out.println("Please choose either 1,2 or 3");
            choice = sc.nextInt();
            break;
        }
        }while(choice != 3);
    }
}