package com.Accounts;
import com.Branch.Branch;
import com.Branch.BranchSystem;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Represents the application interface for staff members.
 */
public class StaffApp {

    /**
     * The choice made by the staff member in the application menu.
     */
    int choice;

    /**
     * Scanner object for input.
     */
    Scanner sc = new Scanner(System.in);

    /**
     * Constructs a new StaffApp object.
     */
    public StaffApp(){}

    /**
     * Starts the staff application interface.
     * @param staffaccmanagement The staff account management system.
     * @param branchManagement The branch management system.
     */
    public void staffapp(StaffAccManagement staffaccmanagement, BranchManagement branchManagement){
        Account staff1 = staffaccmanagement.Login();
        if(staff1==null){
            return;
        }
        else if(staff1.getRole() == Role.MANAGER){
            StaffAccount Manager = (StaffAccount) staff1;
            ManagerApp mA = new ManagerApp();
            mA.managerapp(Manager,branchManagement,staffaccmanagement);//Calls the Manager Application Interface
        }
        else if(staff1.getRole() == Role.STAFF){
            StaffAccount staff = (StaffAccount) staff1;
            try {
                Branch branch = branchManagement.getBranchByName(staff1.getBranchName());
                BranchSystem BS = branch.getBranchSystem();
                do {
                    System.out.println("===========Staff===========\n" +
                            "1. View New Order\n" +
                            "2. Process Order\n" +
                            "3. Change Password\n" +
                            "4. Log Out\n" +
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
                            sc.nextLine();
                            System.out.println("Enter new password:");
                            String password = sc.nextLine();
                            staff.setPassword(password);
                            System.out.println("Password changed successfully");
                            break;
                        case 4:
                            break;
                        default:
                            System.out.println("Please enter 1,2,3 or 4.");
                            break;
                    }

                } while (choice != 4);
            }catch(InputMismatchException e){
                System.out.println("Please enter numbers only.");
                sc.nextLine();
            }
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
