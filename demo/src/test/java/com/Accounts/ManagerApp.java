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
                           "1. Display Order\n"+
                           "2. View Order Details\n"+
                           "3. Process Order\n"+
                           "4. Manage Menu\n"+
                           "5. Display Staff List\n"+
                            "6. Change Password\n"+
                           "7. Log Out\n"+
                           "===========================");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    BS.Display_Order();
                    break;
                case 2:
                    BS.View_New_Order();
                    break;
                case 3:
                    BS.Process_Order();
                    break;
                case 4:
                    BS.Branch_Menu_Management();
                    break;
                case 5:
                    DisplayStaffList DSL = new DisplayStaffList();
                    branch = branchManagement.getBranchByName(Manager.getBranchName());
                    DSL.displaystafflist(branch,staffAccManagement);
                    break;
                case 6:
                    System.out.println("Enter new password:");
                    String password = sc.nextLine();
                    Manager.setPassword(password);
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Please enter 1,2,3,4,5,6 or 7.");
                    break;
            }

        }while(choice !=6);
    }
}
