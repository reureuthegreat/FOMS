package com.Accounts;
import com.BranchPackage.Branch;
import com.BranchPackage.BranchSystem;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Represents the application interface for a manager in the system.
 * Allows managers to perform various tasks related to managing a branch.
 */
public class ManagerApp {

    /**
     * Constructs a ManagerApp object.
     */
    public ManagerApp(){}
    Scanner sc = new Scanner(System.in);
    int choice;

    /**
     * Displays the manager application menu and allows managers to perform tasks.
     *
     * @param Manager            The manager account logged in.
     * @param branchManagement   The branch management system.
     * @param staffAccManagement The staff account management system.
     */
    public void managerapp(StaffAccount Manager,BranchManagement branchManagement, StaffAccManagement staffAccManagement){
            Branch branch = branchManagement.getBranchByName(Manager.getBranchName());
            BranchSystem BS = branch.getBranchSystem();
        try {
            do {
                System.out.println("===========Manager===========\n" +
                        "1. View New Orders\n" +
                        "2. Process Order\n" +
                        "3. Manage Menu\n" +
                        "4. Display Staff List\n" +
                        "5. Change Password\n" +
                        "6. Log Out\n" +
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
                        DSL.displaystafflist(branch, staffAccManagement);
                        break;
                    case 5:
                        sc.nextLine();
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

            } while (choice != 6);
        }catch(InputMismatchException e){
            System.out.println("Please enter numbers only.");
            sc.nextLine();
        }
    }
}
