package com.Accounts;
import com.Branch.Branch;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Represents an interface for Admin functionalities in the system.
 * Handles operations such as managing staff, assigning managers, promoting staff, etc.
 */
public class AdminApp {

    /**
     * Constructs an AdminApp object.
     */
    public AdminApp(){}
    Scanner sc = new Scanner(System.in);
    int choice;

    /**
     * Executes the Admin application with various functionalities.
     * @param Admin The AdminAccount object representing the logged-in Admin.
     * @param staffAccManagement The StaffAccManagement object for managing Staff accounts.
     * @param branchManagement The BranchManagement object for managing Branches.
     */
    public void adminapp(AdminAccount Admin, StaffAccManagement staffAccManagement, BranchManagement branchManagement){
            do {
                System.out.println("==========Admin===========\n" +
                        "1. Manage Staff\n" +
                        "2. Display Staff List((filter: branch, role, gender, age)\n" +
                        "3. Assign Manager to a Branch\n" +
                        "4. Promote Staff to Manager\n" +
                        "5. Transfer Staff\n" +
                        "6. Manage Payment\n" +
                        "7. Manage Branch\n" +
                        "8. Change Password\n" +
                        "9. Log out\n" +
                        "==========================\n");
                try {
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        ManageStaffApp MSA = new ManageStaffApp();
                        MSA.managestaffapp(staffAccManagement,branchManagement);// calls the Manage Staff Application Interface
                        break;
                    case 2:
                        DisplayStaffList dStaffList = new DisplayStaffList();
                        dStaffList.displaystafflist(staffAccManagement, branchManagement); // calls the Display Staff List interface
                        break;
                    case 3:
                        sc.nextLine();
                        System.out.println("Please enter the Manager you want to assign: ");
                        String ManagerID = sc.nextLine();
                        System.out.println("Please enter the name of the branch you are assigning them to: ");
                        String BranchName = sc.nextLine();
                        Branch branch = branchManagement.getBranchByName(BranchName);
                        if(!Admin.VerifyManagerQuota(branch)){
                            System.out.println("Manager Quota reached!");
                            break;
                        }
                        Account Acc = staffAccManagement.findStaffAccount(ManagerID);
                        StaffAccount Acc1 = (StaffAccount) Acc;
                        String oldBranch = Acc1.getBranchName();
                        Admin.assignManager(Acc1,branch);//calls the Admin Account method
                        branch = branchManagement.getBranchByName(oldBranch);
                        branch.decrementManagerNum();
                        break;
                    case 4:
                        sc.nextLine();
                        Admin.Promote(staffAccManagement);
                        break;
                    case 5:
                        sc.nextLine();
                        Admin.transferStaff(staffAccManagement, branchManagement);
                        break;
                    case 6:
                        PaymentManagementApp PMA = new PaymentManagementApp();
                        PMA.paymentmanagementapp();//Calls the PaymentManagementApp Interface
                        break;
                    case 7:
                        ManageBranchApp MBA = new ManageBranchApp();
                        MBA.managebranchapp(branchManagement);
                        break;
                    case 8:
                        sc.nextLine();
                        System.out.println("Enter your new password.");
                        String pw = sc.nextLine();
                        Admin.setPassword(pw);
                        System.out.println("Password has been changed successfully.");
                        break;
                    case 9:
                        break;
                    default:
                        System.out.println("Please enter 1,2,3,4,5,6,7,8 or 9.");
                        break;
                }
            }catch(InputMismatchException e){
                    System.out.println("Please enter numbers only.");
                    sc.nextLine();
                }
        }while (choice != 9);
    }
}
