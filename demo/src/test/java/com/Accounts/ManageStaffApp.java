package com.Accounts;

import java.util.Scanner;

public class ManageStaffApp {
    public ManageStaffApp(){}
    Scanner sc = new Scanner(System.in);
    int choice;
    public void managestaffapp(StaffAccManagement staffAccManagement){
        do{
            System.out.println("===========================.\n"+
            "Please select what you would like to do.\n"+
            "1. Create Staff Account\n"+
            "2. Delete Staff Account\n"+
            "3. Edit Staff Account Details\n"+
            "4. Back\n"+
            "===========================");
		choice = sc.nextInt();
        switch(choice){
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
            System.out.println("Please choose either 1,2,3 or 4.");
            choice = sc.nextInt();
            break;    
        }
        }while(choice != 4);
    }
}
