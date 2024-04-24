package com.Accounts;
import com.Branch.Branch;
import com.Branch.BranchSystem;

import java.util.Scanner;

public class ManagerApp {
    
    public ManagerApp(){}
    Scanner sc = new Scanner(System.in);
    int choice;
    public void managerapp(ManagerAccount Manager,BranchManagement branchManagement, StaffAccManagement staffAccManagement){
        do{
            Branch branch = branchManagement.getBranchByName(Manager.getBranchName());
            BranchSystem BS = branch.getBranchSystem();
            System.out.println("===========Manager===========\n"+
                           "1. View Order Details\n"+
                           "2. Process Order\n"+
                           "3. Manage Menu\n"+
                           "4. Display Staff List\n"+
                           "5. Change Password\n"+
                           "6. Log Out\n"+
                           "===========================");
            choice = sc.nextInt();
            switch (choice) {
                
                case 1:
                    BS.View_New_Order();
                    break;
                case 2:
                    BS.Process_Order();
                    break;
                case 3:
                    BS.Branch_Menu_Management();
                    break;
                case 4:
                    DisplayStaffList DSL = new DisplayStaffList();
                    branch = branchManagement.getBranchByName(Manager.getBranchName());
                    DSL.displaystafflist(branch,staffAccManagement);
                    break;
                case 5:
                    System.out.println("Enter new password:");
                    String password = sc.nextLine();
                    Manager.setPassword(password);
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Please enter 1,2,3,4,5 or 6.");
                    break;
            }

        }while(choice !=6);
    }
}
