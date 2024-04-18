package com.Accounts;

import java.util.Scanner;

public class AdminApp {
    public AdminApp(){}
    Scanner sc = new Scanner(System.in);
    int choice;
    public void adminapp(AdminAccount Admin, StaffAccManagement staffAccManagement, BranchManagement branchManagement){
        do{
            System.out.println("===========Admin===========\n"+
                           "1. Manage Staff\n"+
                           "2. Display Staff List((filter: branch, role, gender, age)\n"+
                           "3. Assign Manager to a Branch\n"+
                           "4. Promote Staff to Manager\n"+
                           "5. Transfer Staff\n"+
                           "6. Manage Payment"+
                           "7. Manage Branch"+
                           "8. Back\n"+
                           "===========================");
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    ManageStaffApp MSA = new ManageStaffApp();
                    MSA.managestaffapp(staffAccManagement);// calls the Manage Staff Application Interface
                    break;
                case 2:
                    DisplayStaffList dStaffList = new DisplayStaffList();
                    dStaffList.displaystafflist(); // calls the Display Staff List interface
                    break;
                case 3:
                    Admin.assignManager(staffAccManagement, branchManagement);//calls the Admin Account method
                    break;
                case 4:
                    Admin.Promote(staffAccManagement);
                    break;
                case 5:
                    Admin.transferStaff(staffAccManagement, branchManagement);
                    break;
                case 6:
                    System.out.println("Payment Management"); // TODO
                    break;
                case 7:
                    ManageBranchApp MBA = new ManageBranchApp();
                    MBA.managebranchapp(branchManagement);
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Please enter 1,2,3,4,5,6,7 or 8.");
                    break;
            }
        }while(choice !=8);
    }
}