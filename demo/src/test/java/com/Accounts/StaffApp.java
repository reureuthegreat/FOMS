package com.Accounts;

import java.util.Scanner;

public class StaffApp {
    int choice;
    Scanner sc = new Scanner(System.in);
    public StaffApp(){}

    public void staffapp(){
        StaffAccManagement staffaccmanagement = new StaffAccManagement();
        BranchManagement branchManagement = new BranchManagement();
        Account staff1 = staffaccmanagement.Login();
        if(staff1==null){
            return;
        }
        else if(staff1.getRole() == Role.MANAGER){
            ManagerAccount Manager = (ManagerAccount) staff1;
            ManagerApp mA = new ManagerApp();
            mA.managerapp(Manager);//Calls the Manager Application Interface
        }
        else if(staff1.getRole() == Role.STAFF){
            StaffAccount staff = (StaffAccount) staff1;
            do{
                System.out.println("===========Staff===========\n"+
							   "1. Display Order\n"+
							   "2. View Order Details\n"+
							   "3. Process Order\n"+
							   "4. Back\n"+
							   "===========================");
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        staff.displayOrder();
                        break;
                    case 2:
                        staff.viewOrder();
                        break;
                    case 3:
                        staff.processOrder();
                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("Please enter 1,2,3 or 4.");
                        break;
                }

            }while(choice !=4);
        }
        else if(staff1.getRole() == Role.ADMIN){
            AdminAccount Admin = (AdminAccount) staff1;
            AdminApp Aa = new AdminApp();
            Aa.adminapp(Admin,staffaccmanagement, branchManagement);
        }
        else{
            return;
        }
    }
}
