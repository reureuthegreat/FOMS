package com.Accounts;

import javax.xml.crypto.Data;

import com.Branch.Branch;
import com.Branch.BranchSystem;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class StaffApp {
    int choice;
    Scanner sc = new Scanner(System.in);
    public StaffApp(){}

    public void staffapp(StaffAccManagement staffaccmanagement, BranchManagement branchManagement){
        
        Account staff1 = staffaccmanagement.Login();
        if(staff1==null){
            return;
        }


        if(staff1.getRole() == Role.MANAGER){
            ManagerAccount Manager = (ManagerAccount) staff1;
            ManagerApp mA = new ManagerApp();
            mA.managerapp(Manager,branchManagement,staffaccmanagement);//Calls the Manager Application Interface
        }
        else if(staff1.getRole() == Role.STAFF){
            Branch branch = branchManagement.getBranchByName(staff1.getBranchName());
            BranchSystem branchSystem = branch.branchSystem;
            do{
                System.out.println("===========Staff===========\n"+
							   "1. View Order Details\n"+
							   "2. Process Order\n"+
							   "3. Back\n"+
							   "===========================");
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        branchSystem.View_New_Order();
                        break;
                    case 2:
                        branchSystem.Process_Order();
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Please enter 1,2 or 3.");
                        break;
                }

            }while(choice !=3);
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
